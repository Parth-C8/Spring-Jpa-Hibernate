package com.example.SpringJPAOne.entities;

import com.example.SpringJPAOne.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDaoService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee, int id) {
        if (employeeRepository.existsById(id)) {
           Employee emp =  employeeRepository.findById(id).get();
           emp.setName(employee.getName());
           emp.setAge(employee.getAge());
           emp.setLocation(employee.getLocation());
            employeeRepository.save(emp);
            return emp;
        }
        return null;
    }

    public void deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }
    public List<Employee> readEmployeeRecords() {
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        return employeeList;

    }
    public int countEmployee()
    {
        return (int) employeeRepository.count();
    }

    public List<Employee> findEmpByName(String name)
    {
        List<Employee> employees =  employeeRepository.findByName(name);
        return employees;
    }
    public List<Employee> findEmpByNameLike()
    {
        List<Employee> employees = employeeRepository.findByNameLike("A%");
        return employees;
    }

    public List<Employee> findEmpWithinAgeRange()
    {
        List<Employee> employees = employeeRepository.findByAgeBetween(28,32);
        return employees;
    }

    public List<Employee> findAllEmpByPagingAndSorting(int pageNumber, int pageSize)
    {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC,"age");
        Page<Employee> employeePage =  employeeRepository.findAll(pageable);
        List<Employee> employees = employeePage.getContent();
        return employees;
    }
}
