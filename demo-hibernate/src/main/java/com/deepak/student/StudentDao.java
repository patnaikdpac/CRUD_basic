package com.deepak.student;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long>
{
	
	Optional<List<Student>> getStudentByMobile(String mobile);
}
