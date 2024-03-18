/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAW;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author victor
 */
public class Main {
//    Usando la herramienta regex101 y los apuntes de clase, obtén expresiones regulares para:

//    Saber si una cadena contiene el patrón AP-Nº (nombre de las autopistas), 
//    siendo Nº cualquier número de uno o dos dígitos. Ejemplos que cumplen el patrón: AP-7, AP-77...
    
//    Saber si una cadena coincide exactamente con el patrón anterior.
//    Saber si una cadena coincide exactamente con el patrón de la matrícula de un coche.
//    Saber si una cadena contiene el patrón letraNumero, tantas veces como se repita. Ejemplos que cumplen el patrón: e3, e3r4, q1w2d4, ...
//    Saber si una cadena es un código postal (5 dígitos)
//    Saber si una cadena es un usuario de IPasen, sabiendo que tiene entre 7 y 8 caracteres seguidos de 3 o 4 dígitos numéricos.
//    Saber si una cadena tiene tamaño 5 y no contiene ni F, ni R, ni K.
//    Saber si una cadena contiene las palabras "Hardware" o "Software".
    
    public static void main(String[] args) {
        //Apartado A -- AP-77
        System.out.println("Apartado A: primero debe ser false, segundo true");
        System.out.println(saberPrimerPatron("BP-78896"));
        System.out.println(saberPrimerPatron("AP-78896"));//Debe devolver true
        
        System.out.println("Apartado B: segundo debe ser false, segundo true");
        System.out.println(saberSegundoPatron("AP-78898"));
        System.out.println(saberSegundoPatron("AP-78"));//Debe devolver true
        
        System.out.println("Apartado C: tercero debe ser false, segundo true");
        System.out.println(saberTerceroPatron("7779-KRK9"));
        System.out.println(saberTerceroPatron("7779-KRK"));//Debe devolver true
        
        System.out.println("Apartado D: cuarto debe ser false, segundo true");
        System.out.println(saberCuartoPatron("1a2r"));//Devolver
        System.out.println(saberCuartoPatron("a1r2e3"));//Debe devolver 3
        
        System.out.println("Apartado E: quinto debe ser false, segundo true");
        System.out.println(saberQuintoPatron("296801"));//Devolverá false
        System.out.println(saberQuintoPatron("29680"));//Debe devolver true
        
        System.out.println("Apartado F: sexto debe ser false, segundo true");
        System.out.println(saberSextoPatron("2-*/+123456"));//Devolverá false
        System.out.println(saberSextoPatron("-*/+-*+1366"));//Debe devolver true
        
        System.out.println("Apartado G: septimo debe ser false, segundo true");
        System.out.println(saberSeptimoPatron("AAAAF"));//Devolverá false
        System.out.println(saberSeptimoPatron("ABABB"));//Debe devolver true
        
        System.out.println("Apartado H: octabo debe ser false, segundo true");
        System.out.println(saberOctavoPatron("ardware,Sftware"));//Devolverá false
        System.out.println(saberOctavoPatron("Hardware Software"));//Debe devolver true
        
        
        
    }
    
    //METODOS
    //Método para contar las palabras por linea del fichero
    public static boolean saberPrimerPatron(String linea) {
        boolean coincide=false;
        //Patron
        String regex = "AP-[0-9][0-9]*";
      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        return matcher.find();
    }
    //Método tercero
    public static boolean saberSegundoPatron(String linea) {
        boolean coincide=false;
        //Patron
        String regex = "^AP-\\d{1,2}$";
      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        return matcher.find();
    }
    
    //Método tercero
    public static boolean saberTerceroPatron(String linea) {
        boolean coincide=false;
        //Patron
        String regex = "^\\d{4}-([A-Z]){3}$";
      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        return matcher.find();
    }
    
    //Método cuarto
    public static int saberCuartoPatron(String linea) {
        boolean coincide=false;
        int contador=0;
        //Patron
        String regex = "[a-zA-Z]{1}\\d{1}+";
      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        while (matcher.find()) {
            contador++;
        }
        return contador;
    }
    
    //Método quinto
    public static boolean saberQuintoPatron(String linea) {
        boolean coincide=false;
        //Patron
        String regex = "^\\d{5}$";
      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        
        return matcher.find();
    }
    
    //Método sexto
    public static boolean saberSextoPatron(String linea) {
        boolean coincide=false;
        //Patron
        String regex = "^[^0-9]{7,8}\\d{3,4}$";
      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        
        return matcher.find();
    }
    
    
    public static boolean saberSeptimoPatron(String linea) {
        boolean coincide=false;
        //Patron
        String regex = "^[^FRK]{5}$";
      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        
        return matcher.find();
    }       
    
    public static boolean saberOctavoPatron(String linea) {
        boolean coincide=false;
        //Patron
        String regex = "\\b(Hardware|Software)\\b";
      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        
        return matcher.find();
    }       
            
}
