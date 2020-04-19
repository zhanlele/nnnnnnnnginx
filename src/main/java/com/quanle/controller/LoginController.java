package com.quanle.controller;

import com.quanle.dto.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author quanle
 * @date 2020/3/24 12:51 AM
 */
@Controller
@RequestMapping("login")
public class LoginController {

    /**
     * 跳转登录页
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String login() {
        return "login";
    }

    /**
     * 执行登录
     *
     * @param userName 用户名
     * @param passWord 密码
     * @param request
     * @return
     */
    @RequestMapping("/signIn")
    @ResponseBody
    public Result<Object> login(String userName, String passWord, HttpServletRequest request) {
        HttpSession session = request.getSession();


        if (!"admin".equals(userName)) {
            return Result.fail("该用户不存在");
        }
        if (!"admin".equals(passWord)) {
            return Result.fail("用户密码不正确");
        }
        session.setAttribute("username", userName + System.currentTimeMillis());
        return Result.success();
    }


    @RequestMapping("loginSystem")
    public String loginSystem(String username, String password, HttpSession session) {
        // 合法用户，信息写入session，同时跳转到系统主页面
        if("admin".equals(username) && "admin".equals(password)) {
            System.out.println("合法用户");
            session.setAttribute("username",username + System.currentTimeMillis());
            return "redirect:/resume/index";
        }else{
            // 非法用户返回登录页面
            System.out.println("非法，跳转");
            return "redirect:/login/toLogin";
        }
    }
    @RequestMapping("/result")
    public String result(){
        return "result";
    }
}
