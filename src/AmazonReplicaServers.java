import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AmazonReplicaServers {
    static class Node{
        public int k;
        public int l;
        public int time;
        Node(int k,int l,int time)
        {
            this.k = k;
            this.l = l;
            this.time = time;
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int k = input.nextInt();
        int l = input.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                matrix[i][j] = 0;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        q.add(l);

        while(!q.isEmpty())
        {
            k = q.poll();
            l = q.poll();
            matrix[k][l] += 1;
            if (k-1>=0 && matrix[k-1][l] ==0)
            {
                matrix[k-1][l] += matrix[k][l];
                q.add(k-1);
                q.add(l);
            }
            if (k+1<m && matrix[k+1][l] ==0)
            {
                matrix[k+1][l] += matrix[k][l];
                q.add(k+1);
                q.add(l);
            }
            if (l-1>=0 && matrix[k][l-1] ==0)
            {
                matrix[k][l-1] += matrix[k][l];
                q.add(k);
                q.add(l-1);
            }
            if (l+1<n && matrix[k][l+1] ==0)
            {
                matrix[k][l+1] += matrix[k][l];
                q.add(k);
                q.add(l+1);
            }

        }
        printMatrix(matrix, m ,n);


        System.out.println(timeTaken(matrix, m,n));
    }

    public static void printMatrix(int[][] mat, int m, int n)
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    public static Integer timeTaken(int[][] mat, int m, int n)
    {
        return Math.max(mat[0][0], Math.max(mat[0][n-1], Math.max(mat[m-1][0],mat[m-1][n-1])))-1;
    }



}
