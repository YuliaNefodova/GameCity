package servies.servlet;

import models.ResponseData;
import utils.AppContext;
import java.util.Random;
import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static org.eclipse.jetty.http.HttpStatus.Code.OK;
import static utils.Constants.*;

import org.apache.log4j.Logger;

public class BeginService {
    private static final Logger log = Logger.getLogger(BeginService.class);
    private int status;

    public ResponseData requestProcessing() {
        status = SC_FORBIDDEN;
        return begin();
    }

    private ResponseData begin() {
        int rnd = new Random().nextInt(CITIES.length);
        status = OK.getCode();
        AppContext.getAppContext().getHistoryGame().getHistoryGame().add(CITIES[rnd]);
        log.info(FIRST_MOVE + CITIES[rnd]);
        return new ResponseData(status, CITIES[rnd]);
    }

}
