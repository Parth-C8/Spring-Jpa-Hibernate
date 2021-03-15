package com.example.SpringJPATwo.entity;

import com.example.SpringJPATwo.repository.EmployeeComponentMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCMDaoService {

    @Autowired
    EmployeeComponentMappingRepository employeeComponentMappingRepository;

    public void createEmpCM()
    {
        EmployeeComponentMapping emp  = new EmployeeComponentMapping();
        emp.setId(301);
        emp.setFirstName("Raj");
        emp.setLastName("Verma");
        emp.setAge(27);
        SalaryComponentMapping sal = new SalaryComponentMapping();
        sal.setBasicSalary(25000);
        sal.setBonusSalary(5000);
        sal.setTaxAmount(2100);
        sal.setSpecialAllowanceSalary(5000);
        emp.setSalaryComponentMapping(sal);
        employeeComponentMappingRepository.save(emp);
    }
}
