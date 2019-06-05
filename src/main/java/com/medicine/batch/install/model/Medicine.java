package com.medicine.batch.install.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author FuDu
 * @date 2019-04-03
 */
@Entity
@Table(name="medicine")
@Data
public class Medicine {
	@Id
	private long id;
	@Column(name="liang")
	private String liang;
	@Column(name="name")
	private String name;
	@Column(name="yongfa")
	private String yongfa;
	@Column(name="zhuyong")
	private String zhuyong;
	@Column(name="dat_id")
	private long datid;
	
	public String toString() {
		return name + "," + liang + "," + zhuyong + "," + yongfa + ";";
	}
}
