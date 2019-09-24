package com.medicine.batch.install.param;

import com.medicine.batch.install.model.DATRecord;
import com.medicine.batch.install.model.Medicine;
import lombok.Data;

import java.util.List;

/**
 * @author: cddufu@cn.ibm.com
 * @date: 2019-09-24
 * @desc: 诊断与治疗部分修改功能需传递的参数，因为这块包含两个部分，所以新建一个类处理前端传递过来的参数
 */
@Data
public class DATParam {
    private DATRecord datRecord;
    private List<Medicine> medicines;
}
