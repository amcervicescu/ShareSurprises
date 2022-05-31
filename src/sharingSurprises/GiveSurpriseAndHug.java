package sharingSurprises;

public class GiveSurpriseAndHug extends AbstractGiveSurprises {
    public GiveSurpriseAndHug(String typeOfBag, int waitTime) {
        super(typeOfBag, waitTime);
    }

    @Override
    public void giveWithPassion() {
        System.out.println("Warm wishes and a big hug!");
    }
}