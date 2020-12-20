package com.dmu.hrms.mapper;

import com.dmu.hrms.entity.Post;
import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    Post selectByPrimaryKey(Integer id);

    List<Post> selectAll();

    int updateByPrimaryKey(Post record);
}