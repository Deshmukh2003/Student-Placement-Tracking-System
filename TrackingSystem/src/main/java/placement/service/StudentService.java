package placement.service;

import java.util.List;

import placement.model.StudentPojo;

public interface StudentService {

    List<StudentPojo> getAllStudents();

    int getTotalStudents();

    boolean deleteStudent(int id);
}