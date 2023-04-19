package devop_project.panda;

import java.util.Vector;

/**
 * 
 * @author insert team name
 * @param <T> must be a atomic type
 */
public class Column<T> {
	private String name;
	private Vector<T> elements;
	
	/**
	 * Create a new column.
	 * @param name the name of the column
	 * @param elements a vector containing the elements of the column.
	 */
	public Column(String name, Vector<T> elements) {
		this.name = name;
		//TODO check type ?
		for(int i=0;i<elements.size();i++) {
			this.elements.add(i,elements.get(i));
		}
	}
	
	/**
	 * create an empty column
	 * @param name
	 */
	public Column(String name) {
		this.name = name;
		this.elements = new Vector<> ();
	}
	
	/**
	 * get the column name
	 * @return the ame
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * get a element of a specific index. 
	 * @param index
	 * @return the element
	 */
	public T getElement(int index) {
		return elements.get(index);
	}
}
