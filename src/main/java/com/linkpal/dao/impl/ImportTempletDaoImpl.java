package com.linkpal.dao.impl;

import com.linkpal.dao.IImportTempletDao;
import com.linkpal.map.IImportTempletMapper;
import com.linkpal.model.ImportTemplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("iImportTempletDao")
public class ImportTempletDaoImpl implements IImportTempletDao {

    @Autowired
    private IImportTempletMapper importTempletMapper;

    @Override
    public List<ImportTemplet> getColumnInfo(String basic_name) {
        return importTempletMapper.getColumnInfo(basic_name);
    }
}
