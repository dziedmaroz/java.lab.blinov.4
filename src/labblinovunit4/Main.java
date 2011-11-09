/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package labblinovunit4;

import Courses.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Илья Архангельский
 *
 * Система Факультатив. Преподаватель объявляет запись на
 * Курс. Студент записывается на Курс, обучается и по оконча-
 * нии Преподаватель выставляет Оценку, которая сохраняется в
 * Архиве. Студентов, Преподавателей и Курсов при обучении
 * может быть несколько.
 * 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Archive archive;
        String [] studentsStrings=null;
        String [] professorStrings=null;
        String [] coursesStrings=null;

        readStrings(coursesStrings, "courses.txt");
        readStrings(studentsStrings, "students.txt");
        readStrings(professorStrings, "professors.txt");


       Student [] students = new Student[studentsStrings.length];
       for (int i=0;i<students.length;i++)
       {
           students[i] = new Student(studentsStrings[i]);
       }

       Professor [] professors = new Professor[professorStrings.length];
       for (int i=0;i<professors.length;i++)
       {
           professors[i]= new Professor(professorStrings[i]);
       }
       Course [] courses = new Course[coursesStrings.length];
       for (int i=0;i<coursesStrings.length;i++)
       {
            courses[i]= new Course(Math.random()>0.5?true:false, coursesStrings[i], professors[i], getStudentsRange(students));
       }

    }

    public static void readStrings (String [] strings, String file)
    {
        BufferedReader bufferedReader=null;
        try
        {
           bufferedReader =  new BufferedReader (new FileReader(file));

        }
        catch (FileNotFoundException e)
        {
            System.out.print(e+"\n");
        }
        try
        {
            int lines =0;
            while (bufferedReader!=null && bufferedReader.ready())
            {
               if ((bufferedReader.readLine()).equals(""))
               {
                   lines++;
               }
            }

            strings = new String[lines];
            lines =0;
            while (bufferedReader!=null && bufferedReader.ready())
            {
                strings[lines]=bufferedReader.readLine();
                lines++;
            }

        }
        catch (IOException e)
        {
          System.out.print(e+"\n");
        }

    }

    public static Student [] getStudentsRange (Student [] students)
    {
        int border_a = (int)Math.round(Math.random()*students.length*1000)%students.length;
        int border_b = (int)Math.round(Math.random()*students.length*1000)%students.length;

        if (border_a<border_b)
        {
            int tmp = border_a;
            border_a = border_b;
            border_b = tmp;
        }
        return  Arrays.copyOfRange(students,border_a,border_b);        
    }

}
