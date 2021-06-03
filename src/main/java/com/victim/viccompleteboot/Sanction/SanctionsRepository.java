package com.victim.viccompleteboot.Sanction;

import com.victim.viccompleteboot.models.Sanction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanctionsRepository extends PagingAndSortingRepository<Sanction,Integer> {

}
