package es.vedruna.appVedruna.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(String asunto, String mensaje) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(asunto);
        email.setText(mensaje);
        mailSender.send(email);
    }
}
