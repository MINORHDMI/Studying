package org.example;

/*
 * @Author: ZHOUPENG
 * @Date: 2020.11.22 14:45
 */


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.AbnormalResignation;
import org.example.mapper.AbnormalResignationMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class TestAbnormalResignationService {

    @Test
    public void updateAbnormalResignation() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        AbnormalResignationMapper abnormalResignationMapper = sqlSession.getMapper(AbnormalResignationMapper.class);
        // 模拟数据
        AbnormalResignation abnormalResignation = new AbnormalResignation();
        abnormalResignation.setId(3);
        abnormalResignation.setEmpId(10000003);
        abnormalResignation.setResignData(new Date());
        abnormalResignation.setReason("离职");
        abnormalResignation.setCreateBy(10000000);
        abnormalResignation.setCreateTime(new Date());
        abnormalResignation.setUpdateBy(10000001);
        abnormalResignation.setUpdateTime(new Date());


        abnormalResignationMapper.updateAbnormalResignation(abnormalResignation);


        sqlSession.close();
    }

    @Test
    public void findAll() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        AbnormalResignationMapper abnormalResignationMapper = sqlSession.getMapper(AbnormalResignationMapper.class);
        // 查询
        List<AbnormalResignation> ResignationList = abnormalResignationMapper.findAll();
        for (AbnormalResignation resignation : ResignationList) {
            System.out.println(resignation);
        }
        sqlSession.close();
    }


    @Test
    public void insertAbnormalResignation() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        AbnormalResignationMapper abnormalResignationMapper = sqlSession.getMapper(AbnormalResignationMapper.class);
        // List<AbnormalResignation> resignationList = mapper.findAll();
        // System.out.println(resignationList);

        AbnormalResignation abnormalResignation = new AbnormalResignation();
        abnormalResignation.setEmpId(10000002);
        abnormalResignation.setResignData(new Date());
        abnormalResignation.setReason("离职");
        abnormalResignation.setCreateBy(10000000);
        abnormalResignation.setCreateTime(new Date());


        abnormalResignationMapper.insertAbnormalResignation(abnormalResignation);
        // 查询
        List<AbnormalResignation> ResignationList = abnormalResignationMapper.findAll();
        for (AbnormalResignation resignation : ResignationList) {
            System.out.println(resignation);
        }
        sqlSession.close();
    }

    @Test
    public void deletetAbnormalResignation() throws IOException {
        final InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        AbnormalResignationMapper abnormalResignationMapper = sqlSession.getMapper(AbnormalResignationMapper.class);

        // 删除数据
        abnormalResignationMapper.deleteAbnormalResignation(10);

        // 查询
        List<AbnormalResignation> ResignationList = abnormalResignationMapper.findAll();
        for (AbnormalResignation resignation : ResignationList) {
            System.out.println(resignation);
        }

        sqlSession.close();

    }





}