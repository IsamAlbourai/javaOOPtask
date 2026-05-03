package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Student;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class StudentService {

    CourseService courseService = new CourseService();
    DepartmentService departmentService = new DepartmentService();

    List<Student> studentsList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    // 🔹 Add Single Student
    public Student addNewStudent() {
        System.out.println(" ** Adding new Student **");

        Student student = new Student();
        student.setId(UUID.randomUUID());

        System.out.println("Enter student Name: ");
        String stdName = scanner.nextLine();
        student.setName(stdName); // ✅ FIXED

        System.out.println("Departments List");
        UniversityService.university.displayDepartments();

        System.out.println("Enter Department: ");
        student.setDepartment(departmentService.addNewDepartment());

        student.setCourseList(student.getDepartment().getOfferedCourses());

        studentsList.add(student); // ✅ store student

        return student;
    }

    // 🔹 Add Multiple Students
    public List<Student> addNewStudents() {
        List<Student> newStudents = new ArrayList<>();

        boolean continueFlag = true;
        while (continueFlag) {
            Student student = addNewStudent();
            newStudents.add(student);

            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_STUDENTS);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return newStudents;
    }

    // 🔹 Display All Students
    public void displayAllStudents() {
        System.out.println("=== Students List ===");

        if (studentsList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student student : studentsList) {
            System.out.println(student);
        }
    }

    // 🔹 Display Student by Name
    public void displayStudentByName() {
        System.out.println("Enter student name to search:");
        String name = scanner.nextLine();

        for (Student student : studentsList) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // 🔹 Update Student
    public void updateStudent() {
        System.out.println("Enter student name to update:");
        String name = scanner.nextLine();

        for (Student student : studentsList) {
            if (student.getName().equalsIgnoreCase(name)) {

                System.out.println("Enter new name:");
                student.setName(scanner.nextLine());

                System.out.println("Student updated successfully.");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // 🔹 Delete Student
    public void deleteStudent() {
        System.out.println("Enter student name to delete:");
        String name = scanner.nextLine();

        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getName().equalsIgnoreCase(name)) {
                studentsList.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}