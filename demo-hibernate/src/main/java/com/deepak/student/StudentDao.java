package com.deepak.student;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

@Transactional
public interface StudentDao extends CrudRepository<Student, Long>
{
	
	Optional<List<Student>> getStudentByMobile(String mobile);
	
	//Query annotation
	@Query("select s from Student s")
	List<Student> getAll();
	
	@Query("SELECT s from Student s WHERE s.id=?1")
	List<Student> getAllById(Long id);
	
//	@Query("SELECT s from Student s WHERE s.id=?1 AND s.mobile=?2")
//	List<Student> getAllByIdMob(Long id, String mobile);
	
	@Query("SELECT s from Student s WHERE s.id= :id AND s.mobile= :mobile")//alternative to above, this would avoid sql injection
	List<Student> getAllByIdMob(@Param("id") Long id, @Param("mobile") String mobile);
	
	@Modifying
	@Query("UPDATE Student s SET s.mail= :mail WHERE s.id= :id ")
	int editStudentMail(@Param("id") Long id, @Param("mail") String mail );
	
	@Modifying
	@Query("DELETE FROM Student s WHERE s.id = :id")
	int deleteStudentId(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM student s WHERE s.mobile= :mobile", nativeQuery = true)
	Optional<Student> getAllByMob(@Param("mobile") String mobile);

	@Procedure(name = "Student.getAllStuData")
	List<Student> getAllStuData();

	@Procedure(name = "Student.getStudentsById")
	List<Student> getStudentsById(Long id);

	@Procedure(name = "Student.getStudentNameById")
	String getStudentNameById(Long id);
}
