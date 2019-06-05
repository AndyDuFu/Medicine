package com.medicine.batch.install.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="image")
@Data
public class Img {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="status")
    private String status;
	@Column(name="url")
    private String url; 
    @Column(name="western_id")
    private Integer westernId;
}
