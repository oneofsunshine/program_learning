#include<iostream>
#include<vector>
using namespace std;
int main()
{
	vector<int> vi;
	int n, m;
	cin >> n >> m;
	for(int i = 0; i < n; i ++)
		vi.push_back(i + 1);
	
	while(vi.size() > 2) {
		cout << vi[m] << " ";
		vi.erase(vi.begin() + (m));
		m = (m + 1) % vi.size();
	}
	cout << endl << vi[0] << " " << vi[1];
	return 0;
} 
