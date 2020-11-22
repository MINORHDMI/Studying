package org.example;

/*
 * @Author: ZHOUPENG
 * @Date: 2020.11.22 17:01
 */


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.AbnormalResignation;
import org.example.entity.Employee;
import org.example.mapper.AbnormalResignationMapper;
import org.example.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestEmployeeService {
    @Test
    public void testSqlConnect() throws SQLException {
        //加载类路径下的jdbc.properties
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void findAll() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        // 查询
        List<Employee> EmployeeList = employeeMapper.findAll();
        for (Employee employee : EmployeeList) {
            System.out.println(employee);
        }
        sqlSession.close();


    }

    @Test
    public void insertEmployee() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpId(10000004);
        employee.setEmpName("周七");
        employee.setStatus("1");
        employeeMapper.insertEmployee(employee);

        // 查询
        List<Employee> EmployeeList = employeeMapper.findAll();
        for (Employee employeeList : EmployeeList) {
            System.out.println(employeeList);
        }
        sqlSession.close();
    }

    @Test
    public void updateEmployee() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setId(5);
        employee.setEmpId(10000004);
        employee.setEmpName("周七");
        employee.setStatus("0");
        employeeMapper.updateEmployee(employee);

        // 查询
        List<Employee> EmployeeList = employeeMapper.findAll();
        for (Employee employeeList : EmployeeList) {
            System.out.println(employeeList);
        }
        sqlSession.close();
    }

    @Test
    public void deleteEmployee() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        employeeMapper.deleteEmployee(5);

        // 查询
        List<Employee> EmployeeList = employeeMapper.findAll();
        for (Employee employeeList : EmployeeList) {
            System.out.println(employeeList);
        }
        sqlSession.close();
    }
}
