package spb.hack.lifeindex.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import spb.hack.lifeindex.model.dto.support.OurPetersburgResults;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class OurPetersburgResponse {

    @JsonProperty("data")
    private ArrayList<OurPetersburgResults> results;
}