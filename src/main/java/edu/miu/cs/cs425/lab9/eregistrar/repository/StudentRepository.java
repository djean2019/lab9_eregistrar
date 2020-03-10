package edu.miu.cs.cs425.lab9.eregistrar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.miu.cs.cs425.lab9.eregistrar.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{
	@Query(value = "SELECT * FROM students where student_number = :stnumber", nativeQuery = true)
	public List<Student> findStudentByStudentNumber(@Param("stnumber") String stnumber);
}
