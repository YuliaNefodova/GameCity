package servies;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import server.context.ServletHandlerProvider;
import utils.AppContext;

public class ServerStarter {

    private static final Logger log = Logger.getLogger(ServerStarter.class);

    public void startServer() {
        try {
            Server server = new Server(Integer.parseInt(AppContext.getAppContext().getProperty().getPort()));
            HandlerList handlerList = new HandlerList();
            server.setHandler(handlerList);
            handlerList.addHandler(ServletHandlerProvider.getServletHandler());
            server.start();
            server.join();
        } catch (Exception e) {
            log.error("Server start error: " + e.getMessage());
            System.exit(-1);
        }
    }
}
