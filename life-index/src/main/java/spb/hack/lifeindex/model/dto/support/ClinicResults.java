package spb.hack.lifeindex.model.dto.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class ClinicResults {
    @JsonProperty("coordinates")
    public ArrayList<Double> coordinates;

    @JsonProperty("district")
    public String district;
}
