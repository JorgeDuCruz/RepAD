import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicioVehiculo {

    public static void inxertarvehiculo(Connection con, Vehiculo vehiculo){
        String sql = "insert into vehiculo (modelo, marca, ano,descripcion) values (?,?,?,?)";
        try {
            PreparedStatement insertar = con.prepareStatement(sql);
            insertar.setString(1,vehiculo.getModelo());
            insertar.setString(2,vehiculo.getMarca());
            insertar.setInt(3,vehiculo.getAno());
            insertar.setString(4,vehiculo.getDescipcion());
            insertar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fallo al insertar "+e.getMessage());
        }
    }

    public static ArrayList<Vehiculo> leerVehiculos(Connection con){
        String sql = "select * from vehiculo";
        ArrayList<Vehiculo> lectura = new ArrayList<>();
        try {
            PreparedStatement ler = con.prepareStatement(sql);
            ResultSet resultado = ler.executeQuery();
            while (resultado.next()){
                int id = resultado.getInt(1);
                String modelo = resultado.getString(2);
                String marca = resultado.getString(3);
                int ano = resultado.getInt(4);
                String desc = resultado.getString(5);
                lectura.add(new Vehiculo(id,modelo,marca,ano,desc));
            }
        } catch (SQLException e) {
            System.out.println("Fallo lectura "+e.getMessage());
        }
        return lectura;

    }

    public static void actualizarVehiculo(Connection con, int id, Vehiculo vehiculo){
        String sql = "update vehiculo set id = ?,modelo = ?,marca = ?,ano = ?,descripcion = ? where id = ?";
        try {
            PreparedStatement update = con.prepareStatement(sql);
            update.setInt(1,id);
            update.setString(2,vehiculo.getModelo());
            update.setString(3, vehiculo.getMarca());
            update.setInt(4,vehiculo.getAno());
            update.setString(5, vehiculo.getDescipcion());
            update.setInt(6,id);
            update.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fallo al actualizar "+e.getMessage());
        }
    }

    public static void eliminarVehiculo(Connection con, int id){
        String sql = "delete from vehiculo where id = ?";
        try {
            PreparedStatement borrar = con.prepareStatement(sql);
            borrar.setInt(1,id);
            borrar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fallo al borrar "+e.getMessage());
        }
    }

    public static void eliminarVehiculos(Connection con){
        String sql = "delete from vehiculo";
        try {
            PreparedStatement borrar = con.prepareStatement(sql);
            borrar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fallo al borrar "+e.getMessage());
        }
    }
}
