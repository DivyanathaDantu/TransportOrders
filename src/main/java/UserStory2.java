import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserStory2 extends FlightDetails{
    public static HashMap<Integer, HashMap<String, Integer>> flightsData;
    public static HashMap<Integer, Integer> flightDetailsWithCapacity = new HashMap<Integer, Integer>();

    private static void initializeData(){
        FlightDetails.initialize_map();
        flightsData = FlightDetails.get_flights_data();
        for (Integer flight : flightsData.keySet()){
            flightDetailsWithCapacity.put(flight, FlightDetails.get_flights_capacity());
        }
    }
    private static void validateAndPrintItineraries(String order, String order_destination){
        String departure = "YUL";
        for (Integer flight : flightsData.keySet()) {
            HashMap<String, Integer> destinationDayMap = map.get(flight);
            for (String destination : destinationDayMap.keySet()) {
                if(destination.equals(order_destination)){
                    if(flightDetailsWithCapacity.get(flight) == null) continue;
                    else if (flightDetailsWithCapacity.get(flight) == 1) flightDetailsWithCapacity.remove(flight);
                    else flightDetailsWithCapacity.replace(flight, flightDetailsWithCapacity.get(flight) - 1);
                    System.out.println("order: " + order + " , flightNumber: " + flight + " , departure: "
                            + departure + " , arrival: " + destination + " , day: "
                            + flightsData.get(flight).get(destination));
                }
            }
        }
    }
    public static void main(String args[]){
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            //System.out.println("Working Directory = " + System.getProperty("user.dir"));
            obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/src/resources/coding-assigment-orders.json"));
            System.out.println(obj);
        } catch (IOException | ParseException e) {
            System.out.println("File not found");
        }
        JSONObject jsonObject = (JSONObject)obj;
        initializeData();
        for (Object key : jsonObject.keySet()) {
            if (jsonObject.get(key) instanceof JSONObject) {
                JSONObject order = (JSONObject) jsonObject.get(key);
                validateAndPrintItineraries((String) key, (String) order.get("destination"));
            }
        }
        //System.out.println(orders);
    }
}
