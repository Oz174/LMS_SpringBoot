package com.project.Library.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Patron")
public class Patron {

    // data members and columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Patron_id",length=11)
    private int patron_id ;

    @Column(name="name", length=50,nullable = false)
    private String name;

    @Column(name="phone_no", length = 50,nullable = false, unique = true)
    private String phone_no;

    @Column(name="membership_no", length=11,nullable = false, unique = true)
    private int membership_no;

    //TODO: mapping with borrow

    public Patron(int patron_id, String name, String phone_no, int membership_no) {
        this.patron_id = patron_id;
        this.name = name;
        this.phone_no = phone_no;
        this.membership_no = membership_no;
    }

    public Patron(String name, String phone_no, int membership_no) {
        this.name = name;
        this.phone_no = phone_no;
        this.membership_no = membership_no;
    }

    public Patron() {
    }

    public int getPatron_id() {
        return patron_id;
    }

    public void setPatron_id(int patron_id) {
        this.patron_id = patron_id;
    }

    public int getMembership_no() {
        return membership_no;
    }

    public void setMembership_no(int membership_no) {
        this.membership_no = membership_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "Patron_id=" + patron_id +
                ", name='" + name + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", membership_no=" + membership_no +
                '}';
    }


}
