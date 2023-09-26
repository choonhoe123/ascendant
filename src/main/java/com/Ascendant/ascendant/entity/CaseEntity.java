package com.Ascendant.ascendant.entity;

import com.Ascendant.ascendant.model.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Entity
@Data
@Table(name = "Cases")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long caseId;
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @NonNull
    private String title;
    @NonNull
    private String msg;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="client")
    @NonNull
    private ClientEntity client;
    @NonNull
    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;
    @Nullable
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    public CaseEntity() {
    }

    public CaseEntity(String title, String msg, ClientEntity client) {
        this.title = title;
        this.msg = msg;
        this.client = client;
    }

    public CaseEntity(String title, String msg) {
        this.title = title;
        this.msg = msg;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
