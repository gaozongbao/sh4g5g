package com.c.controller;

import com.c.model.SysUser;
import com.c.service.FourFiveGService;
import com.c.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin(origins = "*")
public class FiveFourgController {
    @Autowired
    private FourFiveGService fourFiveGService;
    @RequestMapping("/lte/initData")
    @ResponseBody
    public ResponseEntity getTest(String gridid,String datatype) {
        if("mro".equals(datatype)){
            return  ResponseEntity.successResponse(fourFiveGService.initMroData(gridid), "success");
        }else{
            return ResponseEntity.successResponse(fourFiveGService.initSaoPinData(gridid), "success");
        }
    }
    @RequestMapping("/lte/getAllSanGe")
    @ResponseBody
    public ResponseEntity getAllSanGe(){

        return  ResponseEntity.successResponse(fourFiveGService.getAllSanGe(), "success");
    }
}
