package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repository.StudentRepos;

@RestController
@RequestMapping("/student")
public class StudentController {
	

	@Autowired
	private StudentRepos studentrepo;

	
	@PostMapping("/")
	public ResponseEntity<Student> createStudent(@RequestBody Student st){
				
		Student save = this.studentrepo.save(st);
		
		return new ResponseEntity<Student>(save,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getSinglestudent(@PathVariable int id) {
	
		 Student student = this.studentrepo.findById(id).get();
		
		 return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getstudent() {
	
		 List<Student> student = this.studentrepo.findAll();
		
		 return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable int id){
		Student student1 = this.studentrepo.findById(id).get();
		
		Student student2 = new Student();
		student2.setEmail(student.getEmail());
		student2.setId(student1.getId());
		student2.setMobileno(student.getMobileno());
		student2.setName(student.getName());
		student2.setSurname(student.getSurname());
		
		
		Student save = this.studentrepo.save(student2);
		
		return new ResponseEntity<Student>(save,HttpStatus.CREATED);
		
	}
	
		@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteSingleStudent(@PathVariable int id){
		
		Student student = this.studentrepo.findById(id).get();
		this.studentrepo.delete(student);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/")
	public ResponseEntity<HttpStatus> deleteAllStudent() {
		
		this.studentrepo.deleteAll();
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
}
