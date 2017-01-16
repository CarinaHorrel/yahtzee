import java.util.Random;

public class Dobbelsteen {
	private int value;
	
	Random rand =  new Random(); //instance variable, object type
	
// methode gooiDobbelsteen
int gooiDobbelsteen() {
	int ogenDobbelsteen;    
	ogenDobbelsteen = 1+rand.nextInt(6);
	value=ogenDobbelsteen;
	return ogenDobbelsteen;
    }
	 
int getValue(){
	return value;
}
}

