package spb.hack.lifeindex.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import spb.hack.lifeindex.model.dto.support.SchoolResults;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SchoolResponse {

    @JsonProperty("results")
    private ArrayList<SchoolResults> results;
}