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
	
	@Test
	public void equalEmpty () {
		DataFrame d1 = new DataFrame();
		DataFrame d2 = new DataFrame();
		assertEquals("different dataframe",d1,d2);
	}
	
	@Test
	public void equalSameColumnSameOrder() {
		Column<Integer> c1 = new Column<>("first");
		c1.addElement(1);
		c1.addElement(2);
		Column<Integer> c2 = new Column<>("first");
		c2.addElement(1);
		c2.addElement(2);
		
		Column<Integer> c3 = new Column<>("last");
		c1.addElement(3);
		c1.addElement(4);
		Column<Integer> c4 = new Column<>("last");
		c2.addElement(3);
		c2.addElement(4);
		
		DataFrame d1 = new DataFrame(c1, c3);
		DataFrame d2 = new DataFrame(c2, c4);
		
		assertEquals("different dataframe",d1,d2);
	}
	
	@Test
	public void equalSameColumnDiffOrder() {
		Column<Integer> c1 = new Column<>("first");
		c1.addElement(1);
		c1.addElement(2);
		Column<Integer> c2 = new Column<>("first");
		c2.addElement(1);
		c2.addElement(2);
		
		Column<Integer> c3 = new Column<>("last");
		c1.addElement(3);
		c1.addElement(4);
		Column<Integer> c4 = new Column<>("last");
		c2.addElement(3);
		c2.addElement(4);
		
		DataFrame d1 = new DataFrame(c1, c3);
		DataFrame d2 = new DataFrame(c4, c2);
		
		assertEquals("different dataframe",d1,d2);
	}
	
	@Test
	public void notEqualDifColumn() {
		Column<Integer> c1 = new Column<>("first");
		c1.addElement(1);
		c1.addElement(2);
		Column<Integer> c2 = new Column<>("first");
		c2.addElement(7);
		c2.addElement(8);
		
		Column<Integer> c3 = new Column<>("last");
		c1.addElement(5);
		c1.addElement(6);
		Column<Integer> c4 = new Column<>("last");
		c2.addElement(3);
		c2.addElement(4);
		
		DataFrame d1 = new DataFrame(c1, c3);
		DataFrame d2 = new DataFrame(c4, c2);
		
		assertNotEquals("different dataframe",d1,d2);
	}
	
	
//	@Test
//	public void maxInt() {
//		String name = "myColumn";
//		Column<Integer> c1 = new Column<>(name);
//		c1.addElement(1);
//		c1.addElement(2);
//		DataFrame frame = new DataFrame(c1);
//		assertEquals("max incorrect",2,frame.max(name));
//	}
//	
//	@Test
//	public void maxFloat() {
//		String name = "myColumn";
//		Column<Float> c1 = new Column<>(name);
//		c1.addElement(0.1f);
//		c1.addElement(0.2f);
//		DataFrame frame = new DataFrame(c1);
//		assertEquals("max incorrect", (Float) 0.2f,frame.max(name));
//	}
//	
//	@Test
//	public void maxDouble() {
//		String name = "myColumn";
//		Column<Double> c1 = new Column<>(name);
//		c1.addElement(.1);
//		c1.addElement(.2);
//		DataFrame frame = new DataFrame(c1);
//		assertEquals("max incorrect",(Double).2,frame.max(name));
//	}
//	
//	@Test
//	public void minInt() {
//		String name = "myColumn";
//		Column<Integer> c1 = new Column<>(name);
//		c1.addElement(1);
//		c1.addElement(2);
//		DataFrame frame = new DataFrame(c1);
//		assertEquals("min incorect",1,frame.min(name));
//	}
//	
//	@Test
//	public void minFloat() {
//		String name = "myColumn";
//		Column<Float> c1 = new Column<>(name);
//		c1.addElement(0.1f);
//		c1.addElement(0.2f);
//		DataFrame frame = new DataFrame(c1);
//		assertEquals("min incorect",(Float) 0.1f,frame.min(name));
//	}
//	
//	@Test
//	public void minDouble() {
//		String name = "myColumn";
//		Column<Double> c1 = new Column<>(name);
//		c1.addElement(.1);
//		c1.addElement(.2);
//		DataFrame frame = new DataFrame(c1);
//		assertEquals("min incorect",(Double) 0.1, frame.min(name));
//	}
//	
//	@Test
//	public void moyInt() {
//		String name = "myColumn";
//		Column<Integer> c1 = new Column<>(name);
//		c1.addElement(1);
//		c1.addElement(2);
//		DataFrame frame = new DataFrame(c1);
//		assertEquals("moy incorrect",(Double) .5, (Double)frame.moyenne(name));
//	}
//	
//	@Test
//	public void moyFloat() {
//		String name = "myColumn";
//		Column<Float> c1 = new Column<>(name);
//		c1.addElement(0.1f);
//		c1.addElement(0.2f);
//		DataFrame frame = new DataFrame(c1);
//		assertEquals("moy incorrect",(Double) .15, (Double)frame.moyenne(name));
//	}
//	
//	@Test
//	public void moyDouble() {
//		String name = "myColumn";
//		Column<Double> c1 = new Column<>(name);
//		c1.addElement(.1);
//		c1.addElement(.2);
//		DataFrame frame = new DataFrame(c1);
//		assertEquals("moy incorrect",(Double) .15, (Double)frame.moyenne(name));
//	}
	
	
	
	
	
}
