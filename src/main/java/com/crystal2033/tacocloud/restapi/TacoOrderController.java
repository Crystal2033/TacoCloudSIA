package com.crystal2033.tacocloud.restapi;

import com.crystal2033.tacocloud.models.TacoOrder;
import com.crystal2033.tacocloud.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 10/08/2023
 */
@Slf4j
@RestController
@RequestMapping(value = "api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class TacoOrderController {
    private final OrderRepository orderRepository;

    public TacoOrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PutMapping(path = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TacoOrder putOrder(@PathVariable("orderId") Long id, @RequestBody TacoOrder order) {
        order.setId(id);
        return order;
    }

    @PatchMapping(path = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public TacoOrder patchOrder(@PathVariable("orderId") Long id, @RequestBody TacoOrder patchOrder) {

        TacoOrder order = orderRepository.findById(id).get();
        if (patchOrder.getDeliveryName() != null) {
            order.setDeliveryName(patchOrder.getDeliveryName());
        }
        if (patchOrder.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patchOrder.getDeliveryStreet());
        }
        if (patchOrder.getDeliveryCity() != null) {
            order.setDeliveryCity(patchOrder.getDeliveryCity());
        }
        if (patchOrder.getDeliveryState() != null) {
            order.setDeliveryState(patchOrder.getDeliveryState());
        }
        if (patchOrder.getDeliveryZip() != null) {
            order.setDeliveryZip(patchOrder.getDeliveryZip());
        }
        if (patchOrder.getCcNumber() != null) {
            order.setCcNumber(patchOrder.getCcNumber());
        }
        if (patchOrder.getCcExpiration() != null) {
            order.setCcExpiration(patchOrder.getCcExpiration());
        }
        if (patchOrder.getCcCVV() != null) {
            order.setCcCVV(patchOrder.getCcCVV());
        }

        return order; //It saves without return orderRepository.save(order); because we are in Persistent context via Transactional
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long id){
        try{
            orderRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            log.error(e.getMessage());
        }

    }
}
