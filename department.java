import java.util.*;

public class department {
	int depId;
	String depName;
	ArrayList<student> students;
	ArrayList<course> courses;
	
	public void addStudent(student stu) {
		this.students.add(stu);
	}
	
	public void addCourse(course course) {
		this.courses.add(course);
	}
}
