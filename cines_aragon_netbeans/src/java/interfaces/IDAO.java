
package interfaces;

import java.util.ArrayList;

/**
 * Interface que impone usar los mismos métodos para las operaciones CRUD.
 * 
 * @author Fernando Martínez de Azagra Detraux
 */
public interface IDAO <B,I> {
//:3	
    public int add(B bean);
    public int delete(I Integer);
    public ArrayList<B> findAll(B bean);
    public int update(B bean);
	

}
