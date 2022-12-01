package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long generatedFacultyId = 1L;

    public Faculty creatFaculty (Faculty faculty){
        faculty.setId(++generatedFacultyId);
        faculties.put(generatedFacultyId, faculty);
        return faculty;
    }
    public Faculty getFacultyById(long id){
        return faculties.get(id);
    }

    public Faculty updateFaculty(Faculty faculty){
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long id){
        return faculties.remove(id);
    }

    public Collection<Faculty> getFacultiesByColor(String color) {
        return faculties.entrySet().stream()
                .filter(e -> e.getValue().getColor().equals(color))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())).values();
    }
}
