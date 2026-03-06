package com.hibernate_example;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
    @Id
    private int employeeId;
    private String employeeName;
    private String departmentID;
    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
    private List<Laptop> laptop;

    
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getDepartmentID() {
        return departmentID;
    }
    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }
    public List<Laptop> getLaptop() {
        return laptop;
    }
    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", departmentID="
                + departmentID + ", laptop=" + laptop + "]";
    }
    
    
}
