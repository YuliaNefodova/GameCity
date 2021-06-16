package server.endpoints;

import models.ResponseData;
import utils.AppContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static utils.Constants.MAPPING_BEGIN;

@WebServlet(MAPPING_BEGIN)
public class BeginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseData responseData = AppContext.getAppContext().getBeginService().requestProcessing();
        response.setStatus(responseData.getCode());
        response.getWriter().println(responseData.getMessage());
    }
}
