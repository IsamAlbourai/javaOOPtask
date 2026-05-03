package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Teacher;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService {

    static Integer counter = 1;

    PersonService personService = new PersonService();
    DepartmentService departmentService = new DepartmentService();
    CourseService courseService = new CourseService();

    List<Teacher> teacherList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // 🔹 Add Single Teacher
    public Teacher addNewTeacher() {
        System.out.println("** Adding new teacher **");

        Teacher teacher = (Teacher) personService.addNewPerson();

        teacher.setTeacherId("TH-" + counter);
        counter += 1;

        System.out.println("Departments & Associated Courses: ");
        UniversityService.university.displayDepartments();

        teacher.setDepartment(departmentService.addNewDepartment());

        teacher.setCourseList(courseService.addNewCourses());

        teacherList.add(teacher); // ✅ store teacher

        return teacher;
    }

    // 🔹 Add Multiple Teachers
    public List<Teacher> addNewTeachers() {
        List<Teacher> newTeachers = new ArrayList<>();

        boolean continueFlag = true;
        while (continueFlag) {
            Teacher teacher = addNewTeacher();
            newTeachers.add(teacher);

            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_TEACHER);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return newTeachers;
    }

    // 🔹 Display All Teachers
    public void displayAllTeachers() {
        System.out.println("=== Teachers List ===");

        if (teacherList.isEmpty()) {
            System.out.println("No teachers available.");
            return;
        }

        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    // 🔹 Display Teacher by Name
    public void displayTeacherByName() {
        System.out.println("Enter teacher name to search:");
        String name = scanner.nextLine();

        for (Teacher teacher : teacherList) {
            if (teacher.getName().equalsIgnoreCase(name)) {
                System.out.println(teacher);
                return;
            }
        }

        System.out.println("Teacher not found!");
    }

    // 🔹 Update Teacher
    public void updateTeacher() {
        System.out.println("Enter teacher name to update:");
        String name = scanner.nextLine();

        for (Teacher teacher : teacherList) {
            if (teacher.getName().equalsIgnoreCase(name)) {

                System.out.println("Enter new name:");
                teacher.setName(scanner.nextLine());

                System.out.println("Teacher updated successfully.");
                return;
            }
        }

        System.out.println("Teacher not found!");
    }

    // 🔹 Delete Teacher
    public void deleteTeacher() {
        System.out.println("Enter teacher name to delete:");
        String name = scanner.nextLine();

        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getName().equalsIgnoreCase(name)) {
                teacherList.remove(i);
                System.out.println("Teacher deleted successfully.");
                return;
            }
        }

        System.out.println("Teacher not found!");
    }
}
