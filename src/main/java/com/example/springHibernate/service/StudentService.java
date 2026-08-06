package com.example.springHibernate.service;




import com.example.springHibernate.model.Student;
import com.example.springHibernate.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;
import java.util.List;


@Service
public class StudentService {

    private StudentRepository studentRepository;
    public  StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @Transactional
    public void createStudent(Student student){
        studentRepository.createStudent(student);
    }

    @Transactional
     public  Student getStudentById(long id){
        return  studentRepository.getStudentById(id);
    }



    @Transactional
    public List<Student> getAllStudent(){
        return  studentRepository.getAllStudent();
    }



    @Transactional
     public Student update(Student student , long id){
        Student updatedStudent=studentRepository.getStudentById(id);
        updatedStudent.setName(student.getName());
        updatedStudent.setAge(student.getAge());
        updatedStudent.setEmail(student.getEmail());

        return student;

    }

    @Transactional
     public  void  deleteStudent(Student student){
        studentRepository.deleteStudent(student);
    }
}
