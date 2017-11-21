#include<iostream>
#include<cstdlib>
#include<cstring>
using namespace std;
int CompareString( const void * e1, const void * e2)
{

    return strcmp((char *)e1,(char *)e2);
}
int main()
{
    string s[4] = {"Sadasd", "cascs","aacasas","ojisjads"};
    //cout<<strcmp(s[1].c_str(),s[2].c_str());
    qsort(s,4,sizeof(string),CompareString);
    for(int i = 0; i < 4 ; i ++) 
        cout<<s[i]<<endl;
    return 0;
}
