
package interfaces;

import java.sql.ResultSet;

/**
 * Interface que impone los mismos métodos para conectar, 
 * hacer consultas y desconectar con la BBDD.
 * 
 * @author Fernando Martínez de Azagra Detraux
 */
public interface IMotorSQL {
	
	public void connect();
	public int execute(String sql);
	public ResultSet executeQuery(String sql);
	public void disconnect();

}
