package org.example.domain.postgres;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "system_audit")
public class SystemAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "table_id")
    private String tableId;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_name")
    private String userName;

    private String action;
    @CreationTimestamp
    @Column(updatable = false, name = "created_utc_timestamp")
    private Timestamp createdUtcTimestamp;

    private String reason;

    public SystemAudit(Long id, String tableId, String tableName, String userEmail, String userName, Timestamp createdUtcTimestamp, String reason, String action) {
        this.id = id;
        this.tableId = tableId;
        this.tableName = tableName;
        this.userEmail = userEmail;
        this.userName = userName;
        this.createdUtcTimestamp = createdUtcTimestamp;
        this.reason = reason;
        this.action = action;
    }

    public SystemAudit(String tableId, String tableName, String userEmail, String userName, String reason, String action) {
        this.tableId = tableId;
        this.tableName = tableName;
        this.userEmail = userEmail;
        this.userName = userName;
        this.reason = reason;
        this.action = action;
    }

    public SystemAudit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreatedUtcTimestamp() {
        return createdUtcTimestamp;
    }

    public void setCreatedUtcTimestamp(Timestamp createdUtcTimestamp) {
        this.createdUtcTimestamp = createdUtcTimestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemAudit that = (SystemAudit) o;
        return Objects.equals(id, that.id) && Objects.equals(tableId, that.tableId) && Objects.equals(tableName, that.tableName) && Objects.equals(userEmail, that.userEmail) && Objects.equals(userName, that.userName) && Objects.equals(createdUtcTimestamp, that.createdUtcTimestamp) && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tableId, tableName, userEmail, userName, createdUtcTimestamp, reason);
    }

    @Override
    public String toString() {
        return "SystemAudit{" +
                "id=" + id +
                ", tableId='" + tableId + '\'' +
                ", tableName='" + tableName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", createdUtcTimestamp=" + createdUtcTimestamp +
                ", reason='" + reason + '\'' +
                '}';
    }
}