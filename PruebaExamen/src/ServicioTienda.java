import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicioTienda {

    public static void inxertarvehiculo(Connection con,Inventario inventario){
        String sql = "insert into inventariotenda (IdVehiculo, PrezoMayorista, PrezoVenta,PorcentaxeOferta) values (?,?,?,?)";
        try {
            PreparedStatement insertar = con.prepareStatement(sql);
            insertar.setInt(1,inventario.getIdV());
            insertar.setDouble(2,inventario.getPrezoM());
            insertar.setDouble(3,inventario.getPrezoV());
            insertar.setInt(4,inventario.getPorcentaxeOferta());
            insertar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fallo al insertar "+e.getMessage());
        }
    }

    public static ArrayList<Inventario> leerVehiculos(Connection con){
        String sql = "select * from inventariotenda";
        ArrayList<Inventario> lectura = new ArrayList<>();
        try {
            PreparedStatement ler = con.prepareStatement(sql);
            ResultSet resultado = ler.executeQuery();
            while (resultado.next()){
                int id = resultado.getInt(1);
                int idV = resultado.getInt(2);
                double prezoM = resultado.getDouble(3);
                double prezoV = resultado.getDouble(4);
                int porOfer = resultado.getInt(5);
                lectura.add(new Inventario(id,idV,prezoM,prezoV,porOfer));
            }
        } catch (SQLException e) {
            System.out.println("Fallo lectura "+e.getMessage());
        }
        return lectura;

    }

    public static void actualizarVehiculo(Connection con, int id, Inventario inventario){
        String sql = "update inventariotenda set id = ?,idvehiculo = ?,prezomayorista = ?,prezoventa = ?,porcentaxeoferta = ? where id = ?";
        try {
            PreparedStatement update = con.prepareStatement(sql);
            update.setInt(1,id);
            update.setInt(2,inventario.getIdV());
            update.setDouble(3,inventario.getPrezoM());
            update.setDouble(4,inventario.getPrezoV());
            update.setInt(5,inventario.getPorcentaxeOferta());
            update.setInt(6,id);
            update.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fallo al actualizar "+e.getMessage());
        }
    }

    public static void eliminarVehiculo(Connection con, int id){
        String sql = "delete from inventariotenda where id = ?";
        try {
            PreparedStatement borrar = con.prepareStatement(sql);
            borrar.setInt(1,id);
            borrar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fallo al borrar "+e.getMessage());
        }
    }
    public static void eliminarVehiculos(Connection con){
        String sql = "delete from inventariotenda";
        try {
            PreparedStatement borrar = con.prepareStatement(sql);
            borrar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fallo al borrar "+e.getMessage());
        }
    }
}
