import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class Server
{
    public static void main(String[] args)
    {
        int port=2050;
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);

            Socket clientSocket = serverSocket.accept();

            InputStream inputStream = clientSocket.getInputStream();

            System.out.println(inputStream);

            byte[] imageAr = new byte[64000];
            inputStream.read(imageAr);

                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

            System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
            ImageIO.write(image, "jpg", new File("C:\\Users\\Usuario DAM 2\\Desktop\\img.jpg"));

            inputStream.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (UnknownHostException e){
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}