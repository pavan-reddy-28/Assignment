package com.kmit.QueueUsing2Stacks;
import java.util.*;
public class QueueUsing2Stacks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCases=sc.nextInt();
        Stack<Integer> one=new Stack<Integer>();
        Stack<Integer> two=new Stack<Integer>();
        int choice;
        for (int i=0;i<testCases;i++)
		{
			choice=sc.nextInt();
			if (choice==1)
                one.push(sc.nextInt());
            else if(choice==2)
            {
                if(two.isEmpty())
                    while(!one.isEmpty())
                        two.push(one.pop());             
				if(!two.isEmpty())
                    two.pop(); 
            }
            else if(choice==3)
            {       
                if(two.isEmpty())
                {
                    while(!one.isEmpty())
                        two.push(one.pop());
                    System.out.println(two.peek());
                } 
                else 
                    System.out.println(two.peek());
            }
        }
    }
}