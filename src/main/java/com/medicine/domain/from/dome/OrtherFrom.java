package com.medicine.domain.from.dome;


import com.medicine.domain.attiendRecode.OtherMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel(value = "其他信息")
public class OrtherFrom {

    private Long id;

    @ApiModelProperty(value = "中医效果评价")
    private String zylxpj;

    @ApiModelProperty(value = "西医效果评价")
    private String xylxpj;

    @ApiModelProperty(value = "时间")
    private String date;

    @ApiModelProperty(value = "回访人")
    private String  huifangren;

    @ApiModelProperty(value = "内容")
    private String  huifangneirong;

    @ApiModelProperty(value = "其他")
    private String  qita;

    @ApiModelProperty(value = "老师答疑")
    private String  lsdy;

    @ApiModelProperty(value = "个人心得")
    private String  grxd;

    @ApiModelProperty(value = "专家点评")
    private String  zjdp;


    public static OtherMessage ortherFromToOtherMesage(OrtherFrom ortherFrom) {
        OtherMessage otherMessage = new OtherMessage();
        BeanUtils.copyProperties(ortherFrom, otherMessage);
        return otherMessage;
    }

}
