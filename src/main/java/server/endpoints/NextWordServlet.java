package server.endpoints;

import models.ResponseData;
import org.apache.log4j.Logger;
import servies.servlet.NextWordService;
import utils.AppContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import static utils.Constants.CITIES;
import static utils.Constants.MAPPING_NEXT;

@WebServlet(MAPPING_NEXT)
public class NextWordServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(NextWordServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseData responseData = AppContext.getAppContext().getNextWordService().requestProcessing(formatParam(request));
        response.setStatus(responseData.getCode());
        response.getWriter().println(responseData.getMessage());
    }

    private String formatParam(HttpServletRequest request) {
        String param = request.getParameterMap().entrySet().stream()
                .map(entry -> {
                    String par = String.join("", entry.getValue());
                    return par;
                }).collect(Collectors.joining());
    return param;
    }

}
