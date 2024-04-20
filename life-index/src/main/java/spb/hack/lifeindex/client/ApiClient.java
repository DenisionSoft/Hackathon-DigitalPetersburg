package spb.hack.lifeindex.client;

import spb.hack.lifeindex.model.dto.ApiDto;
import spb.hack.lifeindex.model.dto.RequestParamsDto;

public interface ApiClient {

    ApiDto getDto(RequestParamsDto requestParamsDto);
}
