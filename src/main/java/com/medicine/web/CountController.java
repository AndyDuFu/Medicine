package com.medicine.web;


import com.medicine.domain.dto.count.StatementDTO;
import com.medicine.domain.dtoAndFrom.menu.FjManager;
import com.medicine.domain.queryFrom.FJQueryFrom;
import com.medicine.service.PlatformManagerService;
import com.medicine.util.JsonResult;
import com.medicine.util.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiM/count")
@Api(value = "统计管理", description = "统计管理")
public class CountController {

    @Autowired
    private PlatformManagerService platformManagerService;

    @ApiOperation(value = "方剂管理", notes = "和添加一样 " +
            "type 0: 表示证候查询。 1:表示药物查询 2：表示归茎 3：表示四气 4：表示5味")
    @PostMapping(value = "/getFjData")
    public JsonResult<List<StatementDTO>> getFjData(@RequestBody(required = false)FJQueryFrom fjQueryFrom, Integer type) {
        return JsonResult.builder().data(
                platformManagerService.countData(fjQueryFrom, type)
        ).build();
    }
}
