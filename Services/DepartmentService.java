package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DepartmentService {

    CourseService courseService = new CourseService();

    List<Department> departmentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // 🔹 Add Single Department
    public Department addNewDepartment() {
        System.out.println("** Adding new department **");

        Department department = new Department();
        department.setId(UUID.randomUUID());

        System.out.println("Enter Department Name:");
        String deptName = scanner.nextLine();
        department.setName(deptName);

        department.setOfferedCourses(courseService.addNewCourses());

        departmentList.add(department); // store it

        return department;
    }

    // 🔹 Add Multiple Departments
    public List<Department> addNewDepartments() {
        List<Department> newDepartments = new ArrayList<>();

        boolean continueFlag = true;
        while (continueFlag) {
            Department dept = addNewDepartment();
            newDepartments.add(dept);

            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_DEPARTMENTS);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return newDepartments;
    }

    // 🔹 Display All Departments
    public void displayAllDepartments() {
        System.out.println("=== Departments List ===");

        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }

        for (Department dept : departmentList) {
            System.out.println(dept);
        }
    }

    // 🔹 Display Department by Name
    public void displayDepartmentByName() {
        System.out.println("Enter department name to search:");
        String name = scanner.nextLine();

        for (Department dept : departmentList) {
            if (dept.getName().equalsIgnoreCase(name)) {
                System.out.println(dept);
                return;
            }
        }

        System.out.println("Department not found!");
    }

    // 🔹 Update Department
    public void updateDepartment() {
        System.out.println("Enter department name to update:");
        String name = scanner.nextLine();

        for (Department dept : departmentList) {
            if (dept.getName().equalsIgnoreCase(name)) {

                System.out.println("Enter new department name:");
                dept.setName(scanner.nextLine());

                System.out.println("Department updated successfully.");
                return;
            }
        }

        System.out.println("Department not found!");
    }

    // 🔹 Delete Department
    public void deleteDepartment() {
        System.out.println("Enter department name to delete:");
        String name = scanner.nextLine();

        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getName().equalsIgnoreCase(name)) {
                departmentList.remove(i);
                System.out.println("Department deleted successfully.");
                return;
            }
        }

        System.out.println("Department not found!");
    }
}
