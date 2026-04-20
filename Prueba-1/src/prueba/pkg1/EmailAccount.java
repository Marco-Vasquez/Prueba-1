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
public class EmailAccount {
    private String direccion;
    private String contraseña;
    private String nombre;
    private Email[] inbox;
    public EmailAccount(String correo,String contraseña,String nombre){
        this.direccion=correo;
        this.contraseña=contraseña;
        this.nombre=nombre;
        inbox=new Email[100];
    }
    public String getDireccion(){
        return direccion;
    }
    public String getContra(){
        return contraseña;
    }
    public String getNombre(){
        return nombre;
    }
    public boolean recibir(Email email){
        for(int control=0;control<inbox.length;control++){
            if(inbox[control]==null){
                inbox[control]=email;
                return true;
            }
        }
        return false;
    }
    public void mostrar(){
        System.out.println("Cuentra: "+direccion+" | Usuario: "+nombre);
        int total=0,noLeidos=0;
        for(int control=0;control<inbox.length;control++){
            if(inbox[control]!=null){
                total++;
                String estado;
                estado=inbox[control].esLeido()?"LEIDO":"SIN LEER";
                if(!inbox[control].esLeido()){
                    noLeidos++;
                }
                System.out.println(control+" - "+inbox[control].getEmisor()+" - "+inbox[control].getAsunto()+" - "+estado);
            }
        }
        System.out.println("\nCorreos sin leer: "+noLeidos);
        System.out.println("Total correos: "+total);
    }
    public void leerCorreo(int posicion){
        if(posicion>=0&&posicion<inbox.length&&inbox[posicion]!=null){
            inbox[posicion].imprimirCorreo();
            inbox[posicion].marcarcorreoLeido();
        }
        else{
            System.out.println("Correo inexistente");
        }
    }
    public void limpiarInbox(){
        for(int control=0;control<inbox.length;control++){
            if(inbox[control]!=null&&inbox[control].esLeido()){
                inbox[control]=null;
            }
        }
        System.out.println("Los correos leidos han sido elimindados");
    }
}