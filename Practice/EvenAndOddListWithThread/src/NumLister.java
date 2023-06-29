import java.util.List;

public class NumLister implements Runnable{
    List<Integer> subList;
    List<Integer> evenList;
    List<Integer> oddList;
    public NumLister(List<Integer> subList, List<Integer> evenList, List<Integer> oddList){
        this.subList = subList;
        this.evenList = evenList;
        this.oddList = oddList;
    }
    @Override
    public void run(){
        for(int i : subList){
            synchronized (evenList){
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + "Add even numbers : "+i);
                    evenList.add(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            synchronized (oddList){
                if(i % 2 != 0){
                    System.out.println(Thread.currentThread().getName() + "Add odd numbers : "+i);
                    evenList.add(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
