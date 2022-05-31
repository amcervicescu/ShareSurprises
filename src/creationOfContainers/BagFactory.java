package creationOfContainers;


import bagsOfSurprises.FIFOBag;
import bagsOfSurprises.IBag;
import bagsOfSurprises.LIFOBag;
import bagsOfSurprises.RandomBag;

public class BagFactory implements IBagFactory {

    @Override
    public IBag makeBag(String type) {
        switch (type) {
            case "RANDOM":
                return new RandomBag();
            case "FIFO":
                return new FIFOBag();
            case "LIFO":
                return new LIFOBag();
            default:
                System.out.println("Invalid type. Creating default bag (RANDOM type)...");
                return new RandomBag();
        }
    }
}