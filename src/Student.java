import java.io.Serializable;
/*
 * The Student Object Class
 */
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	// Declaring the private fields to be used in each object that will be in the array list
	private Integer studentID;
	private String firstName;
	private String lastName;
	private String Initial;
	private String Gender;
	private String Major;
	private Double CGPA;
	private String City;
	private String State;
	private String PhoneNumber;
	private Integer Credit;
	private Integer Year;
	
	//Constructor
	public Student(Integer studentID, String firstName, String lastName, String Initial, String Gender,String Major,Double CGPA,String City, String State, String PhoneNumber, Integer Credit, Integer Year){
		setstudentID(studentID);
		setFirstName(firstName);
		setLastName(lastName);
		setInitial(Initial);
		setGender(Gender);
		setMajor(Major);
		setCGPA(CGPA);
		setCity(City);
		setState(State);
		setPhoneNumber(PhoneNumber);
		setCredit(Credit);
		setYear(Year);
	}
	//This function maps the column number to the field name
	public Object returnColumn(int column){
		//I'm using an object because the type of each variable varies so we just use a general object to store each one.
		Object returnObject = new Object();
		switch(column){
		case 0: returnObject = studentID; break;
		case 1: returnObject = firstName; break;
		case 2: returnObject = lastName; break;
		case 3: returnObject = Initial; break;
		case 4: returnObject = Gender; break;
		case 5: returnObject = Major; break;
		case 6: returnObject = CGPA; break;
		case 7: returnObject = City; break;
		case 8: returnObject = State; break;
		case 9: returnObject = PhoneNumber; break;
		case 10: returnObject = Credit;break;
		case 11: returnObject = Year;
		}
		return returnObject;
	}
	//Student ID get function, accesses and returns data
	public Integer getstudentID() {
		return this.studentID;
	}
	//Student ID set function
	public void setstudentID(Integer studentID) {
		if(studentID == null)
			throw new IllegalArgumentException("Input valid studentID");
		this.studentID = studentID;
	}
	//Student First Name get function, accesses and returns data
	public String getFirstName() {
		return this.firstName;
	}
	//Student First Name set function
	public void setFirstName(String firstName) {
		if(firstName.equals(""))
			throw new IllegalArgumentException("Input valid first name");
		this.firstName = firstName;
	}
	//Student Last Name get function, accesses and returns data
	public String getLastName() {
		return this.lastName;
	}
	//Student Last Name set function
	public void setLastName(String lastName) {
		if(lastName.equals(""))
			throw new IllegalArgumentException("Input valid last name");
		this.lastName = lastName;
	}
	//Student Initial get function, accesses and returns data
	public String getInitial() {
		return this.Initial;
	}
	//Student Initial set function
	public void setInitial(String Initial) {
		this.Initial = Initial;
	}
	//Student Gender get function, accesses and returns data
	public String getGender() {
		return this.Gender;
	}
	//Student Gender set function
	public void setGender(String Gender) {
		this.Gender = Gender;
	}
	//Student Major get function, accesses and returns data
	public String getMajor() {
		return this.Major;
	}
	//Student Major set function
	public void setMajor(String Major) {
		this.Major = Major;
	}
	//Student City get function, accesses and returns data
	public String getCity() {
		return this.City;
	}
	//Student City set function
	public void setCity(String City) {
		this.City = City;
	}
	//Student State get function, accesses and returns data
	public String getState() {
		return this.State;
	}
	//Student State set function
	public void setState(String State) {
		this.State = State;
	}
	//Student CGPA get function, accesses and returns data
	public Double getCGPA() {
		return this.CGPA;
	}
	//Student CGPA set function
	public void setCGPA(Double CGPA) {
		if(CGPA == null)
			throw new IllegalArgumentException("Input valid CGPA");
		this.CGPA = CGPA;
	}	
	//Student Phone Number get function, accesses and returns data
	public String getPhoneNumber() {
		return this.PhoneNumber;
	}
	//Student Phone Number set function
	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}
	
	//Student Credit get function, accesses and returns data
	public Integer getCredit() {
		return this.Credit;
	}
	//Student Credit set function
	public void setCredit(Integer Credit) {
		this.Credit = Credit;
	}
	//Student Year get function, accesses and returns data
	public Integer getYear() {
		return this.Year;
	}
	//Student Year set function
	public void setYear(Integer Year) {
		if(Year == null)
			throw new IllegalArgumentException("Input valid Year");
		this.Year = Year;
	}
}
