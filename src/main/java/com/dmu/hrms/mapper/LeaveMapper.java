package com.dmu.hrms.mapper;

import com.dmu.hrms.entity.Leave;
import java.util.List;

public interface LeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leave record);

    Leave selectByPrimaryKey(Integer id);

    List<Leave> selectByStatus(String status);

    List<Leave> selectAll();

    int updateByPrimaryKey(Leave record);
}