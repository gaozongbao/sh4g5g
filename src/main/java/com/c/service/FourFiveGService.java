package com.c.service;

import java.util.List;
import java.util.Map;

public interface FourFiveGService {

    public Map<String,Object> initSaoPinData(String gridid);
    public Map<String,Object> initMroData(String gridid);
    public List<Map<String,Object>> getAllSanGe();
}
