package com.tkgroupbd.pusti.api.data.repositories.primaryorders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.OfferDetails;

import java.util.List;

@Repository
public interface OfferDetailsRepository extends JpaRepository<OfferDetails, Integer> {
    @Query("select o from OfferDetails o where o.offer.id=?1")
    public List<OfferDetails> findOfferDetailsByOfferId(int id);
}
