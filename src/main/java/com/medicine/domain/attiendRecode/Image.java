package com.medicine.domain.attiendRecode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medicine.domain.BaseEntity;
import com.medicine.domain.attiendRecode.WesternMedicine;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Data
@Entity
@Proxy(lazy = false)
public class Image extends BaseEntity {

    private String name;

    private String status;

    private String url;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "western_id")
    private WesternMedicine western;
}
