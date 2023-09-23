package com.Ascendant.ascendant.model;

import com.Ascendant.ascendant.entity.CaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Data
public class Client {
    private long id;
    private String name;
    private int age;
    private String address;
    private Date birthday;
    private String Company;
    private List<CaseEntity> cases;
}
