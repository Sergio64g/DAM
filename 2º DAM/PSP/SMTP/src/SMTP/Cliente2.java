package SMTP;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Cliente2 {

    public static void main(String[] args) {
        SMTPClient client = new SMTPClient();
        try {
            int respuesta;
            client.connect("localhost");
            System.out.print(client.getReplyString());
            respuesta = client.getReplyCode();

            if (!SMTPReply.isPositiveCompletion(respuesta)) {
                client.disconnect();
                System.err.println("SMTP server refused connection.");
                System.exit(1);
            }

            client.login();

            /*
		      String destinatario="mariajesusramos@brianda.net";
		      String mensaje = "Hola. \nEnviando saludos.\nChao.";
		      String remitente="yo@localhost.es";
		      client.sendSimpleMessage(remitente, destinatario, mensaje);		      
             */
            String origen = "User1@Example.com";
            String destino1 = "User2@Example.com";
            //String destino2="merceicas@gmail.com";
            String destino2 = "User2@Example.com";
            String asunto = "enviado desde SMTPClient-apachelib";
            String mensaje = "Hola. \nEnviando un mail de prueba y mas.\nAdios.";

            //se crea la cabecera
            SimpleSMTPHeader cabecera = new SimpleSMTPHeader(origen, destino1, asunto);
            cabecera.addCC(destino2);

            //establecer el correo de origen
            client.setSender(origen);
            //añadir correos destino 
            client.addRecipient(destino1);//hay que añadir los dos
            client.addRecipient(destino2);

            //se envia DATA
            Writer writer = client.sendMessageData();
            if (writer == null) { //fallo	       
                System.out.println("FALLO AL ENVIAR DATA.");
                System.exit(1);
            }
            System.out.println(cabecera.toString());
            writer.write(cabecera.toString()); //primero escribo cabecera
            System.out.println(mensaje);
            writer.write(mensaje);//luego mensaje
            writer.close();
            if (!client.completePendingCommand()) { //fallo
                System.out.println("FALLO AL FINALIZAR LA TRANSACCIÓN.");
                System.exit(1);
            }

            client.logout();

        } catch (IOException e) {
            if (client.isConnected()) {
                try {
                    client.disconnect();
                } catch (IOException f) {
                    // do nothing
                }
            }
            System.err.println("Could not connect to server.");
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(0);
    }
}