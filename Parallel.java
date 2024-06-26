public class Parallel extends Net {
    private final Net net1;
    private final Net net2;

    private Parallel(Net net1, Net net2) {
        this.net1 = net1;
        this.net2 = net2;

        this.resistors = mergeResistors(net1.resistors, net2.resistors);
    }

    private String[] mergeResistors(String[] r1, String[] r2) {
        String[] merged = new String[r1.length + r2.length];
        System.arraycopy(r1, 0, merged, 0, r1.length);
        System.arraycopy(r2, 0, merged, r1.length, r2.length);
        return merged;
    }

    public static Parallel newParallel(Net net1, Net net2) {
        if (checkIDs(net1, net2)) {
            System.out.println("Error: Conflicting IDs.");
            return null;
        }
        return new Parallel(net1, net2);
    }

    public double ohm() {
        return 1 / ((1 / net1.ohm()) + (1 / net2.ohm()));
    }
}