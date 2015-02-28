/*
 * Part 3 Comment:
 * This class got some extra functions based on the added functionality, and the databse connection was added the constructor to have multi-threading 
 * for every user's Database interactions.
 * 
 * Part 2 Comment:
 * This class is now completely separate from the view.
 * The controller is now called from the thread class which performs the calculations on the server to be sent back to the client.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.fabric.xmlrpc.base.Array;
/*
 * The Controller - Controller Class
 */
public class mainController {
	//Declaring the variables for the controller to use
	private Double averageCGPA = 0.0;
	private Connection dataBase;
	private ArrayList<Student> studentArray = new ArrayList<Student>();
	private ArrayList<studentUpdate> studentUpdateArray = new ArrayList<studentUpdate>();
	DecimalFormat twoDForm = new DecimalFormat("#.00");
	
	public mainController(Connection dataBase){
		//This constructor will set the arraylist to the default list of students
		this.dataBase = dataBase;
	}
	
	//This method searches based on the student ID input and sets the data to an ArrayListOutput that is updating the table through the model
	public ArrayList<Student> studentIDSearch(Integer studentID){
		ArrayList<Student> studentArray = new ArrayList<Student>();
		try{
		String query = "SELECT * FROM student WHERE 1=1";
		if (studentID != null) {
			query += " AND StudentID = ?";
		}
		PreparedStatement sql = this.dataBase.prepareStatement(query);
		if (studentID != null) {
			sql.setInt(1, studentID);
		}
		ResultSet result = sql.executeQuery();
		while(result.next()){
			Integer StudentID = result.getInt("StudentID");
			String LastName = result.getString("LastName");
			String FirstName = result.getString("FirstName");
			String initial = result.getString("Initial");
			String city = result.getString("City");
			String state = result.getString("State");
			String phone = result.getString("Phone");
			String gender = result.getString("Gender");
			Integer year = result.getInt("Year");
			String major = result.getString("Major");
			Integer credits = result.getInt("Credits");
			Double cgpa = result.getDouble("CGPA");
			Student student = new Student(StudentID, FirstName, LastName, initial, gender, major, cgpa, city, state, phone, credits, year) ;
			studentArray.add(student);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		averageCGPA = averageCGPA / studentArray.size();
		return studentArray;
	}
	//This method will add a student based on the input in the text fields
	public ArrayList<Student> addStudent(Integer studentID, String firstName, String lastName, String Initial, String Gender,String Major,Double CGPA,String City, String State, String PhoneNumber, Integer Credit, Integer Year){
		int i=0;
		if(studentID == null){
			throw new IllegalArgumentException("Student ID Invalid.");
		}
		if(CGPA == null){
			throw new IllegalArgumentException("CGPA Invalid.");
		}
		if(Credit == null){
			throw new IllegalArgumentException("Credit Invalid.");
		}
		if(Year == null){
			throw new IllegalArgumentException("Year Invalid.");
		}
		try{
		String query = "INSERT INTO student (StudentID, FirstName, LastName, Initial, Gender, Major, CGPA, City, State, Phone, Credits, Year)";
		query += " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement sql = this.dataBase.prepareStatement(query);
		i++;sql.setInt(i, studentID);
		i++;sql.setString(i, firstName);
		i++;sql.setString(i, lastName);
		i++;sql.setString(i, Initial);
		i++;sql.setString(i, Gender);
		i++;sql.setString(i, Major);
		i++;sql.setDouble(i, CGPA);
		i++;sql.setString(i, City);
		i++;sql.setString(i, State);
		i++;sql.setString(i, PhoneNumber);
		i++;sql.setInt(i, Credit);
		i++;sql.setInt(i, Year);
		sql.executeUpdate();
		addtoUpdateTableStudent(studentID);
		}
		catch(SQLException e){
			throw new IllegalArgumentException("Student ID Already Exists.");
		}
	return returnArrayList();
	}
	
	public void addtoUpdateTableStudent(Integer studentID){
		int i = 0;
		try{
		String query = "INSERT INTO studentupdate (StudentID, Course_1, Grade_1, CourseCredit_1, Course_2, Grade_2, CourseCredit_2, Course_3, Grade_3, CourseCredit_3, Course_4, Grade_4, CourseCredit_4, Course_5, Grade_5, CourseCredit_5)";
		query += " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement sql = this.dataBase.prepareStatement(query);
		i++;sql.setInt(i, studentID);
		i++;sql.setString(i, " ");
		i++;sql.setString(i, " ");
		i++;sql.setInt(i, 0);
		i++;sql.setString(i, " ");
		i++;sql.setString(i, " ");
		i++;sql.setInt(i, 0);
		i++;sql.setString(i, " ");
		i++;sql.setString(i, " ");
		i++;sql.setInt(i, 0);
		i++;sql.setString(i, " ");
		i++;sql.setString(i, " ");
		i++;sql.setInt(i, 0);
		i++;sql.setString(i, " ");
		i++;sql.setString(i, " ");
		i++;sql.setInt(i, 0);
		sql.executeUpdate();
		}
		catch(SQLException e){
			throw new IllegalArgumentException("Student ID Already Exists.");
		}
	}
	
	//This method will compare the student ID and match it to the object in the search and then set all the preceding elements to the values from the text fields
	public ArrayList<Student> editStudent(Integer OldStudentID, Integer studentID, String firstName, String lastName, String Initial, String Gender,String Major,Double CGPA,String City, String State, String PhoneNumber, Integer Credit, Integer Year){
		int i=0;
		if(OldStudentID == null){
			throw new IllegalArgumentException("Old Student ID Invalid");
		}
		if(studentID == null){
			throw new IllegalArgumentException("Student ID Invalid.");
		}
		if(CGPA == null){
			throw new IllegalArgumentException("CGPA Invalid.");
		}
		if(Credit == null){
			throw new IllegalArgumentException("Credit Invalid.");
		}
		if(Year == null){
			throw new IllegalArgumentException("Year Invalid.");
		}
		try{
		String query = "UPDATE student SET StudentID = ?, FirstName = ?, LastName = ?, Initial = ?, Gender = ?, Major = ?, CGPA = ?, City = ?, State = ?, Phone = ?, Credits = ?, Year = ?";
		query += " WHERE StudentID = ?";
		PreparedStatement sql = this.dataBase.prepareStatement(query);
		i++;sql.setInt(i, studentID);
		i++;sql.setString(i, firstName);
		i++;sql.setString(i, lastName);
		i++;sql.setString(i, Initial);
		i++;sql.setString(i, Gender);
		i++;sql.setString(i, Major);
		i++;sql.setDouble(i, CGPA);
		i++;sql.setString(i, City);
		i++;sql.setString(i, State);
		i++;sql.setString(i, PhoneNumber);
		i++;sql.setInt(i, Credit);
		i++;sql.setInt(i, Year);
		i++;sql.setInt(i, OldStudentID);
		sql.executeUpdate();
		}
		catch(SQLException e){
			throw new IllegalArgumentException("Student Update Failed to Update" + e.getMessage());
		}
	return returnArrayList();
	}
	//This method will compare the student ID and match it to the object in the search and then set all the preceding elements to the values from the text fields
	public ArrayList<studentUpdate> editStudentUpdate(Integer studentID, String course1, String grade1, Integer coursecredit1, String course2,String grade2,Integer coursecredit2,String course3, String grade3, Integer coursecredit3, String course4, String grade4, Integer coursecredit4, String course5, String grade5, Integer coursecredit5){
		int i=0;
		if(studentID == null){
			throw new IllegalArgumentException("Student ID Invalid.");
		}
		if(coursecredit1 == null){
			throw new IllegalArgumentException("Course Credit 1 Invalid or Empty!");
		}
		if(coursecredit2 == null){
			throw new IllegalArgumentException("Course Credit 2 Invalid or Empty!");
		}
		if(coursecredit3 == null){
			throw new IllegalArgumentException("Course Credit 3 Invalid or Empty!");
		}
		if(coursecredit4 == null){
			throw new IllegalArgumentException("Course Credit 4 Invalid or Empty!");
		}
		if(coursecredit5 == null){
			throw new IllegalArgumentException("Course Credit 5 Invalid or Empty!");
		}
		try{
		String query = "UPDATE studentupdate SET Course_1 = ?, Grade_1 = ?, CourseCredit_1 = ?, Course_2 = ?, Grade_2 = ?, CourseCredit_2 = ?, Course_3 = ?, Grade_3 = ?, CourseCredit_3 = ?, Course_4 = ?, Grade_4 = ?, CourseCredit_4 = ?, Course_5 = ?, Grade_5 = ?, CourseCredit_5 = ?";
		query += " WHERE StudentID = ?";
		PreparedStatement sql = this.dataBase.prepareStatement(query);
		i++;sql.setString(i, course1);
		i++;sql.setString(i, grade1);
		i++;sql.setInt(i, coursecredit1);
		i++;sql.setString(i, course2);
		i++;sql.setString(i, grade2);
		i++;sql.setInt(i, coursecredit2);
		i++;sql.setString(i, course3);
		i++;sql.setString(i, grade3);
		i++;sql.setInt(i, coursecredit3);
		i++;sql.setString(i, course4);
		i++;sql.setString(i, grade4);
		i++;sql.setInt(i, coursecredit4);
		i++;sql.setString(i, course5);
		i++;sql.setString(i, grade5);
		i++;sql.setInt(i, coursecredit5);
		i++;sql.setInt(i, studentID);
		sql.executeUpdate();
		//int a = sql.executeUpdate();
		//System.out.println("It works!");
		//System.out.println(a);
		}
		catch(SQLException e){
			throw new IllegalArgumentException("Course Failed to Update" + e.getMessage());
		}
	return returnCouseArrayList();
	} 
	//Since the database does not allow for null values, the values have to be reset to either empty string or 0 for it to be "dropped".
	//This series of switch cases will drop or reset the value based on the user choice from the JCombo.
	public ArrayList<studentUpdate> dropCourse(Integer studentID, String command){
		int i=0;
		if(studentID == null){
			throw new IllegalArgumentException("Student ID Invalid.");
		}
		/*switch(command){
			case"Course 1":{
				try{
				String query = "UPDATE studentupdate SET Course_1 = ?, Grade_1 = ?, CourseCredit_1 = ?";
				query += " WHERE StudentID = ?";
				PreparedStatement sql = this.dataBase.prepareStatement(query);
				i++;sql.setString(i, " ");
				i++;sql.setString(i, " ");
				i++;sql.setInt(i, 0);
				i++;sql.setInt(i, studentID);
				sql.executeUpdate();
				}
				catch(SQLException e){
					throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
					}
				}break;
			case"Course 2":{
				try{
				String query = "UPDATE studentupdate SET Course_2 = ?, Grade_2 = ?, CourseCredit_2 = ?";
				query += " WHERE StudentID = ?";
				PreparedStatement sql = this.dataBase.prepareStatement(query);
				i++;sql.setString(i, " ");
				i++;sql.setString(i, " ");
				i++;sql.setInt(i, 0);
				i++;sql.setInt(i, studentID);
				sql.executeUpdate();
				}
				catch(SQLException e){
					throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
					}
				}break;
			case"Course 3":{
				try{
				String query = "UPDATE studentupdate SET Course_3 = ?, Grade_3 = ?, CourseCredit_3 = ?";
				query += " WHERE StudentID = ?";
				PreparedStatement sql = this.dataBase.prepareStatement(query);
				i++;sql.setString(i, " ");
				i++;sql.setString(i, " ");
				i++;sql.setInt(i, 0);
				i++;sql.setInt(i, studentID);
				sql.executeUpdate();
				}
				catch(SQLException e){
					throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
					}
				}break;
			case"Course 4":{
				try{
				String query = "UPDATE studentupdate SET Course_4 = ?, Grade_4 = ?, CourseCredit_4 = ?";
				query += " WHERE StudentID = ?";
				PreparedStatement sql = this.dataBase.prepareStatement(query);
				i++;sql.setString(i, " ");
				i++;sql.setString(i, " ");
				i++;sql.setInt(i, 0);
				i++;sql.setInt(i, studentID);
				sql.executeUpdate();
				}
				catch(SQLException e){
					throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
					}
				}break;
			case"Course 5":{
				try{
				String query = "UPDATE studentupdate SET Course_5 = ?, Grade_5 = ?, CourseCredit_5 = ?";
				query += " WHERE StudentID = ?";
				PreparedStatement sql = this.dataBase.prepareStatement(query);
				i++;sql.setString(i, " ");
				i++;sql.setString(i, " ");
				i++;sql.setInt(i, 0);
				i++;sql.setInt(i, studentID);
				sql.executeUpdate();
				}
				catch(SQLException e){
					throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
					}
				}break;
		}*/
		if(command.equals("Course 1")){
			try{
				String query = "UPDATE studentupdate SET Course_1 = ?, Grade_1 = ?, CourseCredit_1 = ?";
				query += " WHERE StudentID = ?";
				PreparedStatement sql = this.dataBase.prepareStatement(query);
				i++;sql.setString(i, " ");
				i++;sql.setString(i, " ");
				i++;sql.setInt(i, 0);
				i++;sql.setInt(i, studentID);
				sql.executeUpdate();
				}
				catch(SQLException e){
					throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
					}
				
		}
        if(command.equals("Course 2")){
			try{
			String query = "UPDATE studentupdate SET Course_2 = ?, Grade_2 = ?, CourseCredit_2 = ?";
			query += " WHERE StudentID = ?";
			PreparedStatement sql = this.dataBase.prepareStatement(query);
			i++;sql.setString(i, " ");
			i++;sql.setString(i, " ");
			i++;sql.setInt(i, 0);
			i++;sql.setInt(i, studentID);
			sql.executeUpdate();
			}
			catch(SQLException e){
				throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
				}
		}
        if(command.equals("Course 3")){
        	try{
				String query = "UPDATE studentupdate SET Course_3 = ?, Grade_3 = ?, CourseCredit_3 = ?";
				query += " WHERE StudentID = ?";
				PreparedStatement sql = this.dataBase.prepareStatement(query);
				i++;sql.setString(i, " ");
				i++;sql.setString(i, " ");
				i++;sql.setInt(i, 0);
				i++;sql.setInt(i, studentID);
				sql.executeUpdate();
				}
				catch(SQLException e){
					throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
					}
		}
        if(command.equals("Course 4")){
        	try{
				String query = "UPDATE studentupdate SET Course_4 = ?, Grade_4 = ?, CourseCredit_4 = ?";
				query += " WHERE StudentID = ?";
				PreparedStatement sql = this.dataBase.prepareStatement(query);
				i++;sql.setString(i, " ");
				i++;sql.setString(i, " ");
				i++;sql.setInt(i, 0);
				i++;sql.setInt(i, studentID);
				sql.executeUpdate();
				}
				catch(SQLException e){
					throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
					}
		}
        if(command.equals("Course 5")){
        	try{
				String query = "UPDATE studentupdate SET Course_5 = ?, Grade_5 = ?, CourseCredit_5 = ?";
				query += " WHERE StudentID = ?";
				PreparedStatement sql = this.dataBase.prepareStatement(query);
				i++;sql.setString(i, " ");
				i++;sql.setString(i, " ");
				i++;sql.setInt(i, 0);
				i++;sql.setInt(i, studentID);
				sql.executeUpdate();
				}
				catch(SQLException e){
					throw new IllegalArgumentException("Course Failed to Drop" + e.getMessage());
					}
		}
	return returnCouseArrayList();
	}
	//This method will remove the student from all the databases.
	public ArrayList<Student> removeStudent(Integer studentID){
		if(studentID == null){
			throw new IllegalArgumentException("No student selected.");
		}
		try{
		String query = "DELETE FROM student WHERE StudentID = ?";
		PreparedStatement sql = this.dataBase.prepareStatement(query);
		if (studentID != null) {
			sql.setInt(1, studentID);
		}
		sql.executeUpdate();
		query = "DELETE FROM studentupdate WHERE StudentID = ?";
		sql = this.dataBase.prepareStatement(query);
		if (studentID != null) {
			sql.setInt(1, studentID);
		}
		sql.executeUpdate();
		query = "DELETE FROM transcriptTable WHERE StudentID = ?";
		sql = this.dataBase.prepareStatement(query);
		if (studentID != null) {
			sql.setInt(1, studentID);
		}
		sql.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return returnArrayList();
	}
	//UpdateStudent ID Search
	public ArrayList<studentUpdate> updateStudentIDSearch(Integer studentID){
		ArrayList<studentUpdate> studentUpdateArray = new ArrayList<studentUpdate>();
		try{
		String query = "SELECT * FROM studentupdate WHERE 1=1";
		if (studentID != null) {
			query += " AND StudentID = ?";
		}
		PreparedStatement sql = this.dataBase.prepareStatement(query);
		if (studentID != null) {
			sql.setInt(1, studentID);
		}
		ResultSet result = sql.executeQuery();
		while(result.next()){
			Integer StudentID = result.getInt("StudentID");
			String course1 = result.getString("Course_1");
			String grade1 = result.getString("Grade_1");
			Integer coursecredit1 = result.getInt("CourseCredit_1");
			String course2 = result.getString("Course_2");
			String grade2 = result.getString("Grade_2");
			Integer coursecredit2 = result.getInt("CourseCredit_2");
			String course3 = result.getString("Course_3");
			String grade3 = result.getString("Grade_3");
			Integer coursecredit3 = result.getInt("CourseCredit_3");
			String course4 = result.getString("Course_4");
			String grade4 = result.getString("Grade_4");
			Integer coursecredit4 = result.getInt("CourseCredit_4");
			String course5 = result.getString("Course_5");
			String grade5 = result.getString("Grade_5");
			Integer coursecredit5 = result.getInt("CourseCredit_5");
			studentUpdate studentUpdate = new studentUpdate(StudentID, course1, grade1, coursecredit1, course2, grade2, coursecredit2, course3, grade3, coursecredit3, course4, grade4, coursecredit4, course5, grade5, coursecredit5);
			studentUpdateArray.add(studentUpdate);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return studentUpdateArray;
	}
	//This method returns the complete list of students from the student array
	public ArrayList<studentUpdate> returnCouseArrayList(){
		ArrayList<studentUpdate> studentUpdateArray = new ArrayList<studentUpdate>();
		try{
		Statement sql = this.dataBase.createStatement();
		ResultSet result = sql.executeQuery("SELECT * FROM studentupdate");
		while(result.next()){
			Integer StudentID = result.getInt("StudentID");
			String course1 = result.getString("Course_1");
			String grade1 = result.getString("Grade_1");
			Integer coursecredit1 = result.getInt("CourseCredit_1");
			String course2 = result.getString("Course_2");
			String grade2 = result.getString("Grade_2");
			Integer coursecredit2 = result.getInt("CourseCredit_2");
			String course3 = result.getString("Course_3");
			String grade3 = result.getString("Grade_3");
			Integer coursecredit3 = result.getInt("CourseCredit_3");
			String course4 = result.getString("Course_4");
			String grade4 = result.getString("Grade_4");
			Integer coursecredit4 = result.getInt("CourseCredit_4");
			String course5 = result.getString("Course_5");
			String grade5 = result.getString("Grade_5");
			Integer coursecredit5 = result.getInt("CourseCredit_5");
			studentUpdate studentUpdate = new studentUpdate(StudentID, course1, grade1, coursecredit1, course2, grade2, coursecredit2, course3, grade3, coursecredit3, course4, grade4, coursecredit4, course5, grade5, coursecredit5) ;
			studentUpdateArray.add(studentUpdate);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return studentUpdateArray;
	}
	//This method returns the complete list of students from the student array
	public  ArrayList<Student> returnArrayList(){
		ArrayList<Student> studentArray = new ArrayList<Student>();
		try{
		Statement sql = this.dataBase.createStatement();
		ResultSet result = sql.executeQuery("SELECT * FROM student");
		while(result.next()){
			Integer StudentID = result.getInt("StudentID");
			String lastName = result.getString("LastName");
			String firstName = result.getString("FirstName");
			String initial = result.getString("Initial");
			String city = result.getString("City");
			String state = result.getString("State");
			String phone = result.getString("Phone");
			String gender = result.getString("Gender");
			Integer year = result.getInt("Year");
			String major = result.getString("Major");
			Integer credits = result.getInt("Credits");
			Double cgpa = result.getDouble("CGPA");
			Student student = new Student(StudentID, firstName, lastName, initial, gender, major, cgpa, city, state, phone, credits, year) ;
			studentArray.add(student);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return studentArray;
	}
	//This method adds the entries into the extra table, It will update the values if the report is re-generated.
	public String[] addToUpdateTable(Integer studentID){
		int i = 0;
		ArrayList<Student> studentlist = studentIDSearch(studentID);
		Student studentlistupdate = studentlist.get(0);
		
		ArrayList<studentUpdate> list = updateStudentIDSearch(studentID);
		studentUpdate listupdate = list.get(0);
		
		int NewTotalCredits = listupdate.getcoursecredit1() + listupdate.getcoursecredit2() + listupdate.getcoursecredit3() + listupdate.getcoursecredit4() + listupdate.getcoursecredit5();
		double NewTotalPoints = (listupdate.getcoursecredit1() * switchValue(listupdate.getgrade1())) + (listupdate.getcoursecredit2() * switchValue(listupdate.getgrade2())) + (listupdate.getcoursecredit3() * switchValue(listupdate.getgrade3())) + (listupdate.getcoursecredit4() * switchValue(listupdate.getgrade4())) + (listupdate.getcoursecredit5() * switchValue(listupdate.getgrade5()));
		double GPA = (NewTotalPoints/NewTotalCredits);
		double pointsEarnedToDate = studentlistupdate.getCGPA() * studentlistupdate.getCredit();
		double CGPA = (pointsEarnedToDate + NewTotalPoints) / (studentlistupdate.getCredit() + NewTotalCredits);
		int finalCredits = NewTotalCredits + studentlistupdate.getCredit();
		String CGPAString = twoDForm.format(CGPA);
		String CurrentCGPAString = twoDForm.format(GPA);
		
		try{
			String query = "INSERT INTO transcriptTable (StudentID, FirstName, LastName, Initial, Credits, CGPA)";
			query += " VALUES(?,?,?,?,?,?)";
			query += " ON DUPLICATE KEY UPDATE StudentID = ?, FirstName = ?, LastName = ?, Initial = ?, Credits = ?, CGPA = ?";
			PreparedStatement sql = this.dataBase.prepareStatement(query);
			i++;sql.setInt(i, studentID);
			i++;sql.setString(i, studentlistupdate.getFirstName());
			i++;sql.setString(i, studentlistupdate.getLastName());
			i++;sql.setString(i, studentlistupdate.getInitial());
			i++;sql.setInt(i, finalCredits);
			i++;sql.setDouble(i, CGPA);
			i++;sql.setInt(i, studentID);
			i++;sql.setString(i, studentlistupdate.getFirstName());
			i++;sql.setString(i, studentlistupdate.getLastName());
			i++;sql.setString(i, studentlistupdate.getInitial());
			i++;sql.setInt(i, finalCredits);
			i++;sql.setDouble(i, CGPA);
			sql.executeUpdate();
		}
		catch(SQLException e){
			throw new IllegalArgumentException(e.getMessage());
		}
		String returnedList[]={
				studentID.toString(), 
				studentlistupdate.getFirstName(), 
				studentlistupdate.getLastName(),
				studentlistupdate.getInitial(),
				listupdate.getcourse1(),
				listupdate.getcourse2(),
				listupdate.getcourse3(),
				listupdate.getcourse4(),
				listupdate.getcourse5(),
				listupdate.getgrade1(),
				listupdate.getgrade2(),
				listupdate.getgrade3(),
				listupdate.getgrade4(),
				listupdate.getgrade5(),
				listupdate.getcoursecredit1().toString(),
				listupdate.getcoursecredit2().toString(),
				listupdate.getcoursecredit3().toString(),
				listupdate.getcoursecredit4().toString(),
				listupdate.getcoursecredit5().toString(),
				Integer.toString(NewTotalCredits),
				CurrentCGPAString,
				CGPAString
				};
		return returnedList;
	}
	
	//This method creates the extra table, it is run every time the server is initiated and will not be executed if the table exists.
	public void createUpdatedTable(){
		try{
			Statement sql = this.dataBase.createStatement();
			sql.executeUpdate("CREATE TABLE IF NOT EXISTS transcriptTable "
					+ "(StudentID int(10) unsigned NOT NULL,"
					+ "LastName char(30) NOT NULL,"
					+ "FirstName char(30) NOT NULL,"
					+ "Initial char(1) NOT NULL,"
					+ "Credits int(10) unsigned NOT NULL,"
					+ "CGPA decimal(10,2) NOT NULL,"
					+ "PRIMARY KEY (StudentID)) "
					+ " ENGINE=InnoDB DEFAULT CHARSET=latin1");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	//This method searches through to exactly match all of the inputs based on any input that is used in the search
	public  ArrayList<Student> studentSearch(Integer studentID, String firstName, String lastName, String Gender, String Major, Integer Year, Double CGPA, Double CGPAS){
		averageCGPA = 0.0;
		ArrayList<Student> studentArray = new ArrayList<Student>();
		try{
		if(!(Gender.equalsIgnoreCase("M") || Gender.equalsIgnoreCase("F"))){
			Gender = "";
		}
		int i = 0;
		String query = "SELECT * FROM student WHERE 1=1";
		if (studentID != null) {
			query += " AND StudentID = ?";
		}
		if (Year != null) {
			query += " AND Year = ?";
		}
		if (CGPA !=null && CGPAS !=null){
			query += " AND CGPA BETWEEN ? AND ?";
		}
		query +=" AND FirstName LIKE ? AND LastName LIKE ? AND Gender LIKE ? AND Major LIKE ?";
		PreparedStatement sql = this.dataBase.prepareStatement(query);
		if (studentID != null) {
			i++; sql.setInt(i, studentID);
		}
		if (Year != null) {
			i++; sql.setInt(i, Year);
		}
		if (CGPA != null && CGPAS != null) {
			i++; sql.setDouble(i, CGPA);
			i++; sql.setDouble(i, CGPAS);
		}
		i++; sql.setString(i,  firstName+"%");
		i++; sql.setString(i, lastName+"%");
		i++; sql.setString(i, "%"+Gender+"%");
		i++; sql.setString(i, Major+"%");
		//i++; sql.setString(i, "%"+studentID+"%");
		System.out.println(sql);
		ResultSet result = sql.executeQuery();
		while(result.next()){
			Integer StudentID = result.getInt("StudentID");
			String LastName = result.getString("LastName");
			String FirstName = result.getString("FirstName");
			String initial = result.getString("Initial");
			String city = result.getString("City");
			String state = result.getString("State");
			String phone = result.getString("Phone");
			String gender = result.getString("Gender");
			Integer year = result.getInt("Year");
			String major = result.getString("Major");
			Integer credits = result.getInt("Credits");
			Double cgpa = result.getDouble("CGPA");
			averageCGPA += cgpa;
			//String content = "";
			 
			File file = new File("filename2.txt");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(LastName);
			bw.close();
			Student student = new Student(StudentID, FirstName, LastName, initial, gender, major, cgpa, city, state, phone, credits, year);
			studentArray.add(student);
			
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		averageCGPA = averageCGPA / studentArray.size();
		return studentArray;
	}
	
	//Sets the letter grade to the corresponding value for processing.
	public double switchValue(String keyword){
		double value = 0.0;
		if(keyword.equals("A")){
			value = 4.0;
		}
        if(keyword.equals("A-")){
        	value = 3.7;
		}
        if(keyword.equals("B+")){
        	value = 3.3;
		}
        if(keyword.equals("B")){
        	value = 3.0;
		}
        if(keyword.equals("B-")){
        	value = 2.7;
		}
        if(keyword.equals("C+")){
        	value = 2.3;
		}
        if(keyword.equals("C")){
        	value = 2.0;
		}
        if(keyword.equals("C-")){
        	value = 1.7;
		}
        if(keyword.equals("D+")){
        	value = 1.3;
		}
        if(keyword.equals("D")){
        	value = 1.0;
		}
        if(keyword.equals("D-")){
        	value = 0.7;
		}
        if(keyword.equals("F")){
        	value = 0.0;
		}
		return value;
	}
	
	//Returns the averageCGPA to be printed in the text field
	public Double returnAverage(){
		return averageCGPA;
	}
}