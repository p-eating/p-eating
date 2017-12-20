package com.chinaredstar.eating.model;

import java.io.Serializable;

public class EmployeeModel implements Serializable {

    private static final long serialVersionUID = 7182380440564803020L;

    // 员工号
    private Long employeeId;
    // 员工姓名
    private String name;
    // 员工邮箱
    private String email;
    // 员工性别 M : 男, F : 女
    private String gender;
    // 员工部门
    private String departmentName;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
