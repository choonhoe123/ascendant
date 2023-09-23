package com.Ascendant.ascendant.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String address;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    private String Company;

    public ClientEntity() {
    }

    public ClientEntity(String name, int age, String address, Date birthday, String company) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        Company = company;
    }
}
