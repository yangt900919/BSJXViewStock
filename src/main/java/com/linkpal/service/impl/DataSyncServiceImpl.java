package com.linkpal.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.linkpal.dao.IDataSyncDao;
import com.linkpal.service.IDataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataSyncServiceImpl implements IDataSyncService {

    @Qualifier("DataSyncDaoImpl")
    @Autowired
    IDataSyncDao dataDao;

    @Override
    public List<Map<String,Object>> Send(Map map) {
        String billtype=map.get("billtype").toString();
        List<Map<String,Object>> heads=dataDao.getHeadData(map);
        for(int i=0;i<heads.size();i++)
        {
            Map head=heads.get(i);
            Map param=new HashMap();
            param.put("billtype", billtype);
            param.put("fid", head.get("fid").toString());
            List<Map<String,Object>> entrys=dataDao.getEntryData(param);
            head.put("entry", entrys);
            heads.remove(i);
            heads.add(i, head);
        }
        return heads;
    }

    @Override
    public List<Map<String,Object>> Receive(Map map) {
        List<Map<String,Object>> list=new ArrayList<>();
        try{
            if(map.get("entry")!=null)
            {
                JSONArray array= JSON.parseArray(map.get("entry").toString());
                map.remove("entry");
                for(int i=0;i<array.size();i++)
                {
                    Map m= JSON.parseObject(array.get(i).toString(),Map.class);
                    map.putAll(m);
                    list=dataDao.dataSave(map);
                }
            }
            else
            list=dataDao.dataSave(map);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
