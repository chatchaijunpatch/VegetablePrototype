package th.ac.ku.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.restaurant.model.Vegetable;
import th.ac.ku.restaurant.service.VegetableService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vegetable")
public class VegetableController
{
    @Autowired
    private VegetableService service;

    @GetMapping
    public List<Vegetable> getAll()
    {
        return service.getAll();
    }

    @PostMapping
    public Vegetable create(@RequestBody Vegetable vegetable)
    {
        return service.create(vegetable);
    }

    @GetMapping("/{id}")
    public Vegetable getVegetable(@PathVariable UUID id)
    {
        return service.getVegetable(id);
    }

    @PutMapping("/{id}")
    public Vegetable update(@PathVariable UUID id, @RequestBody Vegetable vegetable)
    {
        return service.update(id, vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable UUID id)
    {
        return service.delete(id);
    }
}
