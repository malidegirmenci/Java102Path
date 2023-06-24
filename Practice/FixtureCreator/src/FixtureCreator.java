import java.util.*;
public class FixtureCreator {
    List<String> teams;
    List<String> tempTeams;
    Set<Soccer> soccers;
    Set<String> playedMatches;
    List<Soccer> rematch;
    Map<Integer, Set<Soccer>> soccerMap;
    Soccer soccer;

    public FixtureCreator(List<String> teams) {

        this.teams = new ArrayList<>(teams);
        this.tempTeams = new ArrayList<>(teams);

        if (this.teams.size() % 2 != 0) {
            this.teams.add("Bay");
            this.tempTeams.add("Bay");
        }

        rematch = new ArrayList<>();
        soccerMap = new HashMap<>();
        playedMatches = new HashSet<>();
    }

    public Map<Integer, Set<Soccer>> build() {
        int week = (this.teams.size() - 1) * 2;
        int homeTeamIndex, awayTeamIndex;
        int k = 0;
        for (int i = 1; i <= week; i++) {
            soccers = new HashSet<>();
            if (i > week / 2) {
                int l = this.teams.size() / 2;
                while (l > 0) {
                    soccers.add(new Soccer(rematch.get(k).getAwayTeam(), rematch.get(k).getHomeTeam()));
                    l--;
                    k++;
                }
                this.soccerMap.put(i, soccers);
                continue;
            }
            for (int j = 0; j < this.teams.size() / 2; j++) {
                homeTeamIndex = randomIndex(tempTeams.size());
                awayTeamIndex = randomIndex(tempTeams.size());
                soccer = new Soccer(tempTeams.get(homeTeamIndex), tempTeams.get(awayTeamIndex));
                while (homeTeamIndex == awayTeamIndex || playedMatches.contains(soccer.toString())) {
                    homeTeamIndex = randomIndex(tempTeams.size());
                    awayTeamIndex = randomIndex(tempTeams.size());
                    soccer = new Soccer(tempTeams.get(homeTeamIndex), tempTeams.get(awayTeamIndex));
                }
                soccers.add(soccer);
                soccer = new Soccer(tempTeams.get(awayTeamIndex), tempTeams.get(homeTeamIndex));
                playedMatches.add(soccer.toString());

                tempTeams.remove(homeTeamIndex);
                tempTeams.remove(awayTeamIndex > homeTeamIndex ? awayTeamIndex - 1 : awayTeamIndex);
            }
            rematch.addAll(soccers);
            tempTeams.addAll(teams);

            this.soccerMap.put(i, soccers);

        }
        return this.soccerMap;
    }

    private int randomIndex(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }
}