package com.springboot.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.StudentService;
import com.springboot.entities.Student;

@RestController
public class HomeController
{
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudent(){
		try {
			List<Student> allStudent = this.studentService.getAllStudent();
			return ResponseEntity.ok(allStudent);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		try {
			Student student = this.studentService.getStudent(id);
			return ResponseEntity.ok(student);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
		try {
			Student insertStuednt = this.studentService.insertStuednt(student);
			return ResponseEntity.of(Optional.of(insertStuednt));
		} catch (Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
		try {
			this.studentService.deleteStudent(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int id) {
		try {
			Student updateStudent = this.studentService.updateStudent(student, id);
			return ResponseEntity.of(Optional.of(updateStudent));
		} catch (Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
