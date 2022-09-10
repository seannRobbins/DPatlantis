import java.util.ArrayList;

public class Program3 {
    private int[][] optTable;
    public Program3()
    {

    }

    public void optTableInit(int[] sections)
    {
        optTable = new int[sections.length][sections.length];
        for (int i = 0; i < sections.length; i++)
        {
            for (int j = 0; j < sections.length; j++)
            {
                optTable[i][j] = 0;
            }
        }

    }
    public int sectionAddition(int i, int j, int[] sections)
    {
        int sum = 0;
        if (i > j)
        {
            return 0;
        }
        for (int k = i; k <= j; k++)
        {
            sum += sections[k];
        }
        return sum;
    }

    public int findOpt(int i, int j, int[] sections)
    {
        if (i >= j)
        {
            return 0;
        }
        else if ((j - i) == 1)
        {
            return Math.min(sections[i], sections[j]);
        }
        else if ((j - i) == 2)
        {
            int optLeft = Math.min(sections[i] + optTable[i][i], sectionAddition(i+1, j, sections) + optTable[i+1][j]);
            int optRight = Math.min(optTable[i][i+1] + sectionAddition(i,i+1, sections), optTable[j][j] + sections[j]);
            return Math.max(optLeft, optRight);
        }
        else
        {
            int l;
            int optLeft = 0;
            int optRight = 0;
            int optMid = 0;
            int low = i;
            int high = j;
            while (low < high)
            {
                l = (high - low) / 2;
                l += low;
                optMid = Math.min(optTable[i][l] + sectionAddition(i,l,sections), optTable[l+1][j] + sectionAddition(l+1,j,sections));
                if (l == 0) //wall is placed at the far left of the sections
                {
                    optLeft = 0;
                }
                else
                {
                    optLeft = Math.min(optTable[i][l - 1] + sectionAddition(i, l - 1, sections), optTable[l][j] + sectionAddition(l, j, sections));
                }
                if (l == j - 1) //wall is placed at the far right of the sections
                {
                    optRight = 0;
                }
                else
                {
                    optRight = Math.min(optTable[i][l + 1] + sectionAddition(i, l + 1, sections), optTable[l + 2][j] + sectionAddition(l + 2, j, sections));
                }
                if ((optMid > optLeft && optMid > optRight) || (optMid == optLeft || optMid == optRight)) //at local max
                {
                    break;
                }
                else if (optLeft > optMid && optMid > optRight) //move left
                {
                    high = l;
                }
                else //move right
                {
                    low = l;
                }
            }
            return optMid;
        }
    }

    public int OPT(int[] sections)
    {
        for (int i = sections.length - 1; i >= 0; i--)
        {
            for (int j = 0; j < sections.length; j++)
            {
                optTable[i][j] = findOpt(i, j, sections);
            }
        }
        return optTable[0][sections.length - 1];
    }

    public int maxFoodCount (int[] sections)
    {
        // Implement your dynamic programming algorithm here
        // You may use helper functions as needed
        optTableInit(sections);
        return OPT(sections);
    }
}
