import java.io.*;

public class Parte3 {

    public static void main(String[] args) {
        primerMetodo("texto3.txt", "o tempo está xélido");
    }

    public static void primerMetodo(String rutaD, String textoCopiar) {
        try {
            DataOutputStream escribir = new DataOutputStream(new FileOutputStream(rutaD));
            DataInputStream leer = new DataInputStream(new FileInputStream(rutaD));
            int correccion=0;
            for (int i=0;i<3;i++){
                System.out.println("Escribindo a cadea: "+textoCopiar+","+i);
                escribir.writeUTF(textoCopiar+","+i);
                System.out.println("Tamaño del fichero: "+escribir.size());
                if (i==0){
                    correccion = escribir.size()-(textoCopiar+","+i).length();
                    System.out.println(correccion);
                }
            }
            //termina de escribir
            long fichero = leer.available();
            System.out.println("tamaño final del archivo: "+fichero);


            while (fichero>0){
                System.out.println("Quedan por leer "+fichero+" bytes");
                String lectura = leer.readUTF();
                System.out.println("cadea: "+lectura);
                int leido = lectura.length();
                fichero = fichero-leido-correccion; // Le resta a la longitud total del fichero los bytes que se han leido y tambien los 4 bytes que referencian a los bytes leidos
            }
            System.out.println("Ya no queda nada por leer");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
