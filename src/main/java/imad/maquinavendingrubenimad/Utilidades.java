/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.maquinavendingrubenimad;

/**
 *
 * @author diabl
 */
public class Utilidades {
    
    public String getPassword() {
        
        String numeros = "0123456789";

        String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String minus = "abcdefghijklmnopqrstuvwxyz";

        String esp = "#$%&()*+,-.:;<=>@";
        
        String todos = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$%&()*+,-.:;<=>@";

        String pswd = "";

        for (int i = 0; i < 1; i++) {
            pswd += (numeros.charAt((int) (Math.random() * numeros.length())));
        }

        for (int i = 0; i < 1; i++) {
            pswd += (mayus.charAt((int) (Math.random() * mayus.length())));
        }
        for (int i = 0; i < 1; i++) {
            pswd += (minus.charAt((int) (Math.random() * minus.length())));
        }
        for (int i = 0; i < 1; i++) {
            pswd += (esp.charAt((int) (Math.random() * esp.length())));
        }

        for (int i = 0; i < 4; i++) {
            pswd += (todos.charAt((int) (Math.random() * todos.length())));
        }

        return pswd;
    }
    
}
