package surpriseTypes;

import java.util.Random;

public class Candies implements ISurprise{
    private final int numberOfCandies;
    private final String typeOfCandies;
    private static final Random random = new Random();

    private Candies(int numberOfCandies, String typeOfCandies) {
        this.numberOfCandies = numberOfCandies;
        this.typeOfCandies = typeOfCandies;
    }

    @Override
    public void enjoy() {
        System.out.println(numberOfCandies + " " + typeOfCandies + " candies");
    }

    public static Candies generate() {
        String[] candyTypes = {"chocolate", "jelly", "fruits", "vanilla", "sour"};
        return new Candies(random.nextInt(8) + 2, candyTypes[random.nextInt(candyTypes.length)]);
    }

}