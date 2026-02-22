package com.demo.student_api;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	private StudentService studentService;

	@Test
	void testGetAllStudents() {
		assertFalse(studentService.getAllStudents().isEmpty());
	}

	@Test
	void testAddStudent() {
		Student student = new Student(0, "Test User", "test@email.com");
		Student added = studentService.addStudent(student);
		assertNotNull(added);
		assertEquals("Test User", added.getName());
	}

	@Test
	void testDeleteStudent() {
		boolean deleted = studentService.deleteStudent(1);
		assertTrue(deleted);
	}
}
