package sharingSurprises;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises {
    public GiveSurpriseAndApplause(String typeOfBag, int waitTime) {
        super(typeOfBag, waitTime);
    }

    @Override
    public void giveWithPassion() {
        System.out.println("Loud applause to you… For it is in giving that we receive.");
    }
}