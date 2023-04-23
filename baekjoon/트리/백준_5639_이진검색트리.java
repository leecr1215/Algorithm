package 트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// 참고 블로그 
// https://madplay.github.io/post/binary-search-tree-in-java

/**
 * 
 * 전위 순회를 보고 트리를 만든 다음 후위 순회 고
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_5639_이진검색트리 {
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
        	// 현재 노드보다 작으면 왼쪽
            if (n < this.num) {
                if (this.left == null) // null이면 노드 생성
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
            	// 현재 노드보다 크면 오른쪽 자식
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 처음 값을 root로 설정
        Node root = new Node(Integer.parseInt(br.readLine()));
        
        String input;
        
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    // 왼쪽 자식, 오른쪽 자식, 현재 노드 순으로 탐색
    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}