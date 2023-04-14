package models;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface Crud <Livre>{
	
	public ArrayList<Livre> selectAll();

}
