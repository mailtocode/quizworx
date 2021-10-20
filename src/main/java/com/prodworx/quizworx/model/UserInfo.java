package com.prodworx.quizworx.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class UserInfo {
    @Id
    private Integer userID;

    @Column
    private String emailAddress;

    @Column
    private String password;

    @Column
    private String userType;
}
