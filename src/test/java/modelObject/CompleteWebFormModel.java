package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;

@Getter
@Setter

public class CompleteWebFormModel {

    private String firstName;
    private String lastName;
    private String jobTitle;
    private String educationLevel;
    private String sex;
    private String yearsOfExperience;
    private String month;
    private String day;
    private String year;

    public CompleteWebFormModel() {

    }

    public void populateObject(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the JSON file and update this instance with the values
            CompleteWebFormModel model = objectMapper.readValue(new File(jsonFilePath), CompleteWebFormModel.class);
            objectMapper.updateValue(this, model);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to populate CompleteWebFormModel from JSON file: " + jsonFilePath, e);
        }
    }
}

