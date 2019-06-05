package com.medicine.batch.install.enums;
/**
 * @author FuDu
 * @date 2019-03-15
 * @desc 该类主要用于批量导入就诊信息时其他信息部分 CSV 文件头的固定格式
 */ 
public enum OtherEnum {
	ZYLXPJ("zylxpj", "中医效果评价"), XYLXPJ("xylxpj", "西医效果评价"), DATE("date", "回访时间"), HUIFANGREN("huifangren", "回访人"),
	HUIFANGNEIRONG("huifangneirong", "回访内容"), QITA("qita", "其他(其他信息)"), LSDY("lsdy", "老师答疑"), GRXD("grxd", "个人心得"),
	ZJDP("zjdp", "专家点评");
	private String value;
	private String desc;
	private OtherEnum(String value, String desc) {
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
