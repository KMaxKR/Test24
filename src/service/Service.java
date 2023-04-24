package service;

import java.util.concurrent.*;

public class Service {
    ScheduledExecutorService serv = Executors.newSingleThreadScheduledExecutor();
    public void feedAnimals(int quantity) throws InterruptedException, ExecutionException {
        try {
            Runnable task1 = () -> System.out.println("Feeding animals ............");
            Future<?> result = serv.scheduleWithFixedDelay(task1, 0, 3, TimeUnit.SECONDS);
            System.out.println(result.get(10, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.out.println("Out of Time");;
        } finally {
            if (serv != null) serv.shutdown();
        }
        if (serv != null){
            serv.awaitTermination(1, TimeUnit.SECONDS);
            if (serv.isTerminated()){
                System.out.println("All task are done");
            }else{
                System.out.println("Still one running");
            }
        }
    }
}
