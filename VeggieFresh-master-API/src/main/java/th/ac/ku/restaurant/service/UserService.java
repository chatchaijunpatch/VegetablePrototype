package th.ac.ku.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.model.User;
import th.ac.ku.restaurant.model.Vegetable;
import th.ac.ku.restaurant.repository.UserRepository;
import th.ac.ku.restaurant.repository.VegetableRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService
{
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repository;

    public List<User> getAll()
    {
        return repository.findAll();
    }

    public User create(User user)
    {
        passwordEncoder = new BCryptPasswordEncoder();
        String enc = passwordEncoder.encode(user.getPassword());
        user.setPassword(enc);
        repository.save(user);
        return user;
    }

    public User getUser(UUID id)
    {
        return repository.findById(id).get();
    }

    public User update(UUID id, User requestBody)
    {
        User record = repository.findById(id).get();
        record.setName(requestBody.getName());
        record.setUsername(requestBody.getUsername());
        record.setPassword(requestBody.getPassword());
        record.setEmail(requestBody.getEmail());

        repository.save(record);

        return record; // Return is optional
    }

    public User delete(UUID id)
    {
        User record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
