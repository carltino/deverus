package com.example.deverus.linkedin.manageprofile.repository;

import com.example.deverus.linkedin.manageprofile.entity.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ProfileRepo extends CrudRepository<Profile,Integer>{

    List<Profile> findByLastName(String lastname);

}
