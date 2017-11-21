#include <iostream>
#include <string>
using namespace std;
class Student {
    public:
    string sname;
    unsigned int sno;
    Student() { }
    Student(const char * s, unsigned int no) {
        sname = s;
        sno = no;
    }
    void Read () {
        char a[100];
        cin.get();
        cin.getline(a,100,' ');
        sname = a;
        cin >> sno;
    }
    void Print() {
        cout << sno << " " << sname << endl;
    }
};
// 在此处补充你的代码
int main()
{
	int t;
	cin >> t;
	Student s("Tom",12);
	while( t-- )	{
		int n;
		cin >> n;
		Student st;
		for( int i = 0;i < n; ++i) {
			st.Read();
			st.Print();
		}
		cout << "****" << endl;
	}
	return 0;
}
