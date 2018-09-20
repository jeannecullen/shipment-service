package com.solstice.cloud.service;

import com.solstice.cloud.domain.OrderLineResult;
import com.solstice.cloud.domain.OrdersResult;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@EnableDiscoveryClient
@FeignClient("ord-ordLine-service")
public interface OrderLineService {

    @RequestMapping(method=RequestMethod.GET, value="/orders/{orders}/linesio")
    OrderLineResult listOrderLineItems(@PathVariable("orders") Long orders);

    @RequestMapping(method=RequestMethod.GET, value="orders/{ordersId}")
    Long getOrders(@PathVariable("ordersId") Long ordersId);

    //@RequestMapping(method= RequestMethod.GET, value"/")
}
