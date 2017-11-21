#include<iostream>
#include<fstream>
using namespace std;
ifstream in("input.dat");
ofstream out("output.dat");
int n = 0;
void swap(int *a, int *b)
{
    int tmp;
    tmp = *a;
    *a = *b;
    *b = tmp;
}
void perm(int list[],int k, int m )
{
    int i;
    if(k > m)
    {
        for(i = 0 ; i < m; i++)
            out<<list[i];
        out<<" ";
        n++;
    }
    else
    {
        for(i = k ; i <= m;i++)
        {
            swap(&list[k],&list[i]);
            perm(list,k+1,m);
            swap(&list[k],&list[i]);
        }
    }
}
int main()
{
	out << (2 * 3 * 4) << endl;
	int list[4] = {1, 2, 3, 4};
	perm(list,0,3);
	return 0;
}
