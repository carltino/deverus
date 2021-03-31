package com.example.deverus.linkedin.manageprofile.api;

        import com.example.deverus.linkedin.manageprofile.entity.JobStatus;
        import com.example.deverus.linkedin.manageprofile.entity.Profile;
        import com.example.deverus.linkedin.manageprofile.repository.ProfileRepo;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringRunner;
        import org.junit.runner.RunWith;

        import java.util.List;
        import java.util.Optional;

        import org.springframework.http.MediaType;
        import org.springframework.test.web.servlet.MvcResult;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

        import static org.junit.jupiter.api.Assertions.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
class ProfileControllerTest extends AbstractTest {

    @Autowired
    ProfileRepo repo;


    @Test
    public void testGetProfile() throws Exception {
        String uri = "/profiles/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(202, status);
        String content = mvcResult.getResponse().getContentAsString();
        Profile profile = super.mapFromJson(content, Profile.class);
        assertEquals(profile.getFirstName(), "Lokesh");
    }

    @Test
    public void testAddProfile() throws Exception{
        String uri = "/profiles/add";
        Profile aNewGuy = new Profile();
        aNewGuy.setFirstName("Carl");
        aNewGuy.setLastName("Addison");
        aNewGuy.setJobstatus(JobStatus.ACTIVE);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri, aNewGuy)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(super.mapToJson(aNewGuy))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();


        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        List<Profile> profile = repo.findByLastName("Addison");
        assertTrue(profile.size() > 0);
    }

}

