package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

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
     *      1. 散装参数: 如果方法中有多个参数, 需要使用@Parm("SQL参数占位符")
     *      2. 对象参数
     *      3. map集合参数
     *
     *
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    /** List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);*/
}