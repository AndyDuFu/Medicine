package com.medicine.web;

import com.medicine.domain.dto.PatientRecodDTO;
import com.medicine.domain.dto.VisitRecordDTO;
import com.medicine.domain.from.VisitRecordForm;
import com.medicine.domain.from.dome.DiagnosisOfZhFrom;
import com.medicine.service.VisitRecordService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;

@RestController
@RequestMapping("/apiM/patient")
@Api(value = "就诊信息", description = "就诊相关接口")
public class VisitRecordController {

    @Autowired
    private VisitRecordService visitRecordService;

    @ApiOperation(value = "添加记录", notes = "需要添加 中医四诊 西医检查 诊断治疗 其他信息")
    @PostMapping("/addRec")
    public JsonResult save(@RequestBody VisitRecordForm visitRecordForm) {
        visitRecordService.save(visitRecordForm);
        return JsonResult.builder().data("成功").build();
    }

    @ApiOperation(value = "查询患者详情记录")
    @GetMapping("/info")
    public PatientRecodDTO getPatiendId(@RequestParam(name = "pid") Long id) {
       return visitRecordService.findById(id);
    }

    @ApiOperation(value = "修改成医案记录", notes = "/setYiyan")
    @GetMapping("/setYiyan")
    public JsonResult editVisitRecord(@RequestParam(name = "id") Long id) {
        visitRecordService.setYiyan(id);
        return JsonResult.builder().data("成功").build();
    }

}
