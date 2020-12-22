package com.dmu.hrms.controller;

import com.dmu.hrms.entity.Leave;
import com.dmu.hrms.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}