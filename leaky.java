import java.util.*;
public class leaky {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Random rand=new Random();
        System.out.println("Enter bucket size");
        int bsize=in.nextInt();
        System.out.println("Enter number of packets");
        int n=in.nextInt();
        System.out.println("Enter outrate");
        int outrate=in.nextInt();
        int[] packets=new int[n];
        System.out.println("Enter packet size in order:");
        for(int i=0;i<n;i++)
        {
            packets[i]=in.nextInt();
        }
        int cycle=0,remains=0,i=0,sent=0;
        boolean flag=false;
        System.out.println("Cycle\tPackets\tDropped\tRemains\tSent");
        while(true){
            cycle++;
            if(packets[i]<=bsize-remains){
                if(packets[i]+remains<=outrate){
                    sent=packets[i]+remains;
                    remains=0;
                }
                else{
                    sent=outrate;
                    remains+=packets[i]-outrate;
                }
                if(!flag)
                {
                    System.out.println(cycle+"\t"+packets[i]+"\t---\t"+remains+"\t"+sent);
                }
                else{
                    System.out.println(cycle+"\t---\t---\t"+remains+"\t"+sent);
                }
            }

                else{
                    if(remains<=outrate){
                        sent=remains;
                        remains=0;
                    }
                    else{
                        sent=outrate;
                        remains-=outrate;
                    }
                    if(!flag)
                {
                    System.out.println(cycle+"\t"+packets[i]+"\tDrop\t"+remains+"\t"+sent);
                }
                else{
                    System.out.println(cycle+"\t---\t---\t"+remains+"\t"+sent);
                }
                }
            
            if(i==packets.length-1){
                flag=true;
                if(remains==0) break;
            }
            else i++;

            
        }
    }
}

