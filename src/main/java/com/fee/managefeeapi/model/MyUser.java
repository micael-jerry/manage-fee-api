package com.fee.managefeeapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "my_user")
public class MyUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Transient
    private String ref;

    @Column(nullable = false)
    private String lastname;
    private String firstname;
    private String sex;
    @Column(nullable = false, length = 50)
    private String birthDate;
    private String address;
    private String phone;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date entranceDate;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups groups;

    private String username;
    private String password;
    @Column(nullable = false)
    private String role;

    @PrePersist
    public void prePersist() {
        this.entranceDate = new Date();
    }
}
