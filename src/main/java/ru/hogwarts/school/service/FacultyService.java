package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty creatFaculty (Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public Faculty getFacultyById(long id){
        return facultyRepository.findById(id).get();
    }

    public Faculty updateFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getFacultiesByColor(String color) {
        return facultyRepository.findByColor(color);
    }
}
