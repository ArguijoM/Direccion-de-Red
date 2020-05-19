/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package direccionred;

import java.util.Locale;

/**
 *
 * @author manuel
 */
public class DireccionRed {
    String direccionIp;
    String mascara;
    String clase;

    public DireccionRed(String ip) {
        this.direccionIp = ip;
    }
    public DireccionRed() {
    }
    public DireccionRed(String ip, String mask) {
        this.direccionIp = ip;
        this.mascara = mask;
    }
    public DireccionRed(String ip, String mask,String clase) {
        this.direccionIp = ip;
        this.mascara = mask;
        this.clase = clase;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public String getMascara() {
        return mascara;
    }
    public String getClase() {
        return clase;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public void setMascara(String mascara) {
        this.mascara = mascara;
    }
    public void setClase(String clase) {
        this.clase = clase;
    }
    
    public String[] contarOctetos(String ip){
        return ip.split("\\.");
    }
    public int toBinario(int octeto){
        int numero = octeto;
        String binario = "";
        if (numero > 0) {
            while (numero > 0) {
                if (numero % 2 == 0) {
                    binario = "0" + binario;
                } else {
                    binario = "1" + binario;
                }
                numero = (int) numero / 2;
            }
        } else if (numero == 0) {
            binario = "0";
        } else {
            binario = "No se pudo convertir el numero. Ingrese solo números positivos";
        }
        return Integer.parseInt(binario);
    }
    public String[] direcciondeRed(){
        String[] direccion = contarOctetos(this.direccionIp);
        String[] mascara = contarOctetos(this.mascara);
        int[] ip = new int[4];
        int[] mask = new int[4];
        int[]resultado = new int[4];
        String[] resul = new String[4];
        
        for(int i=0;i<4;i++){
            ip[i]=Integer.parseInt(direccion[i]);
            mask[i] = Integer.parseInt(mascara[i]);
            resultado[i]=ip[i]&mask[i];
            resultado[i]=toBinario(resultado[i]);
            resul[i]=Integer.toString(resultado[i]);
        }        
        return resul;
    }
}
