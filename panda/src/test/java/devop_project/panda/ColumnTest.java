package devop_project.panda;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class ColumnTest {

	@Test
	public void emptyColumn() {
		String name = "myColumn";
		Column<String> c = new Column<>(name);
		assertEquals("name of the column not the same",name,c.getName());
		assertEquals("number of column not null",0,c.getSize());
	}
	
	@Test
	public void emptyColumnToString() {
		String name = "myColumn";
		Column<String> c = new Column<>(name);
		assertEquals("column not expected",name+ " : ",c.toString());
	}
	
	@Test
	public void intColumnToString() {
		String name = "myColumn";
		Vector<Integer> elements = new Vector<Integer>();
		elements.add(1);
		elements.add(2);
		elements.add(3);
		elements.add(4);
		elements.add(5);
		Column<Integer> c = new Column<>(name,elements);
		assertEquals("column not expected",name+ " : 1 2 3 4 5 ",c.toString());
	}
}
