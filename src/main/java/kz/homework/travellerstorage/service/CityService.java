package kz.homework.travellerstorage.service;

import kz.homework.travellerstorage.dto.CityDTO;
import kz.homework.travellerstorage.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record CityService(CityRepository cityRepository) {

    public void addCity(final CityDTO cityDTO) {
        if (cityDTO.getId() != null) {
            final Optional<CityDTO> optionalCityDTO = cityRepository.findById(cityDTO.getId());
            if (optionalCityDTO.isPresent()) {
                final CityDTO currentCityDTO = optionalCityDTO.get();
                currentCityDTO.setName(cityDTO.getName());
                cityRepository.save(currentCityDTO);
            } else {
                cityRepository.insert(cityDTO);
            }
        } else {
            cityRepository.insert(cityDTO);
        }
    }

    public List<CityDTO> getCities() {
        return cityRepository.findAll();
    }

    public List<CityDTO> findAllByCountryCode(final String countryCode) {
        return cityRepository.findAllByCountryCode(countryCode);
    }

    public void deleteById(final String id) {
        cityRepository.deleteById(id);
    }
}
