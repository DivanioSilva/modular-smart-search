package com.ds;

import com.ds.entities.*;
import com.ds.repositories.querydsl.CarQueryDSLRepository;
import com.ds.repositories.querydsl.CityQueryDSLRepository;
import com.ds.repositories.querydsl.PersonQueryDSLRepository;
import com.ds.services.CarQueryDSLService;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.ds.entities")
public class DemoApplication implements CommandLineRunner {

	@Value("${place.entities}")
	protected String entitiesPlace;

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	private final CityQueryDSLRepository cityQueryDSLRepository;
	private final CarQueryDSLRepository carQueryDSLRepository;
	private final PersonQueryDSLRepository personQueryDSLRepository;
	private final CarQueryDSLService carQueryDSLService;

	public DemoApplication(CityQueryDSLRepository cityQueryDSLRepository,
						   CarQueryDSLRepository carQueryDSLRepository,
						   PersonQueryDSLRepository personQueryDSLRepository,
						   CarQueryDSLService carQueryDSLService) {
		this.cityQueryDSLRepository = cityQueryDSLRepository;
		this.carQueryDSLRepository = carQueryDSLRepository;
		this.personQueryDSLRepository = personQueryDSLRepository;
		this.carQueryDSLService = carQueryDSLService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		QCity qCity = QCity.city;

		BooleanExpression booleanExpression = qCity.population.goe(200).and(qCity.name.contains("tis"));
		OrderSpecifier<String> orderSpecifier = qCity.name.asc();
		Iterable<City> cities2 = cityQueryDSLRepository.findAll(booleanExpression, orderSpecifier);
		logger.info("{}", cities2);

		QCity qCityy = QCity.city;
		Predicate predicate = qCityy.id.eq(1L);
		Iterable<City> cities3 = cityQueryDSLRepository.findAll(predicate);
		logger.info("{}", cities3);

		QCar qCar = QCar.car;
		Predicate carPredicate = qCar.brand.eq("VW");
		Iterable<Car> cars = carQueryDSLRepository.findAll(carPredicate);
		logger.info("{}", cars);

		QCar qCarV2 = QCar.car;
		Predicate carPredicateV2 = qCarV2.person.name.eq("Marianna");
		Iterable<Car> carsV2 = carQueryDSLRepository.findAll(carPredicateV2);
		logger.info("{}", cars);

		QPerson qPerson = QPerson.person;
		Predicate personPredicate = qPerson.name.eq("Marianna").and(qPerson.cars.isNotEmpty());
		Iterable<Person> persons = personQueryDSLRepository.findAll(personPredicate);
		logger.info("{}", persons);

		Iterable<Car> carsIt = carQueryDSLService.findCarSmartSearch("VW", "Gasolina", "", null, null, 2001);

		logger.info("{}", carsIt);
	}
}
