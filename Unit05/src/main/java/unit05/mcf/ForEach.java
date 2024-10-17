package unit05.mcf;

public class ForEach {
    public static void forArray(String[] array) {
        for(String ele : array) {
            System.out.println(ele);
        }
    }

    public static void forList(List<String> list) {
        for(String ele : list) { 
            System.out.println(ele);
        }
    }

    public static void forQueue(Queue<String> queue) {
        for(String ele : queue) { 
            System.out.println(ele);
        }
    }

    public static void main(String[] args) {
        // String[] array = {"a", "b", "c"};
        // forArray(array);
        // ArrayList<String> al = new ArrayList<>();
        // al.append("A");
        // al.append("B");
        // al.append("C");
        // ForEach.forList(al);
        // ArrayQueue<String> aq = new ArrayQueue<>();
        // for(int i = 1; i < 7; i++) {
        //     aq.enqueue(Integer.toString(i));
        // }
        // System.out.println(aq);
        // ForEach.forQueue(aq);

        NodeQueue<String> nq = new NodeQueue<>();
        for(int i = 1; i < 6; i++) {
            nq.enqueue(Integer.toString(i));
        }
        nq.dequeue();
        nq.dequeue();

        for(int i = 1; i < 7; i++) {
            nq.enqueue(Integer.toString(i));
        }

        System.out.println(nq);
        ForEach.forQueue(nq);


    }
}
