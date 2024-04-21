
package spb.hack.lifeindex.model.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.dto.ApiDto;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto extends ApiDto {
    private ArrayList<Pair<GeoPoint, District>> results;
}
