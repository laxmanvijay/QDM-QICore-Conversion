package mat.server;

import mat.server.util.ServerConstants;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to serve up Environment specific HARP properties to the Login page.
 */
@WebServlet("/harpLogin")
public class HarpLoginServlet extends SpringRemoteServiceServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject response = new JSONObject();
        response.put("clientId", ServerConstants.getHarpClientId());
        response.put("baseUrl", ServerConstants.getHarpBaseUrl());
        response.put("harpBaseUrl", ServerConstants.getHarpSiteUrl());

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(response.toString());
        resp.getWriter().flush();
    }
}

