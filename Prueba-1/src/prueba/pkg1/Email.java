/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.pkg1;

/**
 *
 * @author andres
 */
public class Email{
    private String emisor;
    private String asunto;
    private String contenido;
    private boolean leido;
    public Email(String emisor,String asunto,String contenido){
        this.emisor=emisor;
        this.asunto=asunto;
        this.contenido=contenido;
        this.leido=false;
    }
    public String getEmisor(){
        return emisor;
    }
    public String getAsunto(){
        return asunto;
    }
    public String getContenido(){
        return contenido;
    }
    public boolean esLeido(){
        return leido;
    }
    public void marcarcorreoLeido(){
        leido=true;
    }
    public void imprimirCorreo(){
        System.out.println("DE: "+emisor);
        System.out.println("ASUNTO: "+asunto);
        System.out.println(contenido);
    }
}