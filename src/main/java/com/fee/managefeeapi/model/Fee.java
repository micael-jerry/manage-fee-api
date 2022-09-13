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
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fee")
public class Fee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 20)
    private String type;
    private String description;
    private int totalAmount;
    @Transient
    private int remainingAmount;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private MyUser student;
    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;
}
