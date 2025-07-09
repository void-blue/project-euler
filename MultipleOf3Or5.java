import java.util.Scanner;
import java.util.concurrent.*;

public class MultipleOf3Or5 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("enter limit");
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Integer> f1 = exec.submit(new CallableFor3(val));
        Future<Integer> f2 = exec.submit(new CallableFor5(val));
        Future<Integer> f3 = exec.submit(new CallableFor3And5(val));


        int sum = f1.get()+f2.get()-f3.get();
        System.out.println("value is "+sum);
        exec.shutdown();

        try{
            if(!exec.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                exec.shutdownNow();
            }
        } catch (InterruptedException e) {
            exec.shutdownNow();
        }

        sc.close();
    }
}


class CallableFor3 implements Callable<Integer>{

    private int num;

    public CallableFor3(int num){
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 3;i<this.num;i++){
            if(i%3==0)
                sum = sum+i;
        }
        return sum;
    }
}

class CallableFor5 implements Callable<Integer>{

    private int num;

    public CallableFor5(int num){
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 5;i<this.num;i++){
            if(i%5==0)
                sum = sum+i;
        }
        return sum;
    }
}

class CallableFor3And5 implements Callable<Integer>{

    private int num;

    public CallableFor3And5(int num){
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 15;i<this.num;i++){
            if(i%3==0 && i%5==0)
                sum = sum+i;
        }

        return sum;
    }
}
