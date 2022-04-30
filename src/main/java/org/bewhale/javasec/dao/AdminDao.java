package org.bewhale.javasec.dao;

import org.apache.ibatis.annotations.Mapper;
import org.bewhale.javasec.model.Admin;

@Mapper
public interface AdminDao {
    Admin login(String username, String password);
}
