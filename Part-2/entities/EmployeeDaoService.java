package com.example.SpringJPATwo.entity;

import com.example.SpringJPATwo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeDaoService {

    @Autowired
    EmployeeRepository employeeRepository;


    //JPQL

    //Ques1
    public void findEmployeeOrderBySalaryAndAge() {
        List<Object[]> employeeList = employeeRepository.findEmployeeOrderBySalaryAndAge();
        System.out.println("FirstName  LastName ");
        for (Object[] employee : employeeList) {
            System.out.println(employee[0] + "        " + employee[1]);
        }
    }

    //Ques2
    public void updateEmployeeSalaryLessThanAVG(int salary)
    {
        List<Integer> empId = employeeRepository.getEmployeeIDWithSalLessThanAVG();
        for(Integer id : empId)
        {
            employeeRepository.updateEmpSalary(salary,id);
        }
    }

    //Ques3

    public void deleteMinSalary()
    {
        Integer minSal = employeeRepository.minSalary();
        employeeRepository.deleteMinSalary(minSal);
    }




    //Native

    //Ques1
    public void findAllEmployeeLikeNQ() {
        List<Object[]> employeeList = employeeRepository.findAllEmployeeLikeNQ();
        System.out.println("Id    FirstName   Age ");
        for (Object[] employee : employeeList) {
            System.out.println(employee[0] + "      " + employee[1]
                    + "      " + employee[2]);
        }
    }


    //Ques2
    public void deleteByAgeNQ() {
        employeeRepository.deleteByAgeNQ(40);
    }
}
