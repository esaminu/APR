import java.io.Serializable;
/*
 * The Student Update Class, this class stores all the data from the new table containing all the data on the courses.
 * This class follows the exact structure of the student class, the only difference is in the variable names and the number of variables.
 */
public class studentUpdate implements Serializable {
	private static final long serialVersionUID = 1L;
	// Declaring the private fields to be used in each object that will be in the array list
	private Integer studentID;
	private String course1;
	private String grade1;
	private Integer coursecredit1;
	private String course2;
	private String grade2;
	private Integer coursecredit2;
	private String course3;
	private String grade3;
	private Integer coursecredit3;
	private String course4;
	private String grade4;
	private Integer coursecredit4;
	private String course5;
	private String grade5;
	private Integer coursecredit5;
	
	//Constructor
	public studentUpdate(
			Integer studentID, 
			String course1, 
			String grade1, 
			Integer coursecredit1, 
			String course2, 
			String grade2, 
			Integer coursecredit2, 
			String course3, 
			String grade3, 
			Integer coursecredit3, 
			String course4, 
			String grade4, 
			Integer coursecredit4,
			String course5,
			String grade5,
			Integer coursecredit5
		){
		setstudentID(studentID);
		setcourse1(course1);
		setgrade1(grade1);
		setcoursecredit1(coursecredit1);
		setcourse2(course2);
		setgrade2(grade2);
		setcoursecredit2(coursecredit2);
		setcourse3(course3);
		setgrade3(grade3);
		setcoursecredit3(coursecredit3);
		setcourse4(course4);
		setgrade4(grade4);
		setcoursecredit4(coursecredit4);
		setcourse5(course5);
		setgrade5(grade5);
		setcoursecredit5(coursecredit5);
	}
	//This function maps the column number to the field name
	public Object returnColumn(int column){
		//I'm using an object because the type of each variable varies so we just use a general object to store each one.
		Object returnObject = new Object();
		switch(column){
		case 0: returnObject = studentID; break;
		case 1: returnObject = course1; break;
		case 2: returnObject = grade1; break;
		case 3: returnObject = coursecredit1; break;
		case 4: returnObject = course2; break;
		case 5: returnObject = grade2; break;
		case 6: returnObject = coursecredit2; break;
		case 7: returnObject = course3; break;
		case 8: returnObject = grade3; break;
		case 9: returnObject = coursecredit3; break;
		case 10: returnObject = course4;break;
		case 11: returnObject = grade4;break;
		case 12: returnObject = coursecredit4;break;
		case 13: returnObject = course4;break;
		case 14: returnObject = grade4;break;
		case 15: returnObject = coursecredit4;break;
		case 16: returnObject = course5;break;
		case 17: returnObject = grade5;break;
		case 18: returnObject = coursecredit5;
		}
		return returnObject;
	}

	public Integer getstudentID() {
		return this.studentID;
	}

	public void setstudentID(Integer studentID) {
		if(studentID == null)
			throw new IllegalArgumentException("Input valid studentID");
		this.studentID = studentID;
	}

	public String getcourse1() {
		return this.course1;
	}

	public void setcourse1(String course1) {
		this.course1 = course1;
	}

	public String getgrade1() {
		return this.grade1;
	}

	public void setgrade1(String grade1) {
		this.grade1 = grade1;
	}

	public Integer getcoursecredit1() {
		return this.coursecredit1;
	}

	public void setcoursecredit1(Integer coursecredit1) {
		if(coursecredit1 == null)
			throw new IllegalArgumentException("Course Credit 1 Invalid.");
		this.coursecredit1 = coursecredit1;
	}

	public String getcourse2() {
		return this.course2;
	}

	public void setcourse2(String course2) {
		this.course2 = course2;
	}

	public String getgrade2() {
		return this.grade2;
	}

	public void setgrade2(String grade2) {
		this.grade2 = grade2;
	}

	public Integer getcoursecredit2() {
		return this.coursecredit2;
	}

	public void setcoursecredit2(Integer coursecredit2) {
		if(coursecredit2 == null)
			throw new IllegalArgumentException("Course Credit 2 Invalid.");
		this.coursecredit2 = coursecredit2;
	}

	public String getcourse3() {
		return this.course3;
	}

	public void setcourse3(String course3) {
		this.course3 = course3;
	}

	public String getgrade3() {
		return this.grade3;
	}

	public void setgrade3(String grade3) {
		this.grade3 = grade3;
	}	

	public Integer getcoursecredit3() {
		return this.coursecredit3;
	}

	public void setcoursecredit3(Integer coursecredit3) {
		if(coursecredit3 == null)
			throw new IllegalArgumentException("Course Credit 3 Invalid.");
		this.coursecredit3 = coursecredit3;
	}

	public String getcourse4() {
		return this.course4;
	}

	public void setcourse4(String course4) {
		this.course4 = course4;
	}

	public String getgrade4() {
		return this.grade4;
	}

	public void setgrade4(String grade4) {
		this.grade4 = grade4;
	}

	public Integer getcoursecredit4() {
		return this.coursecredit4;
	}

	public void setcoursecredit4(Integer coursecredit4) {
		if(coursecredit4 == null)
			throw new IllegalArgumentException("Course Credit 4 Invalid.");
		this.coursecredit4 = coursecredit4;
	}

	public String getcourse5() {
		return this.course5;
	}

	public void setcourse5(String course5) {
		this.course5 = course5;
	}

	public String getgrade5() {
		return this.grade5;
	}

	public void setgrade5(String grade5) {
		this.grade5 = grade5;
	}

	public Integer getcoursecredit5() {
		return this.coursecredit5;
	}

	public void setcoursecredit5(Integer coursecredit5) {
		if(coursecredit5 == null)
			throw new IllegalArgumentException("Course Credit 5 Invalid.");
		this.coursecredit5 = coursecredit5;
	}
}
