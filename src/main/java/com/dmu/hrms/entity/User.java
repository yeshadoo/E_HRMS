package com.dmu.hrms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class User {
    private Integer id;

    private String role;

    private String username;

    private String password;

}