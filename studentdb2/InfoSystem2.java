import java.io.*;
import java.util.*;
import java.util.regex.*;

public class InfoSystem2{

	private static final String FILE = "C:\\Users\\Chaelle Gabato\\Documents\\CMSC 22\\LAB 13\\db.txt";

	public static void main(String[] args) throws IOException {

		List <StudentSystem2> listOfStudents = new ArrayList<StudentSystem2>();
		String studentNumber, firstName, lastName, course, middleInitial, crushName, courseCode, courseDescription;
		char middleIn;
		int yearLevel;
		Scanner sc = new Scanner(System.in);

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			File impormasyon = new File(FILE);
			fis = new FileInputStream(impormasyon);

			if(impormasyon.length() == 0){
				listOfStudents = new ArrayList<StudentSystem2>();
			}	
			else{
				ois = new ObjectInputStream(fis);
				listOfStudents = (List <StudentSystem2>) ois.readObject();
				ois.close(); 
			}	
		}
		catch(EOFException ex){
			ex.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("FILE NOT FOUND!");
			e.printStackTrace();
			System.exit(0);
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
		finally {
			try{
				fis.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}

		int choice;
		do{
		System.out.println("STUDENT INFORMATION SYSTEM");
		System.out.println("1 - REGISTER\n2 - INFORMATION\n3 - DELETE\n4 - SAVE\n5 - EDIT\n6 - EXIT\n"); 
			choice = sc.nextInt();
			if (choice == 1){
				System.out.println("Student Number: ");
				studentNumber = sc.next();
				register(listOfStudents, studentNumber, sc);
			}
			else if (choice == 2){
				System.out.print("Student Number: ");
				studentNumber = sc.next();
				search(listOfStudents, studentNumber);
			}
			else if (choice == 3){
				System.out.print("Student Number: ");
				studentNumber = sc.next();
				delete(listOfStudents, studentNumber);
			}
			else if (choice == 4){
				save(listOfStudents);
			}	
			else if (choice == 5){
				System.out.println("Student Number: ");
				studentNumber = sc.next();
				edit(listOfStudents, studentNumber, sc);
			}
			else{
				System.out.println("Do you want to save your current work? 1 if YES and 0 if NO.");
				int ifsave = sc.nextInt();
				if(ifsave == 1){
					save(listOfStudents);
				}
				System.out.println("Au revoir! A bientot!");
				break;
			}
		}while (choice<=6 && choice>=1);
	}

	//MODIFIED!
	public static void save(List<StudentSystem2> listOfStudents){
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try{
			File fout = new File(FILE);
			fos = new FileOutputStream(fout);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(listOfStudents);

			System.out.println("The InfoSystem has been saved.");
			oos.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				fos.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	//MODIFIED!
	public static void register(List<StudentSystem2> listOfStudents, String studentNumber, Scanner sc){
		String firstName, lastName, course, crushName, courseCode, courseDescription;
		char middleIn;
		int yearLevel;
				if (listOfStudents.contains(studentNumber)){
						System.out.println("The student number exist.");
				}
				else{
					System.out.println("First Name: ");				
					firstName = sc.next();
					System.out.println("Middle Initial: ");				
					if (sc.nextLine().equals("")){
						middleIn = 32;
					}
					middleIn = sc.next().charAt(0);
						
					System.out.println("Last Name: ");				
					lastName = sc.next();
					System.out.println("Course: ");				
					course = sc.next();
					System.out.println("Year Level: ");				
					yearLevel = sc.nextInt();
					System.out.println("Crush Name: ");				
					crushName = sc.next();
					System.out.println("Favorite Course: ");
					courseCode = sc.next();
					courseDescription = sc.next();

					StudentSystem2 ss2 = new StudentSystem2(studentNumber, firstName, middleIn, lastName, course, yearLevel, crushName, courseCode, courseDescription);
					listOfStudents.add(ss2);
					System.out.println("Student Added!");
				}
	}

	public static void search(List<StudentSystem2> listOfStudents, String studentNumber){
		boolean flag = false;
		for(StudentSystem2 s: listOfStudents){
			if(s.getStudentNumber().equals(studentNumber)){
				System.out.println(s);
				flag = true;
			}
		}
			if (!flag){
				System.out.println("The student number " + studentNumber + " does not exist.");
			}
	}

	public static void delete(List<StudentSystem2> listOfStudents, String studentNumber){
		boolean flag = false;
			for(StudentSystem2 s: listOfStudents){
				if(s.getStudentNumber().equals(studentNumber)){
					listOfStudents.remove(s);
					flag = true;
					break; 
				}
			}
				if (!flag){
					System.out.println("The student number " + studentNumber + " does not exist.");
				}
	}
	
	//MODIFIED!
	public static void edit(List<StudentSystem2> listOfStudents, String studentNumber, Scanner sc){
		String firstName, lastName, course, crushName, courseCode, courseDescription;
		char middleIn;
		int yearLevel;
		boolean flag = false;

		for(StudentSystem2 s: listOfStudents){
			if(s.getStudentNumber().equals(studentNumber)){
				System.out.println("Change First Name: ");
				firstName = sc.next();
				s.setFirstName(firstName);
				System.out.println("Change Middle Initial: ");
				middleIn = sc.next().charAt(0);
				s.setMiddleInitial(middleIn);
				System.out.println("Change Last Name: ");
				lastName = sc.next();
				s.setLastName(lastName);
				System.out.println("Change Course: ");
				course = sc.next();
				s.setCourse(course);
				System.out.println("Change Year Level: ");
				yearLevel = sc.nextInt();
				s.setYearLevel(yearLevel);
				System.out.println("Change Crush Name Level: ");
				crushName = sc.next();
				s.setCrushName(crushName);
				System.out.println("Change Favorite Course: ");
				courseCode = sc.next();
				courseDescription = sc.next();
				s.setfavCourse(courseCode, courseDescription);

				System.out.println("Updated a student!");
				flag = true;
			}
		}
			if (!flag){
				System.out.println("The student number " + studentNumber + " does not exist.");
			}			
	}
}
