package com.dmu.hrms.controller;

import com.dmu.hrms.entity.Staff;
import com.dmu.hrms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
        System.out.println(staff.toString());
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
    @RequestMapping("/update/{id}/{status}")
    public String updateInfo(@PathVariable Integer id,@PathVariable String status) throws UnsupportedEncodingException {
        String decodeStatus = URLDecoder.decode(status, "UTF-8");
        staffService.updateStatus(id,decodeStatus);
        return "entryList";
    }
}