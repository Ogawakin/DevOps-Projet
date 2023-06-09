package devop_project.panda;

import java.util.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Vector;

import java.util.HashMap;

import java.lang.NullPointerException;

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
	 * @param c column to add
	 * @return this
	 */
	public DataFrame addColumn(@SuppressWarnings("rawtypes") Column c) {
		dataframe.put(c.getName(), c);
		return this;
	}
	
	/**
	 * create a DataFrame starting from a csv file
	 * first line of the file must contain one of those type :
	 * string, int, float, double
	 * If not, no comportement is garantied
	 * @param file_name
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataFrame(String file_name) throws IOException { 
		this();
		BufferedReader reader = new BufferedReader(new FileReader(file_name));
		
		String[] types = reader.readLine().split(",");
		String[] names = reader.readLine().split(",");
		
		for(String name:names) {
			addColumn(new Column(name));
		}
		
		String s = reader.readLine();
		while(s!=null) {
			String[] values = s.split(",");
			for(int i=0;i<values.length;i++) {
				if(types[i].equals("string")) {
					dataframe.get(names[i]).addElement(values[i]);
				} else
				if(values[i].equals("NaN")) {
					dataframe.get(names[i]).addElement(values[i]);
				} else
				if(types[i].equals("int")) {
					dataframe.get(names[i]).addElement(Integer.valueOf(values[i]));
				} else 
				if(types[i].equals("float")) {
					dataframe.get(names[i]).addElement(Float.valueOf(values[i]));
				} else
				if(types[i].equals("double")) {
					dataframe.get(names[i]).addElement(Double.valueOf(values[i]));
				} else {
					//do thing here
				}
			}
			s = reader.readLine();
		}
		reader.close();
	}
	
	/**
	 * 
	 * @param label
	 * @return the column or null if it doesn't exist
	 */
	@SuppressWarnings("rawtypes")
	private Column getColumn(String label) {
		if(!dataframe.containsKey(label)) {
			return null;
		}
		return dataframe.get(label);
	}
	
	public int getSize() {
		return dataframe.keySet().size();
	}
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
			for(String lbl : dataframe.keySet()) {
				tab += "[ ";
				tab += getColumn(lbl).getName() + " : ";
				for (int i = 0; i < n; i++) {
					tab += getColumn(lbl).getElement(i).toString() + " ";
				}
				tab += "]\n";
			}
			break;
		case "last" :
			for(String lbl : dataframe.keySet()) {
				tab += "[ ";
				tab += getColumn(lbl).getName() + " : ";
				for (int i = 0; i < n; i++) {
					tab += getColumn(lbl).getElement(getColumn(lbl).getSize() -1 -i).toString() + " ";
				}
				tab += "]\n";
			}
			break;
		}
		return tab; 
	}
	
	public String toString() {
		return toString("all",0);
	}
	
	/**
	 * Print all the dataframe
	 */
	public void print() {
		String acc = toString("all", 0);
		System.out.print(acc);
	}
  
	/**
	 * Print the first 5 lines of the dataframe
	 */
	public void printStart() {
		String acc = toString("first", 5);
		System.out.print(acc);
	}
	
	/**
	 * Print the 5 last lines of the dataframe
	 */
	public void printEnd() {
		String acc = toString("last", 5);
		System.out.print(acc);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		DataFrame D = (DataFrame) o;
		dataframe.keySet();
		
		if(D.getSize()!= this.getSize()) {
			return false;
		}
		
		for(String key : dataframe.keySet()) {
			if (!(getColumn(key).equals(D.getColumn(key)))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param index
	 * @return a dataframe of the lines wanted
	 */
	@SuppressWarnings("unchecked")
	public DataFrame selectLine(int ...index) {
		DataFrame sous_dataframe = this;
		dataframe.keySet();
		for(int i : index){
			if(i >= dataframe.size()){
				throw new IndexOutOfBoundsException();
			}
		}
		for(String key : dataframe.keySet()) {
			@SuppressWarnings("rawtypes")
			Column new_c = new Column(key);
			@SuppressWarnings("rawtypes")
			Column c = getColumn(key);
			for(int i : index){
				new_c.addElement(c.getElement(i));
			}
			sous_dataframe.addColumn(new_c);
		}
		return sous_dataframe;
	}
	
	/**
	 * 
	 * @param label
	 * @return the val max on the column
	 */
	@SuppressWarnings("rawtypes")
	public Object max(String label) {

		Column col = this.getColumn(label);
		if(col == null){
			throw new NullPointerException();
		}

		return col.getMax();
	}
	
	/**
	 * 
	 * @param labels
	 * @return a dataframe of the column want
	 * @throw IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public DataFrame selectColumn(String ...labels){
		DataFrame sous_dataframe = new DataFrame();
		
		for(int i=0;i<labels.length;i++) {
			@SuppressWarnings("rawtypes")
			Column new_c = new Column(labels[i]);
			@SuppressWarnings("rawtypes")
			Column c = getColumn(labels[i]);

			if(c == null){
				throw new NullPointerException();
			}
				
			for (int j=0; j< c.getSize(); j++) {
				new_c.addElement(c.getElement(j));
			}
			sous_dataframe.addColumn(new_c);

		}
		return sous_dataframe;
	}
 /** 
	 * @param label
	 * @return the val min on the column
	 */
	@SuppressWarnings("rawtypes")
	public Object min(String label) {
		Column col = this.getColumn(label);
		if(col == null){
			throw new NullPointerException();
		}

		return col.getMin();
	}
	
	/**
	 * 
	 * @param label
	 * @param val
	 * @return a datafram where all the valeur at the label are val
	 */
	@SuppressWarnings("unchecked")
	public DataFrame selectWhere(String label, Object val) {
		DataFrame sous_dataframe = this;
		Vector<Integer> index = new Vector<Integer>();
		@SuppressWarnings("rawtypes")
		Column c = getColumn(label);
		for (int i=0; i < c.getSize(); i++) {
			if (c.getElement(i) == val){
				index.add(i);
			}
		}
		
		for(String key : dataframe.keySet()) {
			@SuppressWarnings("rawtypes")
			Column new_c = new Column(key);
			@SuppressWarnings("rawtypes")
			Column column = getColumn(key);
			for(int i : index){
				new_c.addElement(column.getElement(i));
			}
			sous_dataframe.addColumn(new_c);
		}
		
		return sous_dataframe;
	}
  
  /* @param label
	 * @return the mean of all the valeur on this column
	 */
	@SuppressWarnings("rawtypes")
	public Object moyenne(String label) {
		Column col = this.getColumn(label);
		if(col == null){
			throw new NullPointerException();
		}
		
		return col.getMoyenne();
	}
}
