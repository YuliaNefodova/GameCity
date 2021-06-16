package utils;

import models.HistoryGame;
import servies.ServerStarter;
import servies.servlet.BeginService;
import servies.servlet.EndService;
import servies.servlet.NextWordService;

public class AppContext {
    public static AppContext appContext = new AppContext();
    private final Property property = new Property();
    private final ServerStarter serverStarter = new ServerStarter();
    private final BeginService beginService = new BeginService();
    private final NextWordService nextWordService = new NextWordService();
    private final EndService endService = new EndService();
    private final HistoryGame historyGame = new HistoryGame();


    public static AppContext getAppContext() {
        return appContext;
    }

    public Property getProperty() {
        return property;
    }

    public ServerStarter getServerStarter() {
        return serverStarter;
    }

    public BeginService getBeginService() {
        return beginService;
    }

    public NextWordService getNextWordService() {
        return nextWordService;
    }

    public EndService getEndService() {
        return endService;
    }

    public HistoryGame getHistoryGame() {
        return historyGame;
    }
}
