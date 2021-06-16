package servies.servlet;

import models.ResponseData;
import org.apache.log4j.Logger;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static org.eclipse.jetty.http.HttpStatus.Code.OK;
import static utils.Constants.THANKS;

public class EndService {
    private static final Logger log = Logger.getLogger(BeginService.class);
    private int status;

    public ResponseData requestProcessing() {
        status = SC_FORBIDDEN;
        return sendEndMassage();
    }

    private ResponseData sendEndMassage(){
        status = OK.getCode();
        log.info(THANKS);
        return new ResponseData(status, THANKS);
    }
}
