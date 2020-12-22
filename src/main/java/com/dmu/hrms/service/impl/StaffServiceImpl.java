package com.dmu.hrms.service.impl;

import com.dmu.hrms.entity.Staff;
import com.dmu.hrms.mapper.StaffMapper;
import com.dmu.hrms.mapper.UserMapper;
import com.dmu.hrms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/12/20 20:52
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffMapper staffMapper;

    @Override
    public int insert(Staff staff) {
        return staffMapper.insert(staff);
    }

    @Override
    public List<Staff> selectAll() {
        return staffMapper.selectAll();
    }


    @Override
    public List<Staff> selectByDept(Integer postId) {
        return staffMapper.selectByDept(postId);
    }

    @Override
    public List<Staff> selectByPost(Integer deptId) {
        return staffMapper.selectByPost(deptId);
    }

    @Override
    public List<Staff> selectByStatus(String status) {
        return staffMapper.selectByStatus(status);
    }

    @Override
    public void updateStatus(Integer id, String param) {
        staffMapper.updateStatus(id,param);
    }

    @Override
    public Staff selectBySname(String sname) {
        return staffMapper.selectBySname(sname);
    }
}