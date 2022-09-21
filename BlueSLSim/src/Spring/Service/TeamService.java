package Spring.Service;


import Engine.MatchEngine;
import Model.LeagueTable;
import Model.Rating;
import Model.Team;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class TeamService {

    private LeagueTable leagueTable = new LeagueTable();
    private MatchEngine matchEngine = new MatchEngine();
    private ArrayList<Team> listOfTeams = leagueTable.createLeague();


    @GetMapping(value = "/teams")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ArrayList<Team> getTeams() {
        return listOfTeams;
    }

    @GetMapping(value = "/teams/sim")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ArrayList<Team> getSeasonCalc() {
        leagueTable.createLeague();
       return playRound(matchEngine,leagueTable);
    }

    @GetMapping(value = "/team/{id}/rating")
    @CrossOrigin(origins = "http://localhost:3000/")
    public Rating getRating(@PathVariable int id) {
        return listOfTeams.get(id).getRating();
    }




    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    private static ArrayList<Team> playRound(MatchEngine matchEngine, LeagueTable leagueTable) {
        ArrayList<Team> superLeagueTeams = leagueTable.getListOfTeams();
        for (int amountOfRounds = 0; amountOfRounds < 2; amountOfRounds++) {
            for (int i = 0; i <= superLeagueTeams.size() - 1; i++) {
                for (int j = 0; j <= superLeagueTeams.size() - 1; j++) {
                    if (i == j) {
                        //skip
                    } else {
                        matchEngine.calculateMatchDay(superLeagueTeams.get(i), superLeagueTeams.get(j));
                    }

                }

            }
        }

        return (superLeagueTeams);
    }



}
