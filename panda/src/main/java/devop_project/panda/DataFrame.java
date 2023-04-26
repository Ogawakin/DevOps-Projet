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
	 * create a DataFrame starting from a csv file
	 * @param file_name
	 */
	public DataFrame(String file_name) { 
		this ();
	}
	
//	/**
//	 * 
//	 * @param label
//	 * @return the column or null if it doesn't exist
//	 */
//	@SuppressWarnings("rawtypes")
//	private Column getColumn(String label) {
//		if(!dataframe.containsKey(label)) {
//			return null;
//		}
//		return dataframe.get(label);
//	}
	
	/**
	 * 
	 * @param way 
	 * @param n
	 * @return 	the dataframe if way = "all"
	 * 			the n first lines if way = "first"
	 * 			the n last lines if way = "last"
	 */
	protected String toString(String way, int n) {
		String tab = "";
		switch (way) {
		case "all" :
			for(String lbl : dataframe.keySet()) {
				tab += "[ ";
				tab += dataframe.get(lbl).toString();
				tab += "]\n";
			}
			break;
		case "first" :
			
			break;
		case "last" :
			
			break;
		}
		return tab; 
	}
	
	/**
	 * Print all the dataframe
	 */
	public void print() {
		String acc = toString("all", 0);
		System.out.print(acc);
	}
//	
//	/**
//	 * Print the first 5 lines of the dataframe
//	 */
//	public void printStart() {
//		String acc = toString("first", 5);
//		System.out.print(acc);
//	}
//	
//	/**
//	 * Print the 5 last lines of the dataframe
//	 */
//	public void printEnd() {
//		String acc = toString("last", 5);
//		System.out.print(acc);
//	}
//	
//	
//	/**
//	 * 
//	 * @param index
//	 * @return a dataframe of the lines wanted
//	 */
//	public DataFrame selectLine(int ...index) {
//		DataFrame sous_dataframe = this;
//		return sous_dataframe;
//	}
//	
//	/**
//	 * 
//	 * @param labels
//	 * @return a dataframe of the column want
//	 */
//	public DataFrame selectColomn(String ...labels) {
//		DataFrame sous_dataframe = this;
//		
//		
//		
//		return sous_dataframe;
//	}
//	
//	/**
//	 * 
//	 * @param label
//	 * @param val
//	 * @return a datafram where all the valeur at the label are val
//	 */
//	public DataFrame selectWhere(String label, Object val) {
//		DataFrame sous_dataframe = this;
//		
//		return sous_dataframe;
//	}
//	
//	/**
//	 * 
//	 * @param label
//	 * @return the val max on the column
//	 */
//	public Object max(String label) {
//		int max = 0;
//		
//		return max;
//	}
//	
//	/**
//	 * 
//	 * @param label
//	 * @return the val min on the column
//	 */
//	public Object min(String label) {
//		int min = 0;
//		
//		return min;
//	}
//	
//	/**
//	 * 
//	 * @param label
//	 * @return the mean of all the valeur on this column
//	 */
//	public double moyenne(String label) {
//		double sum = 0.;
//		
//		return sum;
//	}
//	
	
	
}
