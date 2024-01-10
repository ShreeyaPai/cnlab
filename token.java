import java.util.*;
public class token {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Random rand=new Random();
        System.out.println("Enter bucket size");
        int bsize=in.nextInt();
        System.out.println("Enter number of packets");
        int n=in.nextInt();
        int[] packets=new int[n];
        System.out.println("Enter packet size in order:");
        for(int i=0;i<n;i++)
        {
            packets[i]=in.nextInt();
        }
        int cycle=0,remains=0,outrate=0,tokens=bsize,i=0,sent=0;
        boolean flag=false;
        System.out.println("Cycle\tPackets\tOutrate\tRemains\tSent");
        while(true){
            outrate=rand.nextInt(bsize-1)+1;
            cycle++;
            tokens=bsize-remains;
            if(packets[i]<=tokens){
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
                    System.out.println(cycle+"\t"+packets[i]+"\t"+outrate+"\t"+remains+"\t"+sent);
                    packets[i]=0;
                }
                else{
                    System.out.println(cycle+"\t---\t"+outrate+"\t"+remains+"\t"+sent);
                }
            }

                else{
                    remains=bsize;
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
                    System.out.println(cycle+"\t"+packets[i]+"\t"+outrate+"\t"+remains+"\t"+sent);
                    packets[i]-=tokens;
                }
                else{
                    System.out.println(cycle+"\t---\t"+outrate+"\t"+remains+"\t"+sent);
                }
                }
            
            if(packets[i]!=0){
                continue;
            }
            else if(i==packets.length-1){
                flag=true;
                if(remains==0) break;
            }
            else i++;

            
        }
    }
}
