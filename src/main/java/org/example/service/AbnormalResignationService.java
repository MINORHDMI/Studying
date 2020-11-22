package org.example.service;

/*
 * @Author: ZHOUPENG
 * @Date: 2020.11.22 12:35
 */


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.AbnormalResignation;
import org.example.mapper.AbnormalResignationMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AbnormalResignationService {
    public static void insertAbnormalResignation(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        AbnormalResignationMapper abnormalResignationMapper = sqlSession.getMapper(AbnormalResignationMapper.class);


        // 模拟数据
        AbnormalResignation abnormalResignation = new AbnormalResignation();
        abnormalResignation.setEmpId(10000004);
        abnormalResignation.setResignData(new Date());
        abnormalResignation.setReason("离职");
        abnormalResignation.setCreateBy(10000000);
        abnormalResignation.setCreateTime(new Date());

        // 插入数据
        abnormalResignationMapper.insertAbnormalResignation(abnormalResignation);
        // 查询
        List<AbnormalResignation> ResignationList = abnormalResignationMapper.findAll();
        for (AbnormalResignation resignation : ResignationList) {
            System.out.println(resignation);
        }

    }
    public static void deleteAbnormalResignation(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        AbnormalResignationMapper abnormalResignationMapper = sqlSession.getMapper(AbnormalResignationMapper.class);
        abnormalResignationMapper.deleteAbnormalResignation(9);

        sqlSession.close();
    }

    public void updateAbnormalResignation() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        AbnormalResignationMapper abnormalResignationMapper = sqlSession.getMapper(AbnormalResignationMapper.class);
        // 模拟数据
        AbnormalResignation abnormalResignation = new AbnormalResignation();
        abnormalResignation.setId(2);
        abnormalResignation.setEmpId(10000003);
        abnormalResignation.setResignData(new Date());
        abnormalResignation.setReason("离职");
        abnormalResignation.setCreateBy(10000000);
        abnormalResignation.setCreateTime(new Date());

        abnormalResignationMapper.updateAbnormalResignation(abnormalResignation);


        sqlSession.close();
    }

}
