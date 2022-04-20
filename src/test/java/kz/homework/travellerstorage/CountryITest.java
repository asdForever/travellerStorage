package kz.homework.travellerstorage;

import kz.homework.travellerstorage.dto.CountryDTO;
import kz.homework.travellerstorage.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@Import(MongoDBTestConfiguration.class)
@SpringBootTest
public class CountryITest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CountryService countryService;

    @Test
    public void test_createUser_validateDBAndS3() throws Exception {
        final CountryDTO countryDTO = CountryDTO.builder().name("Kazakhstan").build();
        countryService.addCountry(countryDTO);

        mvc.perform(get("/v1/country"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Kazakhstan"))
                .andDo(MockMvcResultHandlers.print());
    }
}
