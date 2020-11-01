package de.exxcellent.challenge.handler;

import de.exxcellent.challenge.model.Data;
import de.exxcellent.challenge.service.DataService;
import de.exxcellent.challenge.service.FileReaderService;

import java.io.IOException;
import java.util.List;

/**
 * class for handling data of given file
 *
 * @author Verena Pfaff
 */
public class DataHandler implements DataService {

    private FileReaderService reader;

    /**
     * constructs new File Data Handler
     *
     * @param reader reader for files
     */
    public DataHandler(FileReaderService reader) {
        this.reader = reader;
    }

    /**
     * calculates smallest spread between maximum and minimum value
     *
     * @return identifier of row with smallest spread
     * @throws IOException throws I/O Exception if corresponding error occurs
     */
    @Override
    public String getSmallestSpreadIdentifier() throws IOException {

        List<Data> csvDataList = reader.parseInput();

        // set initial smallest spread to first values of list
        int currentSmallestSpread = csvDataList.get(0).getMaxValue() - csvDataList.get(0).getMinValue();
        String currentSmallestSpreadIdentifier = csvDataList.get(0).getIdentifier();

        // iterate through list to identify smallest spread
        // set new smallest spread if necessary
        for (Data csvData : csvDataList) {
            int spread = csvData.getMaxValue() - csvData.getMinValue();
            if (currentSmallestSpread > spread) {
                currentSmallestSpread = spread;
                currentSmallestSpreadIdentifier = csvData.getIdentifier();
            }
        }
        return currentSmallestSpreadIdentifier;
    }
}
