package com.valora.test.dbbundlejsfcontrol.entity;


import com.valora.dbbundle.model.MessageEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages", uniqueConstraints = @UniqueConstraint(columnNames = {"msg_key", "locale_code"}))
public class Message implements MessageEntity, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "msg_key")
    private String msgKey;

    @Column(name = "msg_value", nullable = false)
    private String msgValue;

    @Column(name = "locale_code", nullable = false, length = 10)
    private String localeCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String getMsgKey() {
        return msgKey;
    }

    @Override
    public String getMsgValue() {
        return msgValue;
    }

    @Override
    public String getLocaleCode() {
        return localeCode;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }

    public void setMsgValue(String msgValue) {
        this.msgValue = msgValue;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }
}
