package com.medicine.domain.from.dome;

import com.medicine.domain.attiendRecode.DiagnosisOfZh;
import com.medicine.util.CharacterUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@ApiModel(value = "中医四诊")
public class DiagnosisOfZhFrom {

    private Long id;

    @ApiModelProperty(value = "主诉")
    private String zusu;

    @ApiModelProperty(value = "现病史")
    private String xianbingshi;

    @ApiModelProperty(value = "既往史")
    private String jiwangshi;

    @ApiModelProperty(value = "过敏史")
    private String guomingshi;

    @ApiModelProperty(value = "婚育史")
    private String hunyushi;

    @ApiModelProperty(value = "个人史")
    private String gerenshi;

    @ApiModelProperty(value = "家族史")
    private String jiazhushi;

    @ApiModelProperty(value = "舌诊")
    private String sehz;

    @ApiModelProperty(value = "神色形态")
    private String shensexingtai;

    @ApiModelProperty(value = "胸腹")
    private String xiongfu;

    @ApiModelProperty(value = "腰背四肢爪甲")
    private String yaobeishizhizhuajia;

    @ApiModelProperty(value = "皮肤毛发")
    private String pifimaofa;

    @ApiModelProperty(value = "头面五官颈项")
    private String toumainwuguanjinxiang;

    @ApiModelProperty(value = "前后二阴及")
    private String qinahoueryinjipaixiewu;

    @ApiModelProperty(value = "舌诊图片")
    private WesternMedicineFrom shezhenimg;

    @ApiModelProperty(value = "脉诊")
    private String maizhen;

    @ApiModelProperty(value = "闻诊")
    private String wenzhen;

    @ApiModelProperty(value = "其他")
    private String qita;

    @ApiModelProperty(value = "症状")
    private List<String> zhenzhuang;

    @ApiModelProperty(value = "舌诊")
    private List<String> shezheng;

    @ApiModelProperty(value = "脉诊外键")
    private List<String>  maizhenSel;

    public static DiagnosisOfZh dZhFromToD(DiagnosisOfZhFrom diagnosisOfZhFrom) {
        DiagnosisOfZh diagnosisOfZh = new DiagnosisOfZh();
        BeanUtils.copyProperties(diagnosisOfZhFrom, diagnosisOfZh);
        diagnosisOfZh.setZhenzhuang(CharacterUtils.charsToString(diagnosisOfZhFrom.getZhenzhuang()));
        diagnosisOfZh.setShezheng(CharacterUtils.charsToString(diagnosisOfZhFrom.getShezheng()));
        diagnosisOfZh.setMaizhenSel(CharacterUtils.charsToString(diagnosisOfZhFrom.getMaizhenSel()));
        diagnosisOfZh.setWesternMedicine(WesternMedicineFrom.westerFromToWester(diagnosisOfZhFrom.getShezhenimg()));
        return diagnosisOfZh;
    }

}
