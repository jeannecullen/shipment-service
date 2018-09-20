package com.solstice.cloud;

import com.solstice.cloud.domain.Shipment;
import com.solstice.cloud.service.ShipmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ShipmentServiceTest {

    @Autowired
    ShipmentService shipmentService;

    @Test
    public void testAddShipment() {
        Shipment newShipment = new Shipment();
        //newShipment.setShipDate(2018-06-01);
    }


}
