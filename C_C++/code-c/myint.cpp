 /*
  * Author��Yuan Hao; 
  * ̽����ʱ������������Ϊ����ֵ�Ĵ��ʱ�䣻 
  */
#include <iostream> 
using namespace std;
class MyInt 
{ 
	int nVal; 
	public: 
	MyInt( int n) { nVal = n ;}
    MyInt & operator-(int a) {// ������ʱ���󣬷��أ���ʱ�����ֵ-����ֵ���� 
        MyInt b(nVal - a);
        cout<<b.nVal<<endl;// �����ʱ�����ֵ�� 
        MyInt & c = b; 
        return c;
    }
    friend int Inc(const MyInt m) {// ���أ������ֵ+1��; 
        return m.nVal + 1;
    }
}; 
int main () { 
	int n;
	while(cin >>n) {
		MyInt objInt(n); 
		objInt = objInt-2-1-3; // ����ʱ������ֵ����ʵ��������objint�� 
		cout<<"tip:" << Inc(objInt)<<endl;// ���ʵ��������objint��+1����ֵ�� 
		//cout <<","; 
		objInt-2-1; // ����.operator-(int)����������objint��ֵ�� 
		cout<<"tip:" << Inc(objInt) << endl;// ���ʵ��������objint��+1����ֵ��
	}
	return 0;
}

