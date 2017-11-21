#include <iostream>
#include <set>
using namespace std;
int main()
{
    int order_num;
    multiset<int> msi;
    set<int> mi;
    cin >> order_num;
    string order;
    int num;

    while(order_num --) {
        cin.get();
        getline(cin, order, ' ');
        cin >> num;
        switch(order[1]) {
            case 'd': {
                msi.insert(num);
                mi.insert(num);
                cout << msi.count(num) << endl;
                break;
            }
            case 's': {
                if(mi.find(num) == mi.end())
                    cout << "0 0" << endl;
                else
                    cout << "1 "  << msi.count(num) << endl;
                break;
            }
            case 'e': {
                cout << msi.count(num) << endl;
                msi.erase(num);
                break;
            }
            default: cout << "wrong";
        }
    }
    return 0;
}
/*
 *描述
现有一整数集（允许有重复元素），初始为空。我们定义如下操作：
add x 把x加入集合
del x 把集合中所有与x相等的元素删除
ask x 对集合中元素x的情况询问
对每种操作，我们要求进行如下输出。
add 输出操作后集合中x的个数
del 输出操作前集合中x的个数
ask 先输出0或1表示x是否曾被加入集合（0表示不曾加入），再输出当前集合中x的个数，中间用空格格开。
输入
第一行是一个整数n，表示命令数。0<=n<=100000。
后面n行命令，如Description中所述。
输出
共n行，每行按要求输出。
样例输入
7
add 1
add 1
ask 1
ask 2
del 2
del 1
ask 1
样例输出
1
2
1 2
0 0
0
2
1 0
 */
