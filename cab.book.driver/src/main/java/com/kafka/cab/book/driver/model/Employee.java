package com.kafka.cab.book.driver.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
//@Table(name = "employeeStore")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    Integer ID;
    String Name;
    String Address;
    String Phone;
    String Email;

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + ID +
//                ", name='" +Name + '\'' +
//                ", address='" + Address + '\'' +
//                ", phone='" + Phone + '\'' +
//                ", email='" + Email + '\'' +
//                '}';
//    }


}
