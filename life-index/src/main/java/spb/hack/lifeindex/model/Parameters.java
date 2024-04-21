package spb.hack.lifeindex.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Parameters {
    private Boolean educationValue;
    private Boolean healthValue;
    private Boolean museumValue;
    private Boolean restoranValue;
}
