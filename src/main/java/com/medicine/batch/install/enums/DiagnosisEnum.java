package com.medicine.batch.install.enums;

/**
 * @author FuDu
 * @date 2019-03-15
 * @desc 该类主要用于批量导入就诊信息时诊断治疗部分 CSV 文件头的固定格式
 */
public enum DiagnosisEnum {
	ZYJB("zyjb", "中医疾病"), XYJB("xyjb", "西医疾病"), ZYZH("zyzh", "中医证候"), ZZZF("zzzf", "治则治法"),
	ZFM("zfm", "处方名称"), TYPE("type", "处方类型"), NUMBER("number", "处方剂数"), DOCTOR("doctor", "处方医师"),
	MEDICINEC("medicineC", "中成药"), MEDICINEW("medicineW", "西成药"), OTHER("orther", "其他(诊断与治法)"),
	MEDICINE("medicine", "处方详情");
	
	private String value;
	private String desc;
	private DiagnosisEnum(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	public String value() {
		return value;
	}
	public String desc() {
		return desc;
	}
}
