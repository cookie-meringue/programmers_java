#include <stdio.h>
#define find_min(a, b) (a < b) ? a : b

int main(void)
{
    int N, M;
    int min = 33;
    char chess[50][50];
    int cntw = 0, cntb = 0;
    scanf("%d %d", &N, &M);
    for(int i = 0; i < N; i++)
    {
        scanf("%s", &chess[i]);
    }
    for(int i = 0; i<N-7; i++)
    {
        for(int j = 0; j<M-7; j++)
        {
            cntw = 0; cntb = 0;
            for(int a = i; a < i+8; a++)
            {
                for(int b = j; b<j+8; b++)
                {
                    if((a+b)%2 == 0)
                    {
                        if(chess[a][b] == 'B')
                        {
                            cntw++;
                        }
                        else
                        {
                            cntb++;
                        }
                    }
                    else
                    {
                        if(chess[a][b] == 'B')
                        {
                            cntb++;
                        }
                        else
                        {
                            cntw++;
                        }
                    }
                }
            }
            min = find_min(min, cntw);
            min = find_min(min, cntb);
        }
    }
    printf("%d\n", min);
    return 0;
}