public class NetzTester {
    public static void main(String[] args) {
        Resistor R1 = new Resistor(100, "R1");
        Resistor R2 = new Resistor(200, "R2");
        Resistor R3 = new Resistor(300, "R3");
        Resistor R4 = new Resistor(400, "R4");
        Resistor R5 = new Resistor(500, "R5");
        Resistor R6 = new Resistor(600, "R6");

        Net net1 = Parallel.newParallel(R1, R3);
        Net net2 = Serial.newSerial(net1, R2);
        Net net3 = Serial.newSerial(R4, R5);
        Net net4 = Parallel.newParallel(net2, net3);
        Net finalNet = Parallel.newParallel(net4,R6);

        System.out.println("Gesamtwiderstand: " + finalNet.ohm() + " Ohm");
        System.out.println("Widerstaende im Netz: " + finalNet.show());
    }
}