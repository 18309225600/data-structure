import com.lhf.stack.impl.ArrayStack;
import org.junit.Test;

/**
 * Created by Liuhongfei on 2019/5/23 19:46
 */
public class ArrayStackTest {

    @Test
    public void test(){
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i=0;i<5;i++){
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);


    }
}
