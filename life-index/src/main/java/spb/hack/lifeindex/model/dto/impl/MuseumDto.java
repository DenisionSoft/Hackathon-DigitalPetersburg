import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.House;
import spb.hack.lifeindex.model.dto.ApiDto;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuseumDto {
    private Integer count;
    private ArrayList<Pair<GeoPoint, District>> results;
}
