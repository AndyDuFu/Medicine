package com.medicine.domain.attiendRecode;

import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 *  西医检查
 */
@Data
@Entity
@Table(name = "diagnosis_of_we")
public class DiagnosisOfWe extends BaseEntity{

    // 体格检查
    private String tigejiancha;

    // 常规检查 0:血常规 1:心电图 2:尿常规 3:CT 4:大便常规 5:MRI 6:血生化 7:超声
    //         8:X光   9:其他
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "dOfWe")
    private List<WesternMedicine> westernMedicines;

}
