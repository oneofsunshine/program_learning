#include<iostream>
using namespace std;
int ap[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int ar[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int date(int s, int rOrP, int m, int d)
{
    int t = s;
    if(rOrP)
    {
        for(int i = 0; i < m - 1; i++)
            t += ar[i];
        t += d;
    }// 润年从第一天到目标日期总天数（多1）;
    else
    {
        for(int i = 0; i < m -1; i++)
            t += ap[i];
        t += d;
    }// 平年从第一天到目标日期总天数（多1）;
    return t % 7 - 1;
}
int main()
{
    int start, month, day;
    char rp;
    cin>>start>>rp>>month>>day;
    switch(date(start, (int)rp - 'p', month, day))
    {
        case 0:cout<<"SUN";break;
        case 1:cout<<"MON";break;
        case 2:cout<<"TUE";break;
        case 3:cout<<"WED";break;
        case 4:cout<<"THU";break;
        case 5:cout<<"FRI";break;
        case 6:cout<<"SAT";break;
        default:cout<<"wrong";
    }
}
