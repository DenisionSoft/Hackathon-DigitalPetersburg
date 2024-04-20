package spb.hack.lifeindex.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.dto.FrontendRequestDto;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.service.GeocoderService;

@RestController
@RequestMapping("/api/debug")
@AllArgsConstructor
public class DebugController {

    private final GeocoderService geocoderService;

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

}
