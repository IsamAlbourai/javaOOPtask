package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Course;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CourseService {

    List<Course> courseList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // 🔹 Add Single Course
    public Course addNewCourse() {
        System.out.println("** Adding new Course **");

        Course course = new Course();
        course.setId(UUID.randomUUID());

        System.out.println("Enter course name:");
        String courseName = scanner.nextLine();
        course.setName(courseName);

        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();
        course.setCourseCode(courseCode);

        courseList.add(course); //  store it

        return course;
    }

    // 🔹 Add Multiple Courses
    public List<Course> addNewCourses() {
        List<Course> newCourses = new ArrayList<>();

        boolean continueFlag = true;
        while (continueFlag) {
            Course course = addNewCourse();
            newCourses.add(course);

            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_COURSE);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }

        return newCourses;
    }

    // 🔹 Display All Courses
    public void displayAllCourses() {
        System.out.println("=== Courses List ===");

        if (courseList.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course course : courseList) {
            System.out.println(course);
        }
    }

    // 🔹 Display Course by Name
    public void displayCourseByName() {
        System.out.println("Enter course name to search:");
        String name = scanner.nextLine();

        for (Course course : courseList) {
            if (course.getName().equalsIgnoreCase(name)) {
                System.out.println(course);
                return;
            }
        }

        System.out.println("Course not found!");
    }

    // 🔹 Update Course
    public void updateCourse() {
        System.out.println("Enter course name to update:");
        String name = scanner.nextLine();

        for (Course course : courseList) {
            if (course.getName().equalsIgnoreCase(name)) {

                System.out.println("Enter new course name:");
                course.setName(scanner.nextLine());

                System.out.println("Enter new course code:");
                course.setCourseCode(scanner.nextLine());

                System.out.println("Course updated successfully.");
                return;
            }
        }

        System.out.println("Course not found!");
    }

    // 🔹 Delete Course
    public void deleteCourse() {
        System.out.println("Enter course name to delete:");
        String name = scanner.nextLine();

        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getName().equalsIgnoreCase(name)) {
                courseList.remove(i);
                System.out.println("Course deleted successfully.");
                return;
            }
        }

        System.out.println("Course not found!");
    }
}
