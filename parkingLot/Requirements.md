
 ### Requirements:
 * The parking lot should have multiple levels, each level with a certain number of parking spots.
 * The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks.
 * Each parking spot should be able to accommodate a specific type of vehicle.
 * The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits.
 * The system should track the availability of parking spots and provide real-time information to customers.
 * The system should handle multiple entry and exit points and support concurrent access. 

### Thought process
1. The parking lot should have multiple levels, each level with a certain number of parking spots: Since multiple level exists, 
    hence implicit to understand that there should be a functionality to add the levels
2. The system should handle multiple entry and exit points and support concurrent access: The functions park and unpark should 
    handle concurrency, hence the class where these functions are defined should be a thread-safe singleton class.
3. Corresponding parkVehicle and unparkVehicle functions should aslo be synchronised
