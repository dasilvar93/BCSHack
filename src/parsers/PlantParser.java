//package parsers;
//
//import model.Plant;
//import org.json.JSONObject;
//
//public class PlantParser {
//
//    public static Plant jsonToPlant(String input) {
//        JSONObject plantJson = new JSONObject(input);
//        String species = plantJson.getString("species");
//        double lon = plantJson.getDouble("longitude");
//        double lat = plantJson.getDouble("latitude");
//        return new Plant(species, lon, lat);
//    }
//}
