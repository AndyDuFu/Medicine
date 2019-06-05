package com.medicine.batch.install.thread;

import java.util.List;
import com.medicine.domain.from.VisitRecordForm;
import com.medicine.service.VisitRecordService;

/**
 * @author FuDu
 * @date 2019-03-23
 * @desc 启用多个线程批量插入就诊信息
 */
public class MultiThreadInstallVisitRecords implements Runnable {
	private List<VisitRecordForm> visitRecordForms;
	private VisitRecordService visitRecordService;
	
	public MultiThreadInstallVisitRecords(VisitRecordService visitRecordService, List<VisitRecordForm> visitRecordForms) {
		this.visitRecordService = visitRecordService;
		this.visitRecordForms = visitRecordForms;
	}
	
	@Override
	public void run() {
		visitRecordService.batchInstall(visitRecordForms);
	}

	public List<VisitRecordForm> getVisitRecordForms() {
		return visitRecordForms;
	}

	public void setVisitRecordForms(List<VisitRecordForm> visitRecordForms) {
		this.visitRecordForms = visitRecordForms;
	}

	public VisitRecordService getVisitRecordService() {
		return visitRecordService;
	}

	public void setVisitRecordService(VisitRecordService visitRecordService) {
		this.visitRecordService = visitRecordService;
	}

}
