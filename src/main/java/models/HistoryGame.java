package models;

import java.util.ArrayList;
import java.util.List;

public class HistoryGame {
    List<String> historyGame = new ArrayList<>() ;

    public List<String> getHistoryGame() {
        return historyGame;
    }

    public String getLastElement() {
        return historyGame.get(historyGame.size()-1);
    }
}
