package Prog;

import java.util.List;
import Prog.CancelList;
import Prog.CancelListDao;
import java.util.Scanner;
public class Main{
	

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
	    CancelListDaoImpl wlService = new CancelListDaoImpl();
		
		int c= 0;
		CancelList wl = new CancelList();
		List<CancelList> list = null;
		while(true)
		{   
			System.out.println("...CANCEL MANAGEMENT SYSTEM...");
			System.out.println("=======================================");
			System.out.println("1.Add product to order list");
			System.out.println("2.View order list");
			System.out.println("3.Delete from order list");
			System.out.println("4.Delete whole order");
			System.out.println("5.Exit");
			System.out.println("enter your choice");
			c=sc.nextInt();
			switch(c)
			{
			case 1:
				System.out.println("Enter Product ID : ");
			    int pid = sc.nextInt();
				wl = new CancelList(pid);
				//wl.setProductId(pid);
				try
				{
				int id = wlService.addProductToCancelList(wl);
				System.out.println("Product Id = "+id+ " succesfully added to Order list");
				}
				catch(CancelListException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			
	            
			case 2:
				try
				{
					list = wlService.findAllProductsInCancelList();
					for(CancelList w : list)
						System.out.println("productId = "+w.getProductId());
				}
				catch(CancelListException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter Product ID : ");
			    int pd = sc.nextInt();
				CancelList w2 = new CancelList();
				w2.setProductId(pd);
				try
				{
					wlService.removeProductfromCancelList(w2);
				}
				catch(CancelListException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				//CancelList w3=new CancelList();
				try
				{
					wlService.removeOrderList();
				}
				catch(CancelListException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 5:
				break;
			
			default:
				System.err.println("Incorrect choice");
				System.err.println("enter correct choice");
				break;
			}
		}
	}
}
