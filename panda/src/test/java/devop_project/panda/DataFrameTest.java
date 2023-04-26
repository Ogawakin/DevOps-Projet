package devop_project.panda;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataFrameTest {

	@Test
	public void emptyDataFrameConstructor() {
		DataFrame frame = new DataFrame();
		assertNotEquals("initialised at null",null,frame);
	}
	
	@Test
	public void notEmptyDataFrameConstructor() {
		String name = "myColumn";
		Column<String> c = new Column<>(name);
		DataFrame frame = new DataFrame(c);
		assertNotEquals("initialised at null",null,frame);
	}
	
	@Test
	public void toStringAll() {
		Column<String> c1 = new Column<>("start");
		c1.addElement("hello");
		c1.addElement("world");
		Column<String> c2 = new Column<>("end");
		c2.addElement("bye");
		c2.addElement("world");
		DataFrame frame = new DataFrame(c1,c2);
		assertEquals("string not the same","[ start : hello world ]\n[ end : bye world ]\n",frame.toString("all",0));
	}
}
