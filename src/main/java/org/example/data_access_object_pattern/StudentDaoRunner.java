package org.example.data_access_object_pattern;

/***
 * https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm
 */

public class StudentDaoRunner {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        //add students
        Student student1 = new Student("Robert",0);
        Student student2 = new Student("John",1);
        studentDao.addStudent(student1);
        studentDao.addStudent(student2);

        //print all students
        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }

        //update student
        Student student =studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);

        //get the student
        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
    }
}