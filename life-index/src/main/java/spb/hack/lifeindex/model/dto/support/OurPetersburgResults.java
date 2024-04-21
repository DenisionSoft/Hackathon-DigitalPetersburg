package spb.hack.lifeindex.model.dto.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class OurPetersburgResults {
    @JsonProperty("latitude")
    public Double latitude;
    @JsonProperty("longitude")
    public Double longitude;
    @JsonProperty("reason")
    public String reason;
}
