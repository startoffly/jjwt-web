package com.xinmove.jjwtweb.controller;

import static java.util.Objects.nonNull;

import com.alibaba.fastjson.JSONObject;
import com.xinmove.jjwtweb.JJWT;
import com.xinmove.jjwtweb.constant.Constants;
import com.xinmove.jjwtweb.pojo.ReturnBody;
import com.xinmove.jjwtweb.pojo.vo.UserVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Descripption 用户测试
 * @Author chenweitao
 * @Date 2019/1/24 17:46
 **/
@CrossOrigin(origins ="*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    /**
     * @Description 检查token
     * @param token
     * @Return
     * @Author cwt
     * @Date 2019/1/28 10:11
     */
    @GetMapping("getTest")
    public ReturnBody getTest(@RequestParam String token, HttpServletRequest request, HttpServletResponse response){

        Map<String,Object> data = new HashMap<>();
        String message = "";
        JJWT util = new JJWT();
        try {
            Claims claims = util.parseJWT(token);
            data.put("claims",claims.getSubject());
            UserVo userVo = JSONObject.parseObject(claims.getSubject(),UserVo.class);
            message = "有效token";
        } catch (ExpiredJwtException e) {
            message = "超时token";
            e.printStackTrace();
        } catch (Exception e) {
            message = "无效token";
            e.printStackTrace();
        }
        data.put("token",token);
        return ReturnBody.success(data,message);
    }

    /**
     * @Description 检查token
     * @Return
     * @Author cwt
     * @Date 2019/1/28 10:11
     */
    @GetMapping("getHeadTest")
    public ReturnBody getHeadTest(HttpServletRequest request, HttpServletResponse response){

        String token = request.getHeader(Constants.HEADER_TOKEN);
        Map<String,Object> data = new HashMap<>();
        String message = "";
        if (nonNull(token)){
            JJWT util = new JJWT();
            try {
                Claims claims = util.parseJWT(token);
                data.put("claims",claims.getSubject());
                UserVo userVo = JSONObject.parseObject(claims.getSubject(),UserVo.class);
                message = "有效token";
            } catch (ExpiredJwtException e) {
                message = "超时token";
                e.printStackTrace();
            } catch (Exception e) {
                message = "无效token";
                e.printStackTrace();
            }
        }else{
            message = "参数为空";
        }
        data.put("token",token);
        return ReturnBody.success(data,message);
    }

    /**
     * @Description 模拟登录，实际需用post传递账号密码
     * @Return
     * @Author cwt
     * @Date 2019/1/28 10:10
     */
    @GetMapping("login")
    public ReturnBody login(){

        UserVo userVo = new UserVo("name","password","type");

        Map<String,Object> data = new HashMap<>();
        JJWT util = new JJWT();
        try {
            data.put("token",util.createJWT("testId","xinmove",JSONObject.toJSONString(userVo),60000));
        } catch (Exception e) {
            data.put("token","无效token");
            e.printStackTrace();
        }
        return ReturnBody.success(data);
    }

    /**
     * @Description 模拟登录，实际需用post传递账号密码
     * @Return
     * @Author cwt
     * @Date 2019/1/28 10:10
     */
    @PostMapping("loginPost")
    public ReturnBody loginPost(@RequestBody UserVo userVo,HttpServletRequest request, HttpServletResponse response){

        Map<String,Object> data = new HashMap<>();
        JJWT util = new JJWT();
        try {
            data.put("token",util.createJWT("testId","xinmove",JSONObject.toJSONString(userVo),60000));
        } catch (Exception e) {
            data.put("token","无效token");
            e.printStackTrace();
        }
        return ReturnBody.success(data);
    }

}
