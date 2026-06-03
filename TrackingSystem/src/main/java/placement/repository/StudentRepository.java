package placement.repository;

import java.util.List;

import placement.model.StudentPojo;

public interface StudentRepository {

    List<StudentPojo> getAllStudents();

    int getTotalStudents();

    boolean deleteStudent(int id);
}