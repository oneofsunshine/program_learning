#include<iostream>
#include<iomanip>
#include<math.h>
using namespace std;
int main()
{
    int n=0;
    cin>>n;
    float x[100000],y[100000];
    for(int i=0;i<n;i++)
    {
        cin>>x[i]>>y[i];
    }
    float m;
    float max;
    for(int l=0;l<n;l++)
    {
        for(int k=0;k<n;k++)
        {
            m=(x[l]-x[k])*(x[l]-x[k])+(y[l]-y[k])*(y[l]-y[k]);
            if(m>max)
            {
                max=m;
            }
        }
    }
    cout<<fixed<<setprecision(4)<<sqrt(max)<<endl;
    return 0;
}
