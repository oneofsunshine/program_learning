/*************************************************************************
	> File Name: signin.cpp
	> Author: Yuan Hao
	> Mail:begin20160801@gmail.com 
	> Created Time: 2017年07月14日 星期五 08时49分07秒
 ************************************************************************/

#include<iostream>
#include<fstream>
#include<ctime>
using namespace std;
int main()
{
    fstream f("checkin.log", ios::in | ios::app);
    if(f.good()) {
        time_t t = time(0);
        char tmp[20];
        strftime(tmp, 20, "%F %T", localtime(&t));
	int k;
	cin >> k;
	string s = (k == 1)? "sign in" : "sign out\n"; 
        if(f << tmp << "\t" << s << endl)
            cout << "写入成功" << endl;
        else
            cout << "写入失败" << endl;
    }
    else
        cout << "文件打开失败" << endl;
    f.close();
    return 0;
}
