#include <iostream> 
#include <cstring> 
#include <cstdlib> 
#include <cstdio> 
using namespace std;
const int MAX = 110; 
class CHugeInt {
	public:
    int len;
    int num[201];
    CHugeInt() {}
	CHugeInt(int input) {
        for(int i = 0; i < 201; i++)
            num[i] = 0;
        len = 0;
        if(input == 0)
            len = 1;
        while(input > 0) {
            num[len] = input % 10;
            input /= 10;
            len ++;
        }
    }
	CHugeInt(char * c) {
        for(int i = 0; i < 201; i++)
            num[i] = 0;
        len = strlen(c);
        int k = 0;
        while(c[k] != '\0') {
            num[k] = (int)(c[len - 1 - k] - '0');
            k++;
        }
	}
	CHugeInt operator+ (const CHugeInt & b) {
        CHugeInt h;
        h.len = (len>b.len)?len:b.len;
        for(int i = 0; i < h.len; i++) {
            h.num[i] = num[i] + b.num[i];
        }
        for(int i = 0; i < h.len - 1; i ++) {
            if(h.num[i] >= 10) {
                h.num[i + 1] += 1;
                h.num[i] -= 10;
            }
        }
        if(h.num[len - 1] >= 10) {
            h.num[len - 1] -= 10;
            h.num[len] = 1;
            h.len ++;
        }
		return h;
	}
	CHugeInt operator+ (int n) {
        CHugeInt chi(n);
        CHugeInt ch = * this +chi;
		return ch;
	}
    CHugeInt operator+= (int k) {
        CHugeInt chi(k);
        * this = * this + chi;
        return * this;
    }
	friend CHugeInt operator+ (int n,CHugeInt & other) {
        CHugeInt ch = other + n;
		return ch;
	}
    CHugeInt operator++ (int k) {
        CHugeInt old = *this;
        * this = * this +1;
        return old;
    }
    CHugeInt & operator++ () {
        * this = * this +1;
        return * this;
    }
    friend ostream & operator<< (ostream & os,const CHugeInt & b) {
        for(int i = b.len - 1; i >= 0; i--)
            os<<b.num[i];
        return os;
    }
};
int  main() 
{ 
	char s[210];
	int n;

	while (cin >> s >> n) {
		CHugeInt a(s);
		CHugeInt b(n);

		cout << a + b << endl;
		cout << n + a << endl;
		cout << a + n << endl;
		b += n;
		cout  << ++ b << endl;
		cout << b++ << endl;
		cout << b << endl;
	}
	return 0;
}
