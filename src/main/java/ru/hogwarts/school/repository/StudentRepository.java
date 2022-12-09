package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;
import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Collection<Student> findByAge(int age);

    public Collection<Student> findByNameContainsIgnoreCase(String part);
}