package devop_project.panda;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColumnTest {

	@Test
	public void emptyColumn() {
		String name = "myColumn";
		Column<String> c = new Column<>(name);
		assertEquals("name of the column not the same",name,c.getName());
		assertEquals("number of column not null",0,c.getSize());
	}

}
