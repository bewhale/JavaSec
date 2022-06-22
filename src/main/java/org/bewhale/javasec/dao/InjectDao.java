package org.bewhale.javasec.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.bewhale.javasec.model.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface InjectDao {

    @Select("select * from users order by ${field}")
    ArrayList<Admin> orderBy(@Param("field") String field);


    // @Select("Select * from users where username like '%#{username}%'")
    // 使用# 报错
    // 正确安全写法
    // @Select("Select * from users where username like concat('%',#{username}, '%')")
    @Select("Select * from users where username like '%${username}%'")
    Admin likeSearch(@Param("username") String username);



    //  正确安全写法
    //  @Select("<script>" + "SELECT * FROM users WHERE id IN " + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>" + "#{item}" + "</foreach>" + "</script>")
    //  ArrayList<Admin> in(@Param("ids") List<String> ids);
    @Select("Select * from users where id in (${ids})")
    ArrayList<Admin> in(@Param("ids") String ids);
}
