import java.io.Serializable;

public class Course implements Serializable{
	
	private String courseCode;
	private String courseDescription;

	@Override
	public String toString() {
		return "Favorite Course: "+courseCode+" ("+courseDescription+")";
	}

	public Course(String courseCode, String courseDescription){ 
		setCourseCode(courseCode); 
		setcourseDescription(courseDescription);
	}

	public void setCourseCode(String courseCode){ this.courseCode = courseCode; }
	public void setcourseDescription(String courseDescription){ this.courseDescription = courseDescription; }

	public String getCourseCode(){ return courseCode; }
	public String getCourseDescription(){ return courseDescription; }
}
