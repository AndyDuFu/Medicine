package com.medicine.batch.install.model;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

/**
 * @author FuDu
 * @date 2019-04-03
 * @desc 病人和就诊记录信息
 */
@Data
public class PatientRecord {
	private String name;
	private String sex;
	private int age;
	private String phone;
	private String address;
	private String birthplace;
	private String zipCode;
	private int marriage;
	private String citizenship;
	private String profession;
	private String ethnic;
	private double weight;
	private long dmid;
	private String zyjb;
	private String xyjb;
	private String zyzh;
	private String zzzf;
	private String zfm;
	private String type;
	private String number;
	private String doctor;
	private String medicinec;
	private String medicinew;
	private String other;
	private String medicine;
	private String tigejiancha;
	private String zusu;
	private String xianbingshi;
	private String jiwangshi;
	private String guomingshi;
	private String hunyushi;
	private String gerenshi;
	private String jiazhushi;
	private String sehz;
	private String shensexingtai;
	private String xiongfu;
	private String yaobeishizhizhuajia;
	private String pifimaofa;
	private String toumainwuguanjinxiang;
	private String qinahoueryinjipaixiewu;
	private String maizhen;
	private String wenzhen;
	private String dzqita;
	private String zhenzhuang;
	private String shezheng;
	private String maizhenSel;
	private String zylxpj;
	private String xylxpj;
	private String date;
	private String huifangren;
	private String huifangneirong;
	private String oqita;
	private String lsdy;
	private String grxd;
	private String zjdp;
	private String createDate;
	
	public List<String> properties() {
		return Lists.newArrayList(
				name, sex, age+"", phone, address, birthplace, zipCode, marriage+"", 
				citizenship, profession, ethnic, weight+"", medicine, zyjb, xyjb, zyzh, zzzf, 
				zfm, type, number, doctor, medicinec, medicinew, other, tigejiancha, zusu,
				xianbingshi, jiwangshi, guomingshi, hunyushi, gerenshi, 
				jiazhushi, sehz, shensexingtai, xiongfu, yaobeishizhizhuajia, pifimaofa, 
				toumainwuguanjinxiang, qinahoueryinjipaixiewu, maizhen, wenzhen, dzqita, 
				zhenzhuang, shezheng, maizhenSel, zylxpj, xylxpj, date, huifangren, 
				huifangneirong, oqita, lsdy, grxd, zjdp, createDate
			);
	}
}
