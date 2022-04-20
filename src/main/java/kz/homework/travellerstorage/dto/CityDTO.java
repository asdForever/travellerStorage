package kz.homework.travellerstorage.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Document(collection = "city")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDTO implements Serializable {

    @Id
    private String id;
    private String geonameid;
    private String name;
    private String asciiname;
    private String alternatenames;
    private String latitude;
    private String longitude;
    private String featureClass;
    private String featureCode;
    private String countryCode;
    private String cc2;
    private String admin1Code;
    private String admin2Code;
    private String admin3Code;
    private String admin4Code;
    private String population;
    private String elevation;
    private String dem;
    private String timezone;
    private String modificationDate;
}
