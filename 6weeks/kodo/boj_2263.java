package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문제 : 트리의 순회
 * 기법 :
 */
public class boj_2263 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] inOrder, postOrder;

//    private static void recursive(final List<Integer> inOrder, final List<Integer> postOrder) {
//        if(inOrder.size() == 0)
//            return;
//        int center = postOrder.get(postOrder.size()-1);
//        sb.append(center+" ");
//        if(inOrder.size() == 1)
//            return;
//        for (int i = 0; i < inOrder.size(); i++) {
//            if(inOrder.get(i) == center) {
//                recursive(inOrder.subList(0,i),postOrder.subList(0,i));
//                recursive(inOrder.subList(i+1,inOrder.size()),postOrder.subList(i,postOrder.size()-1));
//                break;
//            }
//        }
//    }

    private static void recursive(final int inStart, final int inEnd, final int postStart, final int postEnd) {

        if(inEnd == inStart)
            return;

        int center = postOrder[postEnd-1];
        sb.append(center+" ");

        for (int i = inStart; i < inEnd; i++) {
            if(inOrder[i] == center) {
                recursive(inStart,i,postStart,i);
                recursive(i+1,inEnd,i,postEnd-1);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

//        List<Integer> inOrder = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .collect(Collectors.toList());
//
//        List<Integer> postOrder = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .collect(Collectors.toList());


        //recursive(inOrder, postOrder);

        inOrder = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        postOrder = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        recursive(0,inOrder.length,0,postOrder.length);
        System.out.println(sb);
    }
}

/*
6
4 2 5 1 6 3
4 5 2 6 3 1

 */
