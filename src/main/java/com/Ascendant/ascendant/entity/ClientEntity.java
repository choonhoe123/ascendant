package com.Ascendant.ascendant.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "clients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private String address;
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @NonNull
    private String Company;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "case")
    private List<CaseEntity> cases;


    public ClientEntity(@NonNull String name, @NonNull int age, @NonNull String address, @NonNull Date birthday, @NonNull String company) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        Company = company;
    }

    public ClientEntity() {
    }

    public ClientEntity(@NonNull String name, @NonNull int age, @NonNull String address, @NonNull Date birthday, @NonNull String company, List<CaseEntity> cases) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        Company = company;
        this.cases = cases;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public void setCases(List<CaseEntity> cases) {
        this.cases = cases;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCompany() {
        return Company;
    }

    public List<CaseEntity> getCases() {
        return cases;
    }
}
