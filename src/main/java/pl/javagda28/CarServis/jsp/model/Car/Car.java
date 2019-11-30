package pl.javagda28.CarServis.jsp.model.Car;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car
{
    private static double carCounter = 0;
    private Double id;
    private CarBrands brand;
    private String registrationNumber;
    private String ownerSecondName;
    private Integer productionDate;
    private Double carMillage;

    public static class CarBuilder
    {

        private Double id;
        private CarBrands brand;
        private String registrationNumber;
        private String ownerSecondName;
        private Integer productionDate;
        private Double carMillage;

        public CarBuilder setBrand(CarBrands brand)
        {
            this.brand = brand;
            return this;
        }

        public CarBuilder setRegistrationNumber(String registrationNumber)
        {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public CarBuilder setOwnerSecondName(String ownerSecondName)
        {
            this.ownerSecondName = ownerSecondName;
            return this;
        }

        public CarBuilder setProductionDate(Integer productionDate)
        {
            this.productionDate = productionDate;
            return this;
        }

        public CarBuilder setCarMillage(Double carMillage)
        {
            this.carMillage = carMillage;
            return this;
        }

        public Car createCar()
        {
            carCounter++;
            id = carCounter;
            return new Car(id, brand, registrationNumber, ownerSecondName, productionDate, carMillage);
        }
    }
}
