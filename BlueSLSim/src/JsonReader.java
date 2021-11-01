import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReader {
    ArrayList<Team> teamArrayList = new ArrayList<>();
    public ArrayList<Team> readJsonFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("superLeagueTeams.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray teamArray = (JSONArray) obj;

            teamArray.forEach(team -> parseTeamObject((JSONObject) team));

            return teamArrayList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return teamArrayList;
    }

    public void parseTeamObject(JSONObject object) {
        //Get employee object within list
        JSONObject teamObject = (JSONObject) object.get("team");
        Team team = new Team((String) teamObject.get("name"),new Rating(Integer.parseInt((String) teamObject.get("offensivRating")) ,Integer.parseInt((String) teamObject.get("defensivRating"))));
        teamArrayList.add(team);
    }
}
