package de.exxcellent.challenge.model;

/**
 * model class for file data
 *
 * @author Verena Pfaff
 */
public class Data {

    private String identifier;
    private int maxValue;
    private int minValue;

    public Data(String identifier, int maxValue, int minValue) {
        this.identifier = identifier;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }
}
