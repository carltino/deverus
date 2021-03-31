package com.example.deverus.linkedin.manageprofile.api;

import com.example.deverus.linkedin.manageprofile.entity.Profile;
import com.example.deverus.linkedin.manageprofile.exception.ProfileNotFoundException;
import com.example.deverus.linkedin.manageprofile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 * @author Carlton Addison
 *
 */
@RestController
public class ProfileController {

    @Autowired
    ProfileService service;

    @GetMapping("/profiles/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable int id) throws Exception {

        return new ResponseEntity<>(service.getProfile(id).orElseThrow(()-> new ProfileNotFoundException()),
                HttpStatus.ACCEPTED);
    }

    @PostMapping("/profiles/add")
    public HttpStatus addProfile(@RequestBody @Valid Profile profile) throws Exception{

        service.addProfile(profile);

        return HttpStatus.ACCEPTED;

    }
}
