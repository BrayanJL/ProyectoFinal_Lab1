package Test;
import AccesoADatos.MembresiaData;
import AccesoADatos.SocioData;
import Entidades.Membresia;
import Entidades.Socio;
import java.time.LocalDate;
import java.time.Month;

public class PruebasMembresiaSocio {
    public static void main(String[] args) {
        
//        System.out.println("PRUEBAS SOCIOS");
        SocioData sd = new SocioData();
//        Socio socio1 = new Socio(42375484, "Jose", "Ramirez", 24, "JoseRamirez@Gmail.com", "2664734954", true);
//        
//        System.out.println("GUARDAR SOCIOS");
//        sd.guardarSocio(socio1);
//        
//        System.out.println("BUSCAR SOCIO");
//        Socio socio2 = sd.buscarSocio(socio1.getIdSocio());
//        
//        System.out.println(socio1.toString());
//        System.out.println(socio2.toString());
//        
//        
//        Socio socio2 = sd.buscarSocioPorDNI(socio1.getDni());
//        
//        System.out.println(socio1.toString());
//        System.out.println(socio2.toString());
//        
//        System.out.println("MODIFICAR SOCIO");
//        
//        Socio socio3 = new Socio(socio1.getDni(), "Josefina", "Josefinez", 19, "Josef@Gmail.com", "2664989898", true);
//        
//        sd.modificarSocio(socio3);
//        
//        System.out.println("LISTAR SOCIOS");
//        
//        for (Socio a : sd.listarSocios()) {
//            System.out.println(a.toString());
//        }
//        
//        Socio socio4 = new Socio(38888888, "Hermione", "Pepinez", 33, "Herma@hotmail.com", "2664664433", true);
//        Socio socio5 = new Socio(38999888, "Richard", "Pepinez", 54, "Ricky@hotmail.com", "2664768798", false);
//        
//        sd.guardarSocio(socio4);
//        sd.guardarSocio(socio5);
//        
//        System.out.println("LISTAR SOCIOS ACTIVOS");
//        
//        System.out.println("Todos los socios:");
//        
//        for (Socio a : sd.listarSocios()) {
//            System.out.println(a.toString());
//        }
//        
//        System.out.println("Solo activos:");
//        
//        for (Socio a : sd.listarSociosActivos()) {
//            System.out.println(a.toString());
//        }
//        
//        System.out.println("ELIMINAR SOCIOS");
//        
//        sd.eliminarSocio(socio4.getDni());
//        
//        System.out.println("Todos los socios:");
//        
//        for (Socio a : sd.listarSocios()) {
//            System.out.println(a.toString());
//        }
//        
//        System.out.println("Solo activos:");
//        
//        for (Socio a : sd.listarSociosActivos()) {
//            System.out.println(a.toString());
//        }
        
        System.out.println("PRUEBAS MEMBRESIA");
        MembresiaData md = new MembresiaData();
        
        Socio socio1 = new Socio(42375484, "Jose", "Ramirez", 24, "JoseRamirez@Gmail.com", "2664734954", true);
        Socio socio4 = new Socio(38888888, "Hermione", "Pepinez", 33, "Herma@hotmail.com", "2664664433", true);
        Socio socio5 = new Socio(40999888, "Richard", "Pepinez", 54, "Ricky@hotmail.com", "2664768798", false);
        Socio socio6 = new Socio(38777888, "Robert", "Nixon", 54, "Robxon@hotmail.com", "2664866998", true);
        
        sd.guardarSocio(socio1);
        sd.guardarSocio(socio4);
        sd.guardarSocio(socio5);
        sd.guardarSocio(socio6);
        
        System.out.println("GUARDAR MEMBRESIA");
        
        Membresia membresia1 = new Membresia(socio1, 12, LocalDate.of(2024, Month.MARCH, 23), LocalDate.of(2024, Month.APRIL, 23), 2000, true);
        Membresia membresia2 = new Membresia(socio4, 12, LocalDate.of(2024, Month.MAY, 12), LocalDate.of(2024, Month.JUNE, 12), 2500, true);
        Membresia membresia3 = new Membresia(socio5, 20, LocalDate.of(2023, Month.DECEMBER, 30), LocalDate.of(2024, Month.JANUARY, 30), 1800, false);
        Membresia membresia4 = new Membresia(socio6, 20, LocalDate.of(2024, Month.APRIL, 10), LocalDate.of(2024, Month.MAY, 10), 1800, true);
        
        md.guardarMembresia(membresia1);
        md.guardarMembresia(membresia2);
        md.guardarMembresia(membresia3);
        md.guardarMembresia(membresia4);
        
        
        System.out.println("LISTAR MEMBRESIAS");
        
        for (Membresia a :  md.listarMembresias()) {
            System.out.println(a.toString());
        }
        
        System.out.println("MODIFICAR COSTO");
        
        md.modificarCosto(membresia1.getIdMembresia(), 2400);
        
        for (Membresia a :  md.listarMembresias()) {
            System.out.println(a.toString());
        }
       
        
        for (Membresia a :  md.listarMembresias()) {
            System.out.println(a.toString());
        }
        
        System.out.println("ELIMINAR MEMBRESIA");
        
        md.eliminarMembresia(membresia4.getIdMembresia());
        
        for (Membresia a :  md.listarMembresias()) {
            System.out.println(a.toString());
        }
        
        System.out.println("HABILITAR MEMBRESIA");
        
        md.habilitarMembresia(membresia4.getIdMembresia());
        
        for (Membresia a :  md.listarMembresias()) {
            System.out.println(a.toString());
        }
        
    }
}
