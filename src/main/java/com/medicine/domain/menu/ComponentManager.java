package com.medicine.domain.menu;

import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "component_manager")
public class ComponentManager extends BaseEntity {

    private String cas;

    private String come;

    private String fzs;

    private String name;

}
