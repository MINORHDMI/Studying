package org.example.mapper;

import org.example.entity.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeMapper {
    public List<Employee> findAll() throws IOException;

    public Employee findById(int empId);

    public void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(int i);
}
