package com.c.service.impl;

import com.c.dao.GcDao;
import com.c.service.FourFiveGService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            for (String gridid :grids){
                //获取4g 工参（带覆盖率）
                fourg.addAll(gcDao.getGcInfo("fourg_gc","fourg_saopin_mastercell_cover","fourg_saopin_addr_mastercell", gridid));
                //获取4g 扫频（带覆带小区）
                fourg.addAll(gcDao.getSaoPinInfo("fourg_saopin_addr_mastercell", Integer.parseInt(gridid)));


                //获取5g 工参和5g扫频
                fiveg.addAll(gcDao.getGcInfo("fiveg_gc","fiveg_saopin_mastercell_cover" ,"fiveg_saopin_addr_mastercell",gridid));
                fiveg.addAll(gcDao.getSaoPinInfo("fiveg_saopin_addr_mastercell", Integer.parseInt(gridid)));


            }
        }else{
            fourg.addAll(gcDao.getGcInfo("fourg_gc","fourg_saopin_mastercell_cover","fourg_saopin_addr_mastercell", null));
            fourg.addAll(gcDao.getSaoPinInfo("fourg_saopin_addr_mastercell", null));
            fiveg.addAll(gcDao.getGcInfo("fiveg_gc","fiveg_saopin_mastercell_cover" ,"fiveg_saopin_addr_mastercell",null));
            fiveg.addAll(gcDao.getSaoPinInfo("fiveg_saopin_addr_mastercell",null));

        }
        res.put("fourG",fourg);
        res.put("fiveG",fiveg);
        return res;
    }

    @Override
    public List<Map<String, Object>> getAllSanGe() {
        return gcDao.getAllSanGe();
    }
}
