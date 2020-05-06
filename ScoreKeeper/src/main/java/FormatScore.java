

public class FormatScore {

     public String formatScoreString(int scoreTeamA, int scoreTeamB) {

      return String.format("%03d", scoreTeamA)+ ":" + String.format("%03d", scoreTeamB);

    }
}
