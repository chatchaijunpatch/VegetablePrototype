package th.ac.ku.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.model.Vegetable;
import th.ac.ku.restaurant.repository.VegetableRepository;

import java.util.List;
import java.util.UUID;

@Service
public class VegetableService
{
    @Autowired
    private VegetableRepository repository;

    public List<Vegetable> getAll()
    {
        return repository.findAll();
    }

    public Vegetable create(Vegetable vegetable)
    {
        repository.save(vegetable);
        return vegetable;
    }

    public Vegetable getVegetable(UUID id)
    {
        return repository.findById(id).get();
    }

    public Vegetable update(UUID id, Vegetable requestBody)
    {
        Vegetable record = repository.findById(id).get();
        record.setName(requestBody.getName());
        record.setPrice(requestBody.getPrice());
        record.setWeight(requestBody.getWeight());
        record.setAmount(requestBody.getAmount());

        repository.save(record);

        return record; // Return is optional
    }

    public Vegetable delete(UUID id)
    {
        Vegetable record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
}
