public abstract class Net {
    protected String[] resistors;

    public abstract double ohm();

    public String show() {
        String output = "";
        for (int i = 0; i < resistors.length; i++) {
           output = output + " " + resistors[i];
        }
        return output;
    }

    public static boolean checkIDs(Net net1, Net net2) {
        for (int i = 0; i < net1.resistors.length; i++) {
            for (int j = 0; j < net2.resistors.length; j++) {
                if (net1.resistors[i] == net2.resistors[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}