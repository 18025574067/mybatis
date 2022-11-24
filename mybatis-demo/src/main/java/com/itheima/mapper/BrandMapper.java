package com.itheima.mapper;

import com.itheima.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /**
     * 查询所有
     */
    List<Brand> selectAll();

    /**
     * 查看详情
     */
    Brand selectById(int id);

    /**
     * 条件查询
     * * 参数接收
     * 1. 散装参数: 如果方法中有多个参数, 需要使用@Parm("SQL参数占位符")
     * 2. 对象参数
     * 3. map集合参数
     */
    // List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    // List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     *
     * @param brand
     * @return
     */
    int update(Brand brand);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteById(int id);
}