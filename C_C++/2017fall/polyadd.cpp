#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Poly
{
    public:
    int coef; //系数
    int expom; //指数
    Poly(int c, int e):coef(c),expom(e) { }
};
class MyLess
{
    public:
    bool operator() (const Poly & p1, const Poly & p2) {
        return p1.expom > p2.expom || (p1.expom == p2.expom && p1.coef < p2.coef);
    }
};
typedef vector<Poly> v_poly;
void printResult(v_poly);
v_poly add(v_poly p1, v_poly p2) //add two poly
{
    v_poly p;
    v_poly::iterator i, j;
    for(i = p1.begin(); i != p1.end(); ++ i) {
        p.push_back(Poly((*i).coef, (*i).expom));
    }
    for(j = p2.begin(); j != p2.end(); j ++) {
        p.push_back(Poly((*j).coef, (*j).expom));
    }
    sort(p.begin(), p.end(), MyLess());
    for(i = p.begin() + 1; i != p.end(); ++ i) {
        j = i;
        j --;
        if((*i).expom == (*j).expom) {
            int c = (*i).coef + (*j).coef;
            int e = (*i).expom;
            p.erase(i);
            i = j -1;
            p.erase(j);
            p.push_back(Poly(c,e));
        }
    }
    for(i = p.begin(); i != p.end(); ++i) {
        if((*i).coef == 0) {
            j = i;
            i --;
            p.erase(j);
        }
    }
    sort(p.begin(), p.end(), MyLess());
    return p;
}
void printResult(v_poly p)
{
    v_poly::iterator it = p.begin();
    for(; it != p.end(); it ++)
        cout << (*it).coef << " " <<(*it).expom << " ";
    cout << endl;
}
int main()
{
    v_poly p1, p2;
    int n1,n2;
    cin >> n1;
    int c,e;
    while(n1 --) {
        cin >> c >> e;
        p1.push_back(Poly(c,e));
        sort(p1.begin(), p1.end(), MyLess());
    }
    cin >> n2;
    while(n2 --) {
        cin >> c >> e;
        p2.push_back(Poly(c,e));
        sort(p2.begin(), p2.end(), MyLess());
    }
    v_poly p = add(p1, p2);
    printResult(p);
    return 0;
}
