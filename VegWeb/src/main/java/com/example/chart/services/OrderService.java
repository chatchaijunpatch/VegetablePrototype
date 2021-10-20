package com.example.chart.services;

import com.example.chart.entities.Cart;
import com.example.chart.entities.VegOrder;
import com.example.chart.entities.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;

import static java.lang.Integer.parseInt;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    private List<VegOrder> cart = new ArrayList<>();

    public List<VegOrder> getAll() {
        String url = "http://localhost:8090/order";
        ResponseEntity<VegOrder[]> response = restTemplate.getForEntity(url, VegOrder[].class);
        VegOrder[] vegetables = response.getBody();
        return Arrays.asList(vegetables);
    }

    public void addOrder(VegOrder vegetable) {
        String url = "http://localhost:8090/order";
        VegOrder vegOrder = new VegOrder();
        vegOrder = vegetable;
        vegOrder.setUsername(userService.getUser().getUsername());
        vegOrder.setVegetable(cartService.getCart().toString());
        vegOrder.setStatus("Underpayment");
        System.out.println(vegOrder.getVegetable());
        restTemplate.postForObject(url, vegOrder, VegOrder.class);
    }
    public void OrderConfig(){
        cart = this.getAll();
        for (int i=0 ; i < this.getAll().size();i++){
            String hee = new String("");
            hee = this.getAll().get(i).getVegetable();
            hee = hee.replace("[","").replace("]","");
            hee = hee.replace("{","[").replace("}","]");
            hee = hee.replace("[","").replace("]","");
            String[] split = hee.split(",");
            List<String> list = Arrays.asList(split);
            for (int j = 0;j < list.size();j++){
                String hee2 =list.get(j);
                split = list.get(j).trim().split("->");
                List<String> list1 = Arrays.asList(split);
                for (int k =0;k<list1.size();k++){
//                    System.out.println(list1.get(k).trim());
                }
                Vegetable vegetable = new Vegetable(UUID.fromString(list1.get(0)),list1.get(1),Double.parseDouble(list1.get(2)),Double.parseDouble(list1.get(3)),parseInt(list1.get(4)));
                cart.get(i).add(new Cart(vegetable,parseInt(list1.get(5))));
            }
        }
    }
    public List<VegOrder> getDummy(String name){ //getall
        this.OrderConfig();
        List<VegOrder> cart2 = new ArrayList<>();
        if (name.equals("admin")){
            return cart;
        }
        else {
            for (int i =0; i<cart.size();i++){
                if (name.equals(cart.get(i).getUsername())){
                    cart2.add(cart.get(i));
                }
            }
        }
        return cart2;
    }
    public VegOrder getOneById(UUID id)
    {
        String url = "http://localhost:8090/order/" + id;
        ResponseEntity<VegOrder> response =
                restTemplate.getForEntity(url, VegOrder.class);
        VegOrder vegetable = response.getBody();
        return vegetable;
    }
    public void update(VegOrder vegetable) {
        String url = "http://localhost:8090/order/" + vegetable.getOrder_Id();
        restTemplate.put(url, vegetable, VegOrder.class);
    }

}
