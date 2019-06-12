package com.c.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.c.model.GlobalConfig;
import com.c.model.SysUser;

import com.c.service.UserService;
import com.c.syslog.SysLog;
import com.c.util.CustomerContextHolder;
import com.c.util.ResponseEntity;
import com.c.util.ResponseReturnUtils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * 测试Controller
 *
 * @author: 高宗宝
 * @Description:无
 */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "/test")
public class TestController {

    
    @Autowired
    private UserService userService;
    @Autowired
    private GlobalConfig globalConfig;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * 测试
     *
     * @author 高宗宝
     */
    @SysLog("测试查询用户")
    @RequestMapping(value = "/get", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResponseEntity getTest(@RequestParam(value = "id", required = true) int id, HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        System.out.println("start test");
        SysUser user = userService.getSysUser(id);
        System.out.println(user);
        System.out.println(globalConfig);
        return ResponseEntity.successResponse(user, "success");
    }


    /**
     * 测试
     *
     * @author 高宗宝
     */
    @ResponseBody
    @RequestMapping(value = "/testcode", method = {RequestMethod.POST, RequestMethod.GET})
    public void testentitycode(@RequestParam(value = "name", required = true) String name,
                               HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        System.out.println("start test");
        //切换到pg数据库
        if ("a".equals(name)) {
            HashMap<String, Object> result = new HashMap<String, Object>();
            result.put("name", name);
            result.put("value", null);
            ResponseReturnUtils.returnReponseEntity(request, response, ResponseEntity.successResponse(result, "成功"));
        } else {
        	ResponseReturnUtils.returnReponseEntity(request, response, ResponseEntity.failResponse("错误"));
        }
    }
}


