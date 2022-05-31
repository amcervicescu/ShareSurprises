package surpriseTypes;

import java.util.ArrayList;
import java.util.Random;

public class FortuneCookie implements ISurprise{
    private final String message;
    private static final Random random = new Random();

    private FortuneCookie(String message) {
        this.message = message;
    }

    @Override
    public void enjoy() {
        System.out.println(message);
    }

    public static FortuneCookie generate() {
        ArrayList<String> messages = new ArrayList<>(20);
        messages.add("Little by little, one travels far.");
        messages.add("It's only after we've lost everything, that we're free to do anything.");
        messages.add("Love all, trust a few, do wrong to none.");
        messages.add("Not all those who wander are lost.");
        messages.add("The worst enemy to creativity is self-doubt.");
        messages.add("Your road to glory will be rocky, but fulfilling.");
        messages.add("Don’t pursue happiness – create it.");
        messages.add("All things are difficult before they are easy.");
        messages.add("The real kindness comes from within you.");
        messages.add("You don’t need strength to let go of something. What you really need is understanding.");
        messages.add("The usefulness of a cup is in its emptiness.");
        messages.add("He who throws mud loses ground.");
        messages.add("Big journeys begin with a single step.");
        messages.add("Be not afraid of growing slowly, be afraid only of standing still.");
        messages.add("It’s amazing how much good you can do if you don’t care who gets the credit.");
        messages.add("See if you can learn anything from the children.");
        messages.add("Follow your bliss and the Universe will open doors where there were once only walls.");
        messages.add("Be careful who you trust. Salt and sugar look the same.");
        messages.add("What we learn with pleasure we never forget.");
        messages.add("Wouldn't it be ironic... to die in the living room?");

        return new FortuneCookie(messages.get(random.nextInt(20)));
    }
}
