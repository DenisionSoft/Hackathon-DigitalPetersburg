package spb.hack.lifeindex.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Index {
    private Long id;
    private House house;
    private Double value;
    // WORK IN PROGRESS!!!
    // list (?) of subindexes
}
