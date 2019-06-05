package com.medicine.domain.attiendRecode;

import com.medicine.domain.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Data
@Entity
@Table(name = "western_medicine")
public class WesternMedicine extends BaseEntity {

    private String text;

    private String name;

    @OneToMany(mappedBy = "western", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "d_of_we_id")
    private DiagnosisOfWe dOfWe;
    
    public WesternMedicine() {}
    
    public WesternMedicine(String text, String name, List<Image> img) {
    	this.text = text;
    	this.name = name;
    	this.img = img;
    }
}
