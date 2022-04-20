package kz.homework.travellerstorage.service;

import kz.homework.travellerstorage.dto.CountryDTO;
import kz.homework.travellerstorage.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record CountryService(CountryRepository countryRepository) {

    public void addCountry(final CountryDTO countryDTO) {
        if (countryDTO.getId() != null) {
            final Optional<CountryDTO> optionalCountryDTO = countryRepository.findById(countryDTO.getId());
            if (optionalCountryDTO.isPresent()) {
                final CountryDTO currentCountryDTO = optionalCountryDTO.get();
                currentCountryDTO.setName(countryDTO.getName());
                countryRepository.save(currentCountryDTO);
            } else {
                countryRepository.insert(countryDTO);
            }
        } else {
            countryRepository.insert(countryDTO);
        }
    }

    public List<CountryDTO> getCountries() {
        return countryRepository.findAll();
    }

    public void deleteById(final String id) {
        countryRepository.deleteById(id);
    }
}
