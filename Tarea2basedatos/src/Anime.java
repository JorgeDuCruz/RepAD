import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Anime {
    String nome;
    String descripcion;
    Date fecha;
    int puntuacion;

    Anime(String nome, String descripcion, String fecha, int puntuacion){
        this.nome = nome;
        this.descripcion = descripcion;
        setFecha(fecha);
        setPuntuacion(puntuacion);
    }

    public void setFecha(String fecha) {
        Date fechaFormateada = stringToDate(fecha);
        if (fechaFormateada != null) {
            this.fecha = fechaFormateada;
        } else {
            this.fecha = Date.valueOf("1900-01-01");
        }
    }

    public void setPuntuacion(int puntuacion) {
        if (puntuacion>=0 && puntuacion<=100){
            this.puntuacion = puntuacion;
        }
        else {
            this.puntuacion=0;
        }
    }

    public static String dateToString(Date dataD) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(dataD);
    }

    private Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println("petou "+ e.getMessage());
            return null;
        }
    }
}
