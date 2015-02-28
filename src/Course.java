/*
 * The Course Object Class
 */
public class Course {
// Declaring the private fields to be used in each object that will be in the array list
private String coursePrefix;
private Integer courseNumber;
private String courseTitle;
private Double Grade;
//Constructor
public Course(String coursePrefix, Integer courseNumber, String courseTitle, Double Grade){
	setcoursePrefix(coursePrefix);
	setcourseNumber(courseNumber);
	setcourseTitlee(courseTitle);
	setGrade(Grade);
}
//This function maps the column number to the field name
public Object returnColumn(int column){
	//I'm using an object because the type of each variable varies so we just use a general object to store each one.
	Object returnObject = new Object();
	switch(column){
	case 0: returnObject = coursePrefix; break;
	case 1: returnObject = courseNumber; break;
	case 2: returnObject = courseTitle; break;
	case 3: returnObject = Grade; break;
	}
	return returnObject;
}
//Student ID get function, accesses and returns data
public String getcoursePrefix() {
	return this.coursePrefix;
}
//Student ID set function
public void setcoursePrefix(String coursePrefix) {
	this.coursePrefix = coursePrefix;
}
//Student First Name get function, accesses and returns data
public Integer getcourseNumber() {
	return this.courseNumber;
}
//Student First Name set function
public void setcourseNumber(Integer courseNumber) {
	this.courseNumber = courseNumber;
}
//Student Last Name get function, accesses and returns data
public String getcourseTitle() {
	return this.courseTitle;
}
//Student Last Name set function
public void setcourseTitlee(String courseTitle) {
	this.courseTitle = courseTitle;
}
//Student Initial get function, accesses and returns data
public Double getGrade() {
	return this.Grade;
}
//Student Initial set function
public void setGrade(Double Grade) {
	this.Grade = Grade;
}
}
