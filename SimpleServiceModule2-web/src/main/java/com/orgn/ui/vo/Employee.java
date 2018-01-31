package com.orgn.ui.vo;

import java.io.Serializable;

public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;

	private String empId;
    private String name;
    private String message;

    public String getEmpId() {
        return empId;
    }
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}