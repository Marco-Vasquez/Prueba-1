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
        System.out.println("0. Salir");
        System.out.println("Seleccione una opcion: ");
        int opcion;
        while(true){
            if(lector.hasNextInt()){
                opcion=lector.nextInt();
                lector.nextLine();
                if(opcion==0||opcion==1||opcion==2){
                    break;
                }
                else{
                    System.out.println("Opcion invalida, intente de nuevo: ");
                }
            }
            else{
                System.out.println("Solo se permiten las opciones indicadas, intente de nuevo: ");
                lector.nextLine();
            }
        }
        switch(opcion){
            case 1:
                login();
                break;
            case 2:
                crearCuenta();
                break;
            case 0:
                System.out.println("Saliendo");
                System.exit(0);
                break;
        }
    }
    public static void login(){
        System.out.println("Correo: ");
        String correo=lector.nextLine();
        System.out.println("Contraseña: ");
        String contra=lector.nextLine();
        for(EmailAccount account:cuentas){
            if(account!=null&&account.getDireccion().equals(correo)&&account.getContra().equals(contra)){
                cuentaactiva=account;
                System.out.println("Login exitoso");
                return;
            }
        }
        System.out.println("Correo o contraseña incorrecta");
    }
    public static void crearCuenta(){
        System.out.println("Correo: ");
        String correo=lector.nextLine();
        for(EmailAccount account:cuentas){
            if(account!=null&&account.getDireccion().equals(correo)){
                System.out.println("Este correo ya existe");
                return;
            }
        }
        System.out.println("Nombre: ");
        String nombre=lector.nextLine();
        System.out.println("Contraseña: ");
        String contra=lector.nextLine();
        for(int control=0;control<cuentas.length;control++){
            if(cuentas[control]==null){
                cuentas[control]=new EmailAccount(correo,contra,nombre);
                cuentaactiva=cuentas[control];
                System.out.println("Cuenta creada");
                return;
            }
        }
        System.out.println("No hay espacio para crear otra cuenta");
    }
    public static void menuPrincipal(){
        System.out.println("\n1. Ver inbox");
        System.out.println("2. Mandar correo");
        System.out.println("3. Leer correo");
        System.out.println("4. Limpiar inbox");
        System.out.println("5. Cerrar sesion");
        System.out.println("Escriba la opcion: ");
        int opcion;
        while(true){
            if(lector.hasNextInt()){
                opcion=lector.nextInt();
                lector.nextLine();
                if(opcion>=1&&opcion<=5){
                    break;
                }
                else{
                    System.out.println("Opcion invalida, intente de nuevo: ");
                }
            }
            else{
                System.out.println("Solo se permiten las opciones indicadas, intente de nuevo: ");
                lector.nextLine();
            }
        }
        switch(opcion){
            case 1:
                cuentaactiva.mostrar();
                break;
            case 2:
                enviarCorreo();
                break;
            case 3:
                System.out.println("Posicion: ");
                int posicion;
                while(true){
                    if(lector.hasNextInt()){
                        posicion=lector.nextInt();
                        lector.nextLine();
                        break;
                    }
                    else{
                        System.out.println("Solo se permiten numeros, intente de nuevo: ");
                        lector.nextLine();
                    }
                }
                cuentaactiva.leerCorreo(posicion);
                break;
            case 4:
                cuentaactiva.limpiarInbox();
                break;
            case 5:
                cuentaactiva=null;
                System.out.println("Sesion cerrada");
                break;
        }
    }
    public static void enviarCorreo(){
        System.out.println("Destinatario: ");
        String destino=lector.nextLine();
        EmailAccount receptor=null;
        for(EmailAccount account:cuentas){
            if(account!=null&&account.getDireccion().equals(destino)){
                receptor=account;
                break;
            }
        }
        if(receptor==null){
            System.out.println("Usuario no existente");
            return;
        }
        System.out.println("Asunto: ");
        String asunto=lector.nextLine();
        System.out.println("Contenido: ");
        String contenido=lector.nextLine();
        Email nuevo=new Email(cuentaactiva.getDireccion(),asunto,contenido);
        if(receptor.recibir(nuevo)){
            System.out.println("Correo enviado correctamente");
        }
        else{
            System.out.println("Inbox lleno");
        }
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