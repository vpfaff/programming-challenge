package de.exxcellent.challenge.util;

import de.exxcellent.challenge.model.Data;
import de.exxcellent.challenge.service.FileReaderService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * class for reading and processing data of csv files
 *
 * @author Verena Pfaff
 */
public class CSVReader implements FileReaderService {

    private final String resourcePath;
    private final String identifierHeader;
    private final String maxValueHeader;
    private final String minValueHeader;

    /**
     * constructs new CSVReader
     *
     * @param resourcePath     path to csv file
     * @param identifierHeader name of header that identifies row
     * @param maxValueHeader   name of header with maximum value
     * @param minValueHeader   name of header with minimum value
     */
    public CSVReader(String resourcePath, String identifierHeader, String maxValueHeader, String minValueHeader) {
        this.resourcePath = resourcePath;
        this.identifierHeader = identifierHeader;
        this.maxValueHeader = maxValueHeader;
        this.minValueHeader = minValueHeader;
    }

    /**
     * processes csv file
     *
     * @return list with data of given csv file
     * @throws IOException throws I/O Exception if corresponding error occurs
     */
    @Override
    public List<Data> parseInput() throws IOException {
        List<Data> csvDataList = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);

        if (inputStream == null) {
            throw new NullPointerException();
        }

        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new InputStreamReader(inputStream));

        // Note: there are no instructions on how to handle empty/wrong cell values in CSV files
        // this should be taken into account in future solutions to make the code more robust
        for (CSVRecord csvRecord : parser) {
            String identifier = csvRecord.get(identifierHeader);
            int maxValue = 0;
            int minValue = 0;
            int temp;

            try {
                maxValue = Integer.parseInt(csvRecord.get(maxValueHeader));
                minValue = Integer.parseInt(csvRecord.get(minValueHeader));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            // swap min and max value
            // this is needed to avoid negative values as a result of calculating the smallest spread later
            if (maxValue < minValue) {
                temp = maxValue;
                maxValue = minValue;
                minValue = temp;
            }

            Data csvData = new Data(identifier, maxValue, minValue);
            csvDataList.add(csvData);
        }

        inputStream.close();
        parser.close();

        return csvDataList;
    }
}
