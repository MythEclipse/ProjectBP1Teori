package asepharyana.projectbp1teori;
import java.util.HashMap;
import java.util.Map;

public class JSONObject {
    private Map<String, String> map;

    public JSONObject(String json) {
        map = new HashMap<>();
        json = json.trim().substring(1, json.length() - 1); // Remove curly braces
        String[] keyValuePairs = json.split(",");
        for (String pair : keyValuePairs) {
            String[] entry = pair.split(":", 2); // Split into two parts only
            String key = entry[0].trim().replace("\"", "");
            String value = entry[1].trim().replace("\"", "");
            map.put(key, value);
        }
    }

    public String getString(String key) {
        return map.get(key);
    }
}
