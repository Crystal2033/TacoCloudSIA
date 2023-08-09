package com.crystal2033.tacocloud.controllers;

import com.crystal2033.tacocloud.models.OrderControllerProps;
import com.crystal2033.tacocloud.models.TacoOrder;
import com.crystal2033.tacocloud.models.User;
import com.crystal2033.tacocloud.repository.OrderRepository;
import com.crystal2033.tacocloud.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 14/07/2023
 */
@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    private final OrderControllerProps orderControllerProps;

    public OrderController(OrderRepository orderRepository, UserRepository userRepository, OrderControllerProps orderControllerProps) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderControllerProps = orderControllerProps;
    }


    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);
        //log.info("Order submitted: {}", order);
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model){
        Pageable pageable = PageRequest.of(0, orderControllerProps.getPageSize());
        model.addAttribute("orders", orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";
    }
}
