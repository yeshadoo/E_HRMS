package com.dmu.hrms.mapper;

import com.dmu.hrms.entity.Probation;
import java.util.List;

public interface ProbationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Probation record);

    Probation selectByPrimaryKey(Integer id);

    List<Probation> selectAll();

    int updateByPrimaryKey(Probation record);
}