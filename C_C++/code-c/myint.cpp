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
    MyInt & operator-(int a) {// 生成临时对象，返回（临时对象的值-参数值）； 
        MyInt b(nVal - a);
        cout<<b.nVal<<endl;// 输出临时对象的值； 
        MyInt & c = b; 
        return c;
    }
    friend int Inc(const MyInt m) {// 返回（对象的值+1）; 
        return m.nVal + 1;
    }
}; 
int main () { 
	int n;
	while(cin >>n) {
		MyInt objInt(n); 
		objInt = objInt-2-1-3; // 将临时变量的值赋给实例化对象objint； 
		cout<<"tip:" << Inc(objInt)<<endl;// 输出实例化对象objint（+1）的值； 
		//cout <<","; 
		objInt-2-1; // 调用.operator-(int)，其结果不对objint赋值； 
		cout<<"tip:" << Inc(objInt) << endl;// 输出实例化对象objint（+1）的值；
	}
	return 0;
}

