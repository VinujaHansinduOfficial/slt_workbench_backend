package com.example.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    private Long employeeNumber;
    private String employeeTitle;
    private String employeename;
    private String employeeGroupName;
    private String employeeDivision;
    private String employeeSection;
    private String employeeSalaryGrade;
    private Long employeeImmEsServiceNo;
    private String supervisorName;
    private String employeeDesignation;

    public Employee(Long employeeNumber, String employeeTitle, String employeename, String employeeGroupName, String employeeDivision, String employeeSection, String employeeSalaryGrade, Long employeeImmEsServiceNo, String supervisorName, String employeeDesignation) {
        this.employeeNumber = employeeNumber;
        this.employeeTitle = employeeTitle;
        this.employeename = employeename;
        this.employeeGroupName = employeeGroupName;
        this.employeeDivision = employeeDivision;
        this.employeeSection = employeeSection;
        this.employeeSalaryGrade = employeeSalaryGrade;
        this.employeeImmEsServiceNo = employeeImmEsServiceNo;
        this.supervisorName = supervisorName;
        this.employeeDesignation = employeeDesignation;
    }

    public Employee() {
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmployeeGroupName() {
        return employeeGroupName;
    }

    public void setEmployeeGroupName(String employeeGroupName) {
        this.employeeGroupName = employeeGroupName;
    }

    public String getEmployeeDivision() {
        return employeeDivision;
    }

    public void setEmployeeDivision(String employeeDivision) {
        this.employeeDivision = employeeDivision;
    }

    public String getEmployeeSection() {
        return employeeSection;
    }

    public void setEmployeeSection(String employeeSection) {
        this.employeeSection = employeeSection;
    }

    public String getEmployeeSalaryGrade() {
        return employeeSalaryGrade;
    }

    public void setEmployeeSalaryGrade(String employeeSalaryGrade) {
        this.employeeSalaryGrade = employeeSalaryGrade;
    }

    public Long getEmployeeImmEsServiceNo() {
        return employeeImmEsServiceNo;
    }

    public void setEmployeeImmEsServiceNo(Long employeeImmEsServiceNo) {
        this.employeeImmEsServiceNo = employeeImmEsServiceNo;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }
}

