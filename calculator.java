import java.util.*;
//create a calculator class for Arithmetic Operations
class Calculator{
    int a,b;
    float a1,b1;
    char op;
    int turn;
    void setValue(String str,String str1,char op){
        if(str.contains(".")||str1.contains(".")){
            this.a1=Float.valueOf(str);
            this.b1=Float.valueOf(str1);
            this.op=op;
            turn=1;
        }
        else{
            this.a=Integer.valueOf(str);
            this.b=Integer.valueOf(str1);
            this.op=op;
            turn=0;
        }
    }
    void resetOperator(char ch){
        this.op=ch;
    }
    void ArithmeticOperations(){
        switch(op){
            case '+':
                if(turn==1){
                    System.out.printf("Answer:%.3f",(a1+b1));
                }
                else{
                    System.out.print("Answer:"+(a+b));
                }
                System.out.println();
                break;
            case '-':
               if(turn==1){
                    System.out.printf("Answer:%.3f",(a1-b1));
                }
                else{
                    System.out.print("Answer:"+(a-b));
                }
                System.out.println();
                break;
            case '/':
                if(b1!=0.0 ||b!=0){
                    if(turn==1){
                        System.out.printf("Answer:%.3f",(a1/b1));
                    }
                    else{
                        System.out.print("Answer:"+(a/b));
                    }
                    System.out.println();
                }
                else{
                    System.out.println("Zero is not Divisible by any number");
                }
                break;
            case '*':
                if(turn==1){
                    System.out.printf("Answer:%.3f",(a1*b1));
                }
                else{
                    System.out.print("Answer:"+(a*b));
                }
                System.out.println();
                break;
            case '^':
                if(turn==1){
                    System.out.printf("Answer:%.3f",(Math.pow(a1,b1)));
                }
                else{
                    System.out.print("Answer:"+(Math.pow(a,b)));
                }
                System.out.println();
                break;
            default:
                break;
        }
    }
    void fahrenheitToCelsius(double fahrenheit){
        System.out.printf("Fahrenheit:%.3f degree",((fahrenheit - 32)*5/9));
        System.out.println();
        
    }
    void celsiusToFahrenheit(double celsius){
        System.out.printf("Celsius:%.3f",celsius*(9/5)+32);
        System.out.println();
        
    }
    void SquareRoot(double number){
        try{
            double sqrt=Math.sqrt(number);
            System.out.printf("SquareRoot of %.2f: %.3f",number,sqrt);
            System.out.println();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
}
class Currency{
    double currency;
    Currency(double currency){
        this.currency=currency;
    }
    void america(){
        System.out.printf("America:%.2f$",currency*0.012);
        System.out.println();
    }
    void china(){
        System.out.printf("China:%.2f Yuan",currency*0.084);
        System.out.println();
    }
    void russia(){
        System.out.printf("Russia:%.2f Ruble",currency*1.13);
        System.out.println();
    }
    void pakistan(){
        System.out.printf("Pakistan:%.2f Pakistan rupee",currency*3.31);
        System.out.println();
    }
}
public class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        Calculator obj=new Calculator();
        boolean times=true;
        while(times){
            System.out.println("YOU Need Calculator enter 1");
            System.out.println("You need to exit enter 0");
            if(s.nextInt()==1){
                System.out.println("You need fahrenheit to celsius Enter f ");
                System.out.println("You need celsius to fahrenheit Enter c ");
                System.out.println("You need Arithmetic Operations Enter a");
                System.out.println("You need currency calculation enter r");
                System.out.println("You need Square root calculation enter s");
                char method=s.next().charAt(0);
                if(method=='a'){
                    System.out.println("Enter a first number:");
                    String str=s.next();
                    System.out.println("Enter a second number:");
                    String str1=s.next();
                    System.out.println("Enter a single operator like(+,-,/,*,^):");
                    char c;
                    while(true){
                        c=s.next().charAt(0);
                        if(c=='+'||c=='-'||c=='/'||c=='*'||c=='^'){
                            break;
                        }
                        else
                            System.out.println("Invalid Character Please enter a valid Operator");
                    }
                
                
                    obj.setValue(str,str1,c);
                    obj.ArithmeticOperations();
                    while(true){
                        System.out.println("Do you want to do any Operation with same numbers and differnt Operator Enter Y Otherwise enter N");
                        if(s.next().charAt(0)=='Y'){
                            System.out.println("Enter a single operator like(+,-,/,*,^):");
                            while(true){
                                c=s.next().charAt(0);
                                if(c=='+'||c=='-'||c=='/'||c=='*'||c=='^'){
                                    break;
                                }
                                else
                                System.out.println("Invalid Character Please enter a valid Operator");
                            }
                            obj.resetOperator(c);
                            obj.ArithmeticOperations();
                        }
                        else{
                            break;
                        }
                    }
                }
                else if(method=='f'){
                    System.out.println("Enter fahrenheit value:");
                    double fahrenheit=s.nextDouble();
                    obj.fahrenheitToCelsius(fahrenheit);
                }
                else if(method=='c'){
                    System.out.println("Enter Celsius value:");
                    double Celsius=s.nextDouble();
                    obj.celsiusToFahrenheit(Celsius);
                }
                else if(method=='r'){
                    System.out.println("Enter a India amount:");
                    double currency=s.nextDouble();
                    Currency cur=new Currency(currency);
                    System.out.println("Convert other conutry currency means enter a country name in small letters,without space and country should in(America,china,russia,pakistan)");
                    String country=s.next();
                    if(country.equals("america")){
                        cur.america();
                    }
                    else if(country.equals("china")){
                        cur.china();
                    }
                    else if(country.equals("russia")){
                        cur.russia();
                    }
                    else if(country.equals("pakistan")){
                        cur.pakistan();
                    }
                    else{
                        System.out.println("Invalid country");
                    }
                }
                else if(method=='s'){
                    System.out.println("Enter a number:");
                    double number=s.nextDouble();
                    obj.SquareRoot(number);
                }
            }
            else{
                System.out.println("Process is end");
                break;
            }
        }
    }
}
