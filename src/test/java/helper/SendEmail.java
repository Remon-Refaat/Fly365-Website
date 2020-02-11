package helper;

import org.apache.commons.mail.*;

public class SendEmail {

    public static void SendReportEmail() throws EmailException {

        System.out.println("=============== Start Send Email ===================");

    Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("autoooselenium@gmail.com", "JustOneUse1"));
        email.setSSLOnConnect(true);
        email.setFrom("mohamed.emad@fly365.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("mohamed.emad11688@gmail.com");
        email.send();

        System.out.println("=============== Email Sent ===================");
}
}
