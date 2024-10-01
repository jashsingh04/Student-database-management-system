package com.studentrepo.studentcrudoperations;

import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
