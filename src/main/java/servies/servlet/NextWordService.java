package servies.servlet;

import models.ResponseData;
import org.apache.log4j.Logger;
import utils.AppContext;
import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static org.eclipse.jetty.http.HttpStatus.Code.OK;
import static utils.Constants.*;

public class NextWordService {
    private static final Logger log = Logger.getLogger(NextWordService.class);
    private int status;

    public ResponseData requestProcessing(String requestData) {
        status = SC_FORBIDDEN;
        if (validationRequest(requestData)) {
            AppContext.getAppContext().getHistoryGame().getHistoryGame().add(requestData);
            log.info(USER_MOVE + requestData);
            return getNextWord(requestData);
        }
        return new ResponseData(status, DOES_NOT_MATCH);
    }

    private ResponseData getNextWord(String city) {
        status = OK.getCode();
        return new ResponseData(status, getCityFromList(getLastChar(city)));
    }

    private String getCityFromList (Character lastChar) {
        for (String city : CITIES) {
            if (lastChar.equals(city.charAt(0))) {
                AppContext.getAppContext().getHistoryGame().getHistoryGame().add(city);
                log.info(COMPUTER_MOVE + city);
                return city;
            }
        }
        return null;
    }

    private Character getLastChar(String city) {
        return city.toUpperCase().charAt(city.length() - 1);
    }

    public static Character getFirstChar(String city) {
        return city.charAt(0);
    }

    private Boolean validationRequest(String requestData) {
        String lastElementHistoryGame = AppContext.getAppContext().getHistoryGame().getLastElement();
        return getLastChar(lastElementHistoryGame).equals(getFirstChar(requestData));
    }
}
