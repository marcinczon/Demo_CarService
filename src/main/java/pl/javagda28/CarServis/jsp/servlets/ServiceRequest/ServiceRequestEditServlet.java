package pl.javagda28.CarServis.jsp.servlets.ServiceRequest;

import pl.javagda28.CarServis.jsp.model.ServiceRequest.ServiceRequest;
import pl.javagda28.CarServis.jsp.service.ServiceRequest.ServiceRequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/SERVICE-REQUEST-EDIT-SERVLET")
public class ServiceRequestEditServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        final Double serviceRequestIdNumber = Double.valueOf(req.getParameter("serviceRequestIdNumber"));
        final Optional<ServiceRequest> optionalServiceRequest = ServiceRequestService.INSTANCE.getServiceRequest(serviceRequestIdNumber);
        if (optionalServiceRequest.isPresent())
        {
            req.setAttribute("serviceRequestEditRequest", optionalServiceRequest.get());
            req.getRequestDispatcher("JSP-ServiceRequest/SERVICE-REQUEST-FORM.jsp").forward(req, resp);
        } else
        {
            resp.sendRedirect("/SERVICE-REQUEST-LIST-SERVLET");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        final String serviceRequestIdNumber = req.getParameter("serviceRequestIdNumber");
        ServiceRequestService.INSTANCE.updateServiceRequestInformation(Double.valueOf(serviceRequestIdNumber), req);
        resp.sendRedirect("/SERVICE-REQUEST-LIST-SERVLET");
    }
}
