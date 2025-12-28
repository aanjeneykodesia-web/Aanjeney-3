package com.production.payment;

import com.razorpay.*;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

 private RazorpayClient client;

 public PaymentController() throws RazorpayException {
  client = new RazorpayClient(
   System.getenv("RAZORPAY_KEY_ID"),
   System.getenv("RAZORPAY_SECRET")
  );
 }

 @PostMapping("/create-order")
 public String createOrder(@RequestParam int amount) throws RazorpayException {
  JSONObject options = new JSONObject();
  options.put("amount", amount * 100);
  options.put("currency", "INR");
  return client.orders.create(options).toString();
 }
}