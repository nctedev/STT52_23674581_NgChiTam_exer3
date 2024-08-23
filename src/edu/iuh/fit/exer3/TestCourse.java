/**
 * @description:
 * @author: Tam, Nguyen Chi Tam
 * @version: 1.0
 * @created: 8/21/2024
 */

package edu.iuh.fit.exer3;


import java.util.Scanner;

public class TestCourse {

    public static void main(String[] args) {
//        Course c1 = new Course();
        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(5);
        initData(courseList);

        while (true) {
            System.out.println("Course Management Menu:");
            System.out.println("1. Add Course");
            System.out.println("2. Get Course List");
            System.out.println("3. Remove Course");
            System.out.println("4. Find Course by ID");
            System.out.println("5. Find Courses by Title");
            System.out.println("6. Find Courses by Department");
            System.out.println("7. Sort Courses by Title");
            System.out.println("8. Find Courses with Max Credit");
            System.out.println("9. Find Department with Most Courses");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1: // Add Course
                    System.out.print("Enter Course ID: ");
                    String id1 = sc.nextLine();
                    System.out.print("Enter Course Title: ");
                    String title1 = sc.nextLine();
                    System.out.print("Enter Course Credit: ");
                    int credit1 = sc.nextInt();
                    sc.nextLine(); // Clear newline
                    System.out.print("Enter Department: ");
                    String department1 = sc.nextLine();
                    Course course = new Course(id1,  credit1, department1, title1);
                    courseList.addCourse(course);
                case 2: // getCourseList
                    Course[] courses = courseList.getCourses();
                    for (Course c : courses) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3: // Remove Course
                    System.out.print("Enter Course ID to remove: ");
                    String id = sc.nextLine();
                    courseList.removeCourse(id);
                    break;
                case 4: // Find Course by ID
                    System.out.print("Enter Course ID to find: ");
                    id = sc.nextLine();
                    Course c = courseList.findCourse(id);
                    if (c != null) {
                        System.out.println(c);
                    } else {
                        System.out.println("Course not found");
                    }
                    break;
                case 5: // Find Courses by Title
                    System.out.print("Enter Course Title to find: ");
                    String title = sc.nextLine();
                    Course[] res = courseList.findCoursebyName(title);
                    if (res != null) {
                        for (Course course2 : res) {
                            if (course2 != null)
                                System.out.println(course2);
                        }
                    } else {
                        System.out.println("Course not found");
                    }
                    break;
                case 6: // Find Courses by Department
                    System.out.print("Enter Department to find: ");
                    String department = sc.nextLine();
                    Course[] courses1 = courseList.findCoursebyDepartment(department);
                    if (courses1 != null) {
                        for (Course course2 : courses1) {
                            if (course2 != null)
                                System.out.println(course2);
                        }
                    } else {
                        System.out.println("Course not found");
                    }
                    break;
                case 7: // Sort Courses by Title
                    System.out.printf("%-10s%-30s%10s\t%-20s\n", "id", "title", "credit", "department");
                    Course[] temp1 = courseList.sortCoursebyName();
                    for (Course course2 : temp1) {
                        if (course2 != null)
                            System.out.println(course2);
                    }
                    break;
                case 8: // Find Courses with Max Credit
                    Course[] courses2 = courseList.findMaxCredit();
                    if (courses2 != null) {
                        for (Course course2 : courses2) {
                            if (course2 != null)
                                System.out.println(course2);
                        }
                    } else {
                        System.out.println("Course not found");
                    }
                    break;
                case 9: // Find Department with Most Courses
                    String department2 = courseList.findDepartmentWithMostCourses();
                    if (department2 != null) {
                        System.out.println("Department with most courses: " + department2);
                    } else {
                        System.out.println("Course not found");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
    }

    private static void initData(CourseList courseList) {
        Course c0 = new Course("FUT100", 3, "FUT", "F");
        Course c1 = new Course("FIT101", 3, "FIT", "B");
        Course c2 = new Course("FIT102", 2, "FIT", "H");
        Course c3 = new Course("FIT103", 4, "FIT", "D");
        Course c4 = new Course("FET202", 4, "FET", "E");

        courseList.addCourse(c0);
        courseList.addCourse(c1);
        courseList.addCourse(c2);
        courseList.addCourse(c3);
        courseList.addCourse(c4);
    }
}