package com.example.SpringJPATwo.repository;

import com.example.SpringJPATwo.entity.EmployeeComponentMapping;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeComponentMappingRepository extends CrudRepository<EmployeeComponentMapping, Integer> {
    
}
