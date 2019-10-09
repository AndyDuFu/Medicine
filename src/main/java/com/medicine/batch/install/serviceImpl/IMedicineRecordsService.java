package com.medicine.batch.install.serviceImpl;

import com.medicine.batch.install.model.*;
import com.medicine.batch.install.param.DATParam;

import java.util.List;
/**
 * @author FuDu
 * @date 2019-09-24
 */
public interface IMedicineRecordsService {
	List<Medicine> getMedicineRecords();
	void modifyTCMRecord(TCMRecord tcmRecord);
	void modifyWMRecord(WMRecord wmRecord);
	void modifyDATParam(DATParam datParam);
	void modifyDATRecord(DATRecord datRecord);
	void modifyMedicines(long datid, List<Medicine> medicines);
	void modifyOMRecord(OMRecord otherRecord);
}
