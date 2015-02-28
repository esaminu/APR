import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
/*
 * The Model - Model Class
 */
public class mainModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Array list declaration
	private ArrayList<Student> studentArray = new ArrayList<Student>();
	//Columns for the tables
	String[] columnNames = {"Student ID", "First Name","Last Name","Initial","Gender","Major","CGPA","City","State","Phone #","Credit","Year"};
	//String[] courseColumnName = {"Course Prefix", "Course Number","Course Title","Grade"};
	//Constructor
	public mainModel(ArrayList<Student> studentModel){
		studentArray = studentModel;
	}
	//Makes the cells in the tables uneditable
	public boolean isCellEditable(int data, int columns){
		return false;
	}
	//Gets the column names per column
	public String getColumnName(int col){
		return columnNames[col];
	}
	//Override method to return the length of the column names
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	//Override method to get the number of rows in the student array
	@Override
	public int getRowCount() {
		return this.studentArray.size();
	}
	//Gets the values at each point in the array
	@Override
	public Object getValueAt(int row, int col) {
		return studentArray.get(row).returnColumn(col);
	}
}
