package de.exxcellent.challenge;

import de.exxcellent.challenge.model.Data;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * JUnit 5 test case for CSV reader class.
 *
 * @author Verena Pfaff
 */
public class CSVReaderTest {
    private final String TEST_FILE_URL = "test.csv";
    private final String[] TEST_FILE_HEADERS = {"Identifier", "MaxVal", "MinVal"};

    private final CSVReader csvReader = new CSVReader(TEST_FILE_URL,
            TEST_FILE_HEADERS[0],
            TEST_FILE_HEADERS[1],
            TEST_FILE_HEADERS[2]);

    @Test
    public void parseInputTest() {
        List<Data> actualOutput = csvReader.parseInput();

        assertAll("csv output",
                () -> assertThat(actualOutput.size(), is(3)),
                () -> assertThat(actualOutput, everyItem(instanceOf(Data.class))),
                () -> assertThat(actualOutput, contains(
                        allOf(hasProperty("identifier", is("1")),
                                hasProperty("maxValue", is(10)),
                                hasProperty("minValue", is(5))),
                        allOf(hasProperty("identifier", is("2")),
                                hasProperty("maxValue", is(12)),
                                hasProperty("minValue", is(12))),
                        allOf(hasProperty("identifier", is("3")),
                                hasProperty("maxValue", is(14)),
                                hasProperty("minValue", is(10)))
                )));
    }
}
