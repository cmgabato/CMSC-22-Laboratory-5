import java.io.Serializable;

public class StudentSystem2 implements Serializable{

	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;
	private Course favCourse;
	private String crushName;

	public String toString() {
		return "Student Number: "+studentNumber+"\nName: "+lastName+", "+firstName+" "+middleInitial+".\nProgram: "+course+"\nYear Level: "+yearLevel+"\nCrush: "+crushName+"\n"+favCourse.toString();
	}

	public StudentSystem2(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, String courseCode, String courseDescription){
		setStudentNumber(studentNumber);
		setFirstName(firstName);
		setMiddleInitial(middleInitial);
		setLastName(lastName);
		setCourse(course);
		setYearLevel(yearLevel); 
		setCrushName(crushName);
		setfavCourse(courseCode, courseDescription);
	}

	public void setStudentNumber(String studentNumber){	this.studentNumber = studentNumber; }
	public void setFirstName(String firstName){		this.firstName = firstName;	}
	public void setMiddleInitial(char middleInitial){		this.middleInitial = middleInitial;	}
	public void setLastName(String lastName){		this.lastName = lastName;	}
	public void setCourse(String course){		this.course = course;	}
	public void setYearLevel(int yearLevel){		this.yearLevel = yearLevel;	}
	public void setfavCourse(String courseCode, String courseDescription){		favCourse = new Course(courseCode, courseDescription);	}
	public void setCrushName(String crushName){		this.crushName = crushName;	}

	public String getStudentNumber(){		return studentNumber;	}
	public String getFirstName(){		return firstName;	}
	public char getMiddleInitial(){		return middleInitial;	}
	public String getLastName(){		return lastName;	}
	public String getCourse(){		return course;	}
	public int getYearLevel(){		return yearLevel;	}
	public String getCrushName(){	return crushName;	}
	public Course getFavCourse(){ 	return favCourse;	}
}