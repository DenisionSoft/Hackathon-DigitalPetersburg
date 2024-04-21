package spb.hack.lifeindex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import spb.hack.lifeindex.model.House;
import spb.hack.lifeindex.model.Index;
import spb.hack.lifeindex.model.dto.*;

import java.util.ArrayList;
import java.util.Collection;
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

    public ArrayList<Index> getIndex(FrontendRequestDto frontendRequestDto) /*throws Exception*/ {

        ArrayList<House> houses = new ArrayList<>();
        for (String address : frontendRequestDto.getAddresses()) {
            RequestParamsDto requestParamsDto = new RequestParamsDto();
            requestParamsDto.setAddress(address);
            houses.add(geocoderService.getAllData(requestParamsDto).getHouse());
        }

        for (House house : houses) {
            ArrayList<Double> Weights = new ArrayList<>();
            Double totalWeight = Weights.stream().mapToDouble(Double::doubleValue).sum();
            Integer dropCount = 0;
            Boolean toRetry = false;

            RequestParamsDto requestParamsDto = new RequestParamsDto();
            requestParamsDto.setHouse(house);
            requestParamsDto.setAddress(house.getAddress());
            requestParamsDto.setRadius(frontendRequestDto.getRadius());
            requestParamsDto.setPage(1);


        }

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
