package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Map<Long, Student> students = new HashMap<>();
    private long generatedId = 1L;

    public Student createStudent(Student student){
        student.setId(++generatedId);
        students.put(generatedId, student);
        return student;
    }

    public Student getStudentById(long id){

        return students.get(id);
    }

    public Student updateStudent(Student student){
        if(students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(long id){
        return students.remove(id);
    }

    public Collection<Student> getStudentsByAge(int age) {
        return students.entrySet().stream()
                .filter(e -> e.getValue().getAge() == age)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())).values();
    }
}
