/**
 * @description:
 * @author: Tam, Nguyen Chi Tam
 * @version: 1.0
 * @created: 8/21/2024
 */

package edu.iuh.fit.exer3;

public class Course {

    private String id;
    private int credit;
    private String department;
    private String title;

    public Course(String id, int credit, String department, String title) {
        setId(id);
        setCredit(credit);
        setDepartment(department);
        setTitle(title);
    }

    public Course() {
        this.id = "";
        this.credit = 0;
        this.department = "";
        this.title = "";
    }

    public String getId() {
        return id;
    }

    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String id) {
        if(id == null || id.trim().length() < 3) {
            throw new IllegalArgumentException("ID must have at least 3 characters");
        }
        int len = id.length();
        for(int i = 0; i < len; i++) {
            if(!Character.isLetterOrDigit(id.charAt(i))) {
                throw new IllegalArgumentException("ID must contain only letters or digits");
            }
        }

        this.id = id;
    }

    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public String toString() {
        return String.format("%-10s%-30s%10d\t%-20s", id, title, credit, department);
    }
}
