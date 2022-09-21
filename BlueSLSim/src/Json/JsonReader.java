package Json;

import Model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * A Json.JsonReader for a Teamsheet
 */
public class JsonReader {
    private ArrayList<Team> teamArrayList = new ArrayList<>();

    /**
     * Reads a Json File
     *
     * @return a list of Teams read from a Json File
     */
    public ArrayList<Team> readJsonFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("superLeagueTeams.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            parseTeamObject((JSONObject) obj);
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
     * Methode to get Teams and their players from a JSON Files
     * @param object -> Json file to read
     * @throws JSONIllegalPlayerPositionException -> if Typo in Position of Model.Player Exception will be thrown
     */
    public void parseTeamObject(JSONObject object) throws JSONIllegalPlayerPositionException {

        JSONArray teamsJsonArr = (JSONArray)object.get("teams");
        for (Object o : teamsJsonArr) {
            JSONObject teamsJsonObj = (JSONObject) o;
            Team team = new Team((String) teamsJsonObj.get("name"),new Rating(Integer.parseInt((String) teamsJsonObj.get("elo"))));
            teamArrayList.add(team);
            ArrayList<Player> playerArrayList = new ArrayList<>();
            JSONArray playersJsonArr = (JSONArray) teamsJsonObj.get("players");
            for (Object oPlayer : playersJsonArr) {
                JSONObject playerJsonObj = (JSONObject) oPlayer;
                String position = (String) playerJsonObj.get("position");
                switch (position) {
                    case "Goalkeeper" -> {
                        Goalkeeper goalkeeper = new Goalkeeper((String) playerJsonObj.get("name"), new Rating(Integer.parseInt((String) playerJsonObj.get("offensivRating")), Integer.parseInt((String) playerJsonObj.get("defensivRating"))), (String) playerJsonObj.get("position"));
                        playerArrayList.add(goalkeeper);
                    }
                    case "Defender" -> {
                        Defender defender = new Defender((String) playerJsonObj.get("name"), new Rating(Integer.parseInt((String) playerJsonObj.get("offensivRating")), Integer.parseInt((String) playerJsonObj.get("defensivRating"))), (String) playerJsonObj.get("position"));
                        playerArrayList.add(defender);
                    }
                    case "Midfielder" -> {
                        Midfielder midfielder = new Midfielder((String) playerJsonObj.get("name"), new Rating(Integer.parseInt((String) playerJsonObj.get("offensivRating")), Integer.parseInt((String) playerJsonObj.get("defensivRating"))), (String) playerJsonObj.get("position"));
                        playerArrayList.add(midfielder);
                    }
                    case "Striker" -> {
                        Striker striker = new Striker((String) playerJsonObj.get("name"), new Rating(Integer.parseInt((String) playerJsonObj.get("offensivRating")), Integer.parseInt((String) playerJsonObj.get("defensivRating"))), (String) playerJsonObj.get("position"));
                        playerArrayList.add(striker);
                    }
                    default -> throw new JSONIllegalPlayerPositionException();
                }
            team.setPlayers(playerArrayList);
            }
        }

    }
}
