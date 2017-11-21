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
    MyInt & operator-(int a) {// �޸ĵ��õĶ����ֵ�����ص��ö���
    	nVal -= a;
    	return *this;
    }
    MyInt & operator-(MyInt a) {// ������ʱ���󣬷��أ���ʱ�����ֵ-����ֵ���� 
    	MyInt b(nVal);
    	b.nVal -= a.nVal;
    	MyInt & c = b;
    	return c;
    }
    friend ostream & operator<<(ostream &os,const MyInt & a) {// ����<<�������������� 
    	os<<a.nVal;
    	return os;
	}
	friend int Inc(const MyInt m) {// ���أ������ֵ+1��; 
        return m.nVal + 1;
    }
}; 
int main () { 
	int n;
	while(cin >>n) {
		MyInt objInt(n);
		MyInt other(2);
		
		cout<<objInt - other<<endl;// ����.operator-(MyInt)�������ʱ�����ֵ;
		
		objInt-2-1-3; // ����.operator-(int)���ı�����ֵ; 
		cout << Inc(objInt);// ��������ֵ�� 
		cout <<","; 
		objInt-2-1; // ����.operator-(int)���ı�����ֵ; 
		cout << Inc(objInt) << endl;// �������+1����ֵ��
	}
	return 0;
}

