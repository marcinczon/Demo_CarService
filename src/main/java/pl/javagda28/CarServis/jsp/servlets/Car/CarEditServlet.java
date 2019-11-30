package pl.javagda28.CarServis.jsp.servlets.Car;

import pl.javagda28.CarServis.jsp.model.Car.Car;
import pl.javagda28.CarServis.jsp.model.Car.CarBrands;
import pl.javagda28.CarServis.jsp.service.Car.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/CAR-EDIT-SERVLET")
public class CarEditServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        final Double carIdNumber = Double.valueOf(req.getParameter("carIdNumber"));
        final Optional<Car> optionalCar = CarService.INSTANCE.getCar(carIdNumber);
        if (optionalCar.isPresent())
        {
            req.setAttribute("carEditRequest", optionalCar.get());
            req.setAttribute("brandList", CarBrands.values());
            req.getRequestDispatcher("JSP-Car/SERVICE-REQUEST-FORM.jsp").forward(req,resp);
        } else
        {
            resp.sendRedirect("/CAR-LIST-SERVLET");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("CarEditServlet - doPost() - 1");
        final String carIdNumber = req.getParameter("carIdNumber");
        System.out.println("CarEditServlet - doPost() - 2-> "+carIdNumber);
        CarService.INSTANCE.updateCarInformation(Double.valueOf(carIdNumber), req);
        System.out.println("CarEditServlet - doPost() - 3");
        resp.sendRedirect("/CAR-LIST-SERVLET");


    }
}
