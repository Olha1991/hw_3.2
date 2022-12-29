package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.StudentsForSQL;
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

    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getStudentFaculty(long id) {
        Student student = getStudentById(id);
        if (student == null) {
            return null;
        }
        return student.getFaculty();
    }

    public int getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public double getAverageAgeOfStudents(){
        return studentRepository.averageAgeOfStudents();
    }

    public Collection<StudentsForSQL> getLastStudents(int limit){
        return studentRepository.getLastStudents(limit);
    }


}