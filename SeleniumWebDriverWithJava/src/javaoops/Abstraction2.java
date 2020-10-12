package javaoops;

abstract class RBIBank{  
abstract void homeLoan();  
}  
//In real scenario, implementation is provided by others i.e. unknown by end user  
class ICICIBank extends RBIBank{  
void homeLoan(){System.out.println("8.9 percent");}  
}  
class SBIBank extends RBIBank{  
void homeLoan(){System.out.println("8.2 percent");}  
}  
class BOIBank extends RBIBank{  
void homeLoan(){System.out.println("8.5 percent");}  
} 
//In real scenario, method is called by programmer or user  
class Abstraction2{  
public static void main(String args[]){  
ICICIBank s1 = new ICICIBank();
s1.homeLoan();  
SBIBank s2 = new SBIBank(); 
s2.homeLoan();  
BOIBank s3 = new BOIBank(); 
s3.homeLoan(); 
}  
} 
