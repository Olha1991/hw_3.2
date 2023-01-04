SELECT student.name, student.age, faculty.name
FROM student
         LEFT JOIN faculty ON student.faculty_name = faculty.name;

SELECT student.name, student.age
FROM avatar
         INNER JOIN avatar ON student.name = avatar.student_id;