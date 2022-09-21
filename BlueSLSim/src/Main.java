import Engine.MatchEngine;
import Model.LeagueTable;
import Model.Team;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main Class and first point of contact for the user
 */
public class Main {
    /**
     * Main methode of the Super League Simulator
     * @param args
     * @throws MenuException
     */
    public static void main(String[] args) throws MenuException {
        Scanner scanner = new Scanner(System.in);
        LeagueTable leagueTable = new LeagueTable();
        MatchEngine matchEngine = new MatchEngine();
        menuPrinter(scanner, leagueTable, matchEngine);
    }

    /**
     * Prints the Menu and takes care of user Input
     *
     * @param scanner Scanner to read user input
     * @param leagueTable Table to alter during matchdays
     * @param matchEngine matchEngine to use for matchdays
     * @throws MenuException
     */
    private static void menuPrinter(Scanner scanner, LeagueTable leagueTable, MatchEngine matchEngine) throws MenuException {
        ArrayList<Team> superLeagueTeams = leagueTable.createLeague();
        System.out.println("Choose your team:");
        for (int teamNumber = 0; teamNumber < superLeagueTeams.size(); teamNumber++) {
            System.out.println("[" + (teamNumber) + "] " + superLeagueTeams.get(teamNumber).getTeamName().toString());
        }
        String team;
        try {
            String input = scanner.nextLine();
            team = superLeagueTeams.get(Integer.parseInt(input)).getTeamName();
            System.out.println("You chose " + team);
        } catch (IndexOutOfBoundsException e) {
            throw new MenuException("Choose one of the teams listed (0-9)");


        } catch (NumberFormatException e) {
            throw new MenuException("Please type a number");
        }
        System.out.println("Would you like to ...");
        int choice = -1;
        do {
            System.out.println(" Menu-Choice");
            System.out.println(" [1] Simulate once");
            System.out.println(" [2] Simulate an amount or until you win the league");
            System.out.println(" [0] Close programm");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> simOnce(leagueTable, matchEngine, team);
                    case 2 -> simXAmount(matchEngine, leagueTable, team);
                    case 0 -> System.out.println("Program closed");
                    default -> throw new MenuException("Choose one of the options in the menu (0-2)");
                }
            } catch (MenuException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 0);
        scanner.close();
    }

    /**
     * Simulates the Super League season once complete
     * Prints your Teams standing at the end of the season
     *
     * @param leagueTable
     * @param matchEngine
     * @param team
     */
    private static void simOnce(LeagueTable leagueTable, MatchEngine matchEngine, String team) {
        leagueTable.createLeague();
        leagueTable.showLeagueTable(playRound(matchEngine, leagueTable));
        int placement = 0;
        for (int i = 0; i < leagueTable.getListOfTeams().size(); i++) {
            if (leagueTable.getListOfTeams().get(i).getTeamName().equals(team)) {
                placement = leagueTable.getListOfTeams().indexOf(leagueTable.getListOfTeams().get(i)) + 1;
            }
        }
        System.out.println(team + " placed " + placement + ".");
    }


    /**
     * Simulates the Super League season once complete
     *
     * @param matchEngine
     * @param leagueTable
     * @return an altered Arraylist of Teams, after an completed season
     */
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

    /**
     * Simulates the Super League an X amount of Times after user input
     * Stops when selected Model.Team won the league
     *
     * @param matchEngine
     * @param leagueTable
     * @param team
     */
    private static void simXAmount(MatchEngine matchEngine, LeagueTable leagueTable, String team) {
        int counter = 0;
        System.out.println("How many times should we simulate the league? (Sim will stop if you win the leauge)");
        Scanner scanner = new Scanner(System.in);
        int amount = Integer.parseInt(scanner.nextLine());
        boolean winner = false;
        for (int i = 0; i < amount; i++) {
            leagueTable.createLeague();
            leagueTable.sortLeagueTable(playRound(matchEngine, leagueTable));
            if (leagueTable.getListOfTeams().get(0).getTeamName().equals(team)) {
                leagueTable.showLeagueTable(leagueTable.getListOfTeams());
                System.out.println("It took " + counter + " seasons to win the league");
                winner = true;
                break;
            } else {
                counter++;
            }
        }
        if (!winner) {
            System.out.println("The league table in year " + counter);
            leagueTable.showLeagueTable(leagueTable.getListOfTeams());
            System.out.println("Even after " + counter + " years, " + team + " didn't win the league!");
        }

    }


}
