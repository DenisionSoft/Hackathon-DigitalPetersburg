package spb.hack.lifeindex.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

//import calculations.BeautifulPlacesResult.ClinicResult.KindergartensResult.KudaGOResult.LibrariesResult.MinCultResult.MuseumResult.PetClinicsResult.PetParksResult.RecyclingResult.RestaurantResult.RestaurantTerm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import spb.hack.lifeindex.model.dto.support.ClinicResults;
import spb.hack.lifeindex.model.dto.support.RestaurantResults;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RestaurantResponse {

    @JsonProperty("results")
    private ArrayList<RestaurantResults> results;
}