package com.goeuro.domain.mapping.json;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

import com.goeuro.util.Utils;

public class CityTest {

	@Test
	public void shouldParserJsonToCities() throws IOException, Exception {
		String content = Utils.callURL("http://api.goeuro.com/api/v2/position/suggest/en/Berlin");
		List<City> cities = City.getCitiesFromJSON(content);

		assertNotNull(cities);
		assertEquals(8, cities.size());
	}
}
