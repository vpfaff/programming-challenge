package de.exxcellent.challenge;

import de.exxcellent.challenge.handler.DataHandler;
import de.exxcellent.challenge.util.CSVReader;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    private static final String WEATHER_FILE_URL = "de/exxcellent/challenge/weather.csv";
    private static final String[] WEATHER_FILE_HEADERS = {"Day", "MxT", "MnT"};

    private static final String FOOTBALL_FILE_URL = "de/exxcellent/challenge/football.csv";
    private static final String[] FOOTBALL_FILE_HEADERS = {"Team", "Goals", "Goals Allowed"};

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        try {
            DataHandler weatherDataHandler = new DataHandler(new CSVReader(WEATHER_FILE_URL,
                    WEATHER_FILE_HEADERS[0],
                    WEATHER_FILE_HEADERS[1],
                    WEATHER_FILE_HEADERS[2]));

            String dayWithSmallestTempSpread = weatherDataHandler.getSmallestSpreadIdentifier();
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

            DataHandler footballDataHandler = new DataHandler(new CSVReader(FOOTBALL_FILE_URL,
                    FOOTBALL_FILE_HEADERS[0],
                    FOOTBALL_FILE_HEADERS[1],
                    FOOTBALL_FILE_HEADERS[2]));

            String teamWithSmallestGoalSpread = footballDataHandler.getSmallestSpreadIdentifier();
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
