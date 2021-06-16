package server.endpoints;

import models.ResponseData;
import utils.AppContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static utils.Constants.MAPPING_END;

@WebServlet(MAPPING_END)
public class EndServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseData responseData = AppContext.getAppContext().getEndService().requestProcessing();
        response.setStatus(responseData.getCode());
        response.getWriter().println(responseData.getMessage());
    }
}
