package com.medicine.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medicine.domain.Datum;
import com.medicine.domain.dto.DatumDTO;
import com.medicine.domain.page.PageDomain;
import com.medicine.service.DatumService;
import com.medicine.util.JsonResult;
import com.medicine.util.StringUtils;
import com.medicine.util.TableDataInfo;
import com.medicine.util.TableSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apiM/datum")
@Api(value = "资料管理", description = "资料管理")
public class DatumController {

    @Autowired
    private DatumService datumService;

    @ApiOperation(value = "保存", notes = "/apiM/datum/save")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(@RequestBody Datum datum) {
        return JsonResult.builder().data(datumService.save(datum)).build();
    }

    @ApiOperation(value = "删除", notes = "/apiM/datum/delete")
    @DeleteMapping(value = "delete")
    public JsonResult delete(@RequestParam Long id) {
        datumService.delete(id);
        return JsonResult.builder().data("删除成功").build();
    }

    @ApiOperation(value = "查询", notes = "/apiM/datum/find")
    @GetMapping(value = "find")
    public TableDataInfo findAll(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String key){
        List<DatumDTO> data = datumService.findByTitleAndKey(title, key);
        return getDataTable(data);

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
}
