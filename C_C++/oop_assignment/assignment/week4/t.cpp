#include<iostream>
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
void strcat(char * d,const char * s)
{
	int len = strlen(d);
	strcpy(d+len,s);
}
class MyString {
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
    MyString operator + (const MyString & ms) {
        MyString result;
        result.len = len + ms.len;
        result.my_str = new char[result.len];
        strcpy(result.my_str,my_str);
        strcat(result.my_str,ms.my_str);
        return result;
    }
	friend ostream & operator << (ostream & os, const MyString & ms) {
		os<<ms.my_str;
		return os;
	}
    MyString operator = (const MyString & ms) {
        delete my_str;
        return MyString(ms);
    }
};
int main()
{
    MyString s1("abcd-"),s2,s3("efgh-"),s4(s1);
	cout << "1. " << s1 << s2 << s3<< s4<< endl;
	s4 = s3 + s1;
    cout<<s4<<endl;
    return 0;
}
