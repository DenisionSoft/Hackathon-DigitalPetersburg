package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.impl.MuseumClient;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.impl.MuseumDto;

@Service
@RequiredArgsConstructor
public class MuseumService {

    private final MuseumClient museumClient;

    public MuseumDto getAllData(RequestParamsDto requestParamsDto) {
        return museumClient.getDto(requestParamsDto);
    }
}
