package com.dmu.hrms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dmu.hrms.entity.Post;
import com.dmu.hrms.entity.Staff;
import com.dmu.hrms.service.StaffService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : hadoo
 * @Date : 2020/12/20 20:50
 */
@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService staffService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Staff> staffs = staffService.selectAll();
        model.addAttribute("staffList",staffs);
        return "staffList";
    }

    @RequestMapping("/goAddStaff")
    public String goAddStaff(){
        return "staffAdd";
    }

    @PostMapping("/addStaff")
    @ResponseBody
    public Boolean addStaff(Staff staff){
        staffService.insert(staff);
        return true;
    }

    @RequestMapping("/listByDept/{id}")
    public String listByDept(@PathVariable Integer id,Model model){
        List<Staff> staffs = staffService.selectByDept(id);
        model.addAttribute("staffList",staffs);
        return "staffList";
    }

    @RequestMapping("/listByPost/{id}")
    public String listByPost(@PathVariable Integer id,Model model){
        List<Staff> staffs = staffService.selectByPost(id);
        model.addAttribute("staffList",staffs);
        return "staffList";
    }

    @RequestMapping("/listByStatus/{status}")
    public String listByStatus(@PathVariable String status,Model model){
        List<Staff> staffs = staffService.selectByStatus(status);
        model.addAttribute("staffList",staffs);
        return "entryList";

    }
    @RequestMapping("/updateStatus/{id}/{status}")
    public String updateInfo(@PathVariable("id") Integer id,@PathVariable("status") String status) throws UnsupportedEncodingException {
        staffService.updateStatus(id,status);
        return "entryList";
    }

    @RequestMapping("/goLeave")
    public String goLeave(){
        return "leaveAdd";
    }

    @RequestMapping("/selectBySname/{sname}")
    @ResponseBody
    public Map<String, Object> selectBySname(@PathVariable String sname){
        Map<String, Object> map = new HashMap<>();
        try {
            JSONArray jsonArray=new JSONArray();
            Staff staff = staffService.selectBySname(sname);
            System.out.println(staff);
            if(null!=staff) {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("staff_id", staff.getId());
                jsonArray.add(jsonObject);
            }
            System.out.println(jsonArray.toString());
            map.put("success",true);
            map.put("msg","操作成功");
            map.put("data",jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","操作失败!");
        }

        return map;

    }
}