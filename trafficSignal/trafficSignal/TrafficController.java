package trafficSignal.trafficSignal;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {
    private static TrafficController instance;
    private Map<String, Road> roads;
    
    private TrafficController(){
        this.roads = new HashMap<>();
    }

    public static synchronized TrafficController getInstance(){
        if(instance == null){
            instance = new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road){
        roads.put(road.getId(), road);
    }

    public void removeRoad(Road road){
        roads.remove(road.getId());
    }

    public void startTrafficControl(){
        for(Road road: roads.values()){
            TrafficLight trafficLight = road.getTrafficLight();
            new Thread(() -> {
                while(true){
                    try{
                        Thread.sleep(trafficLight.getDurationRed());
                        trafficLight.changeSignal(Signal.YELLOW);
                        Thread.sleep(trafficLight.getDurationYellow());
                        trafficLight.changeSignal(Signal.GREEN);
                        Thread.sleep(trafficLight.getDurationGreen());
                        trafficLight.changeSignal(Signal.RED);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void handleEmergency(Road road){
        TrafficLight trafficLight = road.getTrafficLight();
        trafficLight.changeSignal(Signal.GREEN);
        // Add other emergency handling logic here
        // ...
    }

}
