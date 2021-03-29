package cs681;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.*;
import java.util.List;

public class StartupCar
{
	public static void main(String[] args)
	{
		ArrayList<Car> cars = new ArrayList<Car>();

		cars.add(Car.createCar("Mazda", "Miata", 3200, 2015, 200000));
		cars.add(Car.createCar("Jaguar", "F-Type", 120000, 2020, 160000));
		cars.add(Car.createCar("Honda", "Element", 1500, 2007, 29995));
		cars.add(Car.createCar("GMC", "Yukon", 25300, 2003, 2200));

		// minimum price with reduce()
		Integer minPrice1 = cars.stream()
							.map( (Car car)-> car.getPrice() )
							.reduce(0, (result, carPrice)->{
							if(result==0) return carPrice;
							else if(carPrice < result) return carPrice;
							else return result;} );

		System.out.println("--Minimum Price with reduce() in the Stream API--\n");
		System.out.println(minPrice1 + "\n");
	
		// minimum price with min()
		Integer minPrice2 = cars.stream()
							.map( (Car car)-> car.getPrice() )
							.min( Comparator.comparing((Integer price)-> price ) )
							.get();

		System.out.println("--Minimum Price with min() in the Stream API--\n");
		System.out.println(minPrice2 + "\n");


		// maximum year with reduce()
		Integer maxYear1 = cars.stream()
							.map( (Car car)-> car.getYear() )
							.reduce(0, (result, carYear)->{
							if(result==0) return carYear;
							else if(carYear > result) return carYear;
							else return result;} );

		System.out.println("--Maximum Year with reduce() in Stream API--\n");
		System.out.println(maxYear1 + "\n");

		// maximum year with max() in Stream API
		Integer maxYear2 = cars.stream()
							.map( (Car car)-> car.getYear() )
							.max( Comparator.comparing((Integer carYear)-> carYear ) )
							.get();

		System.out.println("--Maximum Year with max() in Stream API--\n");
		System.out.println(maxYear2 + "\n");

		// Count of car makes
		long carMakes = cars.stream()
							.map( (Car car)-> car.getMake() )
							.count();

		System.out.println("--Count of car makes--\n");
		System.out.println(carMakes);

	}
}

