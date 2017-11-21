#include <iostream>
#include <set>
#include <vector>
#include <fstream>
using namespace std;
int count(int * & w, char * & v)
{
	int len = 0;
	vector<int> vi;
	vector<char> vc;
	ifstream is("read_.dat", ios::in);
	multiset<char> msc;
	char c;
	while(is >> c)
		msc.insert(c);
	cout << msc.size() << endl;
	while(!msc.empty()) {
		vc.push_back(* msc.begin());
		vi.push_back(msc.count(* msc.begin()));
		cout << * msc.begin() << " " << msc.count(* msc.begin()) << endl;
		msc.erase(*msc.begin());
		len ++;
	}
	
	w = new int[len];
	v = new char[len];
	
	for(int i = 0; i < len; ++ i) {
		v[i] = vc[i];
		w[i] = vi[i];
	}
	
	is.close();
	return len;
}
int main()
{
	int * n_weight;
	char * n_value;
	int num = count(n_weight, n_value);
	for(int i = 0; i < num; ++ i)
		cout << n_weight[i] << n_value[i] << endl;
	return 0;
}
