/**
 * @description:
 * @author: Tam, Nguyen Chi Tam
 * @version: 1.0
 * @created: 8/21/2024
 */

package edu.iuh.fit.exer3;

public class CourseList {

    private Course[] courses;
    private int count = 0;

    public CourseList(int n) {
        if( n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n];
    }

    public boolean addCourse(Course c) {
        //check if the course is null
        if(courses == null) {
            System.out.println("The array is null");
            return false;
        }

        if(isExist(c)) {
            System.out.println("Course is already existed");
            return false;
        }
        // check if the array is full
        if(count == courses.length) {
            System.out.println("The array is full");
            return false;
        }
        courses[count++] = c;
        return true;
    }

    private boolean isExist(Course c) {
        for (int i = 0; i < count; i++) {
            if(courses[i].getId().equalsIgnoreCase(c.getId())) {
                return true;
            }
        }
        return false;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void removeCourse(String id) {
        if(courses == null || count == 0) {
            System.out.println("The array is empty");
            return;
        }

        int pos = -1;
        for (int i = 0; i < count; i++) {
            if(courses[i].getId().equalsIgnoreCase(id)) {
                pos = i;
                break;
            }
        }

        if(pos == -1) {
            System.out.println("The course is not found");
            return;
        }

        for (int i = pos; i < count - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courses[count - 1] = null;
        count--;
    }

    public Course findCourse(String id) {
        if(courses == null || count == 0) {
            System.out.println("The array is empty");
            return null;
        }

        for (int i = 0; i < count; i++) {
            if(courses[i].getId().equalsIgnoreCase(id)) {
                return courses[i];
            }
        }
        System.out.println("The course is not found");
        return null;
    }

    public Course[] findCoursebyName (String name) {
        if(courses == null || count == 0) {
            System.out.println("The array is empty");
            return null;
        }
        Course[] result = new Course[count];
        int j = 0;
        for(int i = 0; i < count; i++) {
            if(courses[i].getTitle().equalsIgnoreCase(name)) {
                result[j] = courses[i];
                j++;
            }
        }
        if (j > 0) {
            return result;
        }
            System.out.println("The course is not found");
            return null;
    }

    public Course[] findCoursebyDepartment(String department) {
        if(courses == null || count == 0) {
            System.out.println("The array is empty");
            return null;
        }

        Course[] result = new Course[count];
        int j = 0;
        for(int i = 0; i < count; i++) {
            if(courses[i].getDepartment().equalsIgnoreCase(department)) {
                result[j] = courses[i];
                j++;
            }
        }
        if (j > 0) {
            return result;
        }
        System.out.println("The course is not found");
        return null;
    }

    public Course[] sortCoursebyName() {
        if(courses == null || count == 0) {
            System.out.println("The array is empty");
            return null;
        }
        Course[] result = new Course[count];
        for (int i = 0; i < count; i++) {
            result[i] = courses[i];
        }
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if(result[i].getTitle().compareToIgnoreCase(result[j].getTitle()) > 0) {
                    Course temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        return result;
    }

    public Course[] findMaxCredit() {
        if(courses == null || count == 0) {
            System.out.println("The array is empty");
            return null;
        }

        int max = courses[0].getCredit();
        for (int i = 1; i < count; i++) {
            if(courses[i].getCredit() > max) {
                max = courses[i].getCredit();
            }
        }

        Course[] result = new Course[count];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if(courses[i].getCredit() == max) {
                result[j] = courses[i];
                j++;
            }
        }
        return result;
    }

    public String findDepartmentWithMostCourses() {
        if(courses == null || count == 0) {
            System.out.println("The array is empty");
            return null;
        }

        String[] departments = new String[count];
        int[] countDepartments = new int[count];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if(!isExistDepartment(departments, courses[i].getDepartment(), index)) {
                departments[index] = courses[i].getDepartment();
                countDepartments[index] = 1;
                index++;
            } else {
                int pos = findDepartment(departments, courses[i].getDepartment(), index);
                countDepartments[pos]++;
            }
        }

        int max = countDepartments[0];
        int pos = 0;
        for (int i = 1; i < index; i++) {
            if(countDepartments[i] > max) {
                max = countDepartments[i];
                pos = i;
            }
        }
        return departments[pos];
    }

    private int findDepartment(String[] departments, String department, int index) {
        for (int i = 0; i < index; i++) {
            if(departments[i].equalsIgnoreCase(department)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isExistDepartment(String[] departments, String department, int index) {
        for (int i = 0; i < index; i++) {
            if(departments[i].equalsIgnoreCase(department)) {
                return true;
            }
        }
        return false;
    }

}
