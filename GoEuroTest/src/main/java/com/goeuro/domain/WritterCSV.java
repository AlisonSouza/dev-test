package com.goeuro.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.goeuro.domain.mapping.json.City;
import com.opencsv.CSVWriter;

public class WritterCSV {

	private static String CVS = ".csv";

	public void saveFile(List<City> cities, String cityName) throws IOException {
		String uri = "." + File.separator + createFileName(cityName);
		File file = new File(uri);

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(exportToCSV(cities));
		bw.close();
	}

	protected String createFileName(String cityName) {
		return cityName + "_" + Calendar.getInstance().getTimeInMillis() + WritterCSV.CVS;
	}

	protected String exportToCSV(List<City> cities) throws IOException {
		StringWriter writer = new StringWriter();
		CSVWriter csvWriter = new CSVWriter(writer, ';');
		List<String[]> data = toStringArray(cities);
		csvWriter.writeAll(data);
		csvWriter.close();
		return writer.toString();
	}

	protected List<String[]> toStringArray(List<City> cities) {
		List<String[]> records = new ArrayList<String[]>();
		records.add(new String[] { City.Fields.ID.getName(), 
								   City.Fields.TYPE.getName(),
								   City.Fields.LATITUDE.getName(),
								   City.Fields.LONGETUDE.getName()});
		for (City city : cities) {
			records.add(new String[] { String.valueOf(city.getId()), city.getType(),
					String.valueOf(city.getGeoPosition().getLatitude()),
					String.valueOf(city.getGeoPosition().getLongitude()), });
		}

		return records;
	}
}
