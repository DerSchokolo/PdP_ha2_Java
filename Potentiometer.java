public class Potentiometer extends Net {
    private double resistance;

    public Potentiometer(String id) {
        this.resistors = new String[] { id };
        this.resistance = 0.0;
    }

    public void setOhm(double value) {
        this.resistance = value;
    }

    public double ohm() {
        return resistance;
    }
}