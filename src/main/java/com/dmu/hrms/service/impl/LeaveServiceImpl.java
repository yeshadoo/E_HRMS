package com.dmu.hrms.service.impl;

import com.dmu.hrms.entity.Leave;
import com.dmu.hrms.mapper.LeaveMapper;
import com.dmu.hrms.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/12/22 10:51
 */
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    LeaveMapper leaveMapper;

    @Override
    public int insert(Leave leave) {
        return leaveMapper.insert(leave);
    }

    @Override
    public List<Leave> selectAll() {
        return leaveMapper.selectAll();
    }

    @Override
    public List<Leave> selectByStatus(String status) {
        return leaveMapper.selectByStatus(status);
    }

    @Override
    public void updateStatus(Integer id, String param) {
        leaveMapper.updateStatus(id,param);
    }
}