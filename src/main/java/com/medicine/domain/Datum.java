package com.medicine.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "datum")
public class Datum extends BaseEntity {

    private String name;

    private String keyName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datum")
    private List<Attachment> attachments;
}
