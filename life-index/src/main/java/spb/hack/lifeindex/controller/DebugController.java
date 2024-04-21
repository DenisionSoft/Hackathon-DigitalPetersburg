package spb.hack.lifeindex.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.House;
import spb.hack.lifeindex.model.Index;
import spb.hack.lifeindex.model.dto.FrontendRequestDto;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.impl.ClinicDto;
import spb.hack.lifeindex.model.dto.impl.GeocoderDto;
import spb.hack.lifeindex.service.ClinicService;
import spb.hack.lifeindex.service.GeocoderService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/debug")
@AllArgsConstructor
public class DebugController {

    private final GeocoderService geocoderService;
    private final ClinicService clinicService;

    @PostMapping("/geocoder")
    public ResponseEntity<GeoPoint> getGeoPoint(@RequestBody FrontendRequestDto frontendRequestDto) {
        System.out.println("Recieved: " + frontendRequestDto);
        // IndexService would take necessary data and form RequestParamsDto for each service, here we do it manually
        RequestParamsDto requestParamsDto = new RequestParamsDto();
        requestParamsDto.setAddress(frontendRequestDto.getAddresses().getFirst());
        GeoPoint geoPoint = geocoderService.getGeoPoint(requestParamsDto);
        System.out.println("Sending: " + geoPoint);
        return ResponseEntity.ok(geoPoint);
    }

    @PostMapping("/clinic")
    public ResponseEntity<ClinicDto> getClinic(@RequestBody FrontendRequestDto frontendRequestDto) {
        System.out.println("Recieved:" + frontendRequestDto);
        // IndexService would take necessary data and form RequestParamsDto for each service, here we do it manually
        // here, first get the geo point
        RequestParamsDto requestParamsDto = new RequestParamsDto();
        requestParamsDto.setAddress(frontendRequestDto.getAddresses().getFirst());
        GeocoderDto geocoderDto = geocoderService.getAllData(requestParamsDto);
        District district = geocoderDto.getDistrict();

        requestParamsDto.setHouse(geocoderDto.getHouse());
        requestParamsDto.setAddress(geocoderDto.getHouse().getAddress());
        requestParamsDto.setRadius(frontendRequestDto.radius);
        requestParamsDto.setPage(1);

        //ClinicDto clinicDto = clinicService.getAllData(requestParamsDto);
        System.out.println("Sending:" + null);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/index")
    public ResponseEntity<ArrayList<Index>> getIndex(@RequestBody FrontendRequestDto frontendRequestDto) {
        System.out.println("Recieved:" + frontendRequestDto);
        // IndexService would take necessary data and form RequestParamsDto for each service, here we do it manually
        District district = new District();
        district.setName("Выборгский");
        GeoPoint geoPoint = new GeoPoint(0, 0);
        House house = new House();
        house.setBuildingId(1L);
        house.setAddress("Лиственная, 18к1");
        house.setDistrict(district);
        house.setGeoPoint(geoPoint);
        Index index1 = new Index();
        index1.setHouse(house);
        index1.setValue(86.0);
        ArrayList<Index> indexes = new ArrayList<>();
        indexes.add(index1);
        System.out.println("Sending:" + indexes);
        return ResponseEntity.ok(indexes);
    }

}
