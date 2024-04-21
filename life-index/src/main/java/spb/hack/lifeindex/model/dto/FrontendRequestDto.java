package spb.hack.lifeindex.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import spb.hack.lifeindex.model.Parameters;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrontendRequestDto {
    public Integer amount;
    public Integer radius;
    public ArrayList<String> addresses;
    public Parameters parameters;
}
