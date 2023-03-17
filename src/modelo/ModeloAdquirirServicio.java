package modelo;

import java.util.Date;

public class ModeloAdquirirServicio extends AdquirirServicio{

    ConexionPG conpg = new ConexionPG();

    public ModeloAdquirirServicio() {
    }

    public ModeloAdquirirServicio(int adq_codigo, int adq_codcli, int adq_codins, int adq_codnut, int adq_codser, Date adq_fechainicio, int adq_mesesins, int adq_mesesnut, int adq_mesesser, double adq_costototal) {
        super(adq_codigo, adq_codcli, adq_codins, adq_codnut, adq_codser, adq_fechainicio, adq_mesesins, adq_mesesnut, adq_mesesser, adq_costototal);
    }
    
    public boolean crearAdquirirServicio() {
        String sql = "INSERT INTO adquirirServicio(adq_codcli, adq_codins, adq_codnut, adq_codser, adq_fechainicio, adq_mesesins, adq_mesesnut, adq_mesesser, adq_costototal, adq_estado) VALUES (" + getAdq_codcli() + "," + getAdq_codins() + ", " + getAdq_codnut() + ", " + getAdq_codser() + ",'" + getAdq_fechainicio() + "'," + getAdq_mesesins() + "," + getAdq_mesesnut() + "," + getAdq_mesesser() + "," + getAdq_costototal() + ",'A');";

        return conpg.accion(sql);
    }
}
