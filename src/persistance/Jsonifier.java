package persistance;

import model.Plant;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Jsonifier {

    public static JSONObject plantToJson(Plant p) {
        JSONObject plantJson = new JSONObject();
        plantJson.put("species", p.getSpecies());
        plantJson.put("longitude", p.getLong());
        plantJson.put("latitude", p.getLat());
        return plantJson;
    }

    public static JSONArray plantsToJson(List<Plant> plants) {
        JSONArray plantsJson = new JSONArray();
        for (Plant p : plants) {
            plantsJson.put(plantToJson(p));
        }
        return plantsJson;
    }

}
