package Prog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CancelListDaoImpl implements CancelListDao {
private Map<Integer,CancelList> map;
	
	public CancelListDaoImpl()
	{
		map=new HashMap<Integer,CancelList>();
	}
	public int addProductToCancelList(CancelList product) throws CancelListException {
		boolean flag = map.containsKey(product.getProductId());
		if(flag)
		{
			throw new CancelListException("Product is present in the list");
		}
		map.put(product.getProductId(), product);
		return product.getProductId();
	}

		
   public List<CancelList> findAllProductsInCancelList() throws CancelListException {
		Collection<CancelList> col = map.values();
		List<CancelList> list = new ArrayList<>();
		
		for(CancelList w : col)
		{
			list.add(w);
		}
		return list;
	}
public void removeProductfromCancelList(CancelList w2)throws CancelListException {
	// TODO Auto-generated method stub
	boolean flag=false;
	int i=0;
	for (Map.Entry<Integer,CancelList> entry : map.entrySet())  
	{
	    if((entry.getValue().getProductId())==(w2.getProductId())){
			 i=(entry.getKey());
			flag=true;
			break;
		}
	}
	if(flag)
	{
		//System.out.println(map.get(c).getProductId());
		map.remove(i);
		System.out.println("Product is cancelled sucessfully from your order");
				//System.out.println(map);
	}
	
}
   public void removeOrderList()throws CancelListException {
	// TODO Auto-generated method stub
	   map.clear();
	  System.out.println("Order is cancelled");
	   
}

}

	
	

