/*
 * This is where threading is handled, every client request is handled in a new instance here.
 * Objects are passed in and broken down and reassigned to variables to be sent to the controller to be recollected and sent to the client view.
 */
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class mainThreading extends Thread{
	private Socket mainSocket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private boolean status;
	mainController controller;
	//Constructor where the socket is called in and the controller is declared to be called for calculations.
	public mainThreading(Socket socket, mainController controller){
		this.mainSocket = socket;
		this.controller = controller;
	}
	//The function that handles all the calculations of the input and output objects.
	//This function is also responsible of breaking down the object strings into many variables to be used.
	public void run(){
		try{
			status = true;
			output = new ObjectOutputStream(mainSocket.getOutputStream());
			output.flush();
			input = new ObjectInputStream(mainSocket.getInputStream());
			while(status){
				String converted = input.readObject().toString();
				//Debugging purposes
				//System.out.println("recieved command " + converted);
				//Scanner to scan the object and break it down, the first word is key as it is what will decide what to do with the data passed in.
				Scanner scanner = new Scanner(converted);
				//What seperates data is a /, this is what initiates the next variable and so on.
				scanner.useDelimiter("/");
				String keyword = scanner.next();
				System.out.println(keyword);
        if(keyword.equals("SEARCH")) {
        	//Search case will reassign the scans into variables to be passed into the controller.
        	//Errors will be printed of the console of the server.
        	Integer studentID = null;
        	String firstName;
        	String lastName;
        	String Gender;
        	String Major;
        	Double CGPAF = null;
        	Double CGPAS = null;
        	Integer Year = null;
        	try{studentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Year value Search Empty or Invalid");
			}
        	//studentID = String.valueOf(id);
			firstName = scanner.next();
			lastName = scanner.next();
			Gender = scanner.next(); 
			Major = scanner.next();
			try{Year = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Year value Search Empty or Invalid");
			}
			try{CGPAF = Double.parseDouble(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("CGPA First Range Search Empty or Invalid");
			}
			try{CGPAS = Double.parseDouble(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("CGPA Second Range Search Empty or Invalid");
			}
			try{
			sendData(controller.studentSearch(studentID, firstName, lastName, Gender, Major, Year, CGPAF, CGPAS));
			} 
        	catch (Exception e) {
        		e.printStackTrace();
        		sendData("ERROR " + e.getMessage());
        	}
			System.out.println("Search Completed.");
			System.out.println(" ");
			
        }
        if(keyword.equals("ADD")) {
        	//Add case will reassign the scans into variables to be passed into the controller.
        	//Errors will be printed of the console of the server.
        	Integer studentID = null;
        	String firstName;
        	String lastName;
        	String Initial;
        	String Gender;
        	String Major;
        	Double CGPA = null;
        	String City;
        	String State;
        	String PhoneNumber;
        	Integer Credit = null;
        	Integer Year = null;
        	try{studentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Student ID Value Addition Empty or Invalid");
			}
			firstName = scanner.next();
			lastName = scanner.next();
			Initial = scanner.next();
			Gender = scanner.next(); 
			Major = scanner.next();
			try{CGPA = Double.parseDouble(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("CGPA Value Addition Empty or Invalid");
			}
			City = scanner.next();
			State = scanner.next();
			PhoneNumber = scanner.next();
			try{Credit = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Credit Value Addition Empty or Invalid");
			}
			try{Year = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Year Value Addition Empty or Invalid");
			}
        	try {
        		sendData(controller.addStudent(studentID, firstName, lastName, Initial, Gender, Major, CGPA, City, State, PhoneNumber, Credit, Year));
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
			System.out.println("Student Added Function Completed.");
			System.out.println(" ");
			
        }
        if(keyword.equals("EDIT")) {
        	//Edit case will reassign the scans into variables to be passed into the controller.
        	//Errors will be printed of the console of the server.
        	Integer OldStudentID = null;
        	Integer studentID = null;
        	String firstName;
        	String lastName;
        	String Initial;
        	String Gender;
        	String Major;
        	Double CGPA = null;
        	String City;
        	String State;
        	String PhoneNumber;
        	Integer Credit = null;
        	Integer Year = null;
        	try{OldStudentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Old Student ID Value Edit Empty or Invalid");
			}
        	try{studentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Student ID Value Edit Empty or Invalid");
			}
        	firstName = scanner.next();
			lastName = scanner.next();
			Initial = scanner.next();
			Gender = scanner.next(); 
			Major = scanner.next();
			try{CGPA = Double.parseDouble(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("CGPA Value Edit Empty or Invalid");
			}
			City = scanner.next();
			State = scanner.next();
			PhoneNumber = scanner.next();
			try{Credit = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Credit Value Edit Empty or Invalid");
			}
			try{Year = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Year Value Edit Empty or Invalid");
			}
        	try{
			sendData(controller.editStudent(OldStudentID, studentID, firstName, lastName, Initial, Gender, Major, CGPA, City, State, PhoneNumber, Credit, Year));
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
			System.out.println("Edit Student Completed.");
			System.out.println(" ");
        }
        if(keyword.equals("EDITCOURSE")) {
        	// Edit course works just like how edit works but with different variables.
        	Integer studentID = null;
        	try{studentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Student ID Value Edit Empty or Invalid");
			}
        	String course1;
        	String grade1;
			course1 = scanner.next();
			grade1 = scanner.next();
        	Integer coursecredit1 = null;
			try{coursecredit1 = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Course Credit 1 Empty or Invalid");
			}
        	String course2;
        	String grade2;
			course2 = scanner.next();
			grade2 = scanner.next();
        	Integer coursecredit2 = null;
			try{coursecredit2 = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Course Credit 2 Empty or Invalid");
			}
        	String course3;
        	String grade3;
			course3 = scanner.next();
			grade3 = scanner.next();
        	Integer coursecredit3 = null;
			try{coursecredit3 = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Course Credit 3 Empty or Invalid");
			}
        	String course4;
        	String grade4;
			course4 = scanner.next();
			grade4 = scanner.next();
        	Integer coursecredit4 = null;
			try{coursecredit4 = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Course Credit 4 Empty or Invalid");
			}
        	String course5;
        	String grade5;
			course5 = scanner.next();
			grade5 = scanner.next();
        	Integer coursecredit5 = null;
			try{coursecredit5 = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Course Credit 5 Empty or Invalid");
			}
        	try{
			sendData(controller.editStudentUpdate(studentID, course1, grade1, coursecredit1, course2, grade2, coursecredit2, course3,  grade3, coursecredit3, course4, grade4, coursecredit4, course5, grade5, coursecredit5));
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
			System.out.println("Edit Course Completed.");
			System.out.println(" ");
        }
        if(keyword.equals("REMOVE")) {
        	//Remove case will reassign the scan into a variable to be passed into the controller.
        	//Errors will be printed of the console of the server.
        	Integer studentID = null;
        	try{studentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Student ID Remove Empty or Invalid");
			}
        	try{
        	sendData(controller.removeStudent(studentID));
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
        	System.out.println("Remove Completed.");
			System.out.println(" ");
        }
        if(keyword.equals("RETURNSTUDENTS")) {
        	//Return student case will only return the array list and not pass in any arguments.
        	//Errors will be printed of the console of the server.
        	try{
        		sendData(controller.returnArrayList());
        	} 
        	catch (Exception e) {
        		System.out.println("akaka12");
        		sendData("ERROR " + e.getMessage());
        	}
        	System.out.println("akaka");
        }
        if(keyword.equals("RETURNCOURSESTUDENTS")) {
        	//Return student case will only return the array list and not pass in any arguments.
        	//Errors will be printed of the console of the server.
        	try{
        		sendData(controller.returnCouseArrayList());
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
        }
        if(keyword.equals("ADDTOUPDATETABLE")) {
        	// This case will add in all the required variables into the new table created by the server.
        	Integer studentID = null;
        	try{studentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Student ID Empty or Invalid");
			}
        	try{
        		sendData(controller.addToUpdateTable(studentID));
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
        	System.out.println("Adding Transcript Completed.");
			System.out.println(" ");
        }
        if(keyword.equals("DROPCOURSE")){
        	//Drops a course by resetting the values of courses to zero and empty brackets as they cannot be set to null.
        	Integer studentID = null;
        	try{studentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Student ID Empty or Invalid");
			}
        	String command = scanner.next();
        	try{
        		sendData(controller.dropCourse(studentID,command));
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
        	System.out.println("Course Dropped Successfully.");
			System.out.println(" ");
        }
        if(keyword.equals("STUDENTIDSEARCH")) {
        	//Searches for a student ID
        	Integer studentID = null;
        	try{studentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Student ID Search Empty or Invalid");
			}
        	try{
        	sendData(controller.studentIDSearch(studentID));
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
        	System.out.println("Student ID Search Completed.");
			System.out.println(" ");
        }
        if(keyword.equals("UPDATESTUDENTIDSEARCH")) {
        	//Searches for a student ID within the student update table with the courses information
        	Integer studentID = null;
        	try{studentID = Integer.parseInt(scanner.next());}
			catch(NumberFormatException e){
				System.out.println("Student ID Search Empty or Invalid");
			}
        	try{
        	sendData(controller.updateStudentIDSearch(studentID));
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
        	System.out.println("Course Student ID Search Completed.");
			System.out.println(" ");
        }
        if(keyword.equals("RETURNCGPAAVERAGE")) {
        	try{
        	sendData(controller.returnAverage());
        	} 
        	catch (Exception e) {
        		sendData("ERROR " + e.getMessage());
        	}
        	//controller.returnAverage();
			System.out.println("Average CGPA Return to Client Completed.");
			System.out.println(" ");
        }
}
}
		catch(IOException y){
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				System.out.println("Client disconnected.");
				System.out.println(" ");
				input.close();
				output.close();
				mainSocket.close();
			}
			catch(IOException y){
			}
		}
	}
	//Function to send data to the client.
	public void sendData(Object student){
		try{
			output.writeObject(student);
			output.flush();
			output.reset();
		}
		catch(IOException e){
		}
	}
	//Function that gets object data from the client.
	public Object getData() throws IOException{
		try{
			return(input.readObject());
		}
		catch(ClassNotFoundException e){
		}
		return null;
	}
}