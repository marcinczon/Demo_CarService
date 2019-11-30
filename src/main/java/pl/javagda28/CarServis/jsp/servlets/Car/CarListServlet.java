package pl.javagda28.CarServis.jsp.servlets.Car;

import pl.javagda28.CarServis.jsp.service.Car.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CAR-LIST-SERVLET")
public class CarListServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setAttribute("carList", CarService.INSTANCE.getCarList());
        req.getRequestDispatcher("/JSP-Car/SERVICE-REQUEST-LIST.jsp").forward(req, resp);
    }
}
