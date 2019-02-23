package atul.backend.accenture.repository;

import atul.backend.accenture.entity.CreditCardEntity;
import atul.backend.accenture.entity.PaymstrEntity;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymstrRepository extends MyRepo<PaymstrEntity, Integer> {

}
