package com.tkgroupbd.pusti.api.data.repositories.primaryorders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.OrderApprovalInfo;

@Repository
public interface OrderApprovalInfoRepository extends JpaRepository<OrderApprovalInfo, Integer> {

}
