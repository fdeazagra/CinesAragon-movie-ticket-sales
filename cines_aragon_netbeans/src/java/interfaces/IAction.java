
package interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface que impone un único método para localizar las acciones.
 * 
 * @author Fernando Martínez de Azagra Detraux
 */
public interface IAction {
	 public String execute(
	            HttpServletRequest request, 
	            HttpServletResponse response
	   ); 
}
