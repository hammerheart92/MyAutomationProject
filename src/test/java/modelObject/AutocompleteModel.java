package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AutocompleteModel {

    private String addressValue;
    private String streetValue;
    private String street2Value;
    private String cityValue;
    private String stateValue;
    private String zipCodeValue;
    private String countryValue;

    public AutocompleteModel() {

    }

    // Method to populate fields dynamically from a JSON file
    public void populateObject(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the JSON file and update this instance with the values
            AutocompleteModel model = objectMapper.readValue(new File(jsonFilePath), AutocompleteModel.class);
            objectMapper.updateValue(this, model);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to populate AutocompleteModel from JSON file: " + jsonFilePath, e);
        }
    }

    public String getAddressValue() {
        return addressValue;
    }

    public void setAddressValue(String addressValue) {
        this.addressValue = addressValue;
    }

    public String getStreetValue() {
        return streetValue;
    }

    public void setStreetValue(String streetValue) {
        this.streetValue = streetValue;
    }

    public String getStreet2Value() {
        return street2Value;
    }

    public void setStreet2Value(String street2Value) {
        this.street2Value = street2Value;
    }

    public String getCityValue() {
        return cityValue;
    }

    public void setCityValue(String cityValue) {
        this.cityValue = cityValue;
    }

    public String getStateValue() {
        return stateValue;
    }

    public void setStateValue(String stateValue) {
        this.stateValue = stateValue;
    }

    public String getZipCodeValue() {
        return zipCodeValue;
    }

    public void setZipCodeValue(String zipCodeValue) {
        this.zipCodeValue = zipCodeValue;
    }

    public String getCountryValue() {
        return countryValue;
    }

    public void setCountryValue(String countryValue) {
        this.countryValue = countryValue;
    }
}
