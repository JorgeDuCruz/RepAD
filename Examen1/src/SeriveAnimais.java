import java.sql.Connection;

public class SeriveAnimais {
    public static void insertarAnimal(Connection conn,String nome, String especie, int cantidae){
        String sql = "insert into animais (nome,especie,cantidade) values(?,?,?);";
    }
}
