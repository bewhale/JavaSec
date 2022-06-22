package org.bewhale.javasec.dao;

import org.apache.ibatis.annotations.Mapper;
import org.bewhale.javasec.model.Xss;

import java.util.List;

@Mapper
public interface XssDao {
    List<String> getContent();

    void setContent(Xss xss);

    void clear();
}
