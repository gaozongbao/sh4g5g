package com.c.service.impl;

import com.c.dao.GcDao;
import com.c.service.FourFiveGService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class FourFiveGServiceImpl implements FourFiveGService {
    @Autowired
    private GcDao gcDao;

    @Override
    public Map<String, Object> initSaoPinData(String grididStr) {
        Map<String,Object> res = new HashMap<>();
        List<Map<String, Object>> fourg =new ArrayList<>();
        List<Map<String, Object>> fiveg =new ArrayList<>();
        if(StringUtils.isNotBlank(grididStr)){
            String[] grids = grididStr.split(",");
            //获取4g 扫频（带覆带小区）
            fourg.addAll(gcDao.getSaoPinInfo("fourg_saopin_addr_mastercell", Arrays.asList(grids)));
            //获取4g 工参（带覆盖率）
            fourg.addAll(gcDao.getGcInfo("4g", Arrays.asList(grids)));


            //获取5g 工参和5g扫频
            fiveg.addAll(gcDao.getSaoPinInfo("fiveg_saopin_addr_mastercell", Arrays.asList(grids)));
            fiveg.addAll(gcDao.getGcInfo("5g",Arrays.asList(grids)));

        }else{
            fourg.addAll(gcDao.getSaoPinInfo("fourg_saopin_addr_mastercell", null));
            fiveg.addAll(gcDao.getSaoPinInfo("fiveg_saopin_addr_mastercell",null));

            fourg.addAll(gcDao.getGcInfo("4g",  null));
            fiveg.addAll(gcDao.getGcInfo("5g",null));

        }
        res.put("fourG",fourg);
        res.put("fiveG",fiveg);
        return res;
    }

    @Override
    public Map<String, Object> initMroData(String grididStr) {
        Map<String,Object> res = new HashMap<>();
        if(StringUtils.isNotBlank(grididStr)){
            String[] grids = grididStr.split(",");
            res.put("fourG",gcDao.getMroInfo("4g",Arrays.asList(grids)));
            res.put("fiveG", gcDao.getMroInfo("5g",Arrays.asList(grids)));
        }else{
            res.put("fourG",gcDao.getMroInfo("4g",null));
            res.put("fiveG",gcDao.getMroInfo("5g",null));
        }
        return res;
    }

    @Override
    public List<Map<String, Object>> getAllSanGe() {
        return gcDao.getAllSanGe();
    }
}
