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






//    Integer ID =1;
//    String Name="Md. Ariful Islam";
//    String Address="Dhaka";
//    String Phone="01780982495";
//    String Email="abc@gmail.com";


}
