package com.tkgroupbd.pusti.api.services.primaryorders;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovePrimaryOrders;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.Discount;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.ApprovePrimaryOrdersRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface ApprovePrimaryOrdersService {
    MessageResponse createApprovePrimaryOrders(ApprovePrimaryOrdersRequest request);

    public List<ApprovePrimaryOrders> getAllApprovePrimaryOrders();
    public ApprovePrimaryOrders getApprovePrimaryOrdersById(int id);
    public List<ApprovePrimaryOrders>  getApprovePrimaryOrdersByPrimaryApproveId(int id);
    public List<Object[]> getApprovePrimaryOrdersByCurrentDate(LocalDate startDate, LocalDate endDate);
}
