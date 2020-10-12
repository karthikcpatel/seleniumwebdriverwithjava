package javaoops;

interface interfacefirst{  
void defaultmethod();  
}  
interface interfacesecond{  
void defaultmethod();  
}  
class MultipleInheritanceUsingInterface implements interfacefirst, interfacesecond{  
public void defaultmethod(){System.out.println("The default method is getting called...");}   
  
public static void main(String args[]){  
MultipleInheritanceUsingInterface obj = new MultipleInheritanceUsingInterface();  
obj.defaultmethod();  
 }  
} 
