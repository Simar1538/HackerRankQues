import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
              SinglyLinkedList newll = new SinglyLinkedList();
            SinglyLinkedListNode trav1=head1;
            SinglyLinkedListNode trav2=head2;
            while(true)
            {
                if(trav1.data>trav2.data)
                {
                  newll.insertNode(trav2.data);
                  trav2=trav2.next;
                }
                else
                {
                  newll.insertNode(trav1.data);
                  trav1=trav1.next;
                }
            
                if(trav1.next==null)
                 {
                   trav1.next=trav2;
                   break;
                 }
                if(trav2.next==null)
                 {
                  trav2.next=trav1;
                  break;
                 }
            }
                return newll.head;


    }

    private static final Scanner scanner = new Scanner(System.in);
