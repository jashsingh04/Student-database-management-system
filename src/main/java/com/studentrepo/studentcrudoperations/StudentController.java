package com.studentrepo.studentcrudoperations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getStudents() {
        List <Student> students = studentRepository.findAll();
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createstudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @PutMapping("/student/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
        Student student1= studentRepository.findById(id).get();
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setCourse(student.getCourse());
        studentRepository.save(student1);
        return ResponseEntity.ok(student1);
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}