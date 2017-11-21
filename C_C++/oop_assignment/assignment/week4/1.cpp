#include <iostream>
#include <cstdlib>
#include<cstring>
using namespace std;
int CompareString( const void * e1, const void * e2) {
    
    const char * s1 = (const char * ) e1;
    const char * s2 = (const char * ) e2;
    //cout<<
    return strcmp(s1,s2);
    /*
    if( *s1 < *s2 )     return -1;
    else if( *s1 == *s2) return 0;
    else if( *s1 > *s2 ) return 1;
    */
}
int main() {
    const char * Array[4] = {"413","619","326","923"};
    cout<<Array<<endl;
    cout<<sizeof(Array[0])<<endl;
    qsort(Array,4,sizeof(Array[0]),CompareString);
    for( int i = 0;i < 4;i++ )
        cout << Array[i] << endl;
    return 0;
}
