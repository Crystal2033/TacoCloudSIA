package com.crystal2033.tacocloud.controllers;

import com.crystal2033.tacocloud.models.TacoOrder;
import com.crystal2033.tacocloud.models.User;
import com.crystal2033.tacocloud.repository.OrderRepository;
import com.crystal2033.tacocloud.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
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
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


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
}
