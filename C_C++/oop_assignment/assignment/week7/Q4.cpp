#include <iostream>
#include <cstdlib>
#include <map>
using namespace std;
int getId(multimap<int, int> & m, int strength)
{
    map<int, int>::iterator it = m.lower_bound(strength);
    if(it->first == strength)
        return it->second;
    if(it != m.begin()) {
        multimap<int, int>::iterator it1 = it;
        it --;
        if(abs(strength - it->first) <= abs(strength - it1->first))
            return it->second;
        else
            return it1->second;
    }
    else
        return it->second;
}
int main()
{
	multimap<int, int> member;
	member.insert(pair<int, int> (1000000000, 1));
	int N;
    cin >> N;
	while(N--) {
		int id_old;
		int id, strength;
		cin >> id >> strength;
        id_old = getId(member, strength);
		member.insert(pair<int, int> (strength, id));
		cout << id <<" "<< id_old << endl;
	}
	return 0;
}
/*
第一行一个数n(0 < n <=100000)，表示格斗场新来的会员数（不包括facer）。
以后n行每一行两个数，按照入会的时间给出会员的id和实力值。一开始，facer就算是会员，id为1，实力值1000000000。
输入保证两人的实力值不同。

输出
N行，每行两个数，为每场比赛双方的id，新手的id写在前面。

样例输入
3
2 1
3 3
4 2
样例输出
2 1
3 2
4 2
*/
