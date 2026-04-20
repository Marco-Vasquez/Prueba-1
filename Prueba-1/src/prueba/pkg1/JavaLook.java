/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.pkg1;
import java.util.Scanner;
/**
 *
 * @author andres
 */
public class JavaLook {
    static EmailAccount[] cuentas=new EmailAccount[100];
    static EmailAccount cuentaactiva=null;
    static Scanner lector=new Scanner(System.in);
    public static void menuInicial(){
        System.out.println("\n1. Login");
        System.out.println("2. Crear cuenta");
        System.out.println("Seleccione una opcion: ");
        int opcion=lector.nextInt();
        switch(opcion){
            case 1: 
                login();
                break;
            case 2:
                crearCuenta();
                break;
        }
    }
    public static void login(){
        System.out.println("Correo: ");
        String correo=lector.nextLine();
        System.out.println("Contraseña: ");
        String contra=lector.nextLine();
        for(EmailAccount account:cuentas){
            if(account!=null && account.getDireccion().equals(correo) && account.getContra().equals(contra)){
                cuentaactiva=account;
                System.out.println("Login exitoso");
                return;
            }    
        }
        System.out.println("Correo o contraseña incorrecta");
    }
    
    public static void main(String[]args){
        while(true){
            if(cuentaactiva==null){
                menuInicial();
            }
            else{
                menuPrincipal();
            }
        }
    }
    
}
