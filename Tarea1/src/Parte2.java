public class Parte2 {

    public static void main(String[] args) {
        //Ej 1
        Parte1.creaDirectorio("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir");
        System.out.println(Parte1.eDirectorio("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir"));
        //Ej2
        Parte1.creaFicheiro("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir","Products.txt");
        System.out.println(Parte1.eFicheiro("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir/Products.txt"));

        //Ej3
        Parte1.creaDirectorio("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir/subdir");
        Parte1.creaFicheiro("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir/subdir","Products2.txt");

        //Ej4
        Parte1.mContido("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir");

        //Ej5
        Parte1.modoAcceso("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir","Products.txt");
        System.out.println(Parte1.calculaLonxitude("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir","Products.txt"));

        //Ej6
        Parte1.mLectura("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir","Products.txt");

        //Ej7
        Parte1.mEscritura("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir","Products.txt");

        //Ej8
        Parte1.borraFicheiro("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir","Products.txt");

        //Ej9
        Parte1.borraDirectorio("/home/dam/Documentos/AD/RepAD/Tarea1/arquivosdir");
    }
}
