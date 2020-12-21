package com.dmu.hrms.service.impl;

import com.dmu.hrms.entity.Dept;
import com.dmu.hrms.mapper.DeptMapper;
import com.dmu.hrms.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/12/21 9:09
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    @Override
    public int insert(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }
}