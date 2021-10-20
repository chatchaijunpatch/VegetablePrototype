//package th.ac.ku.restaurant.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import th.ac.ku.restaurant.model.Cart;
//import th.ac.ku.restaurant.service.CartService;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/cart")
//public class CartController {
//
//    @Autowired
//    private CartService service;
//
//    @GetMapping
//    public List<Cart> getAll()
//    {
//        return service.getAll();
//    }
//
//    @PostMapping
//    public Cart create(@RequestBody Cart cart)
//    {
//        return service.create(cart);
//    }
//
//    @GetMapping("/{id}")
//    public Cart getOrder(@PathVariable UUID id)
//    {
//        return service.getCart(id);
//    }
//
////    @PutMapping("/{id}")
////    public Cart update(@PathVariable UUID id, @RequestBody Cart cart)
////    {
////        return service.update(id, cart);
////    }
//
//    @DeleteMapping("/{id}")
//    public Cart delete(@PathVariable UUID id)
//    {
//        return service.delete(id);
//    }
//}
