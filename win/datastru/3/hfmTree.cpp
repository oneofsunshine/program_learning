#include <iostream>
#include <cstdio>
#include <vector>
#include <map>
#include <set>
#include <fstream>
#include <string>
#include <algorithm>
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
int count(int * &, char * &); 
void Select(vector<HuffNode>, int, int &, int &);
void CreateMap(vector<HuffNode>, int);
void Initialization(vector<HuffNode> &, int *, char *, int);
void Encoding(string);
void Decoding(vector<HuffNode> &, string, int); 
void Print();
void TreePrinting(vector<HuffNode>, int, int);

int main()
{
	ifstream is("read.dat", ios::in);
	// 从read.dat读取统计后信息 
//	int num;
//	//cout << "请输入字符集大小:";
//	is >> num;
//	//cout << "请输入字符及权重:";
//	int n_weight[num];
//	char n_value[num];
//	for(int i = 0; i < num; ++ i)
//		is >> n_weight[i] >> n_value[i];
	//
	is.close();
	
	//从ToBeTran.dat读取原文统计出现字母及频率 
	int * n_weight;
	char * n_value;
	int num = count(n_weight, n_value);
	//	
	
	vector<HuffNode> vh;
	Initialization(vh, n_weight, n_value, num);
	
	is.open("ToBeTran.dat", ios::in);
	string oraText;
	is >> oraText;
	is.close();
	Encoding(oraText);
	
	is.open("CodeFile.dat", ios::in);
	string codeText;
	is >> codeText;
	is.close();
	Decoding(vh, codeText, num);
	
	Print();
	
	TreePrinting(vh, vh.size() - 1, 0);
	
	return 0;
}

int count(int * & w, char * & v)
{
	int len = 0;
	vector<int> vi;
	vector<char> vc;
	ifstream is("ToBeTran.dat", ios::in);
	multiset<char> msc;
	char c;
	while(is >> c)
		msc.insert(c);
	while(!msc.empty()) {
		vc.push_back(* msc.begin());
		vi.push_back(msc.count(* msc.begin()));
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

void Encoding(string s)
{
	int i = 0;
	ofstream os("CodeFile.dat", ios::out);
	while(s[i] != '\0') {
		os << huffmap[s[i]];
		i++;
	}
	os.close();
}

void Decoding(vector<HuffNode> & vh, string s, int n)
{
	ofstream of("TextFile.dat", ios::out);
	int key = 2 * n - 2;
	for(int i = 0; i < s.length(); ++ i) {
		if(s[i] - '0')
			key = vh[key].rchild; //1
		else
			key = vh[key].lchild; //0
		if(vh[key].lchild == -1) {
			of << vh[key].value;
			key = 2 * n - 2;
		}
	}
	of.close();
}

void Print()
{
	ifstream is("CodeFile.dat", ios::in);
	ofstream os("CodePrin.dat", ios::out);
	string s;
	is >> s;
	if(s.length() <= 50)
		for(int i = 0; i < 50; ++ i) {
			cout << s[i];
			os << s[i];
		}
	else {
		int k = 0;
		while(k < s.length()) {
			if(s.length() - k < 50) {
				for(int i = k; i < s.length(); ++ i) {
					cout << s[i];
					os << s[i];
				}
				os << endl;
				cout << endl;
				break;
			}
			for(int i = k; i < k + 50; ++ i) {
				cout << s[i];
				os << s[i];
			}
			os << endl;
			cout << endl;
			k += 50;
		}
	}
	is.close();
	os.close();
}

void TreePrinting(vector<HuffNode> vh, int h, int space)
{
	if(vh[h].lchild != -1) {
		TreePrinting(vh, vh[h].rchild, space + 5);
		for(int i = 0; i < space; i++)     cout << " ";
		cout << vh[h].weight << endl;
		TreePrinting(vh, vh[h].lchild, space+5);
	}
	else {
		for(int i = 0; i < space; i++)     cout << " ";
		cout << vh[h].weight << vh[h].value << endl;
	}
}
