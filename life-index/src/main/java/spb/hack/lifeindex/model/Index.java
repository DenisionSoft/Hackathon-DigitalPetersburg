package spb.hack.lifeindex.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class Index {
    private Long id;
    private House house;
    private Double value;
    public ArrayList<Double> subIndexes;

    public Index(Long id, House house, Double value, ArrayList<Double> subIndexes) {
        this.id = id;
        this.house = house;
        this.value = value;
        this.subIndexes = subIndexes;
    }
}
