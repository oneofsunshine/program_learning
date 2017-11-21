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

        if(cin>>n);
        else
            num = 1;
        //cin.clear();   //清除错误状态 
        //cin.ignore();//跳过无效数据
        return *this;
    }
// 在此处补充你的代码
};
int main()
{
    MyCin m;
    int n1,n2;
    while( m >> n1 >> n2) 
        cout  << n1 << " " << n2 << endl;
    return 0;
}
