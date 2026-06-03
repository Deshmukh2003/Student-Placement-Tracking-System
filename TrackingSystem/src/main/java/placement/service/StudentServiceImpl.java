package placement.service;

import java.util.List;

import placement.model.StudentPojo;
import placement.repository.StudentRepository;
import placement.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService {

    StudentRepository repo = new StudentRepositoryImpl();

    @Override
    public List<StudentPojo> getAllStudents() {
        return repo.getAllStudents();
    }

    @Override
    public int getTotalStudents() {
        return repo.getTotalStudents();
    }

    @Override
    public boolean deleteStudent(int id) {
        return repo.deleteStudent(id);
    }
}