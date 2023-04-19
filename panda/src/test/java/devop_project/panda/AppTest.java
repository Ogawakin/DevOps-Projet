package devop_project.panda;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Vector;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    
    @Test
    public void constructeurEmptyColumn()
    {
        Column emptyColumn = new Column("");
    }
    
    
    @Test
    public void constructeurNoneEmptyColumnEmptyVector()
    {
    	Vector<Integer> vect = new Vector<Integer>();
        Column<Integer> noneEmptyColumn = new Column<Integer>("list_int",vect);
    }
    
    @Test
    public void constructeurNoneEmptyColumnNoneEmptyVector()
    {
    	Vector<Integer> vect = new Vector<Integer>();
    	vect.add(1);
    	vect.add(3);
    	vect.add(5);
        Column<Integer> noneEmptyColumn = new Column<Integer>("list_int",vect);
    }
    
    public Column getEmptyColumn(String s) {
    	
    	Column emptyColumn = new Column(s);
    	return emptyColumn;
    }
    
	public Column getIntegerColumn(String s) {
	    	
		Vector<Integer> vect = new Vector<Integer>();
		vect.add(1);
		vect.add(3);
		vect.add(5);
		Column integerColumn = new Column(s,vect);
		return integerColumn;
	}
	
	public Column getStringColumn(String s) {
		
		Vector<String> vect = new Vector<String>();
		vect.add("a");
		vect.add("z");
		vect.add("e");
		vect.add("r");
		vect.add("t");
		Column stringColumn = new Column(s,vect);
		return stringColumn;
	}
    
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
    	Column col = getEmptyColumn("empty");
    	assertEquals("Test getSize on empty column",0, col.getSize());
    	
    	Column col2 = getIntegerColumn("Integer");
    	assertEquals("Test getSize on integer column with size 3",3, col2.getSize());
    
    	Column col3 = getStringColumn("String");
    	assertEquals("Test getSize on string column with size 5",5, col3.getSize());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void columnGetElementNegatif()
    {
    	Column col = getEmptyColumn("empty");
    	col.getElement(-1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void columnGetElementZeroOnEmptyList()
    {
    	Column col = getEmptyColumn("empty");
    	col.getElement(0);
    }	
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void columnGetElementTooHighIndexOnEmpty()
    {
    	Column col = getEmptyColumn("empty");
    	col.getElement(1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void columnGetElementTooHighIndexOnNonEmpty()
    {
    	Column col = getIntegerColumn("interget");
    	col.getElement(15);
    }
    
    @Test
    public void columnGetElementFirst()
    {
    	Column col = getIntegerColumn("integer");
    	assertEquals("Test getElement on integer list, get first element",1,col.getElement(0));
    
    	Column col2 = getStringColumn("string");
    	assertEquals("Test getElement on string list, get first element","a",col2.getElement(0));
    }
    
    @Test
    public void columnGetElementRandomIndex()
    {
    	Column col = getIntegerColumn("integer");
    	assertEquals("Test getElement on integer list, get first element",3,col.getElement(1));
    
    	Column col2 = getStringColumn("string");
    	assertEquals("Test getElement on string list, get first element","e",col2.getElement(2));
    }
    
    @Test
    public void columnGetElementLast()
    {
    	Column col = getIntegerColumn("integer");
    	assertEquals("Test getElement on integer list, get first element",5,col.getElement(2));
    
    	Column col2 = getStringColumn("string");
    	assertEquals("Test getElement on string list, get first element","t",col2.getElement(4));
    }
    
    @Test
    public void constructeurEmptyDataFrame()
    {
        DataFrame df = new DataFrame();
    }
}
