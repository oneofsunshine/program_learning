#include <iostream>
#include <cstring>
//#include <cstdlib>
using namespace std;
#include <string>
class MyString : public string
{
public:
    MyString():string() {};
    MyString(const string & s):string(s) {};
    MyString(const char * s):string(s) {};
    MyString(MyString & ms):string(ms) {};
    ~MyString() {}
    MyString operator() (int start, int length)
    {
    	string s = substr(start,length);
        return MyString(s.c_str());
    }
};
int CompareString( const void * e1, const void * e2) {
    MyString * s1 = (MyString * ) e1;
    MyString * s2 = (MyString * ) e2;
    if( *s1 < *s2 )     return -1;
    else if( *s1 == *s2 ) return 0;
    else if( *s1 > *s2 ) return 1;
}

template<class T> 
void swap(T * a, T * b)
{
    T tmp = *a;
    *a = *b;
    *b = tmp;
}
template<class T>
void qsort(T* base, int length, int size, int (*cmp)(const void* a, const void* b))
{
    for(int i = 0; i < length; i++) {
        T * index = base + i;
        for(int j = i + 1; j < length; j++) {
            if((*cmp)(index,(base+j)) == 1)
                index = base + j;
        }
        if(index != base + i)
            swap(*index, *(base +i));
    }
}
/*
int CompareString( const void * e1, const void * e2) {
    string * s1 = (string * ) e1;
    string * s2 = (string * ) e2;
    if( *s1 < *s2 )     return -1;
    else if( *s1 == *s2 ) return 0;
    else if( *s1 > *s2 ) return 1;
}
*/
int main() {
    MyString s1("abcd-"),s2,s3("efgh-"),s4(s1);
    MyString SArray[4] = {"big","me","about","take"};
    cout << "1. " << s1 << s2 << s3<< s4<< endl;
    s4 = s3;    s3 = s1 + s3;
    cout << "2. " << s1 << endl;
    cout << "3. " << s2 << endl;
    cout << "4. " << s3 << endl;
    cout << "5. " << s4 << endl;
    cout << "6. " << s1[2] << endl;
    s2 = s1;    s1 = "ijkl-";
    s1[2] = 'A' ;
    cout << "7. " << s2 << endl;
    cout << "8. " << s1 << endl;
    s1 += "mnop";
    cout << "9. " << s1 << endl;
    s4 = "qrst-" + s2;
    cout << "10. " << s4 << endl;
    s1 = s2 + s4 + " uvw " + "xyz";
    cout << "11. " << s1 << endl;
    qsort(SArray,4,sizeof(MyString), CompareString);
    for( int i = 0;i < 4;++i )
        cout << SArray[i] << endl;
    //输出s1从下标0开始长度为4的子串
    cout << s1(0,4) << endl;
    //输出s1从下标为5开始长度为10的子串
    cout << s1(5,10) << endl;
    /*
    string SArray[4] = {"big","me","about","take"};
    cout<<SArray<<endl;
    cout<<*SArray<<endl;
    cout<<CompareString(&SArray[0],&SArray[1])<<endl;
    cout<<sizeof(string)<<endl;
    qsort(SArray,4,sizeof(string), CompareString);
    for(int i =0; i< 4 ; i++) cout<<SArray[i]<<endl;
    */
    return 0;
}
