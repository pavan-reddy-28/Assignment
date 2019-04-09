package com.kmit.MiddleElementOfALinkedList;
import java.util.*;
class MyListNode {
	public MyListNode next;
	private int data;
	public MyListNode() {
		next = null;
		data = Integer.MIN_VALUE;
	}
	public MyListNode(int data) {
		next = null;
		this.data = data;
	}
	public MyListNode getNext() {
		return next;
	}
	public void setNext(MyListNode node) {
		next = node;
	}
	public int getData() {
		return data;
	}
	public void setdata(int elem) {
		data = elem;
	}
	public String toString() {
		return Integer.toString(data);
	}
}

class MyLinkedList {
	MyListNode head;
	public synchronized void insertAtEnd(MyListNode node) {
		if (head == null)
			head = node;
		else {
			MyListNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(node);
		}
	}
}

public class MiddleElementOfALinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tempData = -1;
		MyLinkedList list = new MyLinkedList();
		while ((tempData = sc.nextInt()) != -1) 
			list.insertAtEnd(new MyListNode(tempData));
		System.out.println(middleElementOfALinkedList(list.head));
	}
	static int middleElementOfALinkedList(MyListNode head)
	{
		MyListNode slow=head,fast=head;
		while(slow!=null && fast!=null && fast.getNext()!=null)
		{
			slow=slow.getNext();
			fast=fast.getNext().getNext();
		}
		return slow.getData();
	}
}