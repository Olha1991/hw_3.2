package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(long id){
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }


    public Collection<Student> getStudentsByAge(int age) {
        return studentRepository.findByAge(age);
    }
}
