package com.amon.cursomc.services;

import com.amon.cursomc.domain.Cliente;
import com.amon.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {
    void sendOrderConfirmationEmail(Pedido id);
    void sendEmail(SimpleMailMessage msg);
    void sendOrderConfirmationHtmlEmail(Pedido obj);
    void sendHtmlEmail(MimeMessage msg);
    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
