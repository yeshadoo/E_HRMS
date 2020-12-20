package com.dmu.hrms.mapper;

import com.dmu.hrms.entity.ChangePost;
import java.util.List;

public interface ChangePostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChangePost record);

    ChangePost selectByPrimaryKey(Integer id);

    List<ChangePost> selectAll();

    int updateByPrimaryKey(ChangePost record);
}