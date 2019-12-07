package com.wolf.service;

import org.springframework.mail.SimpleMailMessage;

import com.wolf.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
