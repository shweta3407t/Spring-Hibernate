package com.example.springHibernate.model;


import com.example.springHibernate.status.StudentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name =  "std_email " , unique = true  ,length = 100 , nullable = false )
    private  String email;


    //embed --> it will create all columns of student and address in one table
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name =  "house" ,
                    column = @Column(name = "curr_house")
            ),
            @AttributeOverride(name =  "street" ,
                    column = @Column(name = "curr_street")
            ),
            @AttributeOverride(name =  " city" ,
                    column = @Column(name = "curr_city")
            ),
            @AttributeOverride(name =  "state" ,
                    column = @Column(name = "curr_state")
            ),
            @AttributeOverride(name =  "pincode" ,
                    column = @Column(name = "curr_pincode")
            )

    })
    private  StudentAddress currentAddress;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name =  "house" ,
                    column = @Column(name = "parmanent_house")
            ),
            @AttributeOverride(name =  "street" ,
                    column = @Column(name = "parmanent_street")
            ),
            @AttributeOverride(name =  " city" ,
                    column = @Column(name = "parmanent_city")
            ),
            @AttributeOverride(name =  "state" ,
                    column = @Column(name = "parmanent_state")
            ),
            @AttributeOverride(name =  "pincode" ,
                    column = @Column(name = "parmanent_pincode")
            )

    })
    private  StudentAddress parmenentAddress;



    ////mapping   collection
//    private List<Skill> skills;




//    @Lob
//    private  String largeData;
//
//    @Convert(converter = BooleanToStringConverter.class)
//    private  Boolean isMonitor;
//
//
//    @Column(name = "std_percentage" , precision = 5, scale = 2)
//    private BigDecimal percentage;
//
//
//    @Transient//its data will no appear n db
//    private String displayName;
//
//
//    private LocalDate dateOfBirth;
//    private LocalDate createdAt;
//
//
//    @Enumerated(EnumType.STRING)
//    private StudentStatus status;

}
