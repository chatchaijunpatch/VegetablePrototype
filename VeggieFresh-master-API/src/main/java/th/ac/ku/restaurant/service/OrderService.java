package th.ac.ku.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.ac.ku.restaurant.model.VegOrder;
import th.ac.ku.restaurant.model.Vegetable;
import th.ac.ku.restaurant.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository repository;

    public List<VegOrder> getAll()
    {
        return repository.findAll();
    }

    public VegOrder create(VegOrder order)
    {
        repository.save(order);
        return order;
    }

    public VegOrder getOrder(UUID id)
    {
        return repository.findById(id).get();
    }

    public VegOrder update(UUID id, VegOrder requestBody)
    {
        VegOrder record = repository.findById(id).get();
        record.setDate(requestBody.getDate());
        record.setName(requestBody.getName());
        record.setMobile(requestBody.getMobile());
        record.setAddress(requestBody.getAddress());
        record.setVegetable(requestBody.getVegetable());
        record.setAmount(requestBody.getAmount());
        record.setUsername(requestBody.getUsername());
        record.setPayment(requestBody.getPayment());
        record.setPrice(requestBody.getPrice());
        record.setEmail(requestBody.getEmail());
        record.setStatus(requestBody.getStatus());

        repository.save(record);

        return record; // Return is optional
    }

    public VegOrder delete(UUID id)
    {
        VegOrder record = repository.findById(id).get();
        repository.deleteById(id);
        System.out.println(repository);
        return record;
    }
}
