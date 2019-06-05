package com.medicine.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Attachment extends BaseEntity {

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "file_path")
    private String filePath;

    private String type;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "datum_id")
    private Datum datum;
}
