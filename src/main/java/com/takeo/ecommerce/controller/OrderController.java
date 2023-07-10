package com.takeo.ecommerce.controller;


import com.takeo.ecommerce.dto.OrderRequest;
import com.takeo.ecommerce.dto.OrderResponse;
import com.takeo.ecommerce.entity.Order;
import com.takeo.ecommerce.entity.Payment;

import com.takeo.ecommerce.entity.Product;
import com.takeo.ecommerce.entity.Users;

import com.takeo.ecommerce.repository.PaymentRepository;

import com.takeo.ecommerce.service.impl.OrderServiceImpl;
import com.takeo.ecommerce.service.impl.ProductServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;


@Controller
public class OrderController {
  @Autowired
    private OrderServiceImpl orderService;
  @Autowired
  private ProductServiceImpl productService;
  @Autowired
  private PaymentRepository paymentRepository;
  @GetMapping("/Buy/{productId}")
  public String buyProductById(@PathVariable("productId") Long productId, Model model) {
    Product product = productService.findProductById(productId);
    if (product != null) {
      BigDecimal price=product.getPrice();
      model.addAttribute("products",price);
      return "redirect:/order";}
    return "redirect:/products";
  }

  @RequestMapping("/order")
  public String orderPayment() {

    return "payment";
  }
    @PostMapping("/placeOrder")
    public String placeOrder(@ModelAttribute("orderRequest") @NotNull OrderRequest orderRequest, @NotNull HttpSession session, @NotNull Model model) {
      Users user = (Users) session.getAttribute("users");
      if (user == null) {
        // User not logged in, redirect to login page
        return "redirect:/login";
      }
      String senderName=user.getUname();
       //get order info from payment web html
      Order order = orderRequest.getOrder();
      order.setSenderName(senderName);
      order.setUser(user);//insert user id
      order.setStatus("INPROGRESS");
      //create unique tracking number
      String randomNumber = String.format("%04d", new Random().nextInt(10000));
      order.setOrderTackingNumber(randomNumber);
      //Product product=orderRequest.getProduct();
      //order.setProduct(product);

      //save order
      orderService.save(order);
     // get payment info from payment web html
      Payment payment = orderRequest.getPayment();

      //save

      payment.setOrder(order);//insert order date for order_id
      paymentRepository.save(payment);
      //display response
      OrderResponse orderResponse = new OrderResponse();
      orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
      orderResponse.setStatus(order.getStatus());
      orderResponse.setMessage("SUCCESS");
      model.addAttribute("res",orderResponse);
      return "orderResponse";
  }
  @GetMapping("/UserOrderList")
  public String findAllUserOrder(@NotNull Model model, @NotNull HttpSession session) {
    Users user = (Users) session.getAttribute("users");
    if (user == null) {
      return "redirect:/login";
    }
    int userId = user.getUid();
    List<Order>orderList = orderService.getAllUserOrder(userId);
    model.addAttribute("orders",orderList );
    return "UserOrderList";
  }
  @GetMapping("/ALLOrder")
  public String findAllOrder(@NotNull Model model) {
    List<Order>order =orderService.getAll();
    model.addAttribute("orders",order);
    return "AdminOrderList";
  }
  @GetMapping("/update-order/{id}")
  public String updateProduct(@PathVariable Long id, @NotNull Model model) {
    Order order =orderService.findOrderById(id);
    model.addAttribute("order",order);
    return "update-Order";
  }
  @PostMapping("/save-order/{id}")
  public  String update(@ModelAttribute Order order, Model model)
  {
    Order  count=orderService.save(order);
    String msg=" ";
    if(count!=null)
      msg="Update Success";
    else
      msg="Try Later!";

    model.addAttribute("msg",msg);
    return"redirect:/ALLOrder";
  }
  @GetMapping("remove-order/{id}")
  public String removeOrder(@PathVariable Long id, @NotNull Model model) {
    orderService.deleteOrderById(id);
    return "redirect:/ALLOrder";
  }
  @GetMapping("/searchMyTrack&Trick")
  public String MyList()
  {

    return("SearchOrderStatus");
  }
  @GetMapping("/orderByTrackingNumber")
  public String UserTrackingInfo(@RequestParam("trNumber") String trNumber, Model model) {
      Order order =orderService.getOrderByTrackingNumber(trNumber);
      if(order!=null)
      model.addAttribute("orders",order);
      else
        model.addAttribute("msg", "Tracking Info not found");
      return "UserOrderList";

  }
  }


