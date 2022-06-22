package org.bewhale.javasec.service.impl;


import org.bewhale.javasec.dao.InjectDao;
import org.bewhale.javasec.model.Admin;
import org.bewhale.javasec.service.InjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InjectServiceImpl implements InjectService {
    final InjectDao injectDao;

    public InjectServiceImpl(InjectDao injectDao) {
        this.injectDao = injectDao;
    }

    @Override
    public ArrayList<Admin> orderBy(String username) {
        return injectDao.orderBy(username);
    }

    @Override
    public Admin likeSearch(String username) {
        return injectDao.likeSearch(username);
    }

    @Override
//    public ArrayList<Admin> in(List<String> ids) {
    public ArrayList<Admin> in(String ids) {
        return injectDao.in(ids);
    }
}
