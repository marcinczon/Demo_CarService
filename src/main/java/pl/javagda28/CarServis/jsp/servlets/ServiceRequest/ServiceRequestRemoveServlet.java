package pl.javagda28.CarServis.jsp.servlets.ServiceRequest;

import pl.javagda28.CarServis.jsp.model.ServiceRequest.ServiceRequest;
import pl.javagda28.CarServis.jsp.service.ServiceRequest.ServiceRequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SERVICE-REQUEST-REMOVE-SERVLET")
public class ServiceRequestRemoveServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        final Double serviceRequestIdNumber = Double.valueOf(req.getParameter("serviceRequestIdNumber"));
        ServiceRequestService.INSTANCE.removeServiceRequest(serviceRequestIdNumber);
        resp.sendRedirect("/SERVICE-REQUEST-LIST-SERVLET");

    }
}
