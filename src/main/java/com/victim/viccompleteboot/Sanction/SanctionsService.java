package com.victim.viccompleteboot.Sanction;

import com.victim.viccompleteboot.models.Sanction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SanctionsService {


    @Autowired
    private SanctionsRepository sanctionsRepository;

    public Page<Sanction> show(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1,7);
        return  sanctionsRepository.findAll(pageable);
    }

    public void save(Sanction sanction){
        sanctionsRepository.save(sanction);
    }

    public Optional<Sanction> sanction(int id){
       return sanctionsRepository.findById(id);
    }

}
