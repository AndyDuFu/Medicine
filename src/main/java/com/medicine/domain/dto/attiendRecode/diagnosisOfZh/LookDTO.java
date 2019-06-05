package com.medicine.domain.dto.attiendRecode.diagnosisOfZh;

import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.WesternMedicineDTO;
import lombok.Data;

@Data
public class LookDTO {
    // 舌诊
    private String sehz;

    // 神色形态
    private String shensexingtai;

    // 胸腹
    private String xiongfu;

    // 腰背四肢爪甲
    private String yaobeishizhizhuajia;

    // 皮肤毛发
    private String pifimaofa;

    // 头面五官颈项
    private String toumainwuguanjinxiang;

    // 前后二阴及
    private String qinahoueryinjipaixiewu;

    private WesternMedicineDTO shezhenimg;
}
