package com.solstice.cloud.service;

import com.solstice.cloud.domain.ProductResult;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@EnableDiscoveryClient
@FeignClient("product-service")
public interface ProductService {

    @GetMapping("/products/{productId}")
    ProductResult getProduct(@PathVariable("productId") Long productId);

}
