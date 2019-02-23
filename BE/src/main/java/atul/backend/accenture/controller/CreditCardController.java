package atul.backend.accenture.controller;

import atul.backend.accenture.config.AccUtils;
import atul.backend.accenture.entity.CreditCardEntity;
import atul.backend.accenture.model.AccentureException;
import atul.backend.accenture.model.CreditCardModel;
import atul.backend.accenture.model.Response;
import atul.backend.accenture.service.CreditCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/accenture")
@Api(value = "accenture", description = "Operations pertaining to card details  in Accenture")
public class CreditCardController {

    private static final Logger log = Logger.getLogger("CreditCardController");
    @Autowired
    private CreditCardService creditCardService;


    @ApiOperation(value = "View a list of available customers detail", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server error")

    }
    )

    @GetMapping("/listAllCustomer")
    public ResponseEntity<Response<List<CreditCardModel>>> getLandingPage() {
        AccUtils accUtils = new AccUtils();
        List<CreditCardModel> cardServiceAllCustomersList = creditCardService.getAllCustomersList();
        log.info("Inside listAllCustomer api");
        Response<List<CreditCardModel>> response = new Response<>();
        response.setHeaderModel(accUtils.staticFixing());
        response.setResponse(cardServiceAllCustomersList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @ApiOperation(value = "Delete an IDs")
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<Response<Boolean>> deleteUser(@PathVariable Integer id) throws Exception {
        log.info("Inside deleting the user");
        AccUtils accUtils = new AccUtils();
        Boolean deleteResponse = creditCardService.deleteUser(id);
        Response<Boolean> response = new Response<>();
        if (deleteResponse) {
            response.setHeaderModel(accUtils.staticFixing());
            response.setResponse(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setResponse(false);
            throw new AccentureException("Cannot find details for given " + id + " ID", accUtils.errorDetails());
        }
    }

    @ApiOperation(value = "Search a customer with an ID")
    @PostMapping("findCustomer/{custId}")
    public ResponseEntity<Response<CreditCardModel>> getCustByID(@PathVariable Integer custId) throws Exception {
        log.info("Inside getByID Customers");
        AccUtils accUtils = new AccUtils();
        CreditCardModel creditCardEntity = creditCardService.getCustomerById(custId);
        if (null != creditCardEntity) {
            Response<CreditCardModel> response = new Response<>();
            response.setHeaderModel(accUtils.staticFixing());
            response.setResponse(creditCardEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            log.info(accUtils.errorDetails().toString());
            throw new AccentureException("Cannot find details for given " + custId + " ID", accUtils.errorDetails());
        }
    }

}
