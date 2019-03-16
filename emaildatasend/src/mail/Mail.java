package mail;

import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





public class Mail {
	static boolean send(String from,String password,String msg,String To)
	{
		String host = "smtp.gmail.com";
		String port = "465";
		
		Properties prop = System.getProperties();
		
		prop.put("mail.smtp.starttls.enable", "true");//start service
		prop.put("mail.smtp.host", host);//set host
		
		prop.put("mail.smtp.auth", "true");//authenticatation
		prop.put("mail.smtp.user", from);//set username
		prop.put("mail.smtp.password", password);//set password
		prop.put("mail.smtp.port", port);//set port no.
		
		prop.put("mail.smtp.socketFactory.port", port);//with the help of socket programming sending the mail to one pc to another but here we are sending only one to one
		prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");//SSlsocketFactory class has security which are given here
		
		prop.put("mail.smtp.socketFactory.fallback", "false");//security related messages will not be displayed by using this ,it is optional
		
		Session session = Session.getDefaultInstance(prop,null);
		session.setDebug(true);
	
		MimeMessage mime = new MimeMessage(session);//message will be send with the help of this
		try
		{
			mime.setFrom(new InternetAddress(from));//Now Get The Address Of Reciepents
			
			
			InternetAddress toAddresses = new InternetAddress();
			toAddresses=new InternetAddress(To);	//Now add all toAddress elements
			mime.addRecipient(RecipientType.TO, toAddresses);//mime
			
			
			mime.setSubject("test");//add Subject TO mime
			mime.setSubject("Confirmation Link");
			mime.setText(msg);
			//Set Message TO mime
		
			
			javax.mail.Transport transport = session.getTransport("smtp");
			transport.connect(host,from,password);
			
			transport.sendMessage(mime,mime.getAllRecipients());
			transport.close();
				
		} 
		catch (AddressException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MessagingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
		
		
	}

}
