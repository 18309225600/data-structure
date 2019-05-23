import com.lhf.queue.impl.ArrayQueue;
import org.junit.Test;

/**
 * Created by Liuhongfei on 2019/5/23 22:09
 */
public class ArrayQueueTest {

    @Test
    public void test(){
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        for (int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);

            if (i%3==0){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
