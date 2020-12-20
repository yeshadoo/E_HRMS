package com.dmu.hrms.service;

import com.dmu.hrms.entity.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/12/20 20:52
 */
public interface StaffService {
    List<Staff> selectAll();
}