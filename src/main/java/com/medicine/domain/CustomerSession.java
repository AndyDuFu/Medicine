package com.medicine.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "customer_session")
public class CustomerSession extends BaseEntity{
    private static final long serialVersionUID = -7331643482904764806L;

    public static final String TOKEN_SUFFIX = "-c";

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "auth_token", length = 50)
    private String authToken;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    /**
     * 此次登录是否过期
     */
    @Column(name = "is_expired", nullable = false)
    private boolean isExpired;

}
