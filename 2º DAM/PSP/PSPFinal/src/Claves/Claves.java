package Claves;

import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Claves implements Serializable {

    PrivateKey clavepriv;
    PublicKey clavepub;

    public void generarClaves() {

        File clave = new File("src/Claves/Clave.privada");
        if (!clave.exists()) {

            try {
                //TODO RSA o DSA
                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
                // SE INICIALIZA EL GENERADOR DE CLAVES
                SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
                //TODO logitud de la clave
                keyGen.initialize(512, numero);
                // SE CREA EL PAR DE CLAVES PRIVADA Y PÚBLICA
                KeyPair par = keyGen.generateKeyPair();
                clavepriv = par.getPrivate();
                clavepub = par.getPublic();

                // GUARDAMOS LA CLAVE PRIVADA
                PKCS8EncodedKeySpec pk8Spec = new PKCS8EncodedKeySpec(clavepriv.getEncoded());
                // Escribir a fichero binario la clave privada
                FileOutputStream outpriv = new FileOutputStream("src/Claves/Clave.privada");
                outpriv.write(pk8Spec.getEncoded());
                outpriv.close();

                // GUARDAMOS LA CLAVE PÚBLICA
                X509EncodedKeySpec pkX509 = new X509EncodedKeySpec(clavepub.getEncoded());
                // Escribir a fichero binario la clave pública

                FileOutputStream outpub = new FileOutputStream("src/Claves/Clave.publica");
                outpub.write(pkX509.getEncoded());
                outpub.close();

                System.out.println("Claves generadas");

            } catch (NoSuchAlgorithmException el) {
                el.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            PrivateKey keyPriv;
            PublicKey keyPub;
            try {
                //TODO Guardar Claves desde ficheros
                keyPriv = (PrivateKey) new ObjectInputStream(new FileInputStream(("src/Claves/Clave.privada")));
                keyPub = (PublicKey) new ObjectInputStream(new FileInputStream(("src/Claves/Clave.publica")));
                clavepriv = keyPriv;
                clavepub = keyPub;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public PrivateKey getClavepriv() {
        return clavepriv;
    }

    public PublicKey getClavepub() {
        return clavepub;
    }
}

/*public String SHA512(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }*/