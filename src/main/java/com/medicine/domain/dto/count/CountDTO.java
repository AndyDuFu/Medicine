package com.medicine.domain.dto.count;

import com.medicine.util.CharacterUtils;
import lombok.Data;

import java.util.List;

/** 四气 无味 归茎 */
@Data
public class CountDTO {

    private String sq;

    private String ww;

    private String gj;

    public  static List<String> stringListConvertString(String str){
        return CharacterUtils.stringTochars(str);
    }
}
