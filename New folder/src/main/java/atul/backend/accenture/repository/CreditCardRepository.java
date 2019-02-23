package atul.backend.accenture.repository;

import atul.backend.accenture.config.Const;
import atul.backend.accenture.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreditCardRepository extends MyRepo<CreditCardEntity, Integer> {

    @Query(value = Const.DBQueries.LANDING_QUERY, nativeQuery = true)
    List<Object[]> getLandingPageResponse();

    @Query(value = Const.DBQueries.getByIDQuery, nativeQuery = true)
    Object[] getCustomerById(Integer id);
}
