package com.medicine.web;


import com.alibaba.fastjson.JSONObject;
import com.medicine.domain.Patient;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.from.PatientFrom;
import com.medicine.service.PatientService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "病人接口", description = "病人操作接口")
@RequestMapping(value = "/apiM/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @ApiOperation(value = "查询分页", notes = "现在不知道要传什么值，未做条件查询")
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<PatientDTO> findAllPage(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer size,
            @RequestParam(value = "searchV", required = false) String name
    ) {
        Pageable pageable = PageRequest.of(page-1, size);
        return patientService.findPatientCriteria(pageable, name);

    }

    @SuppressWarnings("rawtypes")
	@ApiOperation(value = "新增/修改", notes = "输入值还不知道")
    @PostMapping(value = "/add")
    public JsonResult save(@RequestBody PatientFrom patientFrom) {
        if (patientService.findByPhone(patientFrom.getPhone()).size() > 0 ) {
            if (patientFrom.getId() != null) {
               Patient patient = patientService.findById(patientFrom.getId());
               if (!patient.getPhone().equals(patientFrom.getPhone())) {
                   return JsonResult.builder().error("电话号码重复").build();
               }
            } else {
                return JsonResult.builder().error("电话号码重复").build();
            }
        }
        return JsonResult.builder().data(
                patientService.save(patientFrom).getId()).build();
    }
    
    @GetMapping("/delete/{id}")
    public Map<String, Object> deletePatientById(@PathVariable("id")long id) {
    	Map<String, Object> result = new HashMap<>();
    	patientService.deleteById(id);
    	result.put("code", id);
    	return result;
    }
    
    @PostMapping("/delete")
    public Map<String, Object> deletePatientById(@RequestBody JSONObject params) {
    	Map<String, Object> result = new HashMap<>();
    	long patientId = params.getLongValue("id");
    	patientService.deleteById(patientId);
    	result.put("code", patientId);
    	return result;
    }
}
