package com.mlm.stdApp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Override
    List<Student> findAll();

    List<Student> findByid(Long id);
    List<Student> findByLastName(String lastName);
    List<Student> findByAccessCardNumber(int accessCardNumber);

}
