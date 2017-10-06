package utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Support {

    public static void centralizar(Component componente) {
        // Centraliza a janela de abertura no centro do desktop.   
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle r = componente.getBounds();
        // Dimensões da janela   
        int widthSplash = r.width;
        int heightSplash = r.height;

        // calculo para encontrar as cooredenadas X e Y para a centralização da janela.   
        int posX = (screen.width / 2) - (widthSplash / 2);
        int posY = (screen.height / 2) - (heightSplash / 2);

        componente.setBounds(posX, posY, widthSplash, heightSplash);
    }

    public static String md5Criptor(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

}
