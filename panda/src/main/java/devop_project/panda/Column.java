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
	 * create an empty column
	 * @param name
	 */
	public Column(String name) {
		this.name = name;
		this.elements = new Vector<> ();
	}
	
	/**
	 * Create a new column.
	 * @param name the name of the column
	 * @param elements a vector containing the elements of the column.
	 */
	public Column(String name, Vector<T> elements) {
		this(name);
		//TODO check type ?
		for(int i=0;i<elements.size();i++) {
			this.elements.add(i,elements.get(i));
		}
	}
	
	/**
	 * get the column length
	 * @return number of element
	 */
	public int getSize() {
		return elements.size();
	}
	
	/**
	 * get the column name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * get a element of a specific index. 
	 * @param index
	 * @return the element
	 * @throws something
	 */
	public T getElement(int index) {
		return elements.get(index);
	}
	
	public String toString() {
		String acc = name + " : ";
		for(T val : elements) {
			acc += val.toString() + " ";
		}
		return acc;
	}
}
