 /*
  * Author：Yuan Hao; 
  * 探究临时变量（对象）作为返回值的存活时间； 
  */
#include <iostream> 
using namespace std;
class MyInt 
{ 
	int nVal; 
	public: 
	MyInt( int n) { nVal = n ;}
    MyInt & operator-(int a) {// 修改调用的对象的值，返回调用对象；
    	nVal -= a;
    	return *this;
    }
    MyInt & operator-(MyInt a) {// 生成临时对象，返回（临时对象的值-参数值）； 
    	MyInt b(nVal);
    	b.nVal -= a.nVal;
    	MyInt & c = b;
    	return c;
    }
    friend ostream & operator<<(ostream &os,const MyInt & a) {// 重载<<运算符，输出对象； 
    	os<<a.nVal;
    	return os;
	}
	friend int Inc(const MyInt m) {// 返回（对象的值+1）; 
        return m.nVal + 1;
    }
}; 
int main () { 
	int n;
	while(cin >>n) {
		MyInt objInt(n);
		MyInt other(2);
		
		cout<<objInt - other<<endl;// 调用.operator-(MyInt)，输出临时对象的值;
		
		objInt-2-1-3; // 调用.operator-(int)，改变对象的值; 
		cout << Inc(objInt);// 输出对象的值； 
		cout <<","; 
		objInt-2-1; // 调用.operator-(int)，改变对象的值; 
		cout << Inc(objInt) << endl;// 输出对象（+1）的值；
	}
	return 0;
}

