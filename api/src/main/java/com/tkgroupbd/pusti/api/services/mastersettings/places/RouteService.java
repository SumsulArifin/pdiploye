package com.tkgroupbd.pusti.api.services.mastersettings.places;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.places.RouteRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface RouteService {

    MessageResponse saveRoute(RouteRequest routeRequest);

    public Optional<Route> updateRoute(int routeId, RouteRequest routeRequest);

    public void deleteRouteById(int routeId);

    public Optional<Route> updateRouteStatus(int routeId, RouteRequest routeRequest);

    List<Route> findSortedRouteByKey(String field);

    public List<Route> getAllRoute();

    public Route findRouteById(int routeId);
}
