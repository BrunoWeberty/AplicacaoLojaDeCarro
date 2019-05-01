package classesBO;

import classesDAO.CarroDAO;
import java.util.List;
import objetos.Carro;


public class CarroBO 
{
    CarroDAO cDAO;
    
    public CarroBO()
    {
        cDAO = new CarroDAO();
    }
    
    public void salvar(Carro c)
    {
        cDAO.salvar(c);
    }
    
    public List<Carro> getCarros()
    {
        return cDAO.getCarros();
    }
}
