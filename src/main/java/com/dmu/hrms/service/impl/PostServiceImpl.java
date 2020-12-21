package com.dmu.hrms.service.impl;

import com.dmu.hrms.entity.Post;
import com.dmu.hrms.mapper.PostMapper;
import com.dmu.hrms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/12/21 10:40
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;
    @Override
    public int insert(Post post) {
        return postMapper.insert(post);
    }

    @Override
    public List<Post> selectAll() {
        return postMapper.selectAll();
    }
}