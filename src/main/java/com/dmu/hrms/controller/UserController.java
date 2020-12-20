package com.dmu.hrms.controller;

import com.dmu.hrms.entity.User;
import com.dmu.hrms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Collection;

/**
 * @Author : hadoo
 * @Date : 2020/12/20 18:42
 */
@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("username", principal.getName());

        //从SecurityContextHolder中得到Authentication对象，进而获取权限列表，传到前端
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<GrantedAuthority> authorityCollection = (Collection<GrantedAuthority>) auth.getAuthorities();
        model.addAttribute("authorities", authorityCollection.toString());
        return "user/user";
    }

    @RequestMapping("/admin")
    public String admin(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("username", principal.getName());

        //从SecurityContextHolder中得到Authentication对象，进而获取权限列表，传到前端
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<GrantedAuthority> authorityCollection = (Collection<GrantedAuthority>) auth.getAuthorities();
        model.addAttribute("authorities", authorityCollection.toString());
        return "admin/admin";
    }

    @RequestMapping("/goregister")
    public String register() {
        return "register";
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public boolean register(User user) {
        //新注册用户默认权限为user
        user.setRole("user");

        //对密码进行加密存储
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        log.info(user.getPassword());
        userService.addUser(user);
        return true;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}