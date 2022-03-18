package com.fastcampus.ch4.user;

import com.google.common.base.Objects;

import java.util.Date;

public class UserDto {
    private String id;
    private String pwd;
    private String name;
    private String pNumber;
    private String email;
    private String type;
    private Date reg_date;

    public UserDto() {
    }

    public UserDto(String id, String pwd, String name, String pNumber, String email, String type, Date reg_date) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.pNumber = pNumber;
        this.email = email;
        this.type = type;
        this.reg_date = reg_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto user = (UserDto) o;
        return Objects.equal(id, user.id) && Objects.equal(pwd, user.pwd) && Objects.equal(name, user.name) && Objects.equal(pNumber, user.pNumber) && Objects.equal(email, user.email) && Objects.equal(type, user.type) && Objects.equal(reg_date, user.reg_date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, pwd, name, pNumber, email, type, reg_date);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", pNumber='" + pNumber + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", reg_date=" + reg_date +
                '}';
    }
}
