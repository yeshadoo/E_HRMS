package com.dmu.hrms.service;

import com.dmu.hrms.entity.Leave;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/12/22 10:50
 */
public interface LeaveService {
    int insert(Leave leave);

    List<Leave> selectAll();

    List<Leave> selectByStatus(String status);

    void updateStatus(Integer id,String param);
}