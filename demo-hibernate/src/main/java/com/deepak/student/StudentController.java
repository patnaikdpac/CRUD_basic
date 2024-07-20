package com.deepak.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("/student/v1")
public class StudentController 
{
	@Autowired 
	StudentDao dao;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) 
	{
		return dao.save(student);
	}
	
	@GetMapping("/getAll")
	public Iterable<Student> getStudent() 
	{
		return dao.findAll();
	}
	
	@GetMapping("/getId/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id) 
	{
		return dao.findById(id);
	}
	
	@GetMapping("/getMobile/{mobile}")
	public Optional<List<Student>> getStudentByMobile(@PathVariable String mobile)
	{
		return dao.getStudentByMobile(mobile);
	}
	
	@PutMapping("/edit/{id}")
	public Student editStudent(@PathVariable Long id, @RequestBody Student student) 
	{
		Optional<Student> existStudent = dao.findById(id);
		existStudent.get().setName(student.getName()!=null?student.getName():existStudent.get().getName());
		existStudent.get().setMail(student.getMail()!=null?student.getMail():existStudent.get().getMail());
		existStudent.get().setMobile(student.getMobile()!=null?student.getMobile():existStudent.get().getMobile());
		dao.save(existStudent.get());
		return student;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		dao.deleteById(id);
		return "Delete Success!!!";
	}
	
	@GetMapping("/all")
	public List<Student> getAll() {
		return dao.getAll();
	}
	
	@GetMapping("/all/{id}")
	public List<Student> getAllById(@PathVariable Long id) 
	{
		return dao.getAllById(id);
	}
	
	@GetMapping("/all/{id}/{mobile}")
	public List<Student> getAllByIdMob(@PathVariable Long id, @PathVariable String mobile) 
	{
		return dao.getAllByIdMob(id, mobile);
	}
	
	
	@PutMapping("/edit/{id}/{mail}")
	public int editStudentMail(@PathVariable String mail, @PathVariable Long id) 
	{
		
		return dao.editStudentMail(id, mail);
	}
	
	@DeleteMapping("/purge/{id}")
	public int deleteStudentId(@PathVariable Long id)
	{
		return dao.deleteStudentId(id);
	}
	
	@GetMapping("/get/{mobile}")
	public Optional<Student> getAllByMob(@PathVariable String mobile) 
	{
		return dao.getAllByMob(mobile);
	}
	
}
