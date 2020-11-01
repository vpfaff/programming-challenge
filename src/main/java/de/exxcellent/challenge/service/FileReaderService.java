package de.exxcellent.challenge.service;

import de.exxcellent.challenge.model.Data;

import java.io.IOException;
import java.util.List;

/**
 * defines methods for reading files
 *
 * @author Verena Pfaff
 */
public interface FileReaderService {
    List<Data> parseInput() throws IOException;
}
