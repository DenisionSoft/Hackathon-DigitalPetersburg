package spb.hack.lifeindex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.model.Index;
import spb.hack.lifeindex.model.dto.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

@Service
@AllArgsConstructor
public class IndexService {

    
    public ArrayList<Index> getIndex(FrontendRequestDto frontendRequestDto) throws Exception {
        ExecutorService executorService = ExecutorService.newFixedThreadPool(15);
        Collection<Callable<Index>> callables = new ArrayList<>();
        ArrayList<Double> Weights = new ArrayList(15);
        Double totalWeight = Weights.stream().mapToDouble(Double::doubleValue).sum();
        ArrayList<Integer> retryCounter = new ArrayList(15);
        ArrayList<Future<Index>> indexFutureList = new ArrayList<Future<Index>>(15);
        int dropCount = 0;
        bool toRetry = false;
        //Заменить на колл реальных индексов
        IntStream.rangeClosed(1, 15).forEach(i-> {
            callables.add(createCallable());
          });
        for (int i = 0; i<15;i++)
        {
            indexFutureList.set(i,executorService.execute(callables.get(i)));
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
                if (dropCount==3){
                    //НОЕМ НА НЕТОЧНОСТЬ
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
        //Нужно выполнить чтоб закрылись все потоки
        executorService.shutdownNow();
        ArrayList<Index> ansIndexes = new ArrayList<Index>(16);
        double totalIndex = 0;
        for (int i = 1; i<16;i++){
            ansIndexes.set(i,indexFutureList.get(i-1));
            totalIndex += indexFutureList.get(i-1);
        }
        totalIndex/=totalWeight;
        ansIndex.set(0, new Index(totalIndex));
        return ansIndexes;
        /*ExecutorService executor = Executors.newCachedThreadPool();
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
        }*/
    }
}
