package com.medicine.batch.install.service;

import java.util.List;

import javax.annotation.Resource;

import com.medicine.batch.install.model.*;
import com.medicine.batch.install.param.DATParam;
import com.medicine.batch.install.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.batch.install.serviceImpl.IMedicineRecordsService;

/**
 * @author FuDu
 * @date 2019-09-24
 */
@Service
@Transactional
public class MedicineRecordsService implements IMedicineRecordsService {
	@Resource
	private MedicineRecordsRepository medicineRecordsRepository;
	@Resource
	private TCMRepository tcmRepository;
	@Resource
	private WMRepository wmRepository;
	@Resource
	private DATRepository datRepository;
	@Resource
	private OMRepository omRepository;

	@Override
	public List<Medicine> getMedicineRecords() {
		return medicineRecordsRepository.getMedicineRecords();
	}

	// 修改中医四诊部分
	@Override
	public void modifyTCMRecord(TCMRecord tcmRecord) {
		// 假如前端没有办法知道该记录原来关于舌诊图片的id，传递个 0 过来；
		// 那么后台应从数据库取出该记录，并获取舌诊图片id，重新赋值
		// 否则前端页面将出现关联异常而导致出现空白页面
		Long shezhenimgId = tcmRecord.getShezhenimgId();
		if(shezhenimgId == 0) {
			TCMRecord originTCMRecord = tcmRepository.findById(tcmRecord.getId()).get();
			shezhenimgId = originTCMRecord.getShezhenimgId();
			tcmRecord.setShezhenimgId(shezhenimgId);
		}
		tcmRepository.save(tcmRecord);
	}

	// 修改西医检查部分
	@Override
	public void modifyWMRecord(WMRecord wmRecord) {
		wmRepository.save(wmRecord);
	}

	// 修改诊断治疗部分; 该部分包含两个模块要修改: 诊断治疗基本信息 和 中药处方信息
	@Override
	public void modifyDATParam(DATParam datParam) {
		// 诊断治疗基本信息
		DATRecord datRecord = datParam.getDatRecord();
		modifyDATRecord(datRecord);
		// 中药处方信息
		List<Medicine> medicines = datParam.getMedicines();
		modifyMedicines(datRecord.getId(), medicines);
	}

	// 修改诊断治疗基本信息
	@Override
	public void modifyDATRecord(DATRecord datRecord) {
		datRepository.save(datRecord);
	}

	// 修改中药处方信息
	@Override
	public void modifyMedicines(long datid, List<Medicine> medicines) {
		// 保存之前，删除诊断治疗部分关联的中药处方信息重新添加
		medicineRecordsRepository.deleteAllByDatid(datid);
		// 重新添加传递的中药信息
		medicineRecordsRepository.saveAll(medicines);
	}

	// 修改其他信息
	@Override
	public void modifyOMRecord(OMRecord otherRecord) {
		omRepository.save(otherRecord);
	}

}
