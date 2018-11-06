package api.v1.metrics.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(request, response);
    }

    public void destroy() {}
}

