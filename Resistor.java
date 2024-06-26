public class Resistor extends Net {
    private final double resistance;

    public Resistor(double resistance, String id) {
        this.resistance = resistance;
        this.resistors = new String[] {id};
    }

    public double ohm() {
        return this.resistance;
    }
}