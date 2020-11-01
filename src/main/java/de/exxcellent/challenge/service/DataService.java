package de.exxcellent.challenge.service;

import java.io.IOException;

/**
 * defines methods for processing file data
 *
 * @author Verena Pfaff
 */
public interface DataService {
    String getSmallestSpreadIdentifier() throws IOException;
}
