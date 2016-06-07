package com.goeuro.main;

import java.util.List;

import com.goeuro.domain.WritterCSV;
import com.goeuro.domain.mapping.json.City;
import com.goeuro.util.Constants;
import com.goeuro.util.Utils;

public class GoEuroMain 
{
    public static void main( String[] args )
    {
        try{
        	String cityName = args[0].trim();
            List<City> cities = City.getCitiesFromJSON(Utils.callURL(Constants.URL + cityName));
            WritterCSV writterCSV = new WritterCSV();
            writterCSV.saveFile(cities, cityName);
        }catch(Exception ex){
        	System.out.println("Use: java -jar GoEuroTest-0.0.1-SNAPSHOT-jar-with-dependencies.jar CITY_NAME");
        	System.out.println("Example:");
        	System.out.println("java -jar GoEuroTest-0.0.1-SNAPSHOT-jar-with-dependencies.jar Berlin");
        }
    }
}
