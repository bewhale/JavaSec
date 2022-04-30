package org.bewhale.javasec.service.impl;

import org.bewhale.javasec.dao.AdminDao;
import org.bewhale.javasec.model.Admin;
import org.bewhale.javasec.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminDao.login(username, password);
        return admin;
    }
}
