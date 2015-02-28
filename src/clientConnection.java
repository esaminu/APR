/*
 * This is the new controller for the client (view), all this controller does is send out data to the server in form of a String Object.
 * It then returns the result of the ArrayList to the view to be put into the jTables.
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
public class clientConnection {
	private Socket mainSocket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private int socket = 6003;
    boolean status;
	public clientConnection() {
	}
	//Function that sends data to server
	public void sendData(Object student){
		try{
			output.writeObject(student);
			output.flush();
			output.reset();
		}
		catch(IOException e){
		}
	}
	//Function that receives data from the server
	public Object getData() throws IOException{
		try{
			Object response =  input.readObject();
			//This will transmit the exception back to the Client if there is an exception to catch.
			if ( response instanceof String ) {
				if ( ((String) response).contains("ERROR") ) {
					throw new IllegalArgumentException((String) response);
				}
			}
			return response;
		}
		catch(ClassNotFoundException e){
		}
		return null;
	}
	//Receives double from the server to be printed to the CGPA average.
	public double getDoubleData() throws IOException{
		return(input.readDouble());
	}
	//Function that sets the connection status to false to terminate connection from client to server
	public void stopConnection(){
		status=false;
	}
	//Function that searches the database
	public ArrayList<Student> studentSearch(Integer studentID, String firstName, String lastName, String Gender, String Major, Integer Year, Double CGPA, Double CGPAS) throws IOException{
		String request = ("SEARCH"+ "/" + studentID + "/" + firstName + "/" + lastName + "/" + Gender + "/" + Major + "/" + Year + "/" +  CGPA  + "/" + CGPAS);
		sendData(request);
		ArrayList<Student> updatedArray = (ArrayList<Student>) getData();
		return updatedArray;
	}
	//Function that receives the average CGPA
	public Double getCGPAAverage() throws IOException{
		String request = ("RETURNCGPAAVERAGE");
		sendData(request);
		//Double CGPAAverage = (Double) getDoubleData();
		Double CGPAAverage = (Double) getData();
		return CGPAAverage;
	}
	//Function that adds a student to the database
	public ArrayList<Student> addStudent(Integer studentID, String firstName, String lastName, String Initial, String Gender,String Major,Double CGPA,String City, String State, String PhoneNumber, Integer Credit, Integer Year) throws IOException{
		String request = String.format("ADD" + "/" + studentID + "/" + firstName + "/" + lastName + "/" + Initial + "/" + Gender + "/" + Major + "/" + CGPA + "/" + City + "/" + State + "/" + PhoneNumber + "/" + Credit + "/" + Year);
		sendData(request);
		ArrayList<Student> updatedArray = (ArrayList<Student>) getData();
		return updatedArray;
	}
	//Function that modifies the student in the database
	public ArrayList<Student> editStudent(Integer OldStudentID, Integer studentID, String firstName, String lastName, String Initial, String Gender,String Major,Double CGPA,String City, String State, String PhoneNumber, Integer Credit, Integer Year) throws IOException{
		String request = String.format("EDIT" + "/" + OldStudentID + "/" + + studentID + "/" + firstName + "/" + lastName + "/" + Initial + "/" + Gender + "/" + Major + "/" + CGPA + "/" + City + "/" + State + "/" + PhoneNumber + "/" + Credit + "/" + Year);
		sendData(request);
		ArrayList<Student> updatedArray = (ArrayList<Student>) getData();
		return updatedArray;
	}
	//Function that modifies the student courses in the database
	public ArrayList<studentUpdate> editStudentUpdate(Integer studentID, String course1, String grade1, Integer coursecredit1, String course2,String grade2,Integer coursecredit2,String course3, String grade3, Integer coursecredit3, String course4, String grade4, Integer coursecredit4, String course5, String grade5, Integer coursecredit5) throws IOException{
		String request = String.format("EDITCOURSE" + "/" + studentID + "/" + course1 + "/" + grade1 + "/" + coursecredit1 + "/" + course2 + "/" + grade2 + "/" + coursecredit2 + "/" + course3 + "/" + grade3 + "/" + coursecredit3 + "/" + course4 + "/" + grade4 + "/" + coursecredit4 + "/" + course5 + "/" + grade5 + "/" + coursecredit5);
		System.out.println(request);
		sendData(request);
		ArrayList<studentUpdate> updatedCourseArray = (ArrayList<studentUpdate>) getData();
		return updatedCourseArray;
	}
	//Function that removes a student to the database
	public ArrayList<Student> removeStudent(Integer studentID) throws IOException{
		String request = String.format("REMOVE" + "/" + studentID);
		sendData(request);
		ArrayList<Student> updatedArray = (ArrayList<Student>) getData();
		return updatedArray;
	}
	//Function that searches the database with the student ID only
	public ArrayList<Student> studentIDSearch(Integer studentID) throws IOException{
		String request = String.format("STUDENTIDSEARCH" + "/" + studentID);
		sendData(request);
		return (ArrayList<Student>) getData();
	}
	//Function that searches the database of courses with the student ID only
	public ArrayList<studentUpdate> updateStudentIDSearch(Integer studentID) throws IOException{
		String request = String.format("UPDATESTUDENTIDSEARCH" + "/" + studentID);
		sendData(request);
		return (ArrayList<studentUpdate>) getData();
	}
	//Function that returns the database of students
	public ArrayList<Student> returnArrayList() throws IOException{
		String request = "RETURNSTUDENTS";
		sendData(request);
		ArrayList<Student> updatedArray = (ArrayList<Student>) getData();
		return updatedArray;
	}
	//Function that returns the database of the courses
	public ArrayList<studentUpdate> returnCouseArrayList() throws IOException{
		String request = "RETURNCOURSESTUDENTS";
		sendData(request);
		ArrayList<studentUpdate> updatedCourseArray = (ArrayList<studentUpdate>) getData();
		return updatedCourseArray;
	}
	//Function that drops a course from the course table.
	public ArrayList<studentUpdate> dropCourse(Integer studentID, String command) throws IOException{
		String request = "DROPCOURSE" + "/" + studentID + "/" + command;
		sendData(request);
		ArrayList<studentUpdate> updatedCourseArray = (ArrayList<studentUpdate>) getData();
		return updatedCourseArray;
	}
	//Function adds to the course table.
	public String[] addToUpdateTable(Integer studentID) throws IOException{
		String request = "ADDTOUPDATETABLE" + "/" + studentID;
		sendData(request);
		String[] updatedCourseArray = (String[]) getData();
		return updatedCourseArray;
	}
	//Function initializes the socket of the client to connect.
	public void intSocket(){
		try{
			status = true;
			System.out.println("Client has connected to the server.");
			this.mainSocket = new Socket("localhost", socket);
			//this.input = new DataInputStream(this.mainSocket.getInputStream());
			this.output = new ObjectOutputStream(this.mainSocket.getOutputStream());
			this.output.flush();
			this.input = new ObjectInputStream(this.mainSocket.getInputStream());
			while(status){
			}
		}
		catch(IOException y){
			System.out.println("Connection Problem.");
			y.printStackTrace();
		}
		
		finally {
			try{
				this.input.close();
				this.output.close();
				this.mainSocket.close();
		}
			catch(IOException y){
				System.out.println("Cannot close the connection.");
				y.printStackTrace();
			}
		}
	}
	public void start() {
	while(status){
	  
	}
	}
}