package com.medicine.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medicine.domain.dto.YiAnReCodDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.MedicineDTO;
import com.medicine.domain.dtoAndFrom.menu.FjManager;
import com.medicine.domain.dtoAndFrom.menu.ZyManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.page.PageDomain;
import com.medicine.domain.queryFrom.FJQueryFrom;
import com.medicine.domain.queryFrom.YanQueryFrom;
import com.medicine.domain.queryFrom.ZyQueryFrom;
import com.medicine.service.PlatformManagerService;
import com.medicine.service.VisitRecordService;
import com.medicine.util.StringUtils;
import com.medicine.util.TableDataInfo;
import com.medicine.util.TableSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "知识检索", description = "知识检索接口")
@RequestMapping(value = "/apiM/knowledge")
public class KnowledgeController {

    @Autowired
    private PlatformManagerService platformManagerService;

    @Autowired
    private VisitRecordService visitRecordService;


    @ApiOperation(value = "中药管理", notes = "和添加一样")
    @PostMapping(value = "/getListData")
    public TableDataInfo findByManager(@RequestBody(required = false) ZyQueryFrom zyQueryFrom) {
        startPage();
        List<PlatformManagerData> platformManagerData = platformManagerService.findZhongYi(zyQueryFrom);
        List<ZyManager> zyManagers = new ZyManager().convert(platformManagerData);
        return getDataTable(zyManagers);
    }

   @PostMapping("/like/getListData")
   public TableDataInfo findByManager(@RequestBody(required=false)JSONObject params) {
        startPage();
        ZyQueryFrom zyQueryFrom;
        if(null != params) {
        	zyQueryFrom = ZyQueryFrom.getInstance(params.getString("condition"));
        } else {
        	zyQueryFrom = ZyQueryFrom.getInstance(null);
        }
        List<PlatformManagerData> platformManagerData = platformManagerService.findZhongYiByLike(zyQueryFrom);
        List<ZyManager> zyManagers = new ZyManager().convert(platformManagerData);
        return getDataTable(zyManagers);
    }

    protected void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    @ApiOperation(value = "医案管理", notes = "和添加一样")
    @PostMapping(value = "/getYiAnData")
    public TableDataInfo getYiAnData(@RequestBody(required = false)YanQueryFrom yanQueryFrom) {
        startPage();
        List<YiAnReCodDTO> visitRecords = visitRecordService.findALl(yanQueryFrom);
        return getDataTable(visitRecords);
    }
    
    @PostMapping("/like/getYiAnData")
    public TableDataInfo getYiAnData(@RequestBody(required=false) JSONObject params) {
        startPage();
        YanQueryFrom yanQueryFrom;
        if(null != params) {
        	yanQueryFrom = YanQueryFrom.getInstance(params.getInteger("minAge"), params.getInteger("maxAge"), 
            		params.getString("startDate"), params.getString("endDate"), params.getString("condition"));
        } else {
        	yanQueryFrom = YanQueryFrom.getInstance(null, null, null, null, null);
        }
        List<YiAnReCodDTO> visitRecords = visitRecordService.findALl(yanQueryFrom);
        return getDataTable(visitRecords);
    }

    @ApiOperation(value = "方剂管理", notes = "和添加一样")
    @PostMapping(value = "/getFjData")
    public TableDataInfo getFjData(@RequestBody(required = false)FJQueryFrom fjQueryFrom) {
        startPage();
        List<FjManager> fjManagers = platformManagerService.findFj(fjQueryFrom);
        return getDataTable(fjManagers);
    }
    
    @PostMapping("/like/getFjData")
    public TableDataInfo getFjData(@RequestBody(required=false)JSONObject params) {
        startPage();
        FJQueryFrom fjQueryFrom;
        if(null != params) {
        	fjQueryFrom = FJQueryFrom.getInstance(params.getString("condition"));
        } else {
        	fjQueryFrom = FJQueryFrom.getInstance(null);
        }
        List<FjManager> fjManagers = platformManagerService.likeByFj(fjQueryFrom);
        return getDataTable(fjManagers);
    }

    @ApiOperation(value = "方剂组成", notes = "和添加一样")
    @GetMapping(value = "/getCF")
    public List<MedicineDTO> getCF(@RequestParam(name = "status") Integer status, @RequestParam(name = "mid") Long mid) {
        return platformManagerService.findByFJZI(status, mid);
    }
    
}
