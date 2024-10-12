package uni;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class University {
	
	ArrayList<department> dep = new ArrayList<department>();
	

	public String getString(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public int getInt(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(message)); 
	}
	
	public void newCourse(int depId) {
		boolean checkDep = dep.stream()
					.filter(d -> d.depId==depId)
					.findFirst()
					.isPresent();
		
		if(checkDep) {
			int id = getInt("Department Id");
			String name = getString("Department Name");
			course course = new course(id,name);
			dep.stream()
				.filter(d -> d.depId==id)
				.findFirst()
				.get().addCourse(course);
			JOptionPane.showMessageDialog(null,"Course Saved!");
		}
		else {
			JOptionPane.showMessageDialog(null,"Course Unsaved!");
		}
	}
	
	public void getCourse() {
		dep.forEach(d -> {
			System.out.println("Courses in"+d.depName);
			d.courses.forEach(c -> {
				System.out.println(" - "+c.courseName);
			});
		});
	}
	
	public void newDepartment() {
		int depId=getInt("Department ID");
		boolean depCheck = dep.stream()
				.filter(d -> d.depId==depId)
				.toList()
				.isEmpty();
		
		if(depCheck) {
			department d = new department();
			d.depId=depId;
			d.depName=getString("Enter Dep Name");
			d.students=new ArrayList<student>();
			d.courses=new ArrayList<course>();
			
			dep.add(d);
			JOptionPane.showMessageDialog(null,"Department Saved!");
		}
		
		else {
			JOptionPane.showMessageDialog(null,"Department Unsaved!");
		}
	}
	
	public void getDepartment() {
		dep.forEach(d -> {
			System.out.println(d.depId+" "+d.depName);
			System.out.println("Course in"+d.depName);
			d.courses.forEach(c -> System.out.println(c.courseName));
			System.out.println("Students in"+d.depName);
			d.students.forEach(s -> System.out.println(s.name));
		});
	}
	
	public void newStudent(int depId) {
		boolean checkDep = dep.stream()
				.filter(d -> d.depId == depId)
				.findFirst()
				.isPresent();

		if (checkDep) {
			int stuId = getInt("Student Id");
			String name = getString("Student Name");
			String surname = getString("Student Name");
			student student = new student(stuId, name,surname);

			dep.stream()
				.filter(d -> d.depId == depId)
				.findFirst()
				.get()
				.addStudent(student);

			JOptionPane.showMessageDialog(null, "Student Saved!");
		} else {
			JOptionPane.showMessageDialog(null, "Student Unsaved! Department not found.");
		}
	}
	
	public void getStudent() {
		dep.forEach(d -> {
			System.out.println("Students in"+d.depName);
			d.courses.forEach(c -> {
				System.out.println(" - "+c.courseName);
			});
		});
	}
	
	public static void main(String[] args) {
		University uni = new University();
		uni.newDepartment();
		uni.newCourse(1);
		uni.newStudent(1);
		uni.getDepartment();
		uni.getCourse();
		uni.getStudent();
	}

}
