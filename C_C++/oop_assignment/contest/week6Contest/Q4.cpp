#include <iostream>
#include <string>

using namespace std;
template <class T>
class CMyistream_iterator
{
    T iter;
    istream & is;
    public:
    CMyistream_iterator(istream & i):is(i) { 
        is >> iter;
    }
    T operator*() {
        return iter;
    }
    CMyistream_iterator operator++(int) {
        is >> iter;
        return *this;
    }
// 在此处补充你的代码
};

int main()  
{ 
	int t;
	cin >> t;
	while( t -- ) {
		 CMyistream_iterator<int> inputInt(cin);
		 int n1,n2,n3;
		 n1 = * inputInt; //读入 n1
		 int tmp = * inputInt;
		 cout << tmp << endl;
		 inputInt ++;   
		 n2 = * inputInt; //读入 n2
		 inputInt ++;
		 n3 = * inputInt; //读入 n3
		 cout << n1 << " " << n2<< " " << n3 << " ";
		 CMyistream_iterator<string> inputStr(cin);
		 string s1,s2;
		 s1 = * inputStr;
		 inputStr ++;
		 s2 = * inputStr;
		 cout << s1 << " " << s2 << endl;
	}
	 return 0;  
}
