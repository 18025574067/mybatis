package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    /**
     * 查看所有信息
     *
     * @throws IOException
     */
    @Test
    public void testSelectAll() throws IOException {
        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * 查询某个id的全部信息
     *
     * @throws IOException
     */
    @Test
    public void testSelectById() throws IOException {
        // 接收参数
        int id = 1;
        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * 多条件查询
     *
     * @throws IOException
     */
    @Test
    public void testSelectByCondition() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封装对象
/*        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/

        Map map = new HashMap();
//        map.put("status", status);
        map.put("companyName", companyName);
//        map.put("brandName", brandName);

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        // List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        // List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * 单条件查询
     *
     * @throws IOException
     */
    @Test
    public void testSelectByConditionSingle() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封装对象
        Brand brand = new Brand();
//        brand.setStatus(status);
//         brand.setCompanyName(companyName);
//         brand.setBrandName(brandName);

/*        Map map = new HashMap();
//        map.put("status", status);
        map.put("companyName", companyName);
//        map.put("brandName", brandName);*/

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        // List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        // List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        // 5. 释放资源
        sqlSession.close();
    }


    /**
     * 新增信息
     *
     * @throws IOException
     */
    @Test
    public void testAdd() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "波导444";
        String brandName = "波导手机333";
        int ordered = 100;
        String description = "手机中的战斗机";

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.add(brand);

        // 事务提交
//        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }


    @Test
    public void testAdd2() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "波导111";
        String brandName = "波导手机222";
        int ordered = 100;
        String description = "手机中的战斗机";

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        // 事务提交
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * 修改: 分全部修改和动态修改.
     *
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "波导888";
        String brandName = "波导手机222888";
        int ordered = 500;
        String description = "波导手机, 手机中的战斗机";
        int id = 5;

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);

        // 事务提交
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }


    @Test
    public void testDelete() throws IOException {
        // 接收参数
        int id = 12;

        // 1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.deleteById(id);

        // 事务提交
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }
}
