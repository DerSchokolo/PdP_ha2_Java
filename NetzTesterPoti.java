/*

	Name: 		    Frederik Franzen
	Matrikelnummer: 822760

*/

public class NetzTesterPoti {
    public static void main(String[] args) {
        Resistor R1 = new Resistor(100, "R1");
        Resistor R2 = new Resistor(200, "R2");
        Resistor R3 = new Resistor(300, "R3");
        Potentiometer R4 = new Potentiometer("R4");
        Resistor R5 = new Resistor(500, "R5");
        Resistor R6 = new Resistor(600, "R6");

        Net net1 = Parallel.newParallel(R1, R3);
        Net net2 = Serial.newSerial(net1, R2);
        Net net3 = Serial.newSerial(R4, R5);
        Net net4 = Parallel.newParallel(net2, net3);
        Net finalNet = Parallel.newParallel(net4,R6);

        // 400
        // 5000

        for (double i = 400; i <= 5000; i+=200) {
            R4.setOhm(i);
            System.out.println("R4 Widerstand: " + R4.ohm() + " Ohm, Gesamtwiderstand: " + finalNet.ohm() + " Ohm");
        }
        System.out.println();
        System.out.println("Widerstaende im Netz: " + finalNet.show());
    }
}