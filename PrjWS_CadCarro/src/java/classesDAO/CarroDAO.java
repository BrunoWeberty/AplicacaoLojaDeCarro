package classesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import objetos.Carro;
import utilitarios.Conexao;

public class CarroDAO 
{

    Connection conn;

    public CarroDAO() 
    {
        conn = new Conexao().conexao();
    }

    public void salvar(Carro c) 
    {
        try {
            PreparedStatement ppStmt = conn.prepareStatement("INSERT INTO carro(modelo, marca, ano, placa) values(?,?,?,?)");
            ppStmt.setString(1, c.getModelo());
            ppStmt.setString(2, c.getMarca());
            ppStmt.setInt(3, c.getAno());
            ppStmt.setString(4, c.getPlaca());
            ppStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();//Mostra erro no prompt
        }
    }

    public List<Carro> getCarros() 
    {
        List<Carro> lstC = new LinkedList<Carro>();

        try {
            PreparedStatement ppStmt = conn.prepareStatement("SELECT * FROM carro");
            ResultSet rs = ppStmt.executeQuery();
            while (rs.next()) {
                lstC.add(getCarro(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();//Mostra erro no prompt
        }
        return lstC;
    }

    private Carro getCarro(ResultSet rs) throws SQLException
    {
        Carro c = new Carro();

        c.setModelo(rs.getString("modelo"));
        c.setMarca(rs.getString("marca"));
        c.setPlaca(rs.getString("placa"));
        c.setAno(rs.getInt("ano"));

        return c;
    }
}
