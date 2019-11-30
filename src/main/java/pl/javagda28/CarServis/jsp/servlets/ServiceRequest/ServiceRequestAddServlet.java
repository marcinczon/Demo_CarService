package pl.javagda28.CarServis.jsp.servlets.ServiceRequest;

import pl.javagda28.CarServis.jsp.model.ServiceRequest.ServiceRequest;
import pl.javagda28.CarServis.jsp.service.ServiceRequest.ServiceRequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SERVICE-REQUEST-ADD-SERVLET")
public class ServiceRequestAddServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/JSP-ServiceRequest/SERVICE-REQUEST-FORM.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        ServiceRequest serviceRequest = loadCarInformationFromParameters(req);
        ServiceRequestService.INSTANCE.addServiceRequestToList(serviceRequest);
        resp.sendRedirect("/SERVICE-REQUEST-LIST-SERVLET");
    }
    private ServiceRequest loadCarInformationFromParameters(HttpServletRequest request)
    {
        return new ServiceRequest.ServiceRequestBuilder()
                .setContent(request.getParameter("serviceRequestParam_content"))
                .setUrgent(request.getParameter("serviceRequestParam_urgent") != null ? request.getParameter("serviceRequestParam_urgent").equals("on") : false)
                .createServiceOrder();
    }
}
