package com.example.SpringJPAThree.unidirectional;

import org.springframework.data.repository.CrudRepository;

public interface UnidirectionalRepository extends CrudRepository<UnidirectionalAuthor, Integer> {
}
