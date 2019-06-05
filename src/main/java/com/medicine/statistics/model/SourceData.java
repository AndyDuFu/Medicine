package com.medicine.statistics.model;

import lombok.Data;

/**
 * @author: cddufu@cn.ibm.com
 * @date: 2019-06-05
 * @desc: 返回给前端统计图的数据格式
 */
@Data
public class SourceData {
    private String name;
    private Integer count;
}
