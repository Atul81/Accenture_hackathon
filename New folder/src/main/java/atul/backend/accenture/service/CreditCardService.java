package atul.backend.accenture.service;

import atul.backend.accenture.entity.CreditCardEntity;
import atul.backend.accenture.model.CreditCardModel;

import java.util.List;


public interface CreditCardService {

    List<CreditCardModel> getAllCustomersList();

    Boolean deleteUser(Integer id);

    CreditCardModel getCustomerById(Integer id);
}
