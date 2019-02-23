package atul.backend.accenture.config;

import atul.backend.accenture.model.ErrorDetails;
import atul.backend.accenture.model.HeaderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class AccUtils {

    @Autowired
    HttpStatus httpStatus;

    public HeaderModel staticFixing() {
        HeaderModel headerModel = new HeaderModel();
        headerModel.setAppName("Accenture Customer Experience");
        headerModel.setResponseDateTime(new Date().toString());
        headerModel.setUserId("Atul");
        headerModel.setLanguage("English");
        headerModel.setUserAction("Api Consumed");
        headerModel.setStatus("Action Successful");
        return headerModel;
    }

    public ErrorDetails errorDetails() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrors("Error in performing operations");
        errorDetails.setHttpStatus(httpStatus);
        errorDetails.setMessage("Please check the payload");
        return errorDetails;
    }
}
