package Test;

import AccesoADatos.ClaseData;
import AccesoADatos.EntrenadorData;
import Entidades.Clase;
import Entidades.Entrenador;
import java.time.LocalTime;

public class MainTest {
    public static void main(String[] args) {
        
        System.out.println("///////////////////// PRUEBAS ENTRENADOR:");
        
        EntrenadorData ed = new EntrenadorData();
        
        Entrenador ent = new Entrenador(123456, "Pepe", "Juarez","Pilates","tarde",true);
        Entrenador ent2 = new Entrenador(234567, "Pipo", "Juarez","Yoga","Mañana",true);
        Entrenador ent3 = new Entrenador(345678, "Pipi", "Juarez","Calistenia","tarde",true);
        
        System.out.println("");
        System.out.println("///////////////////// Guardar Entrenador:");
        System.out.println("");
        
        ed.guardarEntrenador(ent);
        ed.guardarEntrenador(ent2);
        ed.guardarEntrenador(ent3);
        
        for (Entrenador entrenador : ed.listarEntrenadores()) {
            System.out.println(entrenador.toString());
        }
        
        System.out.println("");
        System.out.println("///////////////////// Modificar Entrenador:");
        System.out.println("");
        
        ent.setDni(123455);
        ed.modificarEntrenador(ent);

        for (Entrenador entrenador : ed.listarEntrenadores()) {
            System.out.println(entrenador.toString());
        }
        
        System.out.println("");
        System.out.println("///////////////////// Buscar entrenador por DNI:");
        System.out.println("");
        
        ent = ed.buscarEntrenadorPorDni(123455);
        System.out.println(ent.toString());
        
        System.out.println("");
        System.out.println("///////////////////// Buscar entrenador por ID:");
        System.out.println("");
        
        ent = ed.buscarEntrenador(ent.getIdEntrenador());
        System.out.println(ent.toString());
        
        System.out.println("");
        System.out.println("///////////////////// Eliminar entrenador:");
        System.out.println("");
        
        ed.eliminarEntrenador(123455);
        ent = ed.buscarEntrenadorPorDni(123455);
        
        for (Entrenador entrenador : ed.listarEntrenadores()) {
            System.out.println(entrenador.toString());
        }
        
        System.out.println("");
        System.out.println("///////////////////// Listar entrenadores activos:");
        System.out.println("");
        
        for (Entrenador entrenador : ed.listarEntrenadoresActivos()) {
            System.out.println(entrenador.toString());
        }
        
        System.out.println("");
        System.out.println("///////////////////// PRUEBAS CLASE:");
        System.out.println("");
        
        ClaseData cd = new ClaseData();
        
        LocalTime hora1 = LocalTime.parse("08:30:00");
        LocalTime hora2 = LocalTime.parse("18:30:00");
        LocalTime hora3 = LocalTime.parse("17:00:00");
        
        Clase clase0 = new Clase(ent,hora2,"Pilates",20,true);
        Clase clase1 = new Clase(ent2, hora1, "Yoga", 30, true);
        Clase clase2 = new Clase(ent3, hora2, "Calistenia", 30, true);
        Clase clase3 = new Clase(ent2,hora1,"Yoda",25,false);
        
        System.out.println("");
        System.out.println("///////////////////// Guardar Clase:");
        System.out.println("");
        
        cd.guardarClase(clase0);
        cd.guardarClase(clase1);
        cd.guardarClase(clase2);
        cd.guardarClase(clase3);
        
        for (Clase cl : cd.listarClases()) {
            System.out.println(cl.toString());
        }
        
        System.out.println("");
        System.out.println("///////////////////// Buscar Clase:");
        System.out.println("");
        
        Clase clase4 = cd.buscarClase(clase2.getIdClase());
        System.out.println(clase4.toString());
        
        System.out.println("");
        System.out.println("///////////////////// Modificar Clase:");
        System.out.println("");
        
        clase4.setHorario(hora3);
        cd.modificarClase(clase4);
        System.out.println(clase4.toString());
        
        System.out.println("");
        System.out.println("///////////////////// Eliminar Clase:");
        System.out.println("");
        
        for (Clase cl : cd.listarClases()) {
            System.out.println(cl.toString());
        }
        
        System.out.println("");
        System.out.println("///////////////////// Listar clases activas:");
        System.out.println("");
        
        for (Clase cl : cd.listarClasesActivas()) {
            System.out.println(cl.toString());
        }
    }
}
