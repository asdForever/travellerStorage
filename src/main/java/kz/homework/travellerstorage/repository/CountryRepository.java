package kz.homework.travellerstorage.repository;

import kz.homework.travellerstorage.dto.CountryDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<CountryDTO, String> {
}
