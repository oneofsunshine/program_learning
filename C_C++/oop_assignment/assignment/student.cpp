#include <iostream>
#include <string>
#include <map>
#include <iterator>
#include <algorithm>
using namespace std;
// �ڴ˴�������Ĵ���
template<class Key, class Value, class Compare = greater<Key> >
class MyMultimap: public multimap<Key, Value, Compare>
{
	public:
    void Set(Key k, Value v) {
        class multimap<Key, Value, Compare>::iterator ending = this->equal_range(k).second;  
        class multimap<Key, Value, Compare>::iterator starting = this->equal_range(k).first;  
        while (starting != ending){  
            starting->second = v;  
            starting++;  
        }
    }
};
template<class T1,  class T2>
ostream & operator<<(ostream & os, pair<T1, T2> p) {
    os <<  "(" << p.first << "," << p.second << ")";
    return os;
}
struct Student 
{
	string name;
	int score;
};
template <class T>
void Print(T first,T last) {
	for(;first!= last; ++ first)
		cout << * first << ",";
	cout << endl;
}
int main()
{
	
	Student s[] = { {"Tom",80},{"Jack",70},
					{"Jone",90},{"Tom",70},{"Alice",100} };
	
	MyMultimap<string,int> mp;
	for(int i = 0; i<5; ++ i)
		mp.insert(make_pair(s[i].name,s[i].score));
	Print(mp.begin(),mp.end()); //�������Ӵ�С���

	mp.Set("Tom",78); //��������Ϊ"Tom"��ѧ���ĳɼ�������Ϊ78
	Print(mp.begin(),mp.end());
	
	
	
	MyMultimap<int,string,less<int> > mp2;
	for(int i = 0; i<5; ++ i) 
		mp2.insert(make_pair(s[i].score,s[i].name));
	
	Print(mp2.begin(),mp2.end()); //���ɼ���С�������
	mp2.Set(70,"Error");          //�����гɼ�Ϊ70��ѧ�������ֶ���Ϊ"Error"
	Print(mp2.begin(),mp2.end());
	cout << "******" << endl;
	
	mp.clear();
	
	string name;
	string cmd;
	int score;		
	while(cin >> cmd ) {
		if( cmd == "A") {
			cin >> name >> score;
			if(mp.find(name) != mp.end() ) {
				cout << "erroe" << endl;
			}
			mp.insert(make_pair(name,score));
		}
		else if(cmd == "Q") {
			cin >> name;
			MyMultimap<string,int>::iterator p = mp.find(name);
			if( p!= mp.end()) {
				cout << p->second << endl;
			}
			else {
				cout << "Not Found" << endl; 
			}		
		}
	}
	return 0;
}
