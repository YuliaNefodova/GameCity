package server.context;

import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter implements Filter {
    public static final Logger log = Logger.getLogger(CORSFilter.class);

    public CORSFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        log.info("CORSFilter HTTP Request: " +
                ((HttpServletRequest) request).getMethod());
        ((HttpServletResponse) response)
                .addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) response)
                .addHeader("Access-Control-Allow-Methods",
                        "GET, OPTIONS, HEAD, PUT, POST");
        HttpServletResponse resp = (HttpServletResponse) response;

        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}
