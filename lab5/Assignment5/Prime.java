class MyThreadPrime extends Thread{
    private int start ; 
    private int end ;
    private int count ;  

    public MyThreadPrime(int start ,int end , int count){
        this.start = start;
        this.end = end;
        this.count = count;
    }
    @Override

    public void run(){
        for(int i = start ; i<=end;i++)
        {
            if(isPrime(i)){
                count++;
            }
        }
        System.out.println(count);
    }
    private boolean isPrime(int num){
        int flag = 0;
        if(num==0 || num==1){
              return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
               flag = 1;
               return false;
            }
        }
        if(flag == 0){
            return true;
        }
        return true;

    }
}
 public class Prime{
    public static void main(String[] args){
       int r1 = 0;
       int r2 = 100000;
       int r3 = 200000;
       int r4 = 300000;
       int c1= 0;
       int c2 = 0;
       int c3 = 0;

     MyThreadPrime thread1 = new MyThreadPrime(r1, r2 , c1);
     MyThreadPrime thread2 = new MyThreadPrime(r2, r3 , c2);
     MyThreadPrime thread3 = new MyThreadPrime(r3, r4 , c3);


 thread1.start();

 thread2.start();
 thread3.start();
    }
 }