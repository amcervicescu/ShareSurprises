package creationOfSurprises;


import surpriseTypes.Candies;
import surpriseTypes.FortuneCookie;
import surpriseTypes.ISurprise;
import surpriseTypes.MinionToy;

import java.util.ArrayList;
import java.util.Random;

public final class GatherSurprises {
    private static final Random random = new Random();

    private GatherSurprises() {
    }

    public static ArrayList<ISurprise> gather(int n) {
        ArrayList<ISurprise> surprises = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            surprises.add(gather());
        }
        return surprises;
    }

    public static ISurprise gather() {
        // The types of surprises are:
        //  0. Fortune cookies
        //  1. Candies
        //  2. Minion toys
        int noOfSurpriseType = random.nextInt(3);
        switch (noOfSurpriseType) {
            case 0:
                return FortuneCookie.generate();
            case 1:
                return Candies.generate();
            case 2:
                return MinionToy.generate();
            default:
                break;
        }
        return FortuneCookie.generate();
    }
}
