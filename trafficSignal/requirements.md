### Requirements
* The traffic signal system should control the flow of traffic at an intersection with multiple roads.
* The system should support different types of signals, such as red, yellow, and green.
* The duration of each signal should be configurable and adjustable based on traffic conditions.
* The system should handle the transition between signals smoothly, ensuring safe and efficient traffic flow.
* The system should be able to detect and handle emergency situations, such as an ambulance or fire truck approaching the intersection.
* The system should be scalable and extensible to support additional features and functionality.

### Follow-ups
1. What design changes would you make to support adding and removing observers dynamically?
2. What design patterns might be useful for extending the functionality of the TrafficLight class?
3. The notifyObservers method currently prints a message. How would you extend this method to support a more robust observer pattern (e.g., notifying multiple observers)?