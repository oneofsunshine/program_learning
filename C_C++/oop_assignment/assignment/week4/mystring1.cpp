#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;
/*
 * int strcmp(const char * s1,const char * s2)
 * {
 * for(int i = 0; s1[i] && s2[i] ; ++i) {
 * if( s1[i] < s2[i] )
 * return -1;
 * else if( s1[i] > s2[i])
 * return 1;
 * }
 * return 0;
 * }
 * */
class MyString: public string {
    public:
    string my_str;
    MyString() {}
    MyString(const char * c) {
        my_str = c;
    }
    MyString(string s) {
        my_str = s;
    }
    MyString(const MyString & ms) {
        my_str = ms.my_str;
    }
    MyString operator + (MyString & ms) {
        MyString result;
        result.my_str = my_str + ms.my_str;
        return result.my_str;
    }
    ~MyString() {
    }
    friend MyString operator + (const char * c,const MyString & ms) {
        MyString result;
        result.my_str =  c + ms.my_str;
        return result.my_str;
    }
    MyString operator + (const char * c) {
        MyString result;
        result.my_str = my_str + c;
        return result;
    }
    MyString & operator += (const char * c) {
        my_str = my_str + c;
        return * this;
    }
    friend ostream & operator << (ostream & os,const  MyString & ms) {
        os<<ms.my_str;
        return os;
    }
    char & operator [] (int k) {
        return my_str[k];
    }
    string operator () (int begin, int length) {
        string s = my_str.substr(begin,length);
        return s;
    }
    friend bool operator < (MyString & s1, MyString & s2) {
        const char * c1 = s1.c_str();
        const char * c2 = s2.c_str();
        return strcmp(c1,c2) <0;
    }
    friend bool operator > (MyString & s1,MyString & s2) {
        const char * c1 = s1.my_str.c_str();
        const char * c2 = s2.my_str.c_str();
        return strcmp(c1,c2) > 0;
    }
    friend bool operator == (MyString & s1,MyString & s2) {
        const char * c1 = s1.my_str.c_str();
        const char * c2 = s2.my_str.c_str();
        return strcmp(c1,c2) == 0;
    }
};
// 在此处补充你的代码
int CompareString( const void * e1, const void * e2) {
    MyString * s1 = (MyString * ) e1;
    MyString * s2 = (MyString * ) e2;
    if( *s1 < *s2 )     return -1;
    else if( *s1 == *s2 ) return 0;
    else if( *s1 > *s2 ) return 1;
}
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
    return 0;
}
