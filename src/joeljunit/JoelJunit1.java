package joeljunit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoelJunit1 {

    public static void main(String[] args) {
        String input;
        Personaje p;
        List<String> estadisticas = new ArrayList<>();
        boolean bucle = true;
        Scanner sc = new Scanner(System.in);

        do {
            input = sc.nextLine();
            estadisticas = new ArrayList<>();

            if (input.equalsIgnoreCase("EXIT")) {
                break;
            } else {
                
                if(input.contains(";")){
                    estadisticas.addAll(List.of(input.split(";")));
                }else{
                    System.out.println("Mal");
                    continue;
                }
                
                
                p = new Personaje();

                // Validaciones de las estadísticas y el nombre
                if (!p.validarNombre(estadisticas.get(0)) || 
                    !p.validarClase(estadisticas.get(1)) || 
                    !p.validarEntero(estadisticas.get(2), 1, 20) ||
                    !p.validarEntero(estadisticas.get(3), 7, 20) ||
                    !p.validarEntero(estadisticas.get(4), 7, 20) ||
                    !p.validarEntero(estadisticas.get(5), 7, 20) ||
                    !p.validarEntero(estadisticas.get(6), 7, 20) ||
                    !p.validarEntero(estadisticas.get(7), 7, 20) ||
                    !p.validarEntero(estadisticas.get(8), 7, 20)) {
                    System.out.println("Mal");
                    continue; // Continuar con la siguiente iteración
                }

                // Establecer las estadísticas si todas son válidas
                p.setNombre(estadisticas.get(0));
                p.setClase(estadisticas.get(1));
                p.setNivel(Integer.parseInt(estadisticas.get(2)));
                p.setFuerza(Integer.parseInt(estadisticas.get(3)));
                p.setDestreza(Integer.parseInt(estadisticas.get(4)));
                p.setConstitucion(Integer.parseInt(estadisticas.get(5)));
                p.setInteligencia(Integer.parseInt(estadisticas.get(6)));
                p.setSabiduria(Integer.parseInt(estadisticas.get(7)));
                p.setCarisma(Integer.parseInt(estadisticas.get(8)));

                System.out.print(p.nombre+";");
                System.out.print("ca="+p.calcularCa()+";");
                System.out.println("pg="+p.calcularPuntosGolpe()+";");
            }

        } while (bucle);
    }

    public static class Personaje {

        private String nombre, clase;
        private int nivel;
        int claseArmadura, puntosGolpe;
        int fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;
        
        private static boolean validarNombre(String nombre) {
            return !nombre.isEmpty();
        }

        private static boolean validarClase(String clase) {
            return clase.equals("G") || clase.equals("M");
        }

        private static boolean validarEntero(String valor, int min, int max) {
            try {
                int num = Integer.parseInt(valor);
                return num >= min && num <= max;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        public int calcularPuntosGolpe(){
            
            int puntosGolpe = 0;
            
            switch (clase) {
                case "G":
                    
                    for (int i = 0; i < nivel; i++) {
                        puntosGolpe += 10 + constitucion;
                    }
                    
                    break;
                case "M":
                    
                    for (int i = 0; i < nivel; i++) {
                        puntosGolpe += 4 + constitucion;
                    }
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
            return puntosGolpe;
        }
        
        public int calcularCa(){
            
            return 10+((destreza-10)/2);
            
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setClase(String clase) {
            if (!clase.equals("G") && !clase.equals("M")) {
                System.out.println("Mal");
                return;
            }
            this.clase = clase;
        }

        public void setNivel(int nivel) {
            if (nivel < 1 || nivel > 20) {
                System.out.println("Mal");
                return;
            }
            this.nivel = nivel;
        }

        public void setFuerza(int fuerza) {
            if (fuerza < 1 || fuerza > 20) {
                System.out.println("Mal");
                return;
            }
            this.fuerza = fuerza;
        }

        public void setDestreza(int destreza) {
            if (destreza < 1 || destreza > 20) {
                System.out.println("Mal");
                return;
            }
            this.destreza = destreza;
        }

        public void setConstitucion(int constitucion) {
            if (constitucion < 1 || constitucion > 20) {
                System.out.println("Mal");
                return;
            }
            this.constitucion = constitucion;
        }

        public void setInteligencia(int inteligencia) {
            if (inteligencia < 1 || inteligencia > 20) {
                System.out.println("Mal");
                return;
            }
            this.inteligencia = inteligencia;
        }

        public void setSabiduria(int sabiduria) {
            if (sabiduria < 1 || sabiduria > 20) {
                System.out.println("Mal");
                return;
            }
            this.sabiduria = sabiduria;
        }

        public void setCarisma(int carisma) {
            if (carisma < 1 || carisma > 20) {
                System.out.println("Mal");
                return;
            }
            this.carisma = carisma;
        }

        @Override
        public String toString() {
            return "Personaje{" + "nombre=" + nombre + ", clase=" + clase + ", nivel=" + nivel + ", claseArmadura=" + claseArmadura + ", puntosGolpe=" + puntosGolpe + " | fuerza=" + fuerza + ", destreza=" + destreza + ", constitucion=" + constitucion + ", inteligencia=" + inteligencia + ", sabiduria=" + sabiduria + ", carisma=" + carisma + '}';
        }
    }
}
