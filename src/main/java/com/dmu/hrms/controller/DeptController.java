package com.dmu.hrms.controller;

import com.dmu.hrms.entity.Dept;
import com.dmu.hrms.entity.Post;
import com.dmu.hrms.service.DeptService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : hadoo
 * @Date : 2020/12/21 9:06
 */
@Controller
@RequestMapping("dept")
public class DeptController {
    @Autowired
    DeptService deptService;

//    @RequestMapping("list")
//    public String list(Model model){
//        List<Dept> depts = deptService.selectAll();
//        model.addAttribute("depts",depts);
//        return "staffAdd";
//    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> getDepts(){

        Map<String, Object> map = new HashMap<>();
        try {
            JSONArray jsonArray=new JSONArray();
            List<Dept> depts = deptService.selectAll();
            if(null!=depts&&depts.size()>0) {
                for(int i=0;i<depts.size();i++) {
                    JSONObject jsonObject=new JSONObject();
                    Dept dept=depts.get(i);
                    jsonObject.put("id", dept.getId());
                    jsonObject.put("dname", dept.getDname());

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
        List<Dept> depts = deptService.selectAll();
        model.addAttribute("depts",depts);
        return "deptList";
    }
}