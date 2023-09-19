package com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.OutletAmendment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletAmendmentRepository extends JpaRepository<OutletAmendment, Integer> {

    @Query("select o from OutletAmendment o where o.route.routeId=?1")
    public List<OutletAmendment> findByRoute(int id);



}
