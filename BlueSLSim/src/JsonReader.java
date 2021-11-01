import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    private static void readJsonFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("destinations.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray destinationArray = (JSONArray) obj;

            destinationArray.forEach(destination -> parseTeamObject((JSONObject) destination));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Team parseTeamObject(JSONObject object) {
        //Get employee object within list
        JSONObject teamObject = (JSONObject) object.get("destination");
        Team team = new Team((String) teamObject.get("name"),new Rating((Integer) teamObject.get("offensivRating"),(Integer) teamObject.get("defensivRating")));
        return team;
    }
}
