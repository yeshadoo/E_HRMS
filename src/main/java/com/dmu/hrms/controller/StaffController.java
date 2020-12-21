package com.dmu.hrms.controller;

import com.dmu.hrms.entity.Staff;
import com.dmu.hrms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}