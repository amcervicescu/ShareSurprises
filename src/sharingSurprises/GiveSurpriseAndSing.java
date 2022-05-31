package sharingSurprises;

public class GiveSurpriseAndSing extends AbstractGiveSurprises {
    public GiveSurpriseAndSing(String typeOfBag, int waitTime) {
        super(typeOfBag, waitTime);
    }

    @Override
    public void giveWithPassion() {
        System.out.println("Singing a nice song, full of joy and genuine excitement…");
    }
}
