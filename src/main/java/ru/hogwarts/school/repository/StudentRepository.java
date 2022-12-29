package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentsForSQL;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    Collection<Student> findByFacultyId(long facultyId);

    @Query(value = "SELECT COUNT (*) as student FROM student", nativeQuery = true)
    public int getAllStudents();

    @Query(value = "SELECT AVG(age) as average_age  FROM student", nativeQuery = true)
    public double averageAgeOfStudents();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT :limit", nativeQuery = true)
    public Collection<StudentsForSQL> getLastStudents(@Param("limit") int limit);
}
