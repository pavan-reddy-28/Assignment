package com.kmit.SelfDrivingBus;

import java.util.*;

class Graph
{
    static int n;
    static ArrayList<Integer> adj[];
    static TreeSet<Integer> temp;
    static boolean flag,vis[];
    Graph(int v)
    {
        n=v;
        adj=new ArrayList[n];
        for(int i=0;i<n;i++)
        adj[i]=new ArrayList<>();
    }
    static void addEdge(int u,int v)
    {
        adj[u].add(v);
        adj[v].add(u);
    }
    static boolean dfs1(int first,int last)
    {
        vis=new boolean[n];
        temp=new TreeSet<>();
        temp.add(first);
        flag=false;
        dfs(first,first,last);
        return flag;
    }
    static void dfs(int start,int first,int last)
    {
        vis[first]=true;
        if(first==last)
        {
            temp.add(first);
            int temp_first=start,temp_flag=0;
            for(int i:temp)
            {
                if(temp_first!=i || temp_first>last)
                {
                    temp_flag=1;
                    break;
                }
            temp_first++;
            }
            if(temp_flag==0)
            flag=true;
            vis[first]=false;
            //return;
        }
        for(int i:adj[first])
        {
            if(!vis[i])
            {
                temp.add(i);
                dfs(start,i,last);
                temp.remove(new Integer(i));    
            }
        }
        vis[first]=false;
    }
}
public class SelfDrivingBus {

    // Complete the solve function below.
    static int solve(int[][] tree) {
        int n=tree.length+1;
        new Graph(n);
        for(int i=0;i<n-1;i++)
            Graph.addEdge(tree[i][0]-1,tree[i][1]-1);
        int cnt=n;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(Graph.dfs1(i,j))
                    cnt++;
            }
        }
        return cnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[][] tree = new int[n-1][2];
        for (int treeRowItr = 0; treeRowItr < n-1; treeRowItr++) {
            String[] treeRowItems = scanner.nextLine().split(" ");
            for (int treeColumnItr = 0; treeColumnItr < 2; treeColumnItr++) {
                int treeItem = Integer.parseInt(treeRowItems[treeColumnItr]);
                tree[treeRowItr][treeColumnItr] = treeItem;
            }
        }
        System.out.println(solve(tree));
        scanner.close();
    }
}
