package spb.hack.lifeindex.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

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