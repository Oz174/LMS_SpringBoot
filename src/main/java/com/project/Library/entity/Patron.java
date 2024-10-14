package com.project.Library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Patron")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Patron {

    // data members and columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Patron_id",length=11)
    private int patron_id ;

    @Column(name="name", length=50,nullable = false)
    private String name;

    @Column(name="phone_no", length = 50,nullable = false)
    private String phone_no;

    @Column(name="membership_no", length=11,nullable = false, unique = true)
    private int membershipNo;

    //TODO: mapping with borrow


    public Patron(String name, String phone_no, int membership_no) {
        this.name = name;
        this.phone_no = phone_no;
        this.membershipNo = membership_no;
    }

}
