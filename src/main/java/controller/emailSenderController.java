package controller;

import module.Email;
import org.springframework.web.bind.annotation.RequestParam;
import service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emailSender/")
@ComponentScan("service")
public class emailSenderController {
    @Autowired
    private EmailSenderService senderService;

    @GetMapping("abc")
    public String abc(@RequestParam(name="name") String name,
                      @RequestParam(name="emailFrom") String emailFrom,
                      @RequestParam(name="message") String message) throws MessagingException {
        Email email = new Email(name, emailFrom, message);
        senderService.sendSimpleEmail("amineachouhame51@gmail.com",
                email.createBody(),
                email.createSubject());
        return name+" "+emailFrom+" "+message;
    }
}
