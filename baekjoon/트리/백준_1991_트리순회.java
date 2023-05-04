package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1991_트리순회 {
    static class Node {
        char value; // 현재 노드의 값
        Node left; // 현재 노드의 왼쪽 노드
        Node right; // 현재 노드의 오른쪽 노드

        Node(char value){
            this.value = value;
        }

        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
        
    }
    
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        Node head = new Node('A');

        // 트리 연결
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);

        }

        preOrder(head);
        sb.append("\n");

        inOrder(head);
        sb.append("\n");

        postOrder(head);
        sb.append("\n");

        System.out.println(sb.toString());


    }   


    public static void insertNode(Node node, char root, char left, char right){
        
        if(node.value == root){
            // 왼쪽 노드
            if(left == '.'){
                node.left = null;
            }else{
                node.left = new Node(left);
            }

            // 오른쪽 노드
            if(right == '.'){
                node.right = null;
            }else{
                node.right = new Node(right);
            }
        }
        else {
            if(node.left != null) insertNode(node.left, root, left, right);
            if(node.right != null) insertNode(node.right, root, left, right);
        }

    }

    // root -> left -> right
    public static void preOrder(Node node){
        if(node==null) return;
        
        sb.append(node.value); // sb에 더하기
        preOrder(node.left);
        preOrder(node.right);
    }

    // left -> root -> right
    public static void inOrder(Node node){
        if(node == null) return;

        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    // right -> left -> root
    public static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.right);
        postOrder(node.left);
        sb.append(node.value);
    }

}
