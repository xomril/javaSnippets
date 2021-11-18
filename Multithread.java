import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MultithreadingDemo extends Thread {
    private List<String> l;
    public MultithreadingDemo(List<String> list) {
        this.l = list;
    }
    public void run()
    {
        synchronized (l) {
            if(l.size() > 0) {
                System.out.println("list contains " + l.size() + " items");
                System.out.println(l.get(0) + " Removed from list");
                l.remove(0);
            }
        }
    }
}

// Main Class
public class Multithread {

    public static void main(String[] args)
    {
        List<String> l = Collections.synchronizedList(new ArrayList<String>());
        synchronized (l) {
            l.add("apple");
            l.add("orange");
            l.add("coin");
            l.add("nut");
        }
        int n = 4;
        System.out.println("list: ");
        l.stream().forEach(System.out::print);
        
        for (int i = 0; i <= n; i++) {
            MultithreadingDemo object = new MultithreadingDemo(l);
            object.start();
        }
    }
}
