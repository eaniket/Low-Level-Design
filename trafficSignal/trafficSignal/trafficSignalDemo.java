package trafficSignal.trafficSignal;

public class trafficSignalDemo {
    public static void run(){
        TrafficController trafficController = TrafficController.getInstance();
    
        // Create roads
        Road r1 = new Road("r1", "Main ORR");
        Road r2 = new Road("r2", "Park Avenue");
        Road r3 = new Road("r3", "Elm Street");
        Road r4 = new Road("r4", "Broadway");
    
        // Create Traffic Lights
        TrafficLight tl1 = new TrafficLight("t1", 6000, 6000, 7000);
        TrafficLight tl2 = new TrafficLight("t2", 5000, 5000, 7000);
        TrafficLight tl3 = new TrafficLight("t3", 6000, 7000, 8000);
        TrafficLight tl4 = new TrafficLight("t4", 6000, 7000, 5000);
    
        // Set Traffic Lights to roads mapping
        r1.setTrafficLight(tl1);
        r2.setTrafficLight(tl2);
        r3.setTrafficLight(tl3);
        r4.setTrafficLight(tl4);
    
        // Add roads to trafficController
        trafficController.addRoad(r1);
        trafficController.addRoad(r2);
        trafficController.addRoad(r3);
        trafficController.addRoad(r4);
    
        // Start traffic flow
        trafficController.startTrafficControl();
    
        // Simulate Emergency on a particular road
        trafficController.handleEmergency(r3);
    }

    public static void main(String[] args) {
        run();
    }
}
