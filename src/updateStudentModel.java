import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
/*
 * A new model for the courses table.
 */
public class updateStudentModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Array list declaration
	private ArrayList<studentUpdate> studentUpdateArray = new ArrayList<studentUpdate>();
	//Columns for the tables
	String[] columnNames = {"Student ID", "Course 1","Grade 1","Course Credits 1", "Course 2","Grade 2","Course Credits 2", "Course 3","Grade 3","Course Credits 3", "Course 4","Grade 4","Course Credits 4", "Course 5","Grade 5","Course Credits 5"};
	//Constructor
	public updateStudentModel(ArrayList<studentUpdate> updateStudentModel){
		studentUpdateArray = updateStudentModel;
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
		return this.studentUpdateArray.size();
	}
	//Gets the values at each point in the array
	@Override
	public Object getValueAt(int row, int col) {
		return studentUpdateArray.get(row).returnColumn(col);
	}
}
