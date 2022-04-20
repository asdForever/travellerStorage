package kz.homework.travellerstorage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Document(collection = "country")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDTO implements Serializable {

    @Id
    private String id;
    private String iso;
    private String iso3;
    private String isoNumeric;
    private String fips;
    private String name;
    private String capital;
    private String area; // in sq km
    private String population;
    private String continent;
    private String tld;
    private String currencyCode;
    private String currencyName;
    private String phone;
    private String postalCodeFormat;
    private String postalCodeRegex;
    private String languages;
    private String geonameId;
    private String neighbours;
    private String equivalentFipsCode;
}
