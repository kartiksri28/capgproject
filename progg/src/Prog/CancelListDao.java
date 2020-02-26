package Prog;

import java.util.List;

public interface CancelListDao {

	public int addProductToCancelList(CancelList product ) throws CancelListException;
	public List<CancelList> findAllProductsInCancelList() throws CancelListException;
	public void removeProductfromCancelList(CancelList w2) throws CancelListException;
	public void removeOrderList() throws CancelListException;
	

}
