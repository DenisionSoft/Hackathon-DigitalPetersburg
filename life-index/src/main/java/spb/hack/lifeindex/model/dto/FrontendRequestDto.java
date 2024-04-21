package spb.hack.lifeindex.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrontendRequestDto {
    public Integer amount;
    public Integer radius;
    public ArrayList<String> addresses;
    // parameters, perhaps model for it or simply number + bool values like maps or smth
}
