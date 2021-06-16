package server.context;

import org.eclipse.jetty.servlet.ServletHandler;
import server.endpoints.BeginServlet;
import server.endpoints.EndServlet;
import server.endpoints.NextWordServlet;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

import static utils.AppContext.getAppContext;

public class ServletHandlerProvider {
    public static ServletHandler getServletHandler() {

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(BeginServlet.class, getAppContext().getProperty().getBeginMapping());
        handler.addServletWithMapping(NextWordServlet.class, getAppContext().getProperty().getNextWordMapping());
        handler.addServletWithMapping(EndServlet.class, getAppContext().getProperty().getEndMapping());
        handler.addFilterWithMapping(CORSFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
        return handler;

    }
}
