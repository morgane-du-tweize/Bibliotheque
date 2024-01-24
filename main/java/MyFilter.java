package servlets;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebFilter(filterName ="Bibiofiltre", urlPatterns = "/*")
public class Bibiofiltre implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        chain.doFilter( new BiblioXssWrapper( (HttpServletRequest) request), response );
    }

	@Override
	public void destroy() {
	}
	
	private static class BiblioXssWrapper extends HttpServletRequestWrapper {
		
    	private static final Pattern [] XSS_PATTERNS = {
    			Pattern.compile( "<.*?>" ),
    			Pattern.compile( "&.*?;" ),
    			Pattern.compile( "%[0-9a-fA-F]*" )
    	};		
		
        public BiblioXssWrapper(HttpServletRequest servletRequest) {
            super(servletRequest);
        }

        @Override
        public String[] getParameterValues( String parameterName ) {
            String [] values = super.getParameterValues(parameterName);
            if (values == null) {
            	return null;
            }
            int count = values.length;
            for ( int i = 0; i < count; i++ ) {
            	values[i] = removeTags(values[i]);
            }
            return values;
        }
        
        @Override
        public String getParameter( String parameter ) {
            return removeTags( super.getParameter(parameter) );
        }
        
        @Override
        public String getHeader( String name ) {
            return removeTags( super.getHeader(name) );
        }
        
        private String removeTags( String text ) {
            if ( text != null ) {
            	text = text.replaceAll( "\0", "" );
                for ( Pattern pattern : XSS_PATTERNS ) {
                	text = pattern.matcher( text ).replaceAll( "" );
                }
                text = text.replaceAll( "<", "" );
                text = text.replaceAll( ">", "" );
            }
            return text;
        }        
        

	}

}

