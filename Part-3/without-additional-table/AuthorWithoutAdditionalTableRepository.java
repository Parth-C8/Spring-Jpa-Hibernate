package com.example.SpringJPAThree.withoutadditionaltable;

import org.springframework.data.repository.CrudRepository;

public interface AuthorWithoutAdditionalTableRepository extends CrudRepository<AuthorWithoutAdditionalTable, Integer> {
}
