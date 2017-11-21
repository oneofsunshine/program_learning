#include <iostream>
#include <list>
#include <map>
using namespace std;
typedef map<int,list<int> > MapList;
int main()
{
	int num;
	MapList ml;
	string order;
	
	cin >> num;
	while(num --) {
		cin >> order;
		int id1 = 0, id2 = 0;
		switch(order[0]) {
			case 'a': {
				cin >> id1 >> id2;
                ml[id1].push_back(id2);
				break;
			}
			case 'm': {
				cin >> id1 >> id2;
                ml[id1].merge(ml[id2]);  
				break;
			}
			case 'o': {
				cin >> id1;
				ml[id1].sort();
                for(list<int>::iterator i = ml[id1].begin(); i != ml[id1].end(); i++)
                    cout<<*i<<" ";
                cout<<endl;
				break;
			}
			case 'n': {
				cin >> id1;
				ml[id1] = list<int> (); 
				break;
			}
			case 'u': {
				cin >> id1;
				ml[id1].sort();
                ml[id1].unique();
				break;
			}
			default:cout <<"wrong";
		}
	}
	return 0;
}
