/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import AccesoADatos.AsistenciaData;
import AccesoADatos.ClaseData;
import AccesoADatos.EntrenadorData;
import AccesoADatos.SocioData;
import Entidades.Asistencia;
import Entidades.Clase;
import Entidades.Entrenador;
import Entidades.Membresia;
import Entidades.Socio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

/**
 *
 * @author N
 */
public class PruebasAsistencia {
    public static void main(String args[]){
    
    System.out.println("///////////////////// PRUEBAS Asistencia:");
        ClaseData cd = new ClaseData();
        SocioData sd = new SocioData();
        AsistenciaData ad = new AsistenciaData();
        
        //Socio socio1 = new Socio(42375484, "Jose", "Ramirez", 24, "JoseRamirez@Gmail.com", "2664734954", true);
        //Socio socio4 = new Socio(38888888, "Hermione", "Pepinez", 33, "Herma@hotmail.com", "2664664433", true);
        //Socio socio5 = new Socio(40999888, "Richard", "Pepinez", 54, "Ricky@hotmail.com", "2664768798", false);
        //Socio socio6 = new Socio(38777888, "Robert", "Nixon", 54, "Robxon@hotmail.com", "2664866998", true);
        
        Socio socio1 = sd.buscarSocioPorDNI(42375484);
        Socio socio2 = sd.buscarSocioPorDNI(38888888);
        Socio socio3 = sd.buscarSocioPorDNI(40999888);
        Socio socio4 = sd.buscarSocioPorDNI(38777888);
     
        
        List<Clase> clases = cd.listarClases();
        List<Socio> socios = sd.listarSocios();
        
        for(Socio socio : socios){
            for(Clase clase : clases){
                LocalDate fecha = LocalDate.now();
                Asistencia asistencia = new Asistencia(socio,clase,fecha);
                
                ad.guardarAsistencia(asistencia);
                
                
                System.out.println(asistencia.toString());
            }
        }
        
    }
}
