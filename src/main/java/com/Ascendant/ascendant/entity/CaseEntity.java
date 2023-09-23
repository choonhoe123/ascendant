package com.Ascendant.ascendant.entity;

import com.Ascendant.ascendant.model.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "case")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long caseId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    private String title;
    private String msg;
    @JsonIgnore
    @ManyToOne(optional = false)
    private ClientEntity client;

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    public CaseEntity() {
    }

    public CaseEntity(Date createDate, String title, String msg, ClientEntity client, StatusEnum statusEnum) {
        this.createDate = createDate;
        this.title = title;
        this.msg = msg;
        this.client = client;
        this.statusEnum = statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public long getCaseId() {
        return caseId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getTitle() {
        return title;
    }

    public String getMsg() {
        return msg;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
