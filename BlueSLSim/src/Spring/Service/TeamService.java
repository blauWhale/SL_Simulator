package Spring.Service;


import Engine.MatchEngine;
import Model.LeagueTable;
import Model.Player;
import Model.Rating;
import Model.Team;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Scanner;


@RestController
public class TeamService {

    private LeagueTable leagueTable = new LeagueTable();
    private MatchEngine matchEngine = new MatchEngine();


    @GetMapping(value = "/teams")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ArrayList<Team> getTeams() {
        return leagueTable.createLeague();
    }

    @GetMapping(value = "/teams/sim")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ArrayList<Team> getSeasonCalc() {
        leagueTable.createLeague();
       return leagueTable.sortLeagueTable(playRound(matchEngine,leagueTable));
    }

    @GetMapping(value = "/teams/sim-elo")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ArrayList<Team> getSeasonCalcElo() {
        leagueTable.createLeague();
        return leagueTable.sortLeagueTable(playRoundElo(matchEngine,leagueTable));
    }

    @GetMapping(value = "/team/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public Team getTeam(@PathVariable int id)    {
        return leagueTable.createLeague().get(id);
    }

    @GetMapping(value = "/teams/sim/{amount}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ArrayList<Team> getSeasonCalcXAmount(@PathVariable int amount) {
        ArrayList<Team> winners = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            leagueTable.createLeague();
            leagueTable.sortLeagueTable(playRound(matchEngine, leagueTable));
            winners.add(leagueTable.getTeams().get(0));
        }
        return winners;
    }

    @GetMapping(value = "/players")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> bestPlayers = new ArrayList<>();
        for(Team team:leagueTable.createLeague()){
            bestPlayers.addAll(team.getPlayers());
        }
        return bestPlayers;
    }








    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    private static ArrayList<Team> playRound(MatchEngine matchEngine, LeagueTable leagueTable) {
        ArrayList<Team> superLeagueTeams = leagueTable.getTeams();
        for (int amountOfRounds = 0; amountOfRounds < 2; amountOfRounds++) {
            for (int i = 0; i <= superLeagueTeams.size() - 1; i++) {
                for (int j = 0; j <= superLeagueTeams.size() - 1; j++) {
                    if (i == j) {
                        //skip
                    } else {
                        matchEngine.calculateMatchDayPlayers(superLeagueTeams.get(i), superLeagueTeams.get(j));
                    }

                }

            }
        }
        return (superLeagueTeams);
    }

    private static ArrayList<Team> playRoundElo(MatchEngine matchEngine, LeagueTable leagueTable) {
        ArrayList<Team> superLeagueTeams = leagueTable.getTeams();
        for (int amountOfRounds = 0; amountOfRounds < 2; amountOfRounds++) {
            for (int i = 0; i <= superLeagueTeams.size() - 1; i++) {
                for (int j = 0; j <= superLeagueTeams.size() - 1; j++) {
                    if (i == j) {
                        //skip
                    } else {
                        matchEngine.calculateMatchDayElo(superLeagueTeams.get(i), superLeagueTeams.get(j));
                    }

                }

            }
        }
        return (superLeagueTeams);
    }


}
