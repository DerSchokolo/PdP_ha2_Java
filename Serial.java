/*

	Name: 		    Frederik Franzen
	Matrikelnummer: 822760

*/

public class Serial extends Net {
    private final Net net1;
    private final Net net2;

    private Serial(Net net1, Net net2) {
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

    public static Serial newSerial(Net net1, Net net2) {
        if (checkIDs(net1, net2)) {
            System.out.println("Error: ID Konflikt");
            return null;
        }
        return new Serial(net1, net2);
    }

    public double ohm() {
        return net1.ohm() + net2.ohm();
    }
}