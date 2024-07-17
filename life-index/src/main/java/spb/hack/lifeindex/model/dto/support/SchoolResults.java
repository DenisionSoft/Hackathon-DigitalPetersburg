package spb.hack.lifeindex.model.dto.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SchoolResults {
    @JsonProperty("address")
    public String address;

    @JsonProperty("district")
    public String district;
}
