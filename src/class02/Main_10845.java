package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10845 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orderNum = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        QueueController controller = QueueController.getController(queue);

        while (orderNum-- > 0){
            var input = br.readLine().split(" ");
            String method = input[0];

            if (method.equals("push")){
                controller.push(Integer.parseInt(input[1]));
                continue;
            }
            if (method.equals("pop")){
                controller.pop();
                continue;
            }
            if (method.equals("size")){
                controller.size();
                continue;
            }
            if (method.equals("empty")){
                controller.empty();
                continue;
            }
            if (method.equals("front")){
                controller.front();
                continue;
            }
            if (method.equals("back")){
                controller.back();
                continue;
            }
        }
    }
}

class QueueController{
    private static QueueController queueController;
    private QueueController(Queue<Integer> queue){
        this.queue = queue;
    }
    private Queue<Integer> queue;

    public static QueueController getController(Queue<Integer> queue){
        queueController = new QueueController(queue);
        return  queueController;
    }

    private int lastIndex = -1;
    public void push(int X){
        queue.add(X);
        lastIndex = X;
    }
    public void pop(){
        if (queue.isEmpty()){
            System.out.println(-1);
        }
        else{
            if (lastIndex == queue.peek()){
                lastIndex = -1;
            }
            System.out.println(queue.poll());
        }
    }
    public void size(){
        System.out.println(queue.size());
    }
    public void empty(){
        if (queue.isEmpty()){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
    public void front(){
        if (queue.isEmpty()){
            System.out.println(-1);
        }
        else{
            System.out.println(queue.peek());
        }
    }
    public void back(){
        if (queue.isEmpty()){
            System.out.println(-1);
        }
        else{
            System.out.println(lastIndex);
        }
    }

}
