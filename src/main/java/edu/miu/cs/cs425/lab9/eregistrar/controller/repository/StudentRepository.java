package edu.miu.cs.cs425.lab9.eregistrar.controller.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import edu.miu.cs.cs425.lab9.eregistrar.controller.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
}
