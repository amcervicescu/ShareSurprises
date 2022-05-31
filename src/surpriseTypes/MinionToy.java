package surpriseTypes;


public class MinionToy implements ISurprise{
    private final String name;
    private static int counter = 0;

    private MinionToy(String name) {
        this.name = name;
    }

    @Override
    public void enjoy() {
        System.out.println("The minion's name is " + name + ".");
    }

    public static MinionToy generate() {
        String[] minionNames = {"Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim"};
        MinionToy minionToy = new MinionToy(minionNames[counter]);
        counter++;
        if (counter == minionNames.length) {
            counter = 0;
        }
        return minionToy;
    }
}