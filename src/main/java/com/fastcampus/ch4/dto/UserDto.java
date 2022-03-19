package com.fastcampus.ch4.dto;

import com.google.common.base.Objects;

import java.util.Date;

public class UserDto {
    private String id;
    private String pwd;
    private String name;
    private String pNumber;
    private String email;
    private String post_number;
    private String address;
    private String detail_adr;
    private Date reg_date;
    private String type;

    public UserDto() {
    }

    public UserDto(String id, String pwd, String name, String pNumber, String email, String post_number, String address, String detail_adr, Date reg_date, String type) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.pNumber = pNumber;
        this.email = email;
        this.post_number = post_number;
        this.address = address;
        this.detail_adr = detail_adr;
        this.reg_date = reg_date;
        this.type = type;
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

    public String getPost_number() {
        return post_number;
    }

    public void setPost_number(String post_number) {
        this.post_number = post_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail_adr() {
        return detail_adr;
    }

    public void setDetail_adr(String detail_adr) {
        this.detail_adr = detail_adr;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equal(id, userDto.id) && Objects.equal(pwd, userDto.pwd) && Objects.equal(name, userDto.name) && Objects.equal(pNumber, userDto.pNumber) && Objects.equal(email, userDto.email) && Objects.equal(post_number, userDto.post_number) && Objects.equal(address, userDto.address) && Objects.equal(detail_adr, userDto.detail_adr) && Objects.equal(reg_date, userDto.reg_date) && Objects.equal(type, userDto.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, pwd, name, pNumber, email, post_number, address, detail_adr, reg_date, type);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", pNumber='" + pNumber + '\'' +
                ", email='" + email + '\'' +
                ", post_number='" + post_number + '\'' +
                ", address='" + address + '\'' +
                ", detail_adr='" + detail_adr + '\'' +
                ", reg_date=" + reg_date +
                ", type='" + type + '\'' +
                '}';
    }
}
