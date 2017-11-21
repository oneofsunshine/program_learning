#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <algorithm>
#include <map>
#include <iomanip>
#define MAX_W 99999
using namespace std;
struct HuffNode
{
	int weight;
	int parent, lchild, rchild;
	char value;
};
map<char, string> huffmap;
void Select(vector<HuffNode> vh, int n, int & m1, int & m2)
{
	int min1 = MAX_W;
	int min2 = MAX_W;
	for(int i = 0;i < n; ++ i) {
		if(vh[i].weight < min1 && vh[i].parent == -1) {
			min2 = min1;
			m2 = m1;
			min1 = vh[i].weight;
			m1 = i;
		}
		else if(vh[i].weight < min2 && vh[i].parent == -1) {
			min2 = vh[i].weight;
			m2 = i;
		}
	}
}
void CreateMap(vector<HuffNode> vh, int n)
{
	for(int i = 0; i < n; ++ i) {
		string str;
		int c = i;
		int tmp = vh[i].parent;
		while(tmp != -1) {
			if(vh[tmp].lchild == c)
				str.push_back('0');
			else
				str.push_back('1');
			c = tmp;
			tmp = vh[tmp].parent;
		}
		reverse(str.begin(), str.end());
		huffmap.insert(pair<char, string>(vh[i].value, str));
	}
}
void Initialization(vector<HuffNode> & vh, int * w, char * v, int n)
{
	if(n <= 1) return ;
	int m = 2 * n - 1;
	int i;
	HuffNode h;
	h.parent = -1;
	h.lchild = -1;
	h.rchild = -1;
	for(i = 0; i < n; ++ i, ++ w, ++ v) {
		h.weight = * w;
		h.value = *v;
		vh.push_back(h);
	}
	h.weight = 0;
	h.value = '\0';
	for(; i < m; ++ i)
		vh.push_back(h);
	for(int i = n; i < m; ++ i) {
		int s1, s2;
		Select(vh, i, s1, s2);
		vh[s1].parent = i;
		vh[s2].parent = i;
		vh[i].lchild = s1;
		vh[i].rchild = s2;
		vh[i].weight = vh[s1].weight + vh[s2].weight;
	}
	CreateMap(vh, n);
	
	ofstream os("hfmTree.dat", ios::out);
	os << setw(5) << "id" << setw(8) << "value" << setw(9) << "weight" << setw(12) << "parent_id"
	 << setw(12) << "lchild_id" << setw(12) << "rchild_id" << endl;
	for(i = 0; i < m; ++ i)
		os << setw(5) << i << setw(8) << vh[i].value << setw(9) << vh[i].weight << setw(12) << vh[i]. parent 
			<< setw(12) << vh[i].lchild << setw(12) << vh[i].rchild << endl;
	os.close();
}

void TreePrint(vector<HuffNode> vh, int h, int space) {
	if(vh[h].lchild != -1) {
		TreePrint(vh, vh[h].rchild, space + 5);
		for(int i = 0; i < space; i++)     cout << " ";
		cout << vh[h].weight << endl;
		TreePrint(vh, vh[h].lchild, space+5);
	}
	else {
		for(int i = 0; i < space; i++)     cout << " ";
		cout << vh[h].weight << vh[h].value << endl;
	}
}
int main() {
	ifstream is("read.dat", ios::in);
	int num;
	is >> num;
	int n_weight[num];
	char n_value[num];
	for(int i = 0; i < num; ++ i)
		is >> n_weight[i] >> n_value[i];
	is.close();
	vector<HuffNode> vh;
	Initialization(vh, n_weight, n_value, num);
	TreePrint(vh, vh.size() - 1, 0);
	return 0;
}
