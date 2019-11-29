package com.xeuj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        System.out.println(properDivisor(6));
        System.out.println(properDivisor(5));
        System.out.println(properDivisor(3));
        String[] str= tokenize_string("xyz abc mnp \"asdf dfaa asdf\" asd \"fdas asdsdafF\" some more");
        for(String st:str) {
            System.out.println(st);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter M N:");
        int M=sc.nextInt();
        int N=sc.nextInt();
        int[][] G = new int[M][N];
        System.out.println("Enter grid value:");
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                G[i][j]=sc.nextInt();
            }
        }
        System.out.println(solveIt(M,N,G));;
    }

    public static int solveIt(int n, int m, int[][] G) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(G[i][j]+" ");
                if(G[i][j]==2) {
                    Integer count = 0;
                    if(G[i][j+1]==0) {
                        G = move(n,m,G,i,j+1,count++);
                    }
                    if(G[i+1][j]==0) {
                        G = move(n,m,G,i+1,j,count++);
                    }
                    if(G[i+1][j+1]==0) {
                        G = move(n,m,G,i=1,j+1,count++);
                    }
                    if(G[i][j-1]==0) {
                        G=move(n,m,G,i,j-1,count++);
                    }
                    if(G[i-1][j]==0) {
                        G=move(n,m,G,i-1,j,count++);
                    }
                    if(G[i-1][j-1]==0) {
                        G=move(n,m,G,i-1,j-1,count++);
                    }
                    return count;
                }
            }
            System.out.println();
        }
        return 1;
    }

    public static int[][] move(int n, int m, int[][] G, int i, int j, Integer count) {
        if(i>=n-1 || j>=m-1 || i<=0 || j<=0) {
            return G;
        }
        if(G[i][j+1]==0) {
            G = move(n,m,G,i,j+1,count++);
        }
        if(G[i+1][j]==0) {
            G = move(n,m,G,i+1,j,count++);
        }
        if(G[i+1][j+1]==0) {
            G = move(n,m,G,i+1,j+1,count++);
        }
        if(G[i][j-1]==0) {
            G=move(n,m,G,i,j-1,count++);
        }
        if(G[i-1][j]==0) {
            G=move(n,m,G,i-1,j,count++);
        }
        if(G[i-1][j-1]==0) {
            G=move(n,m,G,i-1,j-1,count++);
        }
        return G;
    }

    public static String properDivisor(int N) {
        int sum = 0;
        for(int i=1;i<N;i++) {
            if(N%i==0) {
                sum+=i;
            }
        }
        if(sum==N) {
            return "YES";
        }
        return "NO";
    }

    public static int solveIt1(int n, int m, int[][] G) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(G[i][j]==2) {
                    return min(min(i,m-i),min(j,n-j));
                }
            }
        }
        return 0;
    }

    public static int min(int x, int y) {
        return x<y?x:y;
    }
    static String[] tokenize_string(String S){
        List<String> tokens = new LinkedList<>();
        char[] chrs = S.toCharArray();
        boolean openingQuote = false;
        char[] subChrs = new char[20];
        int tokensCount = 0;
        int i=0;
        for(char ch:chrs) {
            subChrs[i++]=ch;
            if(ch=='"') {
                if(openingQuote) {
                    openingQuote=false;
                } else {
                    openingQuote = true;
                }
            }
            if(!openingQuote) {
                if(ch==' ') {
                    tokens.add(String.valueOf(subChrs).trim());
                    subChrs = null;
                    subChrs = new char[20];
                    i=0;
                }
            }
        }
        String subStr = String.valueOf(subChrs);
        if(subStr.length()>0) {
            tokens.add(subStr.trim());
        }
        return tokens.toArray(new String[0]);
    }
}
