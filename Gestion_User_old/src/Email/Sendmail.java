/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.security.Security;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.edu.gg.services.ServiceUser;

/**
 *
 * @author lenovo
 */
public class Sendmail { 

       

    public void sendEmail(String subject, String body, String mail) {
        ServiceUser su = new ServiceUser();
        String b = su.getPasswordU(mail);
       String username = "mariem.haddad@esprit.tn";
                                String password = "tmwqivbbyxeviayi";
                                Properties props = new Properties();
                                Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                                props.put("mail.smtp.port", "465");
                                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                props.put("mail.smtp.ssl.enable", true); 
                                props.put("mail.smtp.ssl.protocols", "TLSv1.2");
                                props.put("mail.smtp.socketFactory.port", "465");
                                props.put("mail.smtp.socketFactory.fallback", "false");
                                props.put("mail.smtp.host", "smtp.gmail.com");
                                props.put("mail.smtp.auth", "true");
                                props.setProperty("mail.debug", "true");
                                props.setProperty("mail.transport.protocol", "smtp");
                                props.put("mail.smtp.starttls.enable", "true"); 
                                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(username, password);
                                    }
                                });

                                try {
                                    Address a = new InternetAddress("mariem.haddad@esprit.tn");
      
                                    Message message = new MimeMessage(session);
                                    message.setFrom(new InternetAddress("mariem.haddad@esprit.tn"));
                                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("haddadmariem32@gmail.com") );
                                    message.setSubject(subject);
                                  String htmlcode =    "<h1> your password is "+b+" </h1>";
                                        
                                        
                                          
                                    message.setContent(htmlcode, "text/html");                   
                                    Transport.send(message);
                                } catch (MessagingException mex) {
                                    System.out.println(" failed, exception: " + mex.getMessage());
                                }
    };
    }
    

    

