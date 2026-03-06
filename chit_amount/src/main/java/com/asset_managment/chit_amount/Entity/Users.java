package com.asset_managment.chit_amount.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate StartDate;
    private LocalDate endDate;
}
