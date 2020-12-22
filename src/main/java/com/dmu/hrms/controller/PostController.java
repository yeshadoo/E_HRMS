package com.dmu.hrms.controller;

import com.dmu.hrms.entity.Dept;
import com.dmu.hrms.entity.Post;
import com.dmu.hrms.service.PostService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : hadoo
 * @Date : 2020/12/21 10:39
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> getPosts(HttpServletRequest request){

        Map<String, Object> map = new HashMap<>();
        try {
            JSONArray jsonArray=new JSONArray();
            List<Post> posts = postService.selectAll();
            if(null!=posts&&posts.size()>0) {
                for(int i=0;i<posts.size();i++) {
                    JSONObject jsonObject=new JSONObject();
                    Post post = posts.get(i);
                    jsonObject.put("id", post.getId());
                    jsonObject.put("pname", post.getPname());

                    jsonArray.put(jsonObject);
                }
            }
            map.put("success",true);
            map.put("msg","操作成功");
            map.put("data",jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","操作失败!");
        }

        return map;
    }

    @RequestMapping("/listAll")
    public String listAll(Model model){
        List<Post> posts = postService.selectAll();
        model.addAttribute("posts",posts);
        return "postList";
    }
}