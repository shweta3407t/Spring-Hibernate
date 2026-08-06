package com.example.springHibernate.model;


import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "std_id"  )
    private long id;


    @Column(name = "std_name" ,length =  100 , nullable = false)
    private String name;


    @Column(name =  "std_age" ,nullable = false )
    private int age;

    @Column(name =  "std_email " , unique = true  ,length = 100 , nullable = false,insertable = true,updatable = true)
    private  String email;






    public Student(){}

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }







    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
