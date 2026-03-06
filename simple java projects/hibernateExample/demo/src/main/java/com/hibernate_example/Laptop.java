package com.hibernate_example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {
    @Id
    private int laptopId;
    private String laptopName;
    private String laptopBrand;

    public int getLaptopId() {
        return laptopId;
    }
    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }
    public String getLaptopName() {
        return laptopName;
    }
    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }
    public String getLaptopBrand() {
        return laptopBrand;
    }
    public void setLaptopBrand(String laptopBrand) {
        this.laptopBrand = laptopBrand;
    }
    @Override
    public String toString() {
        return "Laptop [laptopId=" + laptopId + ", laptopName=" + laptopName + ", laptopBrand=" + laptopBrand + "]";
    }

    
}
