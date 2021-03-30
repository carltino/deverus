package com.example.deverus.linkedin.manageprofile.service;

import com.example.deverus.linkedin.manageprofile.entity.Profile;
import com.example.deverus.linkedin.manageprofile.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo repo;

    public Optional<Profile> getProfile(int id){

        return repo.findById(id);
    }

    public int addProfile(Profile profile) throws Exception{

        return repo.save(profile).hashCode();
    }

}
