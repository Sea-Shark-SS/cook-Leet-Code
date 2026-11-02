package Medium2;

public class Pow {
public static double pow(double x ,int n ) {
	 
    if(n < 0){
        n = -n;
        x = 1 / x;
    }
    
    double pow = 1;
    
    while(n != 0){
        if((n & 1) != 0){
            pow *= x;
        } 
            
        x *= x;
        n >>>= 1;
        
    }
    
    return pow;
	
}
	public static void main(String[] args) {
	double x =2;
	int n=-2147483648;
	System.out.println(pow(x,n));
}
}
