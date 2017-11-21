#include <iostream>
#include <cstring>
using namespace std;

class Array2 {
    public:
    int row,col;
    int ** array;
    Array2() {}
    Array2(int r,int c) {
        row = r;
        col = c;
        array = new int * [r];
        for (int i = 0; i < r; i++) {
            array[i] = new int[c];
        }
    }
    int operator() (int i,int j) {
        return array[i][j];
    }
    int * operator[] (int i) {
        return array[i];
    }
    Array2 & operator= (const Array2 & other) {
        row = other.row;
        col = other.col;
        array = new int * [other.row];
        for (int i = 0; i < other.row; i++) {
            array[i] = new int[col];
        }
        for(int i = 0; i < other.row; i++) {
            for(int j = 0; j < col; j++) {
                array[i][j] = other.array[i][j];
            }
        }
    }
    ~Array2() {
        for(int i = 0;i < row; i++) {
            delete [] array[i];
        }
        delete [] array;
    }
};

int main() {
    Array2 a(3,4);
    int i,j;
    for(  i = 0;i < 3; ++i )
        for(  j = 0; j < 4; j ++ )
            a[i][j] = i * 4 + j;
    for(  i = 0;i < 3; ++i ) {
        for(  j = 0; j < 4; j ++ ) {
            cout << a(i,j) << ",";
        }
        cout << endl;
    }
    cout << "next" << endl;
    Array2 b;     b = a;
    for(  i = 0;i < 3; ++i ) {
        for(  j = 0; j < 4; j ++ ) {
            cout << b[i][j] << ",";
        }
        cout << endl;
    }
    return 0;
}
