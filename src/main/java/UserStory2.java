import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserStory2 extends FlightDetails{
    private static void validateAndPrintIterneraries(JSONObject order){
        FlightDetails.initialize_map();
        HashMap<Integer, HashMap<String, Integer>> flights_data = FlightDetails.get_flights_data();

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
        ArrayList<JSONObject> orders = new ArrayList<>();

        for (Object key : jsonObject.keySet()) {
            if (jsonObject.get(key) instanceof JSONObject) {
                JSONObject order = (JSONObject) jsonObject.get(key);
                validateAndPrintIterneraries(order);
            }
        }
        System.out.println(orders);
    }
}
