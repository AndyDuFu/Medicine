package com.medicine.web;


import com.github.pagehelper.PageHelper;
import com.medicine.domain.Dictionary;
import com.medicine.domain.dto.PatientRecodDTO;
import com.medicine.domain.dto.YiAnReCodDTO;
import com.medicine.domain.from.YiAnForm;
import com.medicine.domain.menu.ComponentManager;
import com.medicine.domain.page.PageDomain;
import com.medicine.service.ComponentManagerService;
import com.medicine.service.DictionaryService;
import com.medicine.service.PlatformManagerService;
import com.medicine.service.VisitRecordService;
import com.medicine.util.JsonResult;
import com.medicine.util.StringUtils;
import com.medicine.util.TableSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "平台管理接口", description = "平台管理"
)
@RequestMapping(value = "/apiM/platform")
public class PlatformManagerController {

    @Autowired
    private PlatformManagerService platformManagerService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private ComponentManagerService componentManagerService;
    @Autowired
    private VisitRecordService visitRecordService;

    @ApiOperation(value = "保存管理", notes = "中医疾病管理 cdm  西医疾病管理  wdm 证候管理      zh\n" +
            "舌诊管理    sz    饮片管理     yp  中药管理      zy\n" +
            "治则治法管理 zzzf  脉诊管理     mz  功能类型管理  gxlx\n" +
            "方剂管理    fj    方剂主治管理  fjzz 症状管理     zz\n" +
            "成分管理    cf")
    @PostMapping(value = "/save")
    public JsonResult<Long> save(
            @RequestBody Map<String, Object> data
            ) {
        return JsonResult.builder().data(
                platformManagerService.save(data).getId()
        ).build();
    }

    @ApiOperation(value = "查询管理", notes = "和添加一样")
    @GetMapping(value = "/getListData")
    public List<Map<String, Object>> findByManager(@RequestParam String type) {
        return platformManagerService.findByManager(type);
    }

    @ApiOperation(value = "删除数据", notes = "传入id")
    @DeleteMapping(value = "/delete")
    public JsonResult<Long> deleteById(@RequestParam Long id) {
        platformManagerService.deletePlatAndPlatDate(id);
        return JsonResult.builder().data("删除成功").build();
    }

    @ApiOperation(value = "查询中医数据", notes = "方剂管理使用")
    @GetMapping(value = "/getZyName")
    public List<String> getZyName() {
        return platformManagerService.findByZyName();
    }

    /** 字典平台管理 **/
    @ApiOperation(value = "字典平台 查询", notes = "/findDictionary")
    @GetMapping(value = "/findDictionary")
    public List<Dictionary> findDictionary(@RequestParam(required = false) String sysType) {
        return dictionaryService.findBySysType(sysType);
    }

    @ApiOperation(value = "字典平台 删除")
    @DeleteMapping(value = "/deleteDictionary")
    public JsonResult<String> deleteDictionary(@RequestParam Long id) {
        dictionaryService.delete(id);
        return JsonResult.builder().data("删除成功").build();
    }

    @ApiOperation(value = "字典平台 添加")
    @PostMapping(value = "/addDictionary")
    public JsonResult<Dictionary> addDictionary(@RequestBody Dictionary dictionary) {
        return JsonResult.builder().data(dictionaryService.save(dictionary)).build();
    }

    /** 成分平台管理 **/
    @ApiOperation(value = "成分平台 根据name查询")
    @GetMapping(value = "/findComponentByName")
    public List<ComponentManager> findComponentByName(
            @RequestParam(required = false) String name) {
        return  componentManagerService.findByName(name);
    }

    @ApiOperation(value = "成分平台 删除")
    @DeleteMapping(value = "/deleteComponentManagerById")
    public JsonResult<String> deleteComponentManagerById(@RequestParam Long id) {
        componentManagerService.delete(id);
        return JsonResult.builder().data("删除成功").build();
    }

    @ApiOperation(value = "成分平台 添加修改")
    @PostMapping(value = "/saveComponentManager")
    public JsonResult<ComponentManager> saveComponentManager(@RequestBody ComponentManager componentManager) {
        return JsonResult.builder().data(componentManagerService.save(componentManager)).build();
    }

    /** 医案管理 **/
    @ApiOperation(value = "医案管理", notes = "/findPatiendAll")
    @GetMapping("/findPatiendAll")
    public Page<YiAnReCodDTO> findPatiendAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String visitDate,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer size,
            @RequestParam(required = false, defaultValue = "1") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return visitRecordService.findByNameAndVisitDate(pageRequest, name, visitDate);
    }

    @ApiOperation(value = "修改医案", notes = "/save/patiend")
    @PostMapping("/save/patiend")
    public JsonResult patiendSave(@RequestBody YiAnForm yiAnForm) {

        visitRecordService.editYianRecode(yiAnForm);
        return JsonResult.builder().data("成功").build();
    }



}
