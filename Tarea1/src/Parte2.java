public class Parte2 {

    public static void main(String[] args) {
        //Ej 1
        Parte1.creaDirectorio("/home/dam/Documentos/AcesoDatos/Tarea1/arquivosdir");

        //Ej2
        Parte1.creaFicheiro("/home/dam/Documentos/AcesoDatos/Tarea1/arquivosdir","Products.txt");

        //Ej3
        Parte1.creaDirectorio("/home/dam/Documentos/AcesoDatos/Tarea1/arquivosdir/subdir");
        Parte1.creaFicheiro("/home/dam/Documentos/AcesoDatos/Tarea1/arquivosdir/subdir","Products2.txt");
    }
}
