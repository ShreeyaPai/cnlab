import java.util.*;
public class crc {
    public static String CRC(String data,String poly,boolean errchk)
    {
        String rem=data;
        if (!errchk){
            for(int i=0;i<poly.length()-1;i++)
            rem+="0";
        }
        for(int i=0;i<rem.length()-poly.length()+1;i++)
        {
            if(rem.charAt(i)=='1'){
                for(int j=0;j<poly.length();j++)
                {
                    rem=rem.substring(0,i+j)+(rem.charAt(i+j)==poly.charAt(j)?0:1)+rem.substring(i+j+1);
                }
            }
        }
        return rem.substring(rem.length()-poly.length()+1);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the data: ");
        String data = in.nextLine();
        String poly="10000100010001010";
        String rem=CRC(data,poly,false);
        System.out.println("Codeword is: "+data+rem);
        System.out.println("Enter the codeword: ");
        String recv=in.nextLine();
        String recrem=CRC(recv,poly,true);
        if(Integer.parseInt(recrem)==0)
        {
            System.out.println("No error");
        }
        else{
            System.out.println("Error. Discard");
        }
        in.close();
    }
    
}
