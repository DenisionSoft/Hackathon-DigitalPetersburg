package spb.hack.lifeindex.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class District {
    private String name;
    private Long id;
    private ArrayList<District> neighbors;
}
