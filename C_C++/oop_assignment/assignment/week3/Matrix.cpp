#include <iostream>
#include <cstring>
using namespace std;

class Matrix {
public:
	int ** p;
    int r,c;
    Matrix operator * (Matrix & a) {
        Matrix m;
        m.r = r;
        m.c = a.c;
        m.p = new int *[m.r];
        for(int i = 0;i < m.r;i ++) {
            m.p[i] = new int[m.c];
            for(int j = 0;j < m.c;j ++) {
                m.p[i][j] = 0;
                for(int k = 0;k < c;k ++)
                    m.p[i][j] += p[i][k] * a.p[k][j];
            }
        }
        return m;
    }
    friend istream & operator >> (istream &in,Matrix & a) {
        in>>a.r>>a.c;
        a.p = new int *[a.r];
        for(int i = 0; i < a.r; i ++) {
            a.p[i] = new int[a.c];
            for(int j = 0; j < a.c; j ++)
                in >> a.p[i][j];
        }
        return in;
    }
    friend ostream & operator << (ostream &o, const Matrix &a){
		for(int i = 0;i < a.r;i ++){
			for(int j = 0;j < a.c;j ++) o << a.p[i][j] << " ";
			o << endl;
		}
		return o;
	}
    ~Matrix() {
        for(int i = 0;i < r; i++) {
            delete [] p[i];
        }
        delete [] p;
    }
};

int main() {
	Matrix a, b;
	cin >> a >> b;
	cout << a * b << endl;
    return 0;
}
