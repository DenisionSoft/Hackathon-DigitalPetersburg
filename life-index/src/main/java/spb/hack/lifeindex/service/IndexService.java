package spb.hack.lifeindex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import spb.hack.lifeindex.model.House;
import spb.hack.lifeindex.model.Index;
import spb.hack.lifeindex.model.dto.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.stream.IntStream;

// import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

@Service
@AllArgsConstructor
public class IndexService {

    private final ClinicService clinicService;
    private final GeocoderService geocoderService;
    //private final KinderService kinderService;
    private final SchoolService schoolService;
    private final RestaurantService restaurantService;
    private final MuseumService museumService;
    private final OurPetersburgService ourPetersburgService;

    public ArrayList<Index> getIndex(FrontendRequestDto frontendRequestDto) /*throws Exception*/ {

        ArrayList<Index> indexes = new ArrayList<>();

        ArrayList<House> houses = new ArrayList<>();
        for (String address : frontendRequestDto.getAddresses()) {
            RequestParamsDto requestParamsDto = new RequestParamsDto();
            requestParamsDto.setAddress(address);
            houses.add(geocoderService.getAllData(requestParamsDto).getHouse());
        }

        Integer radius = frontendRequestDto.getRadius();
        for (House house : houses) {
            Index index = new Index();
            ArrayList<Double> Weights = new ArrayList<>();
            Double totalWeight = Weights.stream().mapToDouble(Double::doubleValue).sum();
            Integer dropCount = 0;
            Boolean toRetry = false;

            RequestParamsDto requestParamsDto = new RequestParamsDto();
            requestParamsDto.setHouse(house);
            requestParamsDto.setAddress(house.getAddress());
            requestParamsDto.setRadius(frontendRequestDto.getRadius());
            requestParamsDto.setPage(1);

            ResponseDataDto responseDataDto;
            responseDataDto = clinicService.getAllData(requestParamsDto);
            ArrayList<Double> distances = new ArrayList<>();
            for(int i = 0; i < responseDataDto.getGeoData().size(); i++) {
                Double distance = GlebService.distance(house.getGeoPoint(), responseDataDto.getGeoData().get(i).a);
                if(distance < radius)
                {
                    distances.add(distance);
                }
            }
            Double clinicIndex = GlebService.distFunction(distances.stream().min(Double::compareTo).get());
            clinicIndex *= frontendRequestDto.getParameters().getHealthValue() ? 1 : 0.5;

            System.out.println(responseDataDto);
            distances.clear();

            responseDataDto = museumService.getAllData(requestParamsDto);

            for(int i = 0; i < responseDataDto.getGeoData().size(); i++) {
                Double distance = GlebService.distance(house.getGeoPoint(), responseDataDto.getGeoData().get(i).a);
                if(distance < radius)
                {
                    distances.add(distance);
                }
            }
            Double museumIndex = 0.0;
            for(int i = 0; i < distances.size() && i < 5; i++)
                museumIndex += GlebService.distFunction(distances.get(i));
            museumIndex /= 5;
            museumIndex *= frontendRequestDto.getParameters().getMuseumValue() ? 1 : 0.5;
            //System.out.println(responseDataDto);
            distances.clear();

            /*
            responseDataDto = restaurantService.getAllData(requestParamsDto);
            for(int i = 0; i < responseDataDto.getGeoData().size(); i++) {
                Double distance = GlebService.distance(house.getGeoPoint(), responseDataDto.getGeoData().get(i).a);
                if(distance < radius)
                {
                    distances.add(distance);
                }
            }
            Double restIndex = 0.0;
            for(Double distance : distances) {
                restIndex += GlebService.distFunction(distance);
            }
            restIndex /= 5;
            restIndex *=  frontendRequestDto.getParameters().getRestoranValue() ? 1 : 0.5;
            System.out.println(responseDataDto);

             */

            /*
            Double ourPetersburgIndex = 0.0;
            responseDataDto = ourPetersburgService.getAllData(requestParamsDto);
            HashMap<String, Double> ScoreMap = new HashMap<>();
            ScoreMap.put("Неисправный лифт", 0.5);
            ScoreMap.put("Отсутствие или несоблюдение графика уборки подъезда", 0.5);
            ScoreMap.put("Неудовлетворительное состояние парадной", 0.5);
            ScoreMap.put("Неубранный снег, требуется обработка территории пескосоляной смесью", 0.75);
            ScoreMap.put("Низкая температура в отапливаемом помещении", 0.75);
            ScoreMap.put("Отсутствие горячей воды", 0.5);
            ScoreMap.put("Несанкционированные надписи / объявления на стенах дома", 0.5);
            ScoreMap.put("Отсутствие холодной воды", 1d);
            ScoreMap.put("Мусор на внутридворовой территории", 0.5);
            ScoreMap.put("Неисправное освещение в подъезде / на фасаде жилого здания", 0.75);
            ScoreMap.put("Неисправный домофон", 0.75);
            ScoreMap.put( "Ненадлежащее состояние малых архитектурных форм, уличной мебели и хозяйственно-бытового оборудования, необходимого для благоустройства территории", 0.5);
            ScoreMap.put("Повреждение отопительного прибора (радиатора и др.), запорной арматуры (вентиль, кран) протечка трубопровода системы центрального отопления на лестничной площадке / подвале / чердаке", 1d);
            ScoreMap.put("Неисправный доводчик входной двери", 0.75);
            ScoreMap.put("Неудовлетворительное состояние окраски фасада дома (кроме несанкционированных надписей / объявлений на стенах дома)", 0.5);
            ScoreMap.put("Требуется дезинсекция (насекомые), дезинфекция в местах общего пользования (в т.ч. мусоропровода)", 0.5);
            ScoreMap.put("Хранение вещей на лестничной площадке", 1d);
            ScoreMap.put("Отказ в составлении акта обследования или несоответствие акта действительности", 0.75);
            ScoreMap.put("Слабый напор холодной воды", 0.75);
            ScoreMap.put("Повреждение кровли", 0.5);
            ScoreMap.put("Неудовлетворительное состояние асфальтового покрытия на придомовой и дворовой территориях", 0.5);
            ScoreMap.put("Повреждение участков цоколя, отмостки, приямков, вентиляционных продухов", 0.5);
            ScoreMap.put("Неудовлетворительное санитарное и техническое состояние контейнерной площадки", 0.5);
            ScoreMap.put("Ненадлежащее содержание трубопроводов и элементов системы водоснабжения", 0.5);
            ScoreMap.put("Отсутствие информации об отключениях в связи с проведением ремонтных работ (на информационном стенде управляющей организации)", 1d);
            ScoreMap.put("Не оборудована контейнерная площадка", 0.5);
            ScoreMap.put("Слабый напор горячей воды", 0.75);
            ScoreMap.put("Мусор на газонах (крупногабаритные объекты)", 0.75);
            ScoreMap.put("Ненадлежащее состояние ограждений газонов", 1d);
            ScoreMap.put("Плохое качество горячей воды", 0.75);
            ScoreMap.put("Требуется дератизация (крысы) в местах общего пользования", 0.5);
            ScoreMap.put("Наличие наледи на крыше", 0.75);
            ScoreMap.put("Засор канализации/протечка канализационной трубы", 0.5);
            ScoreMap.put("Неудовлетворительное содержание газонов (отсутствие травяного покрова)", 0.75);
            ScoreMap.put("Самовольное переустройство и (или) перепланировка помещения", 1d);
            ScoreMap.put("Неубранный снег", 0.75);
            ScoreMap.put("Неисправность системы вентиляции", 1d);
            ScoreMap.put("Предложения по установке малых архитектурных форм, уличной мебели и хозяйственно-бытового оборудования, необходимого для благоустройства территории", 1d);
            ScoreMap.put("Неисправное освещение в лифте", 0.75);
            ScoreMap.put("Разбиты стекла на лестничной площадке", 0.5);
            ScoreMap.put("Неудовлетворительное содержание чердачного помещения, принадлежащего собственникам помещений в многоквартирном доме на праве общей долевой собственности", 0.75);
            for(int i = 0; i < responseDataDto.getArrayStringData().size(); i++) {
                ourPetersburgIndex+=ScoreMap.get(responseDataDto.getArrayStringData().get(i));
            }
            ourPetersburgIndex /= responseDataDto.getArrayStringData().size();

             */
            /*
            distances.clear();
            responseDataDto = schoolService.getAllData(requestParamsDto);
            for(int i = 0; i < responseDataDto.getGeoData().size(); i++) {
                Double distance = GlebService.distance(house.getGeoPoint(), responseDataDto.getGeoData().get(i).a);
                if(distance < radius)
                {
                    distances.add(distance);
                }
            }
            Double schoolIndex = GlebService.distFunction(distances.stream().min(Double::compareTo).get());
            schoolIndex *= frontendRequestDto.getParameters().getEducationValue() ? 1 : 0.5;


             */
            //System.out.println(responseDataDto);
            Double value = (/*restIndex*/ + clinicIndex + museumIndex /*+schoolIndex*/ /*+ourPetersburgIndex*/) / 3;

            value = value * 100;
            Integer valueRounded = value.intValue();
            Double valueDecimal = value.doubleValue();
            index.setValue(valueDecimal);
            distances.clear();
            indexes.add(index);
        }

        return indexes;

            /*
            //callables.add(schoolService.getAllData(requestParamsDto));
            //callables.add(restaurantService.getAllData(requestParamsDto));

            callables.add(clinicService.getAllData(requestParamsDto));
            //callables.add(ProblemsService());
            //callables.add(TheatresService());
            //callables.add(CinemasService());
            //callables.add(CudaGoService());
            //callables.add(SportgroundsService());
            //callables.add(SchoolsService());
            //callables.add(RestaurantService());
            //callables.add(RecyclingService());
            //callables.add(PetService());
            //callables.add(MuseumService());
            //callables.add(LibrariesService());
            //callables.add(KindergartensService());
            //callables.add(BeautifulPlacesService());
            //callables.add(TransportService());
            int i = 0;
            for (Callable<ResponseDataDto> callable : callables) {
                indexFutureList.set(i,executorService.execute(callables.get(i)));
                i++;
            }
            for (int i = 0; i<15;i++)
            {
                try {
                    indexFutureList.get(i).get(30, TimeUnit.SECONDS);
                } catch (TimeoutException ex){
                    retryCounter.set(i,retryCounter.get(i)+5);
                    indexFutureList.set(i,executorService.execute(callables.get(i)));
                    toRetry = true;
                } catch (Exception ex) {
                    retryCounter.set(i,retryCounter.get(i)+1);
                    indexFutureList.set(i,executorService.execute(callables.get(i)));
                    toRetry = true;
                } finally {
                    if (retryCounter.get(i) >=5)
                    {
                        totalWeight-=Weights.get(i);
                        Weights.set(i, 0);
                        dropCount++;
                    }
                    if (dropCount==5){
                        throw new Exception("Слишком много ошибок");
                    }
                    if (i==14&&toRetry){
                        toRetry = false;
                        i = 0;
                    }
                }
            }
        }
        //Нужно выполнить чтоб закрылись все потоки
        executorService.shutdownNow();
        ArrayList<Double> ansIndexes = new ArrayList<Double>(16);
        double totalIndex = 0;
        for (int i = 1; i<16;i++){
            ansIndexes.set(i,indexFutureList.get(i-1).get());
            totalIndex += indexFutureList.get(i-1).get();
        }
        totalIndex/=totalWeight;
        ansIndex.set(0, new Index(totalIndex));
        callables.clear();
        return ansIndexes;
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Index> future = executor.submit(GetMinCultIndex());
        try {
        Object result = future.get(30, TimeUnit.SECONDS); 
        } catch (TimeoutException ex) {

        } catch (InterruptedException e) {
        // handle the interrupts
        } catch (ExecutionException e) {
        // handle other exceptions
        } finally {
        future.cancel(true); // may or may not desire this
        }
        return null;*/
    }
}
