package models;

import java.util.ArrayList;

public interface Crud <Livre> {
	
	public ArrayList<Livre> selectAll();
	
	public void insert();
}
