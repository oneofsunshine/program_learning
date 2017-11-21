#include<iostream>
using namespace std;
int main()
{
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i ++) 
        cin >> a[i];
    int b[n];
    for(int i = 0; i < n; i ++)
        b[i] = a[i] % 10;
    for(int i = 0; i < n - 1; i ++) {
        for ( int j = 1; j < n - i; j ++) {
            if (b[j] < b[j - 1]) {
                int tmp = b[j];
                b[j] = b[j - 1];
                b[j - 1] = tmp;
                tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
            }
        }
    }
    for (int i = 0; i < n - 1; i ++)
        cout << a[i] << " ";
    cout << a[n - 1] << endl; //1

    for (int i = 0; i < n; i ++) {
        if(a[i] >= 10)
            b[i] = (a[i] / 10) % 10;
        else
            b[i] = 0;
    }
    for(int i = 0; i < n - 1; i ++) {
        for ( int j = 1; j < n - i; j ++) {
            if (b[j] < b[j - 1]) {
                int tmp = b[j];
                b[j] = b[j - 1];
                b[j - 1] = tmp;
                tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
            }
        }
    }
    for (int i = 0; i < n - 1; i ++)
        cout << a[i] << " ";
    cout << a[n -1] << endl; //10

    for (int i = 0; i < n; i ++) {
        if(a[i] >= 100)
            b[i] = (a[i] / 100);
        else
            b[i] = 0;
    }
    for(int i = 0; i < n - 1; i ++) {
        for ( int j = 1; j < n - i; j ++) {
            if (b[j] < b[j - 1]) {
                int tmp = b[j];
                b[j] = b[j - 1];
                b[j - 1] = tmp;
                tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
            }
        }
    }
    for (int i = 0; i < n - 1; i ++)
        cout << a[i] << " ";
    cout << a[n - 1] << endl; //100
    return 0;
}
