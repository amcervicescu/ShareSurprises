package main;

import bagsOfSurprises.IBag;
import creationOfContainers.BagFactory;
import creationOfContainers.IBagFactory;
import creationOfSurprises.GatherSurprises;
import sharingSurprises.GiveSurpriseAndApplause;
import sharingSurprises.GiveSurpriseAndHug;
import sharingSurprises.GiveSurpriseAndSing;
import surpriseTypes.Candies;
import surpriseTypes.FortuneCookie;
import surpriseTypes.ISurprise;
import surpriseTypes.MinionToy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void testBag(IBag bag1, IBag bag2) {
        ArrayList<ISurprise> surprises1;

        System.out.println("Is the bag empty? " + bag1.isEmpty());
        System.out.println("\nPutting 5 random surprises in the bag...");
        surprises1 = GatherSurprises.gather(5);
        for (ISurprise surprise : surprises1) {
            bag1.put(surprise);
            surprise.enjoy();
        }
        System.out.println("\nThe current size of the bag is: " + bag1.size());
        System.out.println("Is the bag empty? " + bag1.isEmpty());
        System.out.println("\nLet's take out 3 surprises:");
        for (int i = 0; i < 3; i++) {
            bag1.takeOut();
        }
        System.out.println("The current size of the bag is: " + bag1.size());

        System.out.println("\nPutting the contents of this bag in another one...");
        bag2.put(bag1);
        System.out.println("Now the size of the first bag is " + bag1.size()
                + " and the size of the second bag is " + bag2.size() + ".");
        System.out.println("Then adding a random surprise...");
        bag2.put(GatherSurprises.gather());
        System.out.println("\nLet's take out every surprise from the second bag:");
        while (!bag2.isEmpty()) {
            bag2.takeOut();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t\tTesting\n");

        byte choice;
        String quitChoice;

        // array of random surprises to be used later
        ArrayList<ISurprise> surprises1;
        surprises1 = GatherSurprises.gather(5);

        boolean quit = false;
        while (!quit) {
            System.out.println("The main parts of the project are as follows:");
            System.out.println("1. Types of Surprises");
            System.out.println("2. Bags of Surprises");
            System.out.println("3. Giving Surprises");
            System.out.println("Which part would you like to test? (1, 2 or 3)");
            choice = sc.nextByte();

            switch (choice) {
                case 1:
                    // ============================== 1+3. Types of Surprises + Creating Surprises ==============================

                    System.out.println("\t1. Types of Surprises");

                    System.out.println("\na) Enjoying some fortune cookies:");
                    FortuneCookie.generate().enjoy();
                    FortuneCookie.generate().enjoy();
                    FortuneCookie.generate().enjoy();

                    System.out.println("\nb) Enjoying some candies:");
                    Candies.generate().enjoy();
                    Candies.generate().enjoy();
                    Candies.generate().enjoy();

                    System.out.println("\nc) Enjoying some Minion toys (name order should be: Dave, Carl, Kevin, Stuart, Jerry, Tim):");
                    MinionToy.generate().enjoy();
                    MinionToy.generate().enjoy();
                    MinionToy.generate().enjoy();
                    MinionToy.generate().enjoy();
                    MinionToy.generate().enjoy();
                    MinionToy.generate().enjoy();
                    MinionToy.generate().enjoy();

                    System.out.println("\nd) Enjoying some mixed surprises:");
                    for (ISurprise surprise : surprises1) {
                        surprise.enjoy();
                    }

                    System.out.println("\n\nWould you like to quit? Type \"yes\" or \"no\":");
                    quitChoice = sc.next();
                    if (quitChoice.equals("no")) {
                        quit = false;
                    } else {
                        quit = true;
                    }

                    break;

                case 2:
                    // ================================ 2+4. Bags of Surprises + Creating Bags ================================

                    System.out.println("\n\n\t2. Bags of Surprises");

                    IBagFactory bagFactory = new BagFactory();

                    System.out.println("\na) FIFO Bag:\n");

                    IBag fifoBag1 = bagFactory.makeBag("FIFO");
                    IBag fifoBag2 = bagFactory.makeBag("FIFO");

                    testBag(fifoBag1, fifoBag2);

                    System.out.println("\n\nb) LIFO Bag:\n");

                    IBag lifoBag1 = bagFactory.makeBag("LIFO");
                    IBag lifoBag2 = bagFactory.makeBag("LIFO");

                    testBag(lifoBag1, lifoBag2);

                    System.out.println("\n\nc) Random Bag:\n");

                    IBag randomBag1 = bagFactory.makeBag("RANDOM");
                    IBag randomBag2 = bagFactory.makeBag("RANDOM");

                    testBag(randomBag1, randomBag2);

                    System.out.println("\n\nCreating bag with invalid type \"aaa\"...");
                    IBag someBag = bagFactory.makeBag("aaa");
                    System.out.println();

                    System.out.println("\n\nWould you like to quit? Type \"yes\" or \"no\":");
                    quitChoice = sc.next();
                    if (quitChoice.equals("no")) {
                        quit = false;
                    } else {
                        quit = true;
                    }

                    break;

                case 3:
                    // ========================================= 5. Sharing Surprises =========================================

                    System.out.println("\n\n\t3. Giving Surprises");

                    System.out.println("\n\na) Give surprise and applause:\n");

                    GiveSurpriseAndApplause giveSurpriseAndApplause = new GiveSurpriseAndApplause("FIFO", 1);
                    System.out.println("\nLet's put some surprises in the bag:");
                    for (ISurprise surprise : surprises1) {
                        giveSurpriseAndApplause.put(surprise);
                        surprise.enjoy();
                    }
                    System.out.println("Is the bag empty? " + giveSurpriseAndApplause.isEmpty());
                    System.out.println("\nLet's give out all the surprises!");
                    giveSurpriseAndApplause.giveAll();
                    giveSurpriseAndApplause.giveWithPassion();


                    System.out.println("\n\nb) Give surprise and hug:\n\n");

                    // putting some surprises in another bag, so we can use put(IBag bag) for giveSurpriseAndHug:
                    IBagFactory bagFactory2 = new BagFactory();
                    IBag randomBag = bagFactory2.makeBag("RANDOM");
                    System.out.println("Getting some random surprises from another bag first...");
                    for (ISurprise iSurprise : surprises1) {
                        randomBag.put(iSurprise);
                        iSurprise.enjoy();
                    }
                    GiveSurpriseAndHug giveSurpriseAndHug = new GiveSurpriseAndHug("LIFO", 2);
                    System.out.println("\nLet's put the surprises in the bag:");
                    giveSurpriseAndHug.put(randomBag);
                    System.out.println("Is the bag empty? " + giveSurpriseAndHug.isEmpty());
                    System.out.println("\nLet's give out all the surprises!");
                    giveSurpriseAndHug.giveAll();
                    giveSurpriseAndHug.giveWithPassion();


                    System.out.println("\n\nc) Give surprise and sing:\n");

                    GiveSurpriseAndSing giveSurpriseAndSing = new GiveSurpriseAndSing("RANDOM", 2);
                    System.out.println("\nLet's put some surprises in the bag:");
                    for (ISurprise iSurprise : surprises1) {
                        giveSurpriseAndSing.put(iSurprise);
                        iSurprise.enjoy();
                    }
                    System.out.println("Is the bag empty? " + giveSurpriseAndSing.isEmpty());
                    System.out.println("\nLet's give out all the surprises!");
                    giveSurpriseAndSing.giveAll();
                    giveSurpriseAndSing.giveWithPassion();

                    System.out.println("\n\nWould you like to quit? Type \"yes\" or \"no\":");
                    quitChoice = sc.next();
                    if (quitChoice.equals("no")) {
                        quit = false;
                    } else {
                        quit = true;
                    }

                    break;

                default:
                    System.out.println("Invalid choice. Please try again");
                    System.out.println("\n\nWould you like to quit? Type \"yes\" or \"no\":");
                    quitChoice = sc.next();
                    if (quitChoice.equals("no")) {
                        quit = false;
                    } else {
                        quit = true;
                    }

                    break;
            }
        }

        sc.close();
    }
}
