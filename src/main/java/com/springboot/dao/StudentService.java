package com.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.entities.Student;
import com.springboot.repository.StudentRepository;
@Component
public class StudentService 
{
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudent()
	{
		List<Student> findAll = this.studentRepository.findAll();
		return findAll;
	}
	
	public Student getStudent(int id) 
	{
		Optional<Student> optional = this.studentRepository.findById(id);
		Student student = optional.get();
		return student;
	}
	
	public Student insertStuednt(Student student)
	{
		Student save = this.studentRepository.save(student);
		return save;
	}
	
	public Student updateStudent(Student student,int id) 
	{
		Optional<Student> optional = this.studentRepository.findById(id);
		Student student2 = optional.get();
		student2.setName(student.getName());
		student2.setEmail(student.getEmail());
		student2.setCourse(student.getCourse());
		student2.setAddress(student.getAddress());
		Student save = this.studentRepository.save(student2);
		return save;
	}
	
	public void deleteStudent(int id)
	{
		Optional<Student> findById = this.studentRepository.findById(id);
		Student student = findById.get();
		
		this.studentRepository.delete(student);
	}
	
	
}
