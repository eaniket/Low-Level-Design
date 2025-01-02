package trafficSignal.trafficSignal;

public class TrafficLight {
    private String id;
    private Integer durationRed;
    private Integer durationYellow;
    private Integer durationGreen;
    private Signal currentSignal;

    public TrafficLight(String id, Integer durationRed, Integer durationYellow, Integer durationGreen) {
        this.id = id;
        this.durationRed = durationRed;
        this.durationYellow = durationYellow;
        this.durationGreen = durationGreen;
        this.currentSignal = Signal.RED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDurationRed() {
        return durationRed;
    }

    public void setDurationRed(Integer durationRed) {
        this.durationRed = durationRed;
    }

    public Integer getDurationYellow() {
        return durationYellow;
    }

    public void setDurationYellow(Integer durationYellow) {
        this.durationYellow = durationYellow;
    }

    public Integer getDurationGreen() {
        return durationGreen;
    }

    public void setDurationGreen(Integer durationGreen) {
        this.durationGreen = durationGreen;
    }

    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public synchronized void changeSignal(Signal signal) {
        this.currentSignal = signal;
        notifyObservers();
    }    

    private void notifyObservers(){
        System.out.println("Signal change on: " + id + "; current singal: " + currentSignal);
        // other ways to notify observers
        // ...
    }    

}
