package com.example.SpringJPAOne.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    EmployeeDaoService employeeDaoService;

    //List all the employees present in database
    @GetMapping(path = "/employee")
    public List<Employee> reteriveAllEmployee() {
        return employeeDaoService.readEmployeeRecords();
    }


    //Creates a new employee
    @PostMapping(path = "/employee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        Employee employee1 = employeeDaoService.createEmployee(employee);
        return employee1;
    }

    //Updates an employee
    @PutMapping(path = "/employee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id)
    {
        Employee employee1 = employeeDaoService.updateEmployee(employee,id);
        return employee1;
    }

    //Delete an employee
    @DeleteMapping(path = "/employee/{id}")
    public void deleteEmployee(@PathVariable int id) {
         employeeDaoService.deleteEmployee(id);
    }

    //Counts the total no of employees in database
    @GetMapping(path = "/employee/count")
    public int countAllEmployee() {
        int count = employeeDaoService.countEmployee();
        return count;
    }

    //Finds an employee based on the name
    @GetMapping(path = "/employee/{name}")
    public List<Employee> findEmployeeByName(@PathVariable String name) {
        List<Employee> emp1 = employeeDaoService.findEmpByName(name);
        return emp1;
    }

    //Finds an employee based on the name starting with A
    @GetMapping(path = "/employee/likeA")
    public List<Employee> findEmployeeByNameLike() {
        List<Employee> emp1 = employeeDaoService.findEmpByNameLike();
        return emp1;
    }

    //Finds an employee based on the age between 28 and 32
    @GetMapping(path = "/employee/age")
    public List<Employee> findEmployeeWithinAgeRange() {
        List<Employee> emp1 = employeeDaoService.findEmpWithinAgeRange();
        return emp1;
    }

    //Shows the results in a specific page size in sorted order of age
    @GetMapping(path = "/employee/paging")
    public List<Employee> findAllEmployeeByPagingAndSorting(@RequestParam int no, @RequestParam int size) {
        List<Employee> emp1 = employeeDaoService.findAllEmpByPagingAndSorting(no,size);
        return emp1;
    }
}
