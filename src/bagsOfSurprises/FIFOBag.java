package bagsOfSurprises;


import surpriseTypes.ISurprise;

import java.util.ArrayList;

public class FIFOBag implements IBag{
    // surprises are taken out in the order they were introduced in (first in, first out -> FIFO strategy)
    public final ArrayList<ISurprise> bag = new ArrayList<>();

    // adds a surprise in the bag
    @Override
    public void put(ISurprise newSurprise) {
        this.bag.add(newSurprise);
    }

    // adds all the surprises from another IBag
    //   -> the 'bagOfSurprises' will be empty() afterwards
    @Override
    public void put(IBag bagOfSurprises) {
        int bagSize = bagOfSurprises.size();
        for (int i = 0; i < bagSize; i++) {
            this.bag.add(bagOfSurprises.takeOut());
        }
    }

    // removes a surprise from the bag and returns it
    @Override
    public ISurprise takeOut() {
        ISurprise surprise = bag.get(0);
        surprise.enjoy();
        bag.remove(surprise);
        return surprise;
    }

    // Checks if the bag is empty or not
    @Override
    public boolean isEmpty() {
        return bag.isEmpty();
    }

    // Returns the number of surprises
    @Override
    public int size() {
        return bag.size();
    }
}
