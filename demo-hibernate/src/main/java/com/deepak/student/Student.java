package com.deepak.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Data;

@Data
@Entity

@NamedStoredProcedureQueries
({@NamedStoredProcedureQuery
		(
				name = "Student.getAllStuData", 
				procedureName = "getAllStuData",
				resultClasses = Student.class
		),
  @NamedStoredProcedureQuery
		(
				name = "Student.getStudentsById", 
				procedureName = "getStudentsById",
				resultClasses = Student.class,
				parameters = {
						@StoredProcedureParameter(name = "id", type = Long.class, mode = ParameterMode.IN) 
				}
		),
	@NamedStoredProcedureQuery
		(
				name = "Student.getStudentNameById",
				procedureName = "getStudentNameById",
				resultClasses = Student.class,
				parameters = {
						@StoredProcedureParameter(name = "id", type = Long.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "StudentName", type = String.class, mode = ParameterMode.OUT)
				}
		)

})



public class Student 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roll")
	private Long id;
	
	private String name;
	
	@Column(unique = true)
	private String mail;
	
	@Column(unique = true)
	private String mobile;
	
}
