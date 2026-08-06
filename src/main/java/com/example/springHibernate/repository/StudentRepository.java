package com.example.springHibernate.repository;



 import com.example.springHibernate.model.Student;
 import jakarta.persistence.EntityManager;
 import jakarta.persistence.PersistenceContext;
 import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public  StudentRepository (EntityManager entityManager){
        this.entityManager=entityManager;
    }


    //create
    public void  createStudent(Student student){
        entityManager. persist(student);
    }

    //read by id
    public  Student  getStudentById(long id){
       Student s= entityManager.find(Student.class , id);
//       entityManager.detach(s);
       return s;
    }


    //read  All Student
    public  List<Student>  getAllStudent(){
        return  entityManager.createQuery("FROM Student" , Student.class ). getResultList();
    }



    //delete
    public void  deleteStudent(Student student){
        entityManager.remove(student);
    }

}
