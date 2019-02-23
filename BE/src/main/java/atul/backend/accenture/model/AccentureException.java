package atul.backend.accenture.model;

import java.io.Serializable;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
 import java.util.ArrayList;
import java.util.List;

public class AccentureException extends Exception  implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final ResponseBody responseBody = new ResponseBody();

    private static final Logger log = Logger.getLogger("AccentureException");

    public AccentureException(String message, ErrorDetails errorDetails) {
        super(message);
        ErrorDetails errorDetails1 = errorDetails;
        log.info(errorDetails.toString());
    }
    public AccentureException(String message) {
        super(message);
    }


    public AccentureException(String message, HttpStatus httpStatus) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setCode(Const.Status.ERROR);
        errorDetails.setErrors(message);
        errorDetails.setHttpStatus(httpStatus);
        List<ErrorDetails> detailsList = new ArrayList<>();
        detailsList.add(errorDetails);
        responseBody.setErrorDetails(detailsList);
    }



}
