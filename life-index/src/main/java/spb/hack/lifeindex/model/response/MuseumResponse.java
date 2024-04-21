package spb.hack.lifeindex.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import calculations.BeautifulPlacesResult.ClinicResult.KindergartensResult.KudaGOResult.LibrariesResult.MinCultResult.MuseumResult.PetClinicsResult.PetParksResult.RecyclingResult.RestaurantResult.RestaurantTerm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import spb.hack.lifeindex.model.dto.support.MuseumResults;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MuseumResponse {

    @JsonProperty("results")
    private ArrayList<MuseumResults> results;
}