package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     */
    public List<Brand> selectAll();

}