package pl.javagda28.CarServis.jsp.service.Car;

import pl.javagda28.CarServis.jsp.model.Car.Car;
import pl.javagda28.CarServis.jsp.model.Car.CarBrands;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum CarService
{
    INSTANCE;

    private List<Car> carList = new ArrayList<>();

    public Optional<Car> findCarById(Double carId)
    {
        return null;
    }

    public void addCarToList(Car car)
    {

        carList.add(car);
      //  carList.stream().forEach(car1 -> System.out.println(car1.toString()));
    }

    public void removeCar(Double carId)
    {
        carList = carList.stream().filter(car -> !car.getId().equals(carId)).collect(Collectors.toList());
    }

    public Optional<Car> getCar(Double carId)
    {
        return carList.stream().filter(car -> car.getId().equals(carId)).findFirst();
    }

    public List<Car> getCarList()
    {
        return carList;
    }

    public void updateCarInformation(Double carIdNumber, HttpServletRequest request)
    {
        final Optional<Car> carOptional = carList.stream().filter(car -> car.getId().equals(carIdNumber)).findFirst();
        if (carOptional.isPresent())
        {
            carOptional.get().setBrand(CarBrands.valueOf(request.getParameter("carParam_brand")));
            carOptional.get().setCarMillage(Double.valueOf(request.getParameter("carParam_carMillage")));
            carOptional.get().setRegistrationNumber(request.getParameter("carParam_registrationNumber"));
            carOptional.get().setProductionDate(Integer.valueOf(request.getParameter("carParam_productionDate")));
            carOptional.get().setOwnerSecondName(request.getParameter("carParam_ownerSecondName"));
        } else
        {
            System.out.println("Nie istnieje carOptional o id=" + carIdNumber);
        }


    }


}
