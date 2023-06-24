import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> teams = Arrays.asList("Manchester United", "Arsenal", "Aston Villa",
                "Chelsea", "Liverpool",
                "Derby", "Southampton");

        FixtureCreator fixtureBuilder = new FixtureCreator(teams);
        Map<Integer, Set<Soccer>> soccerMap = fixtureBuilder.build();

        for (Map.Entry<Integer, Set<Soccer>> entry : soccerMap.entrySet()) {
            System.out.println("----------------------------");
            System.out.println("Week " + entry.getKey());
            System.out.println("----------------------------");
            for (Soccer soccer : entry.getValue()) {
                System.out.println(soccer.toString());
            }
            System.out.println("----------------------------");
            System.out.println();
        }
    }

}