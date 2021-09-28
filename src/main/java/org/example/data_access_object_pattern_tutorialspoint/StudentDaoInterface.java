package org.example.data_access_object_pattern_tutorialspoint;

import java.util.List;

public interface StudentDaoInterface {
     List<Student> getAllStudents();
     Student getStudent(int rollNo);
     void addStudent(Student student);
     void updateStudent(Student student);
     void deleteStudent(Student student);
}