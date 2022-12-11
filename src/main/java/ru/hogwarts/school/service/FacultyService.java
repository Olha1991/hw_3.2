package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    public FacultyService(FacultyRepository facultyRepository, StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    public Faculty creatFaculty (Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public Faculty getFacultyById(long id){

        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Faculty faculty){
        if (facultyRepository.findById(faculty.getId()).orElse(null) == null) {
            return null;
        }
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getFacultiesByColor(String color) {

        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> findFacultiesByNameOrColor(String searchStr) {
        return facultyRepository.findByNameContainsIgnoreCaseOrColorIgnoreCase(searchStr, searchStr);
    }

    public Collection<Student> getFacultyStudents(long id) {
        Faculty faculty = getFacultyById(id);
        if (faculty == null) {
            return null;
        }
        return studentRepository.findByFacultyId(faculty.getId());
    }
}
