package com.medicine.batch.install.controller;

import com.medicine.batch.install.model.OMRecord;
import com.medicine.batch.install.model.TCMRecord;
import com.medicine.batch.install.model.WMRecord;
import com.medicine.batch.install.param.DATParam;
import com.medicine.batch.install.serviceImpl.IMedicineRecordsService;
import com.medicine.util.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author: cddufu@cn.ibm.com
 * @date: 2019-09-24
 * @desc: 提供修改病人就诊记录的接口
 */
@RestController
@RequestMapping("/medicine/records")
public class MedicineRecordsController {
    @Resource
    private IMedicineRecordsService medicineRecordsService;

    // 修改中医四诊部分
    @PostMapping("/TCM/modify")
    public JsonResult modifyTCM(@RequestBody TCMRecord tcmRecord) {
        medicineRecordsService.modifyTCMRecord(tcmRecord);
        return JsonResult.builder().data("成功").build();
    }

    // 修改西医检查部分
    @PostMapping("/WM/modify")
    public JsonResult modifyWM(@RequestBody WMRecord wmRecord) {
        medicineRecordsService.modifyWMRecord(wmRecord);
        return JsonResult.builder().data("成功").build();
    }

    // 修改诊断治疗部分
    @PostMapping("/DAT/modify")
    public JsonResult modifyDAT(@RequestBody DATParam datParam) {
        medicineRecordsService.modifyDATParam(datParam);
        return JsonResult.builder().data("成功").build();
    }

    // 修改其他信息部分
    @PostMapping("/OM/modify")
    public JsonResult modifyOM(@RequestBody OMRecord omRecord) {
        medicineRecordsService.modifyOMRecord(omRecord);
        return JsonResult.builder().data("成功").build();
    }
}
