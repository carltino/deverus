package com.example.deverus.linkedin.manageprofile.repository;

import com.example.deverus.linkedin.manageprofile.entity.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProfileRepo extends CrudRepository<Profile,Integer>{

}
