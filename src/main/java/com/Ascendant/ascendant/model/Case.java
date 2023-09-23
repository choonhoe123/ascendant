package com.Ascendant.ascendant.model;

import com.Ascendant.ascendant.entity.ClientEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
public class Case {
    private long caseId;
    private Date createDate;
    private String title;
    private String msg;
    private ClientEntity client;
    private StatusEnum statusEnum;
}
