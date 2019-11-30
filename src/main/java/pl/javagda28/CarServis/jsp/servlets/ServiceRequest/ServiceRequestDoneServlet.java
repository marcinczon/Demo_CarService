package pl.javagda28.CarServis.jsp.servlets.ServiceRequest;

import pl.javagda28.CarServis.jsp.service.ServiceRequest.ServiceRequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SERVICE-REQUEST-DONE-SERVLET")
public class ServiceRequestDoneServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        final String serviceRequestIdNumber = req.getParameter("serviceRequestIdNumber");
        ServiceRequestService.INSTANCE.setDone(serviceRequestIdNumber);
        resp.sendRedirect("/SERVICE-REQUEST-LIST-SERVLET");
    }
}
