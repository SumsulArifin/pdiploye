package com.tkgroupbd.pusti.api.data.repositories.salesOrder;
import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderOutletCoverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesOrderOutletCoverageRepository extends JpaRepository<SalesOrderOutletCoverage,Integer> {

    @Query("select s from SalesOrderOutletCoverage s where s.outlet.outletId=?1")
    public List<SalesOrderOutletCoverage> findSalesOrderOutletCoverageByOutletId(int id);
}
