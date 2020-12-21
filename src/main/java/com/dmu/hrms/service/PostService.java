package com.dmu.hrms.service;

import com.dmu.hrms.entity.Post;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/12/21 10:39
 */
public interface PostService {
    int insert(Post post);

    List<Post> selectAll();
}