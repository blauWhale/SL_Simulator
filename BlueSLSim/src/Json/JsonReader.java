package Json;

import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public ArrayList<Team> scanJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LeagueTable teams = objectMapper.readValue(this.getClass().getClassLoader().getResource("superLeagueTeams.json"), LeagueTable.class);
            return teams.getTeams();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return teamArrayList;

    }
}
