package util

import java.io.IOException;
import java.util.Properties;

import javax.activation.*; 
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.*;
 
public class Mail {
 
    static def send(fromAddr,fromName,toAddr,toName,subject,msgBody,filename,filecontent) {
        Properties props = new Properties()
        Session session = Session.getDefaultInstance(props, null)
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromAddr, fromName));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddr, toName))
            msg.setSubject(subject);
            //msg.setText(msgBody);
            
						// Create the message part 
						BodyPart messageBodyPart = new MimeBodyPart();
						
						// Fill the message
						messageBodyPart.setText(msgBody);
						
						// Create a multipar message
						Multipart multipart = new MimeMultipart();
						
						// Set text message part
						multipart.addBodyPart(messageBodyPart);
						
						// Part two is attachment
						messageBodyPart = new MimeBodyPart();
						DataSource source = new ByteArrayDataSource(filecontent, "application/pdf");
						messageBodyPart.setDataHandler(new DataHandler(source));
						messageBodyPart.setFileName(filename);
						multipart.addBodyPart(messageBodyPart);
            
						// Send the complete message parts
						msg.setContent(multipart );     
                
            Transport.send(msg);
 
        } catch (Exception e) {
            e.printnStackTrace()1
        }
    }
}