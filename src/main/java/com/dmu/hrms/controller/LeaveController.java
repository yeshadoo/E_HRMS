package com.dmu.hrms.controller;

import com.dmu.hrms.entity.Leave;
import com.dmu.hrms.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author : hadoo
 * @Date : 2020/12/22 10:49
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @PostMapping("/addLeave")
    @ResponseBody
    public Boolean insertOne(Leave leave){
        System.out.println(leave.toString());
        leaveService.insert(leave);
        return true;
    }

    @RequestMapping("/listAll")
    public String listLeave(Model model){
        List<Leave> leaves = leaveService.selectAll();
        model.addAttribute("leaves",leaves);
        return "leaveList";
    }

    @RequestMapping("/listByStatus/{status}")
    public String listByStatus(Model model, @PathVariable String status){
        List<Leave> leaves = leaveService.selectByStatus(status);
        model.addAttribute("leaves",leaves);
        return "leaveList";
    }

    @RequestMapping("/updateStatus/{id}/{status}")
    public String updateInfo(@PathVariable("id") Integer id,@PathVariable("status") String status){
        leaveService.updateStatus(id,status);
        return "leaveList";
    }
}