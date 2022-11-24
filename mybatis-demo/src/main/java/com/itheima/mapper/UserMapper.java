package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    /**
     * MyBatis 参数封装
         * 单个参数
             * 1. POJO类型:
             * 2. Map集合:
             * 3. Collection:
             * 4. List
             * 5. Array
             * 6. 其他类型
         * 多个参数


     */
    User select(@Param("username") String username, @Param("password") String password);

}