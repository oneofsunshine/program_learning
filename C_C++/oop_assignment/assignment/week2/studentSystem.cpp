#include<iostream>
#include<math.h>
#include<stdio.h>
#include<string>
using namespace std;
class student
{
    private:
    string name, sno;
    int age, grade1, grade2, grade3, grade4;
    public:
    student(string nameln, int ageln, string snoln, int g1ln, int g2ln, int g3ln, int g4ln)
    {
        name = nameln;
        age = ageln;
        sno = snoln;
        grade1 = g1ln;
        grade2 = g2ln;
        grade3 = g3ln;
        grade4 = g4ln;
    }
    int average()
    {
        return floor((grade1+grade2+grade3+grade4)/4);
    }
    void print() {
        cout<<name<<","<<age<<","<<sno<<","<<average();
    }
};
int main()
{
    string name, sno;
    int age, g1, g2, g3, g4;
    getline(cin,name,',');
    scanf("%d,",&age);
    getline(cin,sno,',');
    scanf("%d,%d,%d,%d",&g1,&g2,&g3,&g4);
    student s(name,age,sno,g1,g2,g3,g4);
    s.print();
    return 0;
}
