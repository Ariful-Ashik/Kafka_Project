package com.kafka.cab.book.driver.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    Integer ID;
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
