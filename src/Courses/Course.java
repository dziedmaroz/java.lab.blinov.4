/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Courses;

/**
 *
 * @author lucian
 */
public class Course
{
    private boolean status;
    private String courseName;
    private Professor professor;
    private Student [] students;

    public Course(boolean status, String courseName, Professor professor, Student[] students)
    {
        this.status = status;
        this.courseName = courseName;
        this.professor = professor;
        this.students = students;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public Professor getProfessor()
    {
        return professor;
    }

    public boolean isStatus()
    {
        return status;
    }

    public Student[] getStudents()
    {
        return students;
    }

    
    
    
}
