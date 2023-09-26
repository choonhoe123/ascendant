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
@Table(name = "Clients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
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
    private String company;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<CaseEntity> cases;


    public ClientEntity(@NonNull String name, @NonNull int age, @NonNull String address, @NonNull Date birthday, @NonNull String company) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        this.company = company;
    }

    public ClientEntity() {
    }

    public ClientEntity(@NonNull String name, @NonNull int age, @NonNull String address, @NonNull Date birthday, @NonNull String company, List<CaseEntity> cases) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        this.company = company;
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
        this.company = company;
    }

    public void setCases(List<CaseEntity> cases) {
        this.cases = cases;
    }

    public long getClientId() {
        return clientId;
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
        return company;
    }

    public List<CaseEntity> getCases() {
        return cases;
    }
}
