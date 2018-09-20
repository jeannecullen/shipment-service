package com.solstice.cloud.repo;

import com.solstice.cloud.domain.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

    //Shipment findById();
    List<Shipment> findAll();
    List<Shipment> findAllByAccountOrderByDeliverDateAsc(long accountId);
}
