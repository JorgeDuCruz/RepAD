import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Connection con = Conexion.conexion();
        System.out.println(con);

        /*
        Ford Mustang 2021
Descrición: Deportivos americanos icónicos.
Tesla Model S 2023
Descrición: Sedán eléctrico de luxo con gran autonomía.
Honda Civic 2020
Descrición: Compacto de gran fiabilidade.
Chevrolet Corvette 2022
Descrición: Deportivo americano con motor V8.
Toyota Prius 2022
Descrición: Híbrido de baixo consumo e ecolóxico.
         */



        ServicioTienda.eliminarVehiculos(con);
        ServicioVehiculo.eliminarVehiculos(con);


        ArrayList<Vehiculo> listaV = new ArrayList<>();
        listaV.add(new Vehiculo("Mustang","Ford",2021,"Deportivos americanos icónicos."));
        listaV.add(new Vehiculo("Model S","Tesla",2023,"Sedán eléctrico de luxo con gran autonomía."));
        listaV.add(new Vehiculo("Civic","Honda",2020,"Compacto de gran fiabilidade."));
        listaV.add(new Vehiculo("Corvette","Chevrolet",2022,"Deportivo americano con motor V8."));
        listaV.add(new Vehiculo("Prius","Toyota",2022,"Híbrido de baixo consumo e ecolóxico."));

        for (Vehiculo vehiculo:listaV){
            ServicioVehiculo.inxertarvehiculo(con,vehiculo);
        }

        ImportarXML.importarXML(con);
        SerializarVehiculo.serializarVehiculos(con);

        /*
        (Id de Ford Mustang), 25000.00, 30000.00, 10
(Id de Tesla Model S), 40000.00, 50000.00, 12
(Id de Honda Civic), 18000.00, 22000.00, 5
(Id de Chevrolet Corvette), 60000.00, 70000.00, 8
(Id de Toyota Prius), 25000.00, 30000.00, 6
         */
        listaV = ServicioVehiculo.leerVehiculos(con);
        ServicioTienda.inxertarvehiculo(con,new Inventario(listaV.get(0).getId(),25000,30000,10));
        ServicioTienda.inxertarvehiculo(con,new Inventario(listaV.get(1).getId(),40000,50000,12));
        ServicioTienda.inxertarvehiculo(con,new Inventario(listaV.get(2).getId(),18000,22000,5));
        ServicioTienda.inxertarvehiculo(con,new Inventario(listaV.get(3).getId(),60000,70000,8));
        ServicioTienda.inxertarvehiculo(con,new Inventario(listaV.get(4).getId(),25000,30000,6));

        System.out.println("OFERTAS COCHES");
        ArrayList<Inventario> listI = ServicioTienda.leerVehiculos(con);

        for (Inventario inventario:listI){
            inventario.setPorcentaxeOferta(inventario.getPorcentaxeOferta()+15);
            ServicioTienda.actualizarVehiculo(con,inventario.getId(),inventario);
        }

        System.out.println("Prezo Fort: "+(listI.get(0).getPrezoV()*listI.get(0).getPorcentaxeOferta()/100));

        listaV = DesserializarVehiculos.desserializarVehiculos();

        for (Vehiculo vehiculo:listaV){
            System.out.println(vehiculo);
            SerializarVariosObjetos.serializarVehiculos(vehiculo);
        }

        EscribirFicheiro.escribri(listaV);
    }
}