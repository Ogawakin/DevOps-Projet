package devop_project.panda;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.NoSuchFieldException;
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
	
	private DataFrame createDefaultStringDataFrame() {
		Column<String> c1 = new Column<>("first name");
		c1.addElement("Jean");
		c1.addElement("Mari");
		c1.addElement("Sacha");
		Column<String> c2 = new Column<>("last name");
		c2.addElement("Baguette");
		c2.addElement("TommeDeSavoie");
		c2.addElement("ain-bai");
		Column<Integer> c3 = new Column<>("age");
		c3.addElement(30);
		c3.addElement(42);
		c3.addElement(99);
		return new DataFrame(c1,c2, c3);
	}
	
	@Test
	public void selectOneColumn() {
		DataFrame d1 = createDefaultStringDataFrame();
		Column<String> c1 = new Column<>("first name");
		c1.addElement("Jean");
		c1.addElement("Mari");
		c1.addElement("Sacha");
		DataFrame d2= new DataFrame(c1);
		assertEquals("column should be equal",d2,d1.selectColumn("first name"));
	}
	
	@Test
	public void selectTwoColumn() {
		DataFrame d1 = createDefaultStringDataFrame();
		Column<String> c1 = new Column<>("first name");
		c1.addElement("Jean");
		c1.addElement("Mari");
		c1.addElement("Sacha");
		Column<Integer> c3 = new Column<>("age");
		c3.addElement(30);
		c3.addElement(42);
		c3.addElement(99);
		DataFrame d2= new DataFrame(c3,c1);
		assertEquals("column should be equal",d2,d1.selectColumn("first name","age"));
	}
	
	@Test (expected = NullPointerException.class)
	public void selectInvalideColumn() {
		DataFrame d1 = createDefaultStringDataFrame();
		d1.selectWhere("city","Smh");
	}

	@Test
	public void selectOneLine() {
		DataFrame d1 = createDefaultStringDataFrame();
		Column<String> c1 = new Column<>("first name");
		c1.addElement("Mari");
		Column<String> c2 = new Column<>("last name");
		c2.addElement("TommeDeSavoie");
		Column<Integer> c3 = new Column<>("age");
		c3.addElement(42);
		DataFrame d2= new DataFrame(c1,c2,c3);
		assertEquals("line should be equal",d2,d1.selectLine(1));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void selectInvalideLine() {
		DataFrame d1 = createDefaultStringDataFrame();
		Column<String> c1 = new Column<>("first name");
		c1.addElement("Mari");
		Column<String> c2 = new Column<>("last name");
		c2.addElement("TommeDeSavoie");
		Column<Integer> c3 = new Column<>("age");
		c3.addElement(42);
		DataFrame d2= new DataFrame(c1,c2,c3);
		assertEquals("line should be equal",d2,d1.selectLine(10));
	}
	
	@Test
	public void selectTwoAdjacentLine() {
		DataFrame d1 = createDefaultStringDataFrame();
		Column<String> c1 = new Column<>("first name");
		c1.addElement("Jean");
		c1.addElement("Sacha");
		Column<String> c2 = new Column<>("last name");
		c2.addElement("Baguette");
		c2.addElement("ain-bai");
		Column<Integer> c3 = new Column<>("age");
		c3.addElement(30);
		c3.addElement(99);
		DataFrame d2= new DataFrame(c1,c2,c3);
		assertEquals("line should be equal",d2,d1.selectLine(0,2));
	}
	
	@Test
	public void selectTwoNonAdjacentLine() {
		DataFrame d1 = createDefaultStringDataFrame();
		Column<String> c1 = new Column<>("first name");
		c1.addElement("Jean");
		c1.addElement("Mari");
		Column<String> c2 = new Column<>("last name");
		c2.addElement("Baguette");
		c2.addElement("TommeDeSavoie");
		Column<Integer> c3 = new Column<>("age");
		c3.addElement(30);
		c3.addElement(42);
		DataFrame d2= new DataFrame(c1,c2,c3);
		assertEquals("line should be equal",d2,d1.selectLine(0,1));
	}
	
	@Test
	public void selectWhereValueInDataframe() {
		DataFrame d1 = createDefaultStringDataFrame();
		Column<String> c1 = new Column<>("first name");
		c1.addElement("Jean");
		Column<String> c2 = new Column<>("last name");
		c2.addElement("Baguette");
		Column<Integer> c3 = new Column<>("age");
		c3.addElement(30);
		DataFrame d2= new DataFrame(c1,c2,c3);
		assertEquals("line should be equal",d2,d1.selectWhere("age",30));
	}

	@Test
	public void selectWhereValueNonInDataframe() {
		DataFrame d1 = createDefaultStringDataFrame();
		Column<String> c1 = new Column<>("first name");
		Column<String> c2 = new Column<>("last name");
		Column<Integer> c3 = new Column<>("age");
		DataFrame d2= new DataFrame(c1,c2,c3);
		assertEquals("line should be equal",d2,d1.selectWhere("age",33));
	}

	@Test (expected = NullPointerException.class)
	public void selectWhereLabelNonInDataframe() {
		DataFrame d1 = createDefaultStringDataFrame();
		d1.selectWhere("city","Smh");
	}

	@Test
	public void selectWhere2ValueInDataframe() {
		Column<String> c1 = new Column<>("first name");
		c1.addElement("Riri");
		c1.addElement("Fifi");
		c1.addElement("Loulou");

		Column<String> c2 = new Column<>("last name");
		c2.addElement("Duck");
		c2.addElement("Duck");
		c2.addElement("Duck");

		Column<Integer> c3 = new Column<>("age");
		c3.addElement(86);
		c3.addElement(86);
		c3.addElement(86);
		DataFrame d1= new DataFrame(c1,c2,c3);

		Column<String> c4 = new Column<>("first name");
		c4.addElement("Riri");
		c4.addElement("Fifi");
		c4.addElement("Loulou");
		c4.addElement("Pas");
		Column<String> c5 = new Column<>("last name");
		c5.addElement("Duck");
		c5.addElement("Duck");
		c5.addElement("Duck");
		c5.addElement("Didé");
		Column<Integer> c6 = new Column<>("age");
		c6.addElement(86);
		c6.addElement(86);
		c6.addElement(86);
		c6.addElement(0);
		DataFrame d2= new DataFrame(c4,c5,c6);
		assertEquals("line should be equal",d1,d2.selectWhere("age",86));
	}

	public void maxInt() {
		String name = "myColumn";
		Column<Integer> c1 = new Column<>(name);
		c1.addElement(1);
		c1.addElement(2);
		DataFrame frame = new DataFrame(c1);
		assertEquals("max incorrect",2,frame.max(name));
	}

	@Test
	public void maxFloat() {
		String name = "myColumn";
		Column<Float> c1 = new Column<>(name);
		c1.addElement(0.1f);
		c1.addElement(0.2f);
		DataFrame frame = new DataFrame(c1);
		assertEquals("max incorrect", (Float) 0.2f,frame.max(name));
	}
	
	@Test
	public void maxDouble() {
		String name = "myColumn";
		Column<Double> c1 = new Column<>(name);
		c1.addElement(.1);
		c1.addElement(.2);
		DataFrame frame = new DataFrame(c1);
		assertEquals("max incorrect",(Double).2,frame.max(name));
	}
	

	@Test(expected = NullPointerException.class)
	public void maxUnckowLabel() {
		String name = "myColumn";
		Column<Double> c1 = new Column<>(name);
		c1.addElement(.1);
		c1.addElement(.2);
		DataFrame frame = new DataFrame(c1);
		frame.max("name");
	}

	@Test
	public void minInt() {
		String name = "myColumn";
		Column<Integer> c1 = new Column<>(name);
		c1.addElement(1);
		c1.addElement(2);
		DataFrame frame = new DataFrame(c1);
		assertEquals("min incorect",1,frame.min(name));
	}
  
	@Test
	public void minFloat() {
		String name = "myColumn";
		Column<Float> c1 = new Column<>(name);
		c1.addElement(0.1f);
		c1.addElement(0.2f);
		DataFrame frame = new DataFrame(c1);
		assertEquals("min incorect",(Float) 0.1f,frame.min(name));
	}
	
	@Test
	public void minDouble() {
		String name = "myColumn";
		Column<Double> c1 = new Column<>(name);
		c1.addElement(.1);
		c1.addElement(.2);
		DataFrame frame = new DataFrame(c1);
		assertEquals("min incorect",(Double) 0.1, frame.min(name));
	}
	
	@Test(expected = NullPointerException.class)
	public void minUnckowLabel() {
		String name = "myColumn";
		Column<Double> c1 = new Column<>(name);
		c1.addElement(.1);
		c1.addElement(.2);
		DataFrame frame = new DataFrame(c1);
		frame.min("name");
	}

	@Test
	public void moyInt() {
		String name = "myColumn";
		Column<Integer> c1 = new Column<>(name);
		c1.addElement(1);
		c1.addElement(2);
		DataFrame frame = new DataFrame(c1);
		assertEquals("moy incorrect",true, frame.moyenne(name).equals(1));
	}
	
	@Test
	public void moyFloat() {
		String name = "myColumn";
		Column<Float> c1 = new Column<>(name);
		c1.addElement(0.1f);
		c1.addElement(0.2f);
		DataFrame frame = new DataFrame(c1);
		assertEquals("moy incorrect",true, frame.moyenne(name).equals(0.15f));
	}
	
	private boolean closeEnough(double a, double b) {
		final double epsilon = 0.000001;
		return a<b+epsilon && a>b-epsilon;
	}

	@Test
	public void moyDouble() {
		String name = "myColumn";
		Column<Double> c1 = new Column<>(name);
		c1.addElement(.1);
		c1.addElement(.2);
		DataFrame frame = new DataFrame(c1);
		assertEquals("moy incorrect",true, closeEnough((Double)frame.moyenne(name),(Double) 0.15));
	}

	@Test
	public void sumInt() {
		String name = "myColumn";
		Column<Integer> c1 = new Column<>(name);
		c1.addElement(1);
		c1.addElement(2);
		DataFrame frame = new DataFrame(c1);
		assertEquals("moy incorrect",true, frame.moyenne(name).equals(1));
	}
	
	@Test
	public void sumFloat() {
		String name = "myColumn";
		Column<Float> c1 = new Column<>(name);
		c1.addElement(0.1f);
		c1.addElement(0.2f);
		DataFrame frame = new DataFrame(c1);
		assertEquals("moy incorrect",true, frame.moyenne(name).equals(0.15f));
	}
	
	@Test
	public void sumDouble() {
		String name = "myColumn";
		Column<Double> c1 = new Column<>(name);
		c1.addElement(.1);
		c1.addElement(.2);
		DataFrame frame = new DataFrame(c1);
		assertEquals("moy incorrect",true, closeEnough((Double)frame.moyenne(name),(Double) 0.15));
	}


	
	
	
}
