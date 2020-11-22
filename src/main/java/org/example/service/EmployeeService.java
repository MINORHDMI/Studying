package org.example.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Employee;
import org.example.mapper.EmployeeMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EmployeeService {
    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = mapper.findAll();
        System.out.println(employeeList);

        Employee employee = mapper.findById(1);
        System.out.println(employee);

    }

    public void insertEmployee() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpId(10000004);
        employee.setEmpName("周七");
        employee.setStatus("在职");
        employeeMapper.insertEmployee(employee);

        // 查询
        List<Employee> EmployeeList = employeeMapper.findAll();
        for (Employee employeeList : EmployeeList) {
            System.out.println(employeeList);
        }
        sqlSession.close();
    }

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
