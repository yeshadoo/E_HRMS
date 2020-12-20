package com.dmu.hrms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept {
    private Integer id;

    private String dname;

    private List<Staff> staffs;
}