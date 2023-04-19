package devop_project.panda;

import java.util.Map;
import java.util.HashMap;

/**
 * 
 * @author insert team name
 *
 */
public class DataFrame {
	@SuppressWarnings("rawtypes")
	private Map<String,Column> dataframe;
	
	/**
	 * create an empty dataframe
	 */
	public DataFrame() {
		dataframe = new HashMap<>();
	}
	
	/**
	 * create a DataFrame with the specified columns
	 * @param columns all columns to use
	 */
	public DataFrame(@SuppressWarnings("rawtypes") Column ...columns) {
		this();
		for(int i=0;i<columns.length;i++) {
			dataframe.put(columns[i].getName(), columns[i]);
		}
	}
	
	/**
	 * 
	 * @param label
	 * @return the column or null if it doesn't exist
	 */
	@SuppressWarnings("rawtypes")
	public Column getColumn(String label) {
		if(!dataframe.containsKey(label)) {
			return null;
		}
		return dataframe.get(label);
	}
	
	public void print() {
		String acc = "";
		for(String lbl : dataframe.keySet()) {
			acc += "[ ";
			acc += dataframe.get(lbl).toString();
			acc += "]\n";
		}
		System.out.print(acc);
	}
}
