package com.xinmove.jjwtweb.controller;

import com.xinmove.jjwtweb.pojo.ReturnBody;
import com.xinmove.jjwtweb.pojo.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UserController
 * @Descripption TODO
 * @Author chenweitao
 * @Date 2019/1/24 17:46
 **/
@RestController
@RequestMapping("/api/user")
public class UserController<Rlogin> {

    @GetMapping("test")
    public ReturnBody getTest(HttpServletRequest request, HttpServletResponse response){

        return ReturnBody.success("成功的数据");
    }

    @PostMapping("login")
    public ReturnBody login(@RequestBody UserVo userVo){


        return ReturnBody.fail("失败");
    }


}
