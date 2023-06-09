package devop_project.panda;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class ColumnTest {

	@Test
	public void constructeurEmptyColumn() {
		String name = "myColumn";
		Column<String> c = new Column<>(name);
		assertEquals("name of the column not the same",name,c.getName()); 
		assertEquals("number of column not null",0,c.getSize());
	}
	
	@Test
    public void constructeurNoneEmptyColumnEmptyVector(){
		String name = "list_int";
    	Vector<Integer> vect = new Vector<Integer>();
        Column<Integer> noneEmptyColumn = new Column<Integer>(name,vect);
        assertEquals("name of the column not the same",name,noneEmptyColumn.getName());
		assertEquals("number of column not null",0,noneEmptyColumn.getSize());
    }
	
	@Test
	public void constructeurNoneEmptyColumnNoneEmptyVector(){
		String name = "list_int";
    	Vector<Integer> vect = new Vector<Integer>();
    	vect.add(1);
    	vect.add(3);
    	vect.add(5);
        Column<Integer> noneEmptyColumn = new Column<Integer>(name,vect);
        assertEquals("name of the column not the same",name,noneEmptyColumn.getName());
		assertEquals("number of column not null",3,noneEmptyColumn.getSize());
    }

    @SuppressWarnings("rawtypes")
	public Column getEmptyColumn(String s) {
    	Column emptyColumn = new Column(s);
    	return emptyColumn;
    }
    
	public Column<Integer> getIntegerColumn(String s) {
		Vector<Integer> vect = new Vector<Integer>();
		vect.add(1);
		vect.add(3);
		vect.add(5);
		Column<Integer> integerColumn = new Column<>(s,vect);
		return integerColumn;
	}

	public Column<Float> getFloatColumn(String s) {
		Vector<Float> vect = new Vector<Float>();
		vect.add((float) 1.0);
		vect.add((float) 3.6);
		vect.add((float) 5.0);
		Column<Float> integerColumn = new Column<>(s,vect);
		return integerColumn;
	}

	public Column<Double> getDoubleColumn(String s) {
		Vector<Double> vect = new Vector<Double>();
		vect.add((double)1.0);
		vect.add((double)3.6);
		vect.add((double)5.0);
		Column<Double> integerColumn = new Column<>(s,vect);
		return integerColumn;
	}

	
	public Column<String> getStringColumn(String s) {
		Vector<String> vect = new Vector<String>();
		vect.add("a");
		vect.add("z");
		vect.add("e");
		vect.add("r");
		vect.add("t");
		Column<String> stringColumn = new Column<>(s,vect);
		return stringColumn;
	}
    
	@SuppressWarnings("rawtypes")
    @Test
    public void columnGetName()
    {
		Column col = getEmptyColumn("");
    	assertEquals("Test getName on empty name","", col.getName());
    	
    	Column col2 = getEmptyColumn("non empty");
    	assertEquals("Test getName on caracteres name","non empty", col2.getName());
    	
    	Column col3 = getEmptyColumn("azert12345&éà@");
    	assertEquals("Test getName on  somes spetials caractere name","azert12345&éà@", col3.getName());
    
    	Column col4 = getIntegerColumn("Integer");
    	assertEquals("Test getName on integer column","Integer", col4.getName());
    
    	Column col5 = getStringColumn("String");
    	assertEquals("Test getName on string column","String", col5.getName());
    }
    
    @Test
    public void columnGetSize()
    {
    	@SuppressWarnings("rawtypes")
    	Column col = getEmptyColumn("empty");
    	assertEquals("Test getSize on empty column",0, col.getSize());
    	
    	Column<Integer> col2 = getIntegerColumn("Integer");
    	assertEquals("Test getSize on integer column with size 3",3, col2.getSize());
    
    	Column<String> col3 = getStringColumn("String");
    	assertEquals("Test getSize on string column with size 5",5, col3.getSize());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void columnGetElementNegatif()
    {
    	@SuppressWarnings("rawtypes")
    	Column col = getEmptyColumn("empty");
    	col.getElement(-1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void columnGetElementZeroOnEmptyList()
    {
    	@SuppressWarnings("rawtypes")
    	Column col = getEmptyColumn("empty");
    	col.getElement(0);
    }	
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void columnGetElementTooHighIndexOnEmpty()
    {
    	@SuppressWarnings("rawtypes")
    	Column col = getEmptyColumn("empty");
    	col.getElement(1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void columnGetElementTooHighIndexOnNonEmpty()
    {
    	Column<Integer> col = getIntegerColumn("interget");
    	col.getElement(15);
    }
    
    @Test
    public void columnGetElementFirst()
    {
    	Column<Integer> col = getIntegerColumn("integer");
    	assertEquals("Test getElement on integer list, get first element",1,(int)col.getElement(0));
    
    	Column<String> col2 = getStringColumn("string");
    	assertEquals("Test getElement on string list, get first element","a",col2.getElement(0));
    }
    
    @Test
    public void columnGetElementRandomIndex()
    {
    	Column<Integer> col = getIntegerColumn("integer");
    	assertEquals("Test getElement on integer list, get first element",3,(int)col.getElement(1));
    
    	Column<String> col2 = getStringColumn("string");
    	assertEquals("Test getElement on string list, get first element","e",col2.getElement(2));
    }
    
    @Test
    public void columnGetElementLast()
    {
    	Column<Integer> col = getIntegerColumn("integer");
    	assertEquals("Test getElement on integer list, get first element",5,(int)col.getElement(2));
    
    	Column<String> col2 = getStringColumn("string");
    	assertEquals("Test getElement on string list, get first element","t",col2.getElement(4));
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
	
	@Test
	public void setName() {
		String name = "myColumn";
		String newName = "ourColumn";
		Vector<Integer> elements = new Vector<Integer>();
		Column<Integer> c = new Column<>(name,elements);
		c.setName(newName);
		assertEquals("different name",newName,c.getName());
	}
	
	@Test
	public void addElementToEmpty() {
		String name = "myColumn";
		Vector<Integer> elements = new Vector<Integer>();
		Column<Integer> c = new Column<>(name,elements);
		c.addElement(42);
		assertEquals("different length",1,c.getSize());
		assertEquals("different element",42,(int)c.getElement(0));
	}
	
	@Test
	public void addElementToNonEmpty() {
		String name = "myColumn";
		Vector<String> elements = new Vector<String>();
		elements.add("1.0");
		elements.add("2.1");
		elements.add("3.9");
		elements.add("4.3");
		elements.add("5.1");
		Column<String> c = new Column<>(name,elements);
		c.addElement("PI");
		assertEquals("different length",6,c.getSize());
		assertEquals("different element","PI",c.getElement(5));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void setElementToEmpty() {
		String name = "myColumn";
		Vector<Integer> elements = new Vector<Integer>();
		Column<Integer> c = new Column<>(name,elements);
		c.setElement(0,42);
	}
	
	@Test
	public void setElementToNonEmpty() {
		String name = "myColumn";
		Vector<String> elements = new Vector<String>();
		elements.add("1.0");
		elements.add("2.1");
		elements.add("3.9");
		elements.add("4.3");
		elements.add("5.1");
		Column<String> c = new Column<>(name,elements);
		c.setElement(2,"PI");
		assertEquals("different length",5,c.getSize());
		assertEquals("different element","PI",c.getElement(2));
	}
	
	@Test
	public void equalEmpty() {
		Column<String> c1 = new Column<>("c1");
		Column<String> c2 = new Column<>("c2");
		assertEquals("different column",c1,c2);
	}
	
	@Test
	public void equalWithDuck() {
		Column<String> c1 = new Column<>("c1");
		Object duck = new Object() {};
		assertNotEquals("should different column",c1,duck);
	}
	
	@Test
	public void equalDiferentSize() {
		Column<String> c1 = new Column<>("c1");
		Column<String> c2 = new Column<>("c2");
		c2.addElement("a");
		assertNotEquals("different column",c1,c2);
	}
	
	@Test
	public void equalDiffType() {
		Column<Integer> c1 = new Column<>("c1");
		c1.addElement(1);
		Column<Double> c2 = new Column<>("c2");
		c2.addElement(1.);
		assertNotEquals("should be different",c1,c2);
	}
	
	@Test
	public void equalString() {
		Column<String> c1 = new Column<>("c1");
		c1.addElement(".1");
		c1.addElement(".2");
		c1.addElement(".87");
		c1.addElement(".4");
		Column<String> c2 = new Column<>("c2");
		c2.addElement(".1");
		c2.addElement(".2");
		c2.addElement(".87");
		c2.addElement(".4");
		assertEquals("should be the same",c1,c2);
	}
	
	@Test
	public void equalFloat() {
		Column<Float> c1 = new Column<>("c1");
		c1.addElement(1f);
		Column<Float> c2 = new Column<>("c2");
		c2.addElement(1f);
		assertEquals("should be the same",c1,c2);
	}
	
	@Test
	public void equalInt() {
		Column<Integer> c1 = new Column<>("c1");
		c1.addElement(1);
		Column<Integer> c2 = new Column<>("c2");
		c2.addElement(1);
		assertEquals("should be the same",c1,c2);
	}
	
	@Test
	public void equalDouble() {
		Column<Double> c1 = new Column<>("c1");
		c1.addElement(1.);
		Column<Double> c2 = new Column<>("c2");
		c2.addElement(1.);
		assertEquals("should be the same",c1,c2);
	}

	@Test
	public void integerMax(){
		Column<Integer> col = this.getIntegerColumn("");

		assertEquals("Max element should be 5", true , col.getMax().equals(5));
	}

	@Test
	public void stringMax(){
		Column<String> col = this.getStringColumn("");

		assertEquals("Max element should be z", true , col.getMax().equals("z"));
	}

	@Test
	public void integerMin(){
		Column<Integer> col = this.getIntegerColumn("");

		assertEquals("Min element should be 1", true, col.getMin().equals(1));
	}

	@Test
	public void stringMin(){
		Column<String> col = this.getStringColumn("");

		assertEquals("Min element should be a", true, col.getMin().equals("a"));
	}

	@Test
	public void integerMoyenne(){
		Column<Integer> col = this.getIntegerColumn("");

		assertEquals("Moy element should be 3", true, col.getMoyenne().equals(3));
	}

	@Test
	public void floatMoyenne(){
		Column<Float> col = this.getFloatColumn("");

		assertEquals("Moy element should be 3.2", true , col.getMoyenne().equals((float)3.2));
	}

	private boolean closeEnough(double a, double b) {
		final double epsilon = 0.000001;
		return a<b+epsilon && a>b-epsilon;
	}
	
	@Test
	public void doubleMoyenne(){
		Column<Double> col = this.getDoubleColumn("");
		assertEquals("Moy element should be 3.2 (+-0.000001)", true,closeEnough(col.getMoyenne(),(Double)3.2));
	}

	@Test (expected = UnsupportedOperationException.class)
	public void stringMoyenne(){
		Column<String> col = this.getStringColumn("");
		col.getMoyenne();
	}

	@Test
	public void integerSomme(){
		Column<Integer> col = this.getIntegerColumn("");

		assertEquals("Moy element should be 3", true, col.getSum().equals(9));
	}

	@Test
	public void floatSomme(){
		Column<Float> col = this.getFloatColumn("");

		assertEquals("Moy element should be 3.2", true , col.getSum().equals((float)9.6));
	}
	
	@Test
	public void doubleSomme(){
		Column<Double> col = this.getDoubleColumn("");
		assertEquals("Moy element should be 3.2 (+-0.000001)", true,closeEnough(col.getSum(),(Double)9.6));
	}

	@Test (expected = UnsupportedOperationException.class)
	public void stringSomme(){
		Column<String> col = this.getStringColumn("");
		col.getSum();
	}

}
