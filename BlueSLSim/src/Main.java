import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeagueTable leagueTable = new LeagueTable();
        MatchEngine matchEngine = new MatchEngine();
        ArrayList<Team> superLeagueTeams = leagueTable.createLeague();
        System.out.println("Choose your team:");
        for (int team = 0; team < superLeagueTeams.size(); team++) {
            System.out.println("[" + (team) + "] " + superLeagueTeams.get(team).getTeamName().toString());
        }

        String input = scanner.nextLine();
        String team = superLeagueTeams.get(Integer.parseInt(input)).getTeamName();
        System.out.println("You chose " + team);

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
                    default -> throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter a number from 1-2 or 0 to close");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void simOnce(LeagueTable leagueTable, MatchEngine matchEngine, String team) {
        leagueTable.showLeagueTable(playRound(matchEngine, leagueTable));
        int placement = 0;
        for (int i = 0; i < leagueTable.listOfTeams.size(); i++) {
            if (leagueTable.listOfTeams.get(i).getTeamName().equals(team)) {
                placement = leagueTable.listOfTeams.indexOf(leagueTable.listOfTeams.get(i)) + 1;
            }
        }
        System.out.println(team + " placed " + placement + ".");
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

    private static void simXAmount(MatchEngine matchEngine, LeagueTable leagueTable, String team) {
        int counter = 0;
        System.out.println("How many times should we simulate the league? (Sim will stop if you win the leauge)");
        Scanner scanner = new Scanner(System.in);
        int amount = Integer.parseInt(scanner.nextLine());
        boolean winner = false;
        for (int i = 0; i < amount; i++) {
            leagueTable.createLeague();
            leagueTable.sortLeagueTable(playRound(matchEngine, leagueTable));
            if (leagueTable.listOfTeams.get(0).getTeamName().equals(team)) {
                leagueTable.showLeagueTable(leagueTable.listOfTeams);
                System.out.println("It took " + counter + " seasons to win the league");
                winner = true;
                break;
            } else {
                counter++;
            }
        }
        if (!winner) {
            System.out.println("Even after " + counter + " years, " + team + " didn't win the league!");
        }

    }

    public static void uibuilder(MatchEngine matchEngine, LeagueTable leagueTable) {
        final String[] selectedTeam = new String[1];
        ArrayList<Team> superLeagueTeams = leagueTable.createLeague();
        //Layout
        FlowLayout layout = new FlowLayout();
        JFrame frame = new JFrame();
        frame.setLayout(layout);
        frame.setSize(600, 600);

        //Label
        ImageIcon footballIcon = new ImageIcon("BlueSLSim/resources/football.png");
        JLabel label = new JLabel("Choose your Team: ",
                footballIcon,
                SwingConstants.CENTER);


        //Dropdown
        String[] teamsArry = getStringArray(superLeagueTeams);
        JComboBox<String> teamlist = new JComboBox<>(teamsArry);
        teamlist.setSelectedIndex(0);
        teamlist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String selectedItem = (String) cb.getSelectedItem();
                selectedTeam[0] = selectedItem;
            }
        });
        teamlist.setSize(new Dimension(100, 100));

        //Button
        JButton button = new JButton();
        button.setText("Simulate a round");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leagueTable.setListOfTeams(leagueTable.createLeague());
                playRound(matchEngine, leagueTable);
                leagueTable.showLeagueTable(superLeagueTeams);
                frame.add(new JLabel(selectedTeam[0] + "is your Team"));
                JTable table = tableBuilder(superLeagueTeams);
                frame.add(new JScrollPane(table), 0);
                frame.revalidate();
                frame.validate();
                frame.repaint();
            }
        });


        //add the frame
        frame.add(label);
        frame.add(teamlist);
        frame.add(button);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setVisible(true);

    }

    private static JTable tableBuilder(ArrayList<Team> superLeagueTeams) {
        //Table
        //headers for the table
        String[] columns = {
                "Pos.", "Name", "Games", "Points", "TD", "Results"
        };
        Object[][] data = new Object[10][6];
        for (int i = 0; i < superLeagueTeams.size(); i++) {
            data[i][0] = i + 1 + ".";
            data[i][1] = superLeagueTeams.get(i).getTeamName();
            data[i][2] = superLeagueTeams.get(i).getGames();
            data[i][3] = superLeagueTeams.get(i).getPoints();
            data[i][4] = superLeagueTeams.get(i).getGoalsScored() + ":" + superLeagueTeams.get(i).getGoalsConceded();
            data[i][5] = "W" + superLeagueTeams.get(i).getWins() + "D" + superLeagueTeams.get(i).getDraws() + "L" + superLeagueTeams.get(i).getLoses();


        }

        //create table with data
        JTable table = new JTable(data, columns);
        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 1) {
                column.setPreferredWidth(150); //third column is bigger
            } else {
                column.setPreferredWidth(30);
            }
        }
        return table;
    }


    public static String[] getStringArray(ArrayList<Team> arr) {

        // declaration and initialise String Array
        String str[] = new String[arr.size()];

        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {

            // Assign each value to String array
            str[j] = arr.get(j).getTeamName();
        }

        return str;
    }
}
