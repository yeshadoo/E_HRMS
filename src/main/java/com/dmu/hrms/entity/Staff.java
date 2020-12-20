package com.dmu.hrms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Staff {
    private Integer id;

    private String sname;

    private String phone;

    private String email;

    private Integer deptId;

    private Integer postId;

    private String status;

    private String level;

    private Dept dept;

    private Post post;

}