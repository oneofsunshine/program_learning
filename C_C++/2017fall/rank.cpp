/*************************************************************************
	> File Name: tmp.cpp
	> Author: Yuan Hao
	> Mail:begin20160801@gmail.com 
	> Created Time: 2017年11月03日 星期五 21时17分51秒
 ************************************************************************/

#include<iostream>
#include<cstdio>
using namespace std;
struct Student
{
    int sno, yu, shu, wu;
    double ave;
};
int main()
{
    Student stu[10];
    for (int i = 0; i < 10; i ++) {
        cin >> stu[i].sno >> stu[i].yu >> stu[i].shu >> stu[i].wu;
        stu[i].ave = (stu[i].yu + stu[i].shu + stu[i].wu) / 3.0;
    }
    for (int i = 0; i < 9; i ++) {
        for (int j = 1; j < 10 - i; j ++) {
            if (stu[j - 1].ave < stu[j].ave) {
                Student tmp = stu[j - 1];
                stu[j - 1] = stu[j];
                stu[j] = tmp;
            }
        }
    }
    for (int i = 0; i < 10; i ++) {
        cout << stu[i].sno << "-" << stu[i].yu << "-" << stu[i].shu << "-" << stu[i].wu << "-";
        printf("%.02lf\n", stu[i].ave);
    }

    return 0;
}
