package org.bewhale.javasec.dao;

import org.apache.ibatis.annotations.Mapper;
import org.bewhale.javasec.model.Admin;

import java.util.ArrayList;

@Mapper
public interface AdminDao {
    Admin login(String username, String password);

    ArrayList<Admin> getAllInfo();

    Admin getInfoByUserName(String username);

    int updatePWD(String username, String newPWD);
}
