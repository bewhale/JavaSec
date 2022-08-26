package org.bewhale.javasec.service.impl;

import org.bewhale.javasec.dao.AdminDao;
import org.bewhale.javasec.model.Admin;
import org.bewhale.javasec.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService {
    final
    AdminDao adminDao;

    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username, password);
    }

    @Override
    public int updatePWD(String username, String newPWD) {
       return adminDao.updatePWD(username, newPWD);
    }

    @Override
    public Admin getInfoByUserName(String username) {
        return this.adminDao.getInfoByUserName(username);
    }

    @Override
    public ArrayList<Admin> getAllInfo() {
        return this.adminDao.getAllInfo();
    }
}
