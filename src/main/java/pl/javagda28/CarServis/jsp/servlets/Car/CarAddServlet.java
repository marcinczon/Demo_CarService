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

@WebServlet("/CAR-ADD-SERVLET")
public class CarAddServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //Ladujemy strony z formularzem
        req.setAttribute("brandList", CarBrands.values());
        req.getRequestDispatcher("/JSP-Car/SERVICE-REQUEST-FORM.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Car car = loadCarInformationFromParameters(req);

        CarService.INSTANCE.addCarToList(car);
        resp.sendRedirect("/CAR-LIST-SERVLET");
    }

    private Car loadCarInformationFromParameters(HttpServletRequest request)
    {
        return new Car.CarBuilder()
                .setBrand(CarBrands.valueOf(request.getParameter("carParam_brand")))
                .setCarMillage(Double.valueOf(request.getParameter("carParam_carMillage")))
                .setRegistrationNumber(request.getParameter("carParam_registrationNumber"))
                .setProductionDate(Integer.valueOf(request.getParameter("carParam_productionDate")))
                .setOwnerSecondName(request.getParameter("carParam_ownerSecondName"))
                .createCar();


    }


}
