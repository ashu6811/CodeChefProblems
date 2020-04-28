import java.util.Scanner;

public class Ordering_the_Soldiers {

    public static void main(String[] args) {
        String finalOutput = "";
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int n;
        for(int i=0; i<t; i++)
        {
            n = input.nextInt();
            int[] soldierSteps = new int[n];
            int[] soldierRank = new int[n];
            int tempSteps, pos;


            for(int j=0; j<n; j++)
            {
                soldierSteps[j] = input.nextInt();
                soldierRank[j] = j+1;
                tempSteps = soldierSteps[j];
                pos = j;
                soldierRank[pos] = soldierRank[pos] - tempSteps;
                while (tempSteps > 0)
                {
                    pos--;
                    soldierRank[pos]++;
                    tempSteps--;
                }
            }

            for (int j=0; j<n; j++)
            {
                finalOutput += soldierRank[j];
                if(j!=(n-1))
                    finalOutput += " ";
                else finalOutput += "\n";
            }

        }
        System.out.print(finalOutput);
    }
}

/*
2
3
0 1 0
5
0 1 2 0 1
7
0 1 2 0 1 3 1
 */