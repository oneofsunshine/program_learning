#include <iostream>
#include <iomanip>
#include <cstring>
using namespace std;
// 在此处补充你的代码
template <class T>
class CArray3D {
public:
    class CArray2D {
    private:
        T *a;
        int i,j;
    public:
        CArray2D() {a = NULL;}
        CArray2D(int a1, int a2):i(a1),j(a2) {
            a = new T[i*j];
        }
        ~CArray2D() {
            if (a != NULL) delete []a;
        }
        T * operator[](int a1) {
            return a + a1*j;
        }
        operator  T * () {
            return this->a;
        }
    };
    CArray3D() {array2D = NULL;}
    CArray3D(int a1, int a2, int a3) {
        array2D = new CArray2D*[a1];
        for (int m = 0; m < a1; ++m) {
            array2D[m] = new CArray2D(a2, a3);
        }
    }
    CArray2D & operator[](int i) {
        return *array2D[i];
    }
    ~CArray3D() {
        if (array2D != NULL) delete []array2D;
    }
private:
    CArray2D **array2D;
};
CArray3D<int> a(3,4,5);
CArray3D<double> b(3,2,2);
void PrintA()
{
	for(int i = 0;i < 3; ++i) {
		cout << "layer " << i << ":" << endl;
		for(int j = 0; j < 4; ++j) {
			for(int k = 0; k < 5; ++k) 
				cout << a[i][j][k] << "," ;
			cout << endl;
		}
	}
}
void PrintB()
{
	for(int i = 0;i < 3; ++i) {
		cout << "layer " << i << ":" << endl;
		for(int j = 0; j < 2; ++j) {
			for(int k = 0; k < 2; ++k) 
				cout << b[i][j][k] << "," ;
			cout << endl;
		}
	}
}
int main()
{
    int No = 0;
    for( int i = 0; i < 3; ++ i )
        for( int j = 0; j < 4; ++j )
            for( int k = 0; k < 5; ++k )
                a[i][j][k] = No ++;
    PrintA();
    memset(a[1],-1 ,20*sizeof(int)); //point
    PrintA();
    memset(a[1][1],0 ,5*sizeof(int));
    PrintA();
		
    for( int i = 0; i < 3; ++ i )
		for( int j = 0; j < 2; ++j )
			for( int k = 0; k < 2; ++k )
				b[i][j][k] = 10.0/(i+j+k+1);
    PrintB();
    int n = a[0][1][2];
	double f = b[0][1][1];
    cout << "****" << endl;
	cout << n << "," << f << endl;
    return 0;
}
