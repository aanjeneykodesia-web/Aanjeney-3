package com.production.auth;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

 @PostMapping("/send-otp")
 public String sendOtp(@RequestParam String phone) {
  return "OTP sent via Twilio";
 }

 @PostMapping("/verify-otp")
 public String verifyOtp(@RequestParam String phone, @RequestParam String otp) {
  return "JWT_TOKEN";
 }
}