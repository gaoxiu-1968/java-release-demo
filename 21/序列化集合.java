import java.util.*;

/**
 * 参考：<a href="https://openjdk.org/jeps/431">...</a>
 * 个人体验评价：
 *  总体而言该提案就是对现有的集合定义顺序语法进行了统一
 * 影响点：
 *  List
 *  Deque
 *  LinkedHashSet
 *  SortedSet
 *  LinkedHashMap
 *  SortedMap
 *
 */
public class 序列化集合 {
    /**
     * 摘要：引入新接口来表示具有定义遇到顺序的集合，每个这样的集合都有一个明确定义的第一个元素、第二个元素等等，直到最后一个元素。它还提供了统一的 API 来访问其第一个和最后一个元素，以及
     *      以相反的顺序处理其元素。
     * 动机：Java 的集合框架缺少一种表示具有定义出现顺序的元素序列的集合类型。它还缺少一套适用于此类集合的统一操作。这些缺陷一直是问题和投诉的根源。
     * 实现：定义了三个接口规范：sequenced collection , sequenced set, sequenced map
     *
     * SequencedCollection:
     *     void addFirst(E)
     *     void addLast(E)
     *     E getFirst()
     *     E getLast()
     *     E removeFirst()
     *     E removeLast()
     *
     * @param args
     */
    public static void main(String[] args) {
//        sequenceCollection();
//        sequenceSet();
        sequenceMap();
    }


    public static void sequenceCollection(){
        List<String> list = new ArrayList<>();
        list.add("b");
        list.addFirst("a");
        list.addLast("c");
        System.out.println(list);
        list.reversed();
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }

    public static void sequenceSet(){
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();
        sequencedSet.add("b");
        sequencedSet.addFirst("a");
        sequencedSet.addLast("c");
        System.out.println(sequencedSet);
    }

    public static void sequenceMap(){
        SequencedMap<String, String> sequencedMap = new LinkedHashMap<>();
        sequencedMap.put("2", "b");
        sequencedMap.putFirst("1", "a");
        sequencedMap.putLast("3","c");
        System.out.println(sequencedMap);
        sequencedMap.reversed();
        System.out.println(sequencedMap);
        sequencedMap.pollFirstEntry();
        System.out.println(sequencedMap);
        sequencedMap.pollLastEntry();
        System.out.println(sequencedMap);
    }
}
