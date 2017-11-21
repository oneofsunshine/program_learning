#include <cstdlib>
#include <iostream>
using namespace std;
int strlen(const char * s) 
{	int i = 0;
	for(; s[i]; ++i);
	return i;
}
void strcpy(char * d,const char * s)
{
	int i = 0;
	for( i = 0; s[i]; ++i)
    d[i] = s[i];
	d[i] = 0;
		
}
int strcmp(const char * s1,const char * s2)
{
	for(int i = 0; s1[i] && s2[i] ; ++i) {
		if( s1[i] < s2[i] )
			return -1;
		else if( s1[i] > s2[i])
			return 1;
	}
	return 0;
}
void strcat(char * d,const char * s)
{
	int len = strlen(d);
	strcpy(d+len,s);
}
class MyString
{
	public:
    int len;
	char * my_str;
    MyString() {
        len = 0;
        my_str = new char[len];
    }
    MyString(const char * c) {
        len = strlen(c);
        my_str = new char[len];
        strcpy(my_str, c);
    }
	MyString(string s) {
        len = s.length();
        my_str = new char[len];
        for(int i = 0; i < len; i++) {
            my_str[i] = s[i];
        }
    }
    MyString(const MyString & ms) {
        len = ms.len;
        my_str = new char[len];
        strcpy(my_str,ms.my_str);
    }
	friend ostream & operator << (ostream & os, const MyString & ms) {
		os<<ms.my_str;
		return os;
	}
	char & operator [] (int n) {
		return my_str[n];
	}
	MyString operator = (const MyString & ms) {
        delete my_str;
        return MyString(ms);
	}
    MyString operator + (const char * c) {
        MyString result;
        result.len = len + strlen(c);
        result.my_str = new char[result.len];
        strcpy(result.my_str,my_str);
        strcat(result.my_str,c);
        return result;
    }
    friend MyString operator + (const char * c, MyString & ms) {
        MyString result;
        result.len = ms.len + strlen(c);
        result.my_str = new char[result.len];
        strcpy(result.my_str,c);
        strcat(result.my_str,ms.my_str);
        return result;
    }
    MyString operator + (const MyString & ms) {
        MyString result;
        result.len = len + ms.len;
        result.my_str = new char[result.len];
        strcpy(result.my_str,my_str);
        strcat(result.my_str,ms.my_str);
        return result;
    }
    MyString operator += (const char * c) {
        char * tmp = my_str;
        len += strlen(c);
        my_str = new char[len];
        strcpy(my_str,tmp);
        strcat(my_str,c);
        return * this;
    }
    char * operator () (int begin, int length) {
        char * c = new char[length];
        for(int i = begin, k = 0; k < length; i++, k++) {
            c[k] = my_str[i];
        }
        return c;
    }
    int operator < (MyString & s2) {
        if(strcmp(my_str,s2.my_str) == -1)
            return 1;
        return 0;
    }
    int operator > (MyString & s2) {
        if(strcmp(my_str, s2.my_str) == 1)
            return 1;
        return 0;
    }
    int operator == (MyString & s2) {
        if(strcmp(my_str, s2.my_str) == 0)
            return 1;
        return 0;
    }
// 在此处补充你的代码
};
int CompareString( const void * e1, const void * e2)
{
	MyString * s1 = (MyString * ) e1;
	MyString * s2 = (MyString * ) e2;
	if( * s1 < *s2 )
	return -1;
	else if( *s1 == *s2)
	return 0;
	else if( *s1 > *s2 )
	return 1;
}
int main()
{
	MyString s1("abcd-"),s2,s3("efgh-"),s4(s1);
	MyString SArray[4] = {"big","me","about","take"};
	cout << "1. " << s1 << s2 << s3<< s4<< endl;
	s4 = s3;
	s3 = s1 + s3;
	cout << "2. " << s1 << endl;
	cout << "3. " << s2 << endl;
	cout << "4. " << s3 << endl;
	cout << "5. " << s4 << endl;
	cout << "6. " << s1[2] << endl;
	s2 = s1;
	s1 = "ijkl-";
	s1[2] = 'A' ;
	cout << "7. " << s2 << endl;
	cout << "8. " << s1 << endl;
	s1 += "mnop";
	cout << "9. " << s1 << endl;
	s4 = "qrst-" + s2;
	cout << "10. " << s4 << endl;
	s1 = s2 + s4 + " uvw " + "xyz";
	cout << "11. " << s1 << endl;
	qsort(SArray,4,sizeof(MyString),CompareString);
	for( int i = 0;i < 4;i ++ )
	cout << SArray[i] << endl;
	//s1的从下标0开始长度为4的子串
	cout << s1(0,4) << endl;
	//s1的从下标5开始长度为10的子串
	cout << s1(5,10) << endl;
	return 0;
}
/*
 *样例输入
 无
样例输出
1. abcd-efgh-abcd-
2. abcd-
3. 
4. abcd-efgh-
5. efgh-
6. c
7. abcd-
8. ijAl-
9. ijAl-mnop
10. qrst-abcd-
11. abcd-qrst-abcd- uvw xyz
about
big
me
take
abcd
qrst-abcd-
 */
