package com.medicine.batch.install.enums;

/**
 * @author FuDu
 * @date 2019-03-15
 * @desc 该类主要用于批量导入就诊信息时中医四诊部分 CSV 文件头的固定格式
 */ 
public enum ChMedEnum {
	ZUSU("zusu", "主诉"), XIANBINGSHI("xianbingshi", "现病史"), JIWANGSHI("jiwangshi", "既往史"), GUOMINGSHI("guomingshi", "过敏史"),
	HUNYUSHI("hunyushi", "婚育史"), GERENSHI("gerenshi", "个人史"), JIAZHUSHI("jiazhushi", "家族史"), SEHZ("sehz", "舌诊"),
	SHENSEXINGTAI("shensexingtai", "神色形态"), XIONGFU("xiongfu", "胸腹"), YAOBEISHIZHIZHUAJIA("yaobeishizhizhuajia", "腰背四肢爪甲"),
	PIFIMAOFA("pifimaofa", "皮肤毛发"), TOUMAINWUGUANJINXIANG("toumainwuguanjinxiang", "头面五官颈项"),
	QINAHOUERYINJIPAIXIEWU("qinahoueryinjipaixiewu", "前后二阴及排泄物"), MAIZHEN("maizhen", "脉诊"), WENZHEN("wenzhen", "闻诊"),
	QITA("qita", "其他(中医四诊)"), ZHENZHUANG("zhenzhuang", "症状"), SHEZHENG("shezheng", "舌诊(四诊摘要)"), MAIZHENSEL("maizhenSel", "脉诊(四诊摘要)");
	private String value;
	private String desc;
	private ChMedEnum(String value, String desc) {
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
