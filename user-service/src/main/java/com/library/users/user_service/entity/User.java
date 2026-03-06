package com.library.users.user_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false, unique = true,name = "user_name")    
    private String userName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "admin_flag", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String adminFlag = "N";

    public void setAdminFlag(String adminFlag) {
        // if caller provides null or empty, keep default 'N'
        this.adminFlag = (adminFlag == null || adminFlag.isBlank()) ? "N" : adminFlag;
    }
}