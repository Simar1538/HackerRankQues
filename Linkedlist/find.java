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

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
     static int length(SinglyLinkedListNode head)
     {
         SinglyLinkedListNode trav=head;
         int count=0;
         while(trav!=null)
        {
          trav=trav.next;
          count++;
        }
        return count;
     } 
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode trav1=head1,trav2=head2;
        int l1=length(head1);
        int l2=length(head2);
        if(l1>l2)
        {
            l1-=l2;
            while(l1>0)
            {
                trav1=trav1.next;
                l1--;
            }
        }
        else
        {
            l2-=l1;
            while(l2>0)
            {
                trav2=trav2.next;
                l2--;
            }
        }
        while(trav1!=null&&trav2!=null)
        {
             if(trav1==trav2)
             return trav1.data;
          trav1=trav1.next;
          trav2=trav2.next;

        }
        return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);
