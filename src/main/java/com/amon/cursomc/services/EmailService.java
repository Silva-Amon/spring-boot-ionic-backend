package com.amon.cursomc.services;

import com.amon.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendOrderConfirmationEmail(Pedido id);
    void sendEmail(SimpleMailMessage msg);
}
