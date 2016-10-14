public class Student{

	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;

	public String toString() {
		return "Student Number: "+studentNumber+"\nName: "+lastName+", "+firstName+" "+middleInitial+".\nProgram: "+course+"\nYear Level: "+yearLevel+"\n";
	}

	public Student(){
		studentNumber = firstName = middleInitialS = lastName = course = null;
		yearLevel = -1;
	}

	public Student(String studentNumber, String, firstName, char middleInitial, String lastName, String course, int yearLevel){
		setNumber(studentNumber);
		setFirst(firstName);
		setMiddle(middleInitial);
		setLast(lastName);
		setCourse(course);
		setLevel(yearLevel); 
	}

	public void setNumber(String studentNumber){	this.studentNumber = studentNumber; }
	public void setFirst(String firstName){		this.firstName = firstName;	}
	public void setMiddle(char middleInitial){		this.middleInitial = middleInitial;	}
	public void setLast(String lastName){		this.lastName = lastName;	}
	public void setCourse(String course){		this.course = course;	}
	public void setLevel(int yearLevel){		this.yearLevel = yearLevel;	}

	public String getNumber(){		return studentNumber;	}
	public String getFirst(){		return firstName;	}
	public char getMiddle(){		return middleInitial;	}
	public String getLast(){		return lastName;	}
	public String getCourse(){		return course;	}
	public int getLevel(){		return yearLevel;	}
}