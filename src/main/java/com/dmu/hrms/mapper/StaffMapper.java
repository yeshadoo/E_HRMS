package com.dmu.hrms.mapper;

import com.dmu.hrms.entity.Staff;
import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    Staff selectByPrimaryKey(Integer id);

    List<Staff> selectAll();

    int updateByPrimaryKey(Staff record);
}