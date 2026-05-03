package ObjectOrientedProgramming.OOPDemo;

import ObjectOrientedProgramming.OOPDemo.Menu.Menu;
import ObjectOrientedProgramming.OOPDemo.Services.*;

import java.util.Scanner;

public class MainApp {

    static Menu menu = new Menu();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        UniversityService universityService = new UniversityService();
        DepartmentService departmentService = new DepartmentService();
        TeacherService teacherService = new TeacherService();
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        boolean mainMenuContinue = true;

        while (mainMenuContinue) {
            menu.displayMenu();

            int option = input.nextInt();
            input.nextLine(); // ✅ FIX buffer issue

            switch (option) {

                // 🔹 University Menu
                case 1 -> {
                    boolean uniMenuContinue = true;
                    while (uniMenuContinue) {
                        System.out.println(" *********** University Menu ***********");
                        int universityOption = input.nextInt();
                        input.nextLine();
                        uniMenuContinue = universityService.handleUniversityMenu(universityOption);
                    }
                }

                // 🔹 Department Menu
                case 2 -> {
                    System.out.println("1- Add Department");
                    System.out.println("2- Display All");
                    System.out.println("3- Search by Name");
                    System.out.println("4- Update");
                    System.out.println("5- Delete");

                    int choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {
                        case 1 -> departmentService.addNewDepartment();
                        case 2 -> departmentService.displayAllDepartments();
                        case 3 -> departmentService.displayDepartmentByName();
                        case 4 -> departmentService.updateDepartment();
                        case 5 -> departmentService.deleteDepartment();
                    }
                }

                // 🔹 Teacher Menu
                case 3 -> {
                    System.out.println("1- Add Teacher");
                    System.out.println("2- Display All");
                    System.out.println("3- Search by Name");
                    System.out.println("4- Update");
                    System.out.println("5- Delete");

                    int choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {
                        case 1 -> teacherService.addNewTeacher();
                        case 2 -> teacherService.displayAllTeachers();
                        case 3 -> teacherService.displayTeacherByName();
                        case 4 -> teacherService.updateTeacher();
                        case 5 -> teacherService.deleteTeacher();
                    }
                }

                // 🔹 Student Menu
                case 4 -> {
                    System.out.println("1- Add Student");
                    System.out.println("2- Display All");
                    System.out.println("3- Search by Name");
                    System.out.println("4- Update");
                    System.out.println("5- Delete");

                    int choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {
                        case 1 -> studentService.addNewStudent();
                        case 2 -> studentService.displayAllStudents();
                        case 3 -> studentService.displayStudentByName();
                        case 4 -> studentService.updateStudent();
                        case 5 -> studentService.deleteStudent();
                    }
                }

                // 🔹 Course Menu
                case 5 -> {
                    System.out.println("1- Add Course");
                    System.out.println("2- Display All");
                    System.out.println("3- Search by Name");
                    System.out.println("4- Update");
                    System.out.println("5- Delete");

                    int choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {
                        case 1 -> courseService.addNewCourse();
                        case 2 -> courseService.displayAllCourses();
                        case 3 -> courseService.displayCourseByName();
                        case 4 -> courseService.updateCourse();
                        case 5 -> courseService.deleteCourse();
                    }
                }

                case 6 -> {
                    System.out.println("Exit");
                    mainMenuContinue = false;
                }

                default -> System.out.println("Select a valid choice");
            }
        }
    }
}
