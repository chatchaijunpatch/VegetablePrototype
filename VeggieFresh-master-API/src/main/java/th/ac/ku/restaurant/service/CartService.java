//package th.ac.ku.restaurant.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import th.ac.ku.restaurant.model.Cart;
//import th.ac.ku.restaurant.repository.CartRepository;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class CartService {
//    @Autowired
//    private CartRepository repository;
//
//    public List<Cart> getAll() {
//        return repository.findAll();
//    }
//
//    public Cart create(Cart cart){
//        repository.save(cart);
//        return cart;
//    }
//
//    public Cart getCart(UUID id)
//    {
//        return repository.findById(id).get();
//    }
//
////    public Cart update(UUID id, Cart requestBody)
////    {
////        Cart record = repository.findById(id).get();
////        record.setName(requestBody.getName());
////        record.setPrice(requestBody.getPrice());
////
////        repository.save(record);
////
////        return record; // Return is optional
////    }
//
//    public Cart delete(UUID id)
//    {
//        Cart record = repository.findById(id).get();
//        repository.deleteById(id);
//        return record;
//    }
//}
