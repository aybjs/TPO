package test;

import rmi.BusinessDelegate;

public class Test {
		
	public static void main(String[] args)
	{
		try{
			BusinessDelegate sys = BusinessDelegate.getInstancia();			
			System.out.println(sys.test("ghghghjhjgg"));
		} 
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
