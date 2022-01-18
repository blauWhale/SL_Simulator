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
    ArrayList<Player> playerArrayList = new ArrayList<>();

    /**
     * Reads a Json File
     *
     * @return a list of Teams read from a Json File
     */
    public ArrayList<Team> readJsonFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("./superLeagueTeams.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);


            parseTeamObject((JSONObject) obj);
//            parseJSONString(teamArray.toJSONString());
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

    public void parseTeamObject(JSONObject object) {

        JSONArray teamsJsonArr = (JSONArray)object.get("teams");
        for (Object o : teamsJsonArr) {
            JSONObject teamsJsonObj = (JSONObject) o;
            Team team = new Team((String) teamsJsonObj.get("name"),new Rating(Integer.parseInt((String) teamsJsonObj.get("offensivRating")) ,Integer.parseInt((String) teamsJsonObj.get("defensivRating"))));
            teamArrayList.add(team);
            JSONArray playersJsonArr = (JSONArray) teamsJsonObj.get("players");
            for (Object oPlayer : playersJsonArr) {
                JSONObject playerJsonObj = (JSONObject) oPlayer;
                if(playerJsonObj.get("position").equals("Goalkeeper")){
                    Goalkeeper goalkeeper = new Goalkeeper((String) playerJsonObj.get("name"),new Rating(Integer.parseInt((String) teamsJsonObj.get("offensivRating")) ,Integer.parseInt((String) teamsJsonObj.get("defensivRating"))),(String) playerJsonObj.get("position"));
                    playerArrayList.add(goalkeeper);
                }
                if(playerJsonObj.get("position").equals("Defender")){
                    Defender defender = new Defender((String) playerJsonObj.get("name"),new Rating(Integer.parseInt((String) teamsJsonObj.get("offensivRating")) ,Integer.parseInt((String) teamsJsonObj.get("defensivRating"))), (String) playerJsonObj.get("position"));
                    playerArrayList.add(defender);
                }
                if(playerJsonObj.get("position").equals("Midfielder")){
                    Midfielder midfielder = new Midfielder((String) playerJsonObj.get("name"),new Rating(Integer.parseInt((String) teamsJsonObj.get("offensivRating")) ,Integer.parseInt((String) teamsJsonObj.get("defensivRating"))), (String) playerJsonObj.get("position"));
                    playerArrayList.add(midfielder);
                }
                if(playerJsonObj.get("position").equals("Striker")){
                    Striker striker = new Striker((String) playerJsonObj.get("name"),new Rating(Integer.parseInt((String) teamsJsonObj.get("offensivRating")) ,Integer.parseInt((String) teamsJsonObj.get("defensivRating"))), (String) playerJsonObj.get("position"));
                    playerArrayList.add(striker);
                }
            team.setPlayers(playerArrayList);
            }
        }

    }
}
