package com.goeuro.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.goeuro.domain.mapping.json.City;
import com.goeuro.domain.mapping.json.GeoPosition;

public class WritterCSVTest {

	@Test
	public void shouldReturnHeaderFromCSV() {
		WritterCSV writterCSV = new WritterCSV();
		List<String[]> cities = writterCSV.toStringArray(new ArrayList<>());
		
		assertArrayEquals(getCitiesHeader(), cities.get(0));
	}
	
	@Test
	public void shouldReturnCityName() {
		WritterCSV writterCSV = new WritterCSV();
		String cityName = writterCSV.createFileName("Berlin");
		
		assertNotNull(cityName);
		assertTrue(cityName.contains("Berlin"));
		assertTrue(cityName.contains(".csv"));
	}
	
	@Test
	public void shouldReturnOneCityWithCSVFormat() throws IOException {
		WritterCSV writterCSV = new WritterCSV();
		List<City> cities = new ArrayList<>();
		City berlin = new City();
		GeoPosition geoPosition = new GeoPosition();
		berlin.setId(1L);
		berlin.setType("teste");
		geoPosition.setLatitude(9999.0);
		geoPosition.setLongitude(88888.0);
		berlin.setGeoPosition(geoPosition);
		cities.add(berlin);
		
		String cityName = writterCSV.exportToCSV(cities);
		
		String[] content = cityName.split(";");
		
		assertNotNull(cityName);

		assertTrue(content[0].contains(City.Fields.ID.getName()));
		assertTrue(content[1].contains(City.Fields.TYPE.getName()));
		assertTrue(content[2].contains(City.Fields.LATITUDE.getName()));
		assertTrue(content[3].contains(City.Fields.LONGETUDE.getName()));
		assertTrue(content[3].contains("1"));
		assertTrue(content[4].contains("teste"));
		assertTrue(content[5].contains("9999.0"));
		assertTrue(content[6].contains("88888.0"));
	}
	
	private String[] getCitiesHeader() {
		return new String[] { City.Fields.ID.getName(), 
				   City.Fields.TYPE.getName(),
				   City.Fields.LATITUDE.getName(),
				   City.Fields.LONGETUDE.getName()};
	}
}
