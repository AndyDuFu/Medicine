package com.medicine.statistics.controller;

import com.medicine.statistics.service.SourceDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: cddufu@cn.ibm.com
 * @date:
 * @desc:
 */
@RestController
@RequestMapping("/source/data")
public class SourceDataController {
    @Resource
    private SourceDataService countService;

    /**
     * 根据性别统计病患人数
     */
    @GetMapping("/gender")
    public Map<String, Object> getCountByGender() {
        Map<String, Object> result = new HashMap<>();
        result.put("sourceData", countService.getDataByGender());
        return result;
    }

    /**
     * 根据年龄段统计病患数(以10年为一个年龄段)
     */
    @GetMapping("/age")
    public Map<String, Object> getDataByAge() {
        Map<String, Object> result = new HashMap<>();
        result.put("sourceData", countService.getDataByAge());
        return result;
    }

    /**
     * 根据中医诊断统计病例数
     */
    @GetMapping("/chm")
    public Map<String, Object> getDataByChm() {
        Map<String, Object> result = new HashMap<>();
        result.put("sourceData", countService.getDataByChm());
        return result;
    }

    /**
     * 根据西医诊断统计病例数
     */
    @GetMapping("/wem")
    public Map<String, Object> getDataByWem() {
        Map<String, Object> result = new HashMap<>();
        result.put("sourceData", countService.getDataByWem());
        return result;
    }

    /**
     * 根据药物统计病例数
     */
    @GetMapping("/medicine")
    public Map<String, Object> getDataByMedicine() {
        Map<String, Object> result = new HashMap<>();
        result.put("sourceData", countService.getDataByMedicine());
        return result;
    }

}
