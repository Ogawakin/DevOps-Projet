package devop_project.panda;

import java.util.Vector;
import java.lang.IndexOutOfBoundsException;

/**
 * represent a column, containing a name and it's elements
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
	 * change column label
	 * @param newName
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * get a element of a specific index. 
	 * @param index
	 * @return the element
	 * @throws IndexOutOfBoundsException
	 */
	public T getElement(int index) {
		if(index>=getSize()) {
			throw new IndexOutOfBoundsException();
		}
		return elements.get(index);
	}
	
	/**
	 * add an element to the column
	 * @param element
	 */
	public void addElement(T element) {
		elements.add(element);
	}
	
	/**
	 * change an element to the column
	 * @param index
	 * @param element
	 * @throws IndexOutOfBoundsException
	 */
	public void setElement(int index, T element) {
		if(index>=getSize()) {
			throw new IndexOutOfBoundsException();
		}
		elements.set(index, element);
	}
	
	/**
	 * @return string version of column
	 */
	public String toString() {
		String acc = name + " : ";
		for(T val : elements) {
			acc += val.toString() + " ";
		}
		return acc;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Column<T> c = (Column<T>) o;
		if(c.getSize()!=this.getSize()) {
			return false;
		}
		for(int i=0;i<getSize();i++) {
			if (!getElement(i).equals(c.getElement(i))) {
				return false;
			}
		}
		return true;
	}
}
