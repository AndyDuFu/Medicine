package com.medicine.batch.install.constant;

import java.util.List;

import com.google.common.collect.Lists;
import com.medicine.batch.install.enums.ChMedEnum;
import com.medicine.batch.install.enums.DiagnosisEnum;
import com.medicine.batch.install.enums.OtherEnum;
import com.medicine.batch.install.enums.PatientEnum;
import com.medicine.batch.install.enums.VisitRecordEnum;
import com.medicine.batch.install.enums.WestMedEnum;


/**
 * @author FuDu
 * @date 2019-04-03
 * @desc excel 文件的标题部分
 */
public class PatientAndVisitRecord {
	public static final List<String> TITLE_DESC = Lists.newArrayList(
			PatientEnum.NAME.desc(), PatientEnum.SEX.desc(), PatientEnum.AGE.desc(), PatientEnum.PHONE.desc(), 
			PatientEnum.ADDRESS.desc(), PatientEnum.BIRTHPLACE.desc(), PatientEnum.ZIPCODE.desc(), 
			PatientEnum.MARRIAGE.desc(), PatientEnum.CITIZENSHIP.desc(), PatientEnum.PROFESSION.desc(),
			PatientEnum.ETHNIC.desc(), PatientEnum.WEIGHT.desc(),
			DiagnosisEnum.MEDICINE.desc(), DiagnosisEnum.ZYJB.desc(), DiagnosisEnum.XYJB.desc(),
			DiagnosisEnum.ZYZH.desc(), DiagnosisEnum.ZZZF.desc(), DiagnosisEnum.ZFM.desc(),
			DiagnosisEnum.TYPE.desc(), DiagnosisEnum.NUMBER.desc(), DiagnosisEnum.DOCTOR.desc(),
			DiagnosisEnum.MEDICINEC.desc(), DiagnosisEnum.MEDICINEW.desc(), DiagnosisEnum.OTHER.desc(),
			WestMedEnum.BODYCHECK.desc(),
			ChMedEnum.ZUSU.desc(), ChMedEnum.XIANBINGSHI.desc(), ChMedEnum.JIWANGSHI.desc(), 
			ChMedEnum.GUOMINGSHI.desc(), ChMedEnum.HUNYUSHI.desc(), ChMedEnum.GERENSHI.desc(),ChMedEnum.JIAZHUSHI.desc(),
			ChMedEnum.SEHZ.desc(), ChMedEnum.SHENSEXINGTAI.desc(), ChMedEnum.XIONGFU.desc(), ChMedEnum.YAOBEISHIZHIZHUAJIA.desc(),
			ChMedEnum.PIFIMAOFA.desc(), ChMedEnum.TOUMAINWUGUANJINXIANG.desc(), ChMedEnum.QINAHOUERYINJIPAIXIEWU.desc(),
			ChMedEnum.MAIZHEN.desc(), ChMedEnum.WENZHEN.desc(), ChMedEnum.QITA.desc(), ChMedEnum.ZHENZHUANG.desc(),
			ChMedEnum.SHEZHENG.desc(), ChMedEnum.MAIZHENSEL.desc(),
			OtherEnum.ZYLXPJ.desc(), OtherEnum.XYLXPJ.desc(), OtherEnum.DATE.desc(), OtherEnum.HUIFANGREN.desc(),
			OtherEnum.HUIFANGNEIRONG.desc(), OtherEnum.QITA.desc(), OtherEnum.LSDY.desc(), OtherEnum.GRXD.desc(),
			OtherEnum.ZJDP.desc(),
			VisitRecordEnum.CREATE_DATE.desc()
	);
	public static final List<String> TITLE_VALUE = Lists.newArrayList(
			PatientEnum.NAME.value(), PatientEnum.SEX.value(), PatientEnum.AGE.value(), PatientEnum.PHONE.value(), 
			PatientEnum.ADDRESS.value(), PatientEnum.BIRTHPLACE.value(), PatientEnum.ZIPCODE.value(), 
			PatientEnum.MARRIAGE.value(), PatientEnum.CITIZENSHIP.value(), PatientEnum.PROFESSION.value(),
			PatientEnum.ETHNIC.value(), PatientEnum.WEIGHT.value(),
			DiagnosisEnum.MEDICINE.value(), DiagnosisEnum.ZYJB.value(), DiagnosisEnum.XYJB.value(),
			DiagnosisEnum.ZYZH.value(), DiagnosisEnum.ZZZF.value(), DiagnosisEnum.ZFM.value(),
			DiagnosisEnum.TYPE.value(), DiagnosisEnum.NUMBER.value(), DiagnosisEnum.DOCTOR.value(),
			DiagnosisEnum.MEDICINEC.value(), DiagnosisEnum.MEDICINEW.value(), DiagnosisEnum.OTHER.value(),
			WestMedEnum.BODYCHECK.value(),
			ChMedEnum.ZUSU.value(), ChMedEnum.XIANBINGSHI.value(), ChMedEnum.JIWANGSHI.value(), 
			ChMedEnum.GUOMINGSHI.value(), ChMedEnum.HUNYUSHI.value(), ChMedEnum.GERENSHI.value(),ChMedEnum.JIAZHUSHI.value(),
			ChMedEnum.SEHZ.value(), ChMedEnum.SHENSEXINGTAI.value(), ChMedEnum.XIONGFU.value(), ChMedEnum.YAOBEISHIZHIZHUAJIA.value(),
			ChMedEnum.PIFIMAOFA.value(), ChMedEnum.TOUMAINWUGUANJINXIANG.value(), ChMedEnum.QINAHOUERYINJIPAIXIEWU.value(),
			ChMedEnum.MAIZHEN.value(), ChMedEnum.WENZHEN.value(), ChMedEnum.QITA.value(), ChMedEnum.ZHENZHUANG.value(),
			ChMedEnum.SHEZHENG.value(), ChMedEnum.MAIZHENSEL.value(),
			OtherEnum.ZYLXPJ.value(), OtherEnum.XYLXPJ.value(), OtherEnum.DATE.value(), OtherEnum.HUIFANGREN.value(),
			OtherEnum.HUIFANGNEIRONG.value(), OtherEnum.QITA.value(), OtherEnum.LSDY.value(), OtherEnum.GRXD.value(),
			OtherEnum.ZJDP.value(),
			VisitRecordEnum.CREATE_DATE.value()
	);
}
