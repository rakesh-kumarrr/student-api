package com.demo.student_api;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public StudentService() {
        students.add(new Student(nextId++, "Alice", "alice@email.com"));
        students.add(new Student(nextId++, "Bob", "bob@email.com"));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }
    public Student updateStudent(int id, Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }
}