package sharingSurprises;

import bagsOfSurprises.IBag;
import creationOfContainers.BagFactory;
import surpriseTypes.ISurprise;

import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {
    private IBag bag; // needs parameter for type of bag in constructor
    private int waitTime;
    private static BagFactory bagFactory = new BagFactory();

    public AbstractGiveSurprises(String typeOfBag, int waitTime) {
        this.bag = bagFactory.makeBag(typeOfBag);
        this.waitTime = waitTime;
    }

    public void put(ISurprise newSurprise) {
        bag.put(newSurprise);
    }

    public void put(IBag surprises) {
        bag.put(surprises);
    }

    public ISurprise give() {
        // surprise distribution order depends on the type of bag
        return bag.takeOut();
    }

    public void giveAll() {
        while (!bag.isEmpty()) {
            give();

            // Sleep for X seconds - code snippet
            try {
                TimeUnit.SECONDS.sleep(waitTime); // number of seconds to sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean isEmpty() {
        return bag.isEmpty();
    }

    abstract void giveWithPassion();
}

