package spb.hack.lifeindex.model.dto.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class RestaurantResults {
    @JsonProperty("coord")
    public ArrayList<Double> coordinates;
}
