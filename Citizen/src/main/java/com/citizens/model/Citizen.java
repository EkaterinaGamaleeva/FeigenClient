package com.citizens.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Table(name = "citizens")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Min(value = 0, message = "Age should be greater than 0")
    @Column(name = "age")
    private Integer age;
    @Column(name = "sex")
    private String sex;
    @Column(name = "city")
    private String city;
    @Min(value = 9000, message = "Salary should be greater than 9000")
    @Column(name = "salary")
    private Integer salary;

}
