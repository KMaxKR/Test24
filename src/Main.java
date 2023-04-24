import service.Service;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Begin...");

        Service service = new Service();
        service.feedAnimals(2);

        System.out.println("End");
    }
}