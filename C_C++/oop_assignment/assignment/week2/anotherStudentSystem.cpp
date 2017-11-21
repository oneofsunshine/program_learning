#include<iostream>
#include<string>
#include<cstdio>
#include<cstring>
#include<cstdlib>
#include<sstream>
using namespace std;
class Student {
    private:
    string name,sno;
    int age;
    float ave, g1,g2,g3,g4;
    public:
    void input() {
        getline(cin,name,',');
        scanf("%d,",&age);
        getline(cin,sno,',');
        scanf("%f,%f,%f,%f",&g1,&g2,&g3,&g4);
    }
    void calculate() {
        ave = (g1+g2+g3+g4) / 4;
    }
    void output() {
        cout<<name<<","<<age<<","<<sno<<","<<ave;
    }
};
int main()
{
    Student student;
    student.input();
    student.calculate();
    student.output();
}
