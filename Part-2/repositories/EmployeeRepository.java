package com.example.SpringJPATwo.repository;

import com.example.SpringJPATwo.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    //JPQL Queries


    //Ques1
    @Query("   select firstName, lastName\n" +
            "    from Employee\n" +
            "    where salary >(select AVG(salary) from Employee)\n" +
            "    order by salary DESC, age")
    List<Object[]> findEmployeeOrderBySalaryAndAge();

    //Ques2

    @Query("select id from Employee where salary <(select AVG(salary) from Employee) ")
    List<Integer> getEmployeeIDWithSalLessThanAVG();
    @Modifying
    @Transactional
    @Query("update Employee set salary = :updatedSalary where id = :givenId")
    void updateEmpSalary(@Param("updatedSalary") int updatedSalary, @Param("givenId") int id);


    //Ques3

    @Query("select min(salary) from Employee")
    Integer minSalary();
    @Modifying
    @Transactional
    @Query(value = "delete from Employee where salary = :minsalary")
    void deleteMinSalary(@Param("minsalary")Integer minsalary);

    //Native Queries

    //Ques1
    @Query(value = "select empId, empFirstName, empAge from employeeTable" +
            " where empLastName Like '%singh'", nativeQuery = true)
    List<Object[]> findAllEmployeeLikeNQ();


    //Ques2
    @Modifying
    @Transactional
    @Query(value = "delete from employeeTable where empAge>:agelimit", nativeQuery = true)
    void deleteByAgeNQ(@Param("agelimit") int agelimit);
}
