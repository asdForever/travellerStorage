package kz.homework.travellerstorage.controller;

import kz.homework.travellerstorage.dto.CityDTO;
import kz.homework.travellerstorage.service.CityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kz.homework.travellerstorage.configuration.MessageQueueConfiguration.CITY_QUEUE_NAME;

@RestController
@CrossOrigin(origins = "http://localhost:8990")
@RequestMapping("/v1/city")
public class CityController {

    private static final Log LOG = LogFactory.getLog(CityController.class);

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RabbitListener(queues = CITY_QUEUE_NAME)
    public void addCity(final CityDTO cityDTO) {
        LOG.info("new city received: " + cityDTO);
        this.cityService.addCity(cityDTO);
    }

    @GetMapping
    public List<CityDTO> getCities() {
        return cityService.getCities();
    }

    @GetMapping("/{countryCode}")
    public List<CityDTO> findAllByCountryCode(@PathVariable("countryCode") final String countryCode) {
        return cityService.findAllByCountryCode(countryCode);
    }

    @DeleteMapping
    public void deleteById(@RequestParam(name = "id") final String id) {
        cityService.deleteById(id);
    }
}
