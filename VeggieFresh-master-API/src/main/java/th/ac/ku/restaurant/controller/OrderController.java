package th.ac.ku.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.restaurant.model.VegOrder;
import th.ac.ku.restaurant.model.Vegetable;
import th.ac.ku.restaurant.service.OrderService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService service;

    @GetMapping
    public List<VegOrder> getAll()
    {
        return service.getAll();
    }

    @PostMapping
    public VegOrder create(@RequestBody VegOrder order)
    {
        return service.create(order);
    }

    @GetMapping("/{id}")
    public VegOrder getOrder(@PathVariable UUID id)
    {
        return service.getOrder(id);
    }

    @PutMapping("/{id}")
    public VegOrder update(@PathVariable UUID id, @RequestBody VegOrder order)
    {
        return service.update(id, order);
    }

    @DeleteMapping("/{id}")
    public VegOrder delete(@PathVariable UUID id)
    {
        return service.delete(id);
    }

}
