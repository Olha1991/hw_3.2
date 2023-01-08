package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{
    public Collection<Faculty> findByColor(String color);
    public Collection<Faculty> findByNameContainsIgnoreCaseOrColorIgnoreCase(String name, String color);
}
