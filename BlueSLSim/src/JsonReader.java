import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A JsonReader for a Teamsheet
 */
public class JsonReader {
    ArrayList<Team> teamArrayList = new ArrayList<>();

    /**
     * Reads a Json File
     *
     * @return a list of Teams read from a Json File
     */
    public ArrayList<Team> readJsonFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("BlueSLSim/json.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray teamArray = (JSONArray) obj;

            parseJSONString(teamArray.toJSONString());
            return teamArrayList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teamArrayList;
    }


    /**
     * Parser for Jsonobjects read by a JsonReader
     *
     * Adds the objects to an Arraylist
     *
     * param object JsonObject of anykind
     */
    public static List parseJSONString(String jsonStr) throws Exception {
        List<String> keyList = new ArrayList<String>();
        JSONObject authorJsonObj = (JSONObject) new JSONParser().parse(jsonStr);

        JSONArray teamsJsonArr = (JSONArray)authorJsonObj.get("teams");
        for (Object o : teamsJsonArr) {
            JSONObject teamsJsonObj = (JSONObject) o;
            String isMulti = (String) teamsJsonObj.get("IsMulti");
            String defensivRating = "" + teamsJsonObj.get("defensivRating");
            String name = (String) teamsJsonObj.get("name");
            String offensivRating = "" + teamsJsonObj.get("offensivRating");
            JSONArray playersJsonArr = (JSONArray) teamsJsonObj.get("players");
            for (Object value : playersJsonArr) {
                JSONObject playersJsonObj = (JSONObject) value;
                String isMultiOf = (String) playersJsonObj.get("IsMulti");
                String defensivRatingOf = "" + playersJsonObj.get("defensivRating");
                String nameOf = (String) playersJsonObj.get("name");
                String offensivRatingOf = "" + playersJsonObj.get("offensivRating");
                String position = (String) playersJsonObj.get("position");
            }
        }
        return keyList;
    }
}
