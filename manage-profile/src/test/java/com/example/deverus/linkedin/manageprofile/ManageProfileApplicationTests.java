package com.example.deverus.linkedin.manageprofile;

import com.example.deverus.linkedin.manageprofile.entity.Profile;
import com.example.deverus.linkedin.manageprofile.repository.ProfileRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
class ManageProfileApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ProfileRepo repo;

    @Test
    public void getProfile() {
        String expected = "Lokesh";

        Optional<?> profile = repo.findById(1);

        if(!profile.isPresent()){
            fail();
        }

        assertEquals(((Profile) profile.get()).getFirstName(), expected);
    }

    @Test
    public void addProfile() {

        repo.save(new Profile());
    }

}
