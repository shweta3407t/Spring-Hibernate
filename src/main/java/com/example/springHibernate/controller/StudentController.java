package com.example.springHibernate.controller;

import com.example.springHibernate.model.Student;
import com.example.springHibernate.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService s){
        this.studentService=s;
    }


    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
           studentService.createStudent(student);

           return ResponseEntity.status(HttpStatus.CREATED).body("DONE");
    }

     @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student ,@PathVariable long id){
        studentService.update(student , id);

        return  ResponseEntity.ok("DONE");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
          Student student=studentService.getStudentById(id);
          return  ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent( ){
           List<Student > studentList=studentService.getAllStudent( );
           return  ResponseEntity.ok(studentList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
           Student student=studentService.getStudentById(id);

           studentService.deleteStudent(student);

           return  ResponseEntity.ok("DONE");
    }


}
