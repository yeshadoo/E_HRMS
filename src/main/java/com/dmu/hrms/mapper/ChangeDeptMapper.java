package com.dmu.hrms.mapper;

import com.dmu.hrms.entity.ChangeDept;
import java.util.List;

public interface ChangeDeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChangeDept record);

    ChangeDept selectByPrimaryKey(Integer id);

    List<ChangeDept> selectAll();

    int updateByPrimaryKey(ChangeDept record);
}