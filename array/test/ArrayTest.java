import com.lhf.array.Array;
import org.junit.Test;

/**
 * Created by Liuhongfei on 2019/5/21 22:18
 */
public class ArrayTest {

    @Test
    public void test(){
        Array<Integer> arr = new Array(3);
        for (int i=0;i<10;i++){
            arr.add(i);
        }

        arr.add(2,200);

        arr.addFirst(-1);

        arr.removeFirst();
        arr.removeLast();
        System.out.println(arr);
    }
}
