package com.c.service;

import java.util.List;
import java.util.Map;

public interface FourFiveGService {
    /**
     *
     * @param gridid
     * 栅格id 多个以逗号分隔
     *
     * @return
     * 以map 集合存放
     *{
     * 		data:{
     * 			fourG:[{
     * 					id:1,
     * 					"longitude":112.2,
     * 					"latitude":24.0,
     * 					"rsrp":-88.0,
     * 					cellid:"小区id",
     * 					type:"saopin"
     *                 },{
     * 					id:"小区id"
     * 					districtandcounty:"所属地市",
     * 					enodeb:"所属e-nodeb",
     * 					cellname:"小区中文名",
     * 					cgi:"cgi",
     * 					longitude:"经度",
     * 					latitude:"纬度",
     * 					cellpower:"小区功率(0.1毫瓦分贝)",
     * 					electronictiltangle:"电子下倾角",
     * 					mechanicaltiltangle:"机械下倾角",
     * 					totaldowntiltangle:"总下倾角",
     * 					azimuth:"方位角",
     * 					antennaheight:"天线挂高",
     * 					coveragetype:"室内外",
     * 					grid:"网格id",
     * 					type:"cell",
     * 					coverf100:0.80,#大于100dbm 覆盖率
     * 					coverf110:0.80,#大于110dbm 覆盖率
     * 					coverf120:0.80,#大于120dbm 覆盖率
     * 					sampleCount:20#小区对应采样点个数
     *                }],
     * 			fiveG:[和4g一样]
     * 		}
     * 	}
     *
     *
     */
    public Map<String,Object> initSaoPinData(String gridid);


    /**
     *
     * @param gridid
     * 栅格id 多个以逗号分隔
     * @return
     * 返回格式入saopindata 接口一样
     */
    public Map<String,Object> initMroData(String gridid);
    public List<Map<String,Object>> getAllSanGe();
}
