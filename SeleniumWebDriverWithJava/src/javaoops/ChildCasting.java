package javaoops;

interface Casting
{
	void ChetanMoney();
}
class ParentCasting implements Casting
{
	public void ChetanMoney()
	{
		System.out.println("Chetan's Wealth");
	}
	}
public class ChildCasting extends ParentCasting
{
	public void KartikMoney() 
	{
		System.out.println("Kartik's wealth");
	}

public static void main(String[] args) 
{
	ParentCasting obj1 = new ParentCasting();
	obj1.ChetanMoney();
	ChildCasting obj2 = new ChildCasting();
	obj2.KartikMoney();
	obj2.ChetanMoney();
	ChildCasting obj3 = new ChildCasting();
	obj3.ChetanMoney();
	
	ParentCasting obj4 = (ParentCasting) obj2; //upcasting
	obj4.ChetanMoney();
	
	ParentCasting obj5 = new ChildCasting();  //downcasting
	ChildCasting obj6 = (ChildCasting)obj5;
	obj6.ChetanMoney();
	obj6.KartikMoney();
}
}