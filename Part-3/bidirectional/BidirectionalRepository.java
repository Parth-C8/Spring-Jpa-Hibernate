package com.example.SpringJPAThree.bidirectional;

import org.springframework.data.repository.CrudRepository;

public interface BidirectionalRepository extends CrudRepository<BidirectionalAuthor, Integer> {
}
