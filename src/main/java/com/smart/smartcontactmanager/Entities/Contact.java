package com.smart.smartcontactmanager.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;
    private String name;
    private String nickName;
    private String email;
    private String phone;
    private String address;
    private String work;
    private String image;
    @Column(length = 5000)
    private String description;

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getcId() {
        return cId;
    }
    public void setcId(int cId) {
        this.cId = cId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getWork() {
        return work;
    }
    public void setWork(String work) {
        this.work = work;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Contact() {
    }
    public Contact(int cId, String name, String nickName, String email, String phone, String address, String work,
            String image, String description, User user) {
        this.cId = cId;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.work = work;
        this.image = image;
        this.description = description;
        this.user = user;
    }
    @Override
    public String toString() {
        return "Contact [cId=" + cId + ", name=" + name + ", nickName=" + nickName + ", email=" + email + ", phone="
                + phone + ", address=" + address + ", work=" + work + ", image=" + image + ", description="
                + description + ", user=" + user + "]";
    }
}
