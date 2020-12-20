package com.dmu.hrms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Post {
    private Integer id;

    private String pname;

    private List<Staff> staffs;
}