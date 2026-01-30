import java.util.ArrayList;

public class problem4 {
    public static void main(String[] args) {
        String[] inputs={"10","-5","25.5","150","abc","30.5"};

        ArrayList<Number> numberlist = new ArrayList<>();
        for(String input:inputs){
            try{
                if(input.contains(".")){
                    double d=Double.parseDouble(input);
                    numberlist.add(d);
                }else{
                    int n=Integer.parseInt(input);
                    numberlist.add(n);
                }
            }catch(NumberFormatException e){
                System.out.println("Invalid number format: "+input);
            }catch(Exception e){
                System.out.println(e.getMessage()+": "+input);
            }
        }
        int intsum =0;
        double doublesum=0.0;
        int doublecount=0;
     for (Number num : numberlist) {

           
            if (num instanceof Integer) {
                intsum += num.intValue();
            } else if (num instanceof Double) {
                doublesum += num.doubleValue();
                doublecount++;
            }
        }

        
        System.out.println("Stored Numbers: " + numberlist);
        System.out.println("Sum of Integers: " + intsum);

        if (doublecount > 0) {
            System.out.println("Average of Floating Numbers: " + (doublesum / doublecount));
        } else {
            System.out.println("No floating-point numbers found.");
        }

    }
}
