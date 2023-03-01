package com.eminanceinnovation.controller;

import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eminanceinnovation.service.EmailService;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.util.JSONPObject;

import jakarta.mail.Session;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
public class ForgotPasswordController {
		
	Random random=new Random(1000);
	int otp=0;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send-otp")
	public void sendOTP(@RequestBody Map<String, String> body, HttpSession session) {
		otp=random.nextInt(999999);
		String subject="OTP from Eminence Innovation";
		String message="<p>Your One time password is "+otp+" for changing password. Otp is valid for only 10 minutes. Don't share the OTP with anyone. If you are not please contact to Eminence  Innovation.</p>";
		String to=body.get("email");
		boolean flag = this.emailService.sendEmail(subject, message, to);
		if(flag) {
			session.setAttribute("otp",otp );
			System.out.println("Email is sent Sucessfully");
		}
		else {
			System.out.println("There is problem in sending email");
		}
	}
	
	@PostMapping("/verify-otp")
	public void verifyOTP(@RequestBody Map<String, Integer> body) {
			int emailotp=body.get("otp");
			if(otp==emailotp) {
				System.out.println("Otp is matched");
			}
			else {
				System.out.println("Otp is not matched");
			}
	}

}
