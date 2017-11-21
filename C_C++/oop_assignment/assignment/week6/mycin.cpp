#include <iostream>
using namespace std;
class MyCin
{
    int num;
    public:
    MyCin():num(0) {}
    operator bool() {
        return !num;
    }
    MyCin & operator>>(int & n) {
        if(cin >> n) {
            if(n == -1) num = 1;
        }
        else
            num = 1;
        return *this;
    }
};
int main()
{
    MyCin m;
    int n1,n2;
    while( m >> n1 >> n2) 
        cout  << n1 << " " << n2 << endl;
    return 0;
}
