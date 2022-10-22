import java.util.HashMap;

public class FlightDetails {

  int capacity = 20;
  static HashMap<Integer, HashMap<String, Integer>> map = new HashMap<Integer, HashMap<String, Integer>>();

  public FlightDetails() {}

  public FlightDetails(int capacity, HashMap<Integer, HashMap<String, Integer>> map1) {
    this.capacity = capacity;
    map = map1;
  }

  public static void initialize_map() {

    map.put(1, new HashMap<String, Integer>() {
      {
        put("YYZ", 1);
      }
    });

    map.put(2, new HashMap<String, Integer>() {
      {
        put("YYC", 1);
      }
    });

    map.put(3, new HashMap<String, Integer>() {
      {
        put("YVR", 1);
      }
    });

    map.put(4, new HashMap<String, Integer>() {
      {
        put("YYZ", 2);
      }
    });

    map.put(5, new HashMap<String, Integer>() {
      {
        put("YYC", 2);
      }
    });

    map.put(6, new HashMap<String, Integer>() {
      {
        put("YVR", 2);
      }
    });

  }

  public int get_flights_capacity() {
    return this.capacity;
  }

  public static HashMap<Integer, HashMap<String, Integer>> get_flights_data() {
    return map;
  }

  public static void main(String[] args) {
    System.out.println("Flight details class....");
    initialize_map();
    HashMap<Integer, HashMap<String, Integer>> default_map = get_flights_data();
    System.out.println("Mappings of HashMap default_map are : "+ default_map);
  }
  
}
