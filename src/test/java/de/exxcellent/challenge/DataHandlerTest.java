package de.exxcellent.challenge;

import de.exxcellent.challenge.util.CSVReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

/**
 * JUnit 5 test case for data handler class.
 *
 * @author Verena Pfaff
 */
public class DataHandlerTest {

    private final String TEST_FILE_URL = "test.csv";
    private final String[] TEST_FILE_HEADERS = {"Identifier", "MaxVal", "MinVal"};

    private final CSVReader csvReader = new CSVReader(TEST_FILE_URL,
            TEST_FILE_HEADERS[0],
            TEST_FILE_HEADERS[1],
            TEST_FILE_HEADERS[2]);

    private final DataHandler dataHandler = new DataHandler(csvReader);

    @Test
    public void getSmallestSpreadTest() throws IOException {
        String successLabel = "2";
        assertEquals("identifier must be 2", successLabel, dataHandler.getSmallestSpreadIdentifier());
    }
}
