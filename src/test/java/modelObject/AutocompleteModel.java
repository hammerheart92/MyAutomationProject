package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;

@Getter
@Setter

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
}
