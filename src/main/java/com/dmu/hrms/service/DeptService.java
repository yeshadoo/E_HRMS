package com.dmu.hrms.service;

import com.dmu.hrms.entity.Dept;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/12/21 9:06
 */
public interface DeptService {
    int insert(Dept dept);

    List<Dept> selectAll();
}