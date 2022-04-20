package kz.homework.travellerstorage.repository;

import kz.homework.travellerstorage.dto.CityDTO;
import kz.homework.travellerstorage.dto.CountryDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityRepository extends MongoRepository<CityDTO, String> {

    List<CityDTO> findAllByCountryCode(final String countryCode);
}
