package kz.homework.travellerstorage.controller;

import kz.homework.travellerstorage.dto.CountryDTO;
import kz.homework.travellerstorage.service.CountryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kz.homework.travellerstorage.configuration.MessageQueueConfiguration.COUNTRY_QUEUE_NAME;

@RestController
@CrossOrigin(origins = "http://localhost:8990")
@RequestMapping("/v1/country")
public class CountryController {

    private static final Log LOG = LogFactory.getLog(CountryController.class);

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RabbitListener(queues = COUNTRY_QUEUE_NAME)
    public void addCountry(final CountryDTO countryDTO) {
        LOG.info("new country received: " + countryDTO);
        this.countryService.addCountry(countryDTO);
    }

    @GetMapping
    public List<CountryDTO> getCountries() {
        return countryService.getCountries();
    }

    @DeleteMapping
    public void deleteById(@RequestParam(name = "id") final String id) {
        countryService.deleteById(id);
    }
}
