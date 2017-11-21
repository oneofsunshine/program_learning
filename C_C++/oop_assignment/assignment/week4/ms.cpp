#include<iostream>
#include<cstdio>
using namespace std;
#define Warr_Num 5
class Headquarter;
class Warrior {
protected:
    Headquarter * phq;
	int id;// 代表武士编号
public:
    static int initLifeValue[Warr_Num];
    static string warr_name[5];// 代表武士名
    Warrior() { }
	Warrior(Headquarter * phead,int n):phq(phead),id(n) { }
    virtual ~Warrior() { }
    void print(int clock, int whichWarr);
};
class Iceman :public Warrior {
    public:
    Iceman(Headquarter * ph, int i):Warrior(ph, i) { }
    ~Iceman() { }
};
class Lion :public Warrior {
    public:
    Lion(Headquarter * ph, int i):Warrior(ph, i) { }
    ~Lion() { }
};
class Wolf :public Warrior {
    public:
    Wolf(Headquarter * ph, int i):Warrior(ph, i) { }
    ~Wolf() { }
};
class Ninja :public Warrior {
    public:
    Ninja(Headquarter * ph, int i):Warrior(ph, i) { }
    ~Ninja() { }
};
class Dragon :public Warrior {
    public:
    Dragon(Headquarter * ph, int i):Warrior(ph, i) { }
    ~Dragon() { }
};

class Headquarter {
public:
    int color,  vitality;// 代表司令部总生命元
    static string hq_color[2];
    bool stopped;
    int curmaking;
    static int makingorder[2][Warr_Num];
    int num_warr;// 代表武士总个数
    int num[Warr_Num]; // 各武士数量
    Warrior * pWarr[1000];
    Headquarter () { };
	Headquarter(int color_, int M);
    ~Headquarter();
    int produce(int clock);
};

void Warrior::print(int clock, int whichWarr) {
    string color = Headquarter::hq_color[phq->color];
    string warr = warr_name[whichWarr];
    int bio = initLifeValue[whichWarr];
    int number = phq->num[whichWarr];
    printf("%03d %s %s %d born with strength %d,%d %s in %s headquarter\n", clock, color.c_str(), warr.c_str(), id, bio, number, warr.c_str(), color.c_str());
}

Headquarter::Headquarter(int color_, int M) {
    color = color_;
	vitality = M;
    num_warr = 0;
    stopped = false;
    curmaking = 0;
    for(int i = 0; i < Warr_Num; i++)
        num[i] = 0;
}

Headquarter::~Headquarter() {
    for(int i = 0; i < num_warr; i++)
        delete pWarr[i];
}

int Headquarter::produce(int clock) {
    if(stopped)
        return 0;

    int count = 0; //寻找下一个制造
    while(Warrior::initLifeValue[makingorder[color][curmaking]] > vitality && count < Warr_Num) { //找遍还是找不到curmaking回到开始位置
        curmaking = (curmaking + 1) % Warr_Num; //curmaking 找到要制造的武士
        count ++;
    }

    int whichWarr = makingorder[color][curmaking]; //选中要制造的武士种类
    if(Warrior::initLifeValue[whichWarr] > vitality) { //当前生命元不足以制造下一个武士（停止制造）
        stopped = true;
        if(color == 0)
            printf("%03d red headquarter stops making warriors\n", clock);
        else
            printf("%03d blue headquarter stops making warriors\n", clock);
        return 0;
    }

    vitality -= Warrior::initLifeValue[whichWarr];
    curmaking = (curmaking + 1) % Warr_Num; // curmaking移向下一个要制造的武士
    switch(curmaking) { //制造武士
        case 0:pWarr[num_warr] = new Dragon(this, num_warr + 1);break;
        case 1:pWarr[num_warr] = new Ninja(this, num_warr + 1);break;
        case 2:pWarr[num_warr] = new Iceman(this, num_warr + 1);break;
        case 3:pWarr[num_warr] = new Lion(this, num_warr + 1);break;
        case 4:pWarr[num_warr] = new Wolf(this, num_warr + 1);break;
        default:cout<<"wrong";
    }
    num[whichWarr]++; //此武士数量+1
    pWarr[num_warr]->print(clock, whichWarr);
    num_warr ++; //总武士数+1
    return 1;
}

string Headquarter::hq_color[2] = {"red","blue"};
string Warrior::warr_name[Warr_Num] =  {"dragon","ninja","iceman","lion","wolf" };
int Warrior::initLifeValue[5];
int Headquarter::makingorder[2][Warr_Num] = {{2,3,4,1,0},{3,0,1,2,4}}; //存放两司令部武士制造顺序

int main()
{
	int num, time = 1;
    cin>>num;
	while(time <= num) {
        cout<<"Case:"<<time<<endl;
		int M;
		cin >> M;
		Headquarter red(0,M), blue(1,M);
        for(int i = 0; i < Warr_Num; i++)
            scanf("%d", & Warrior::initLifeValue[i]);
        int clock = 0;
	    while(1) {
            int red_over = red.produce(clock);
            int blue_over = blue.produce(clock);
            if(red_over == 0 && blue_over ==0)
                break;
            clock ++;
        }
        time ++;
	}
	return 0;
}
/*
 *描述
 *魔兽世界的西面是红魔军的司令部，东面是蓝魔军的司令部。两个司令部之间是依次排列的若干城市。 
 红司令部，City 1，City 2，……，City n，蓝司令部
两军的司令部都会制造武士。武士一共有 dragon 、ninja、iceman、lion、wolf 五种。每种武士都有编号、生命值、攻击力这三种属性。 
双方的武士编号都是从1开始计算。红方制造出来的第n个武士，编号就是n。同样，蓝方制造出来的第n个武士，编号也是n。 
武士在刚降生的时候有一个生命值。 
在每个整点，双方的司令部中各有一个武士降生。 
红方司令部按照iceman、lion、wolf、ninja、dragon的顺序循环制造武士。 
蓝方司令部按照lion、dragon、ninja、iceman、wolf的顺序循环制造武士。 
制造武士需要生命元。 
制造一个初始生命值为m的武士，司令部中的生命元就要减少m个。 
如果司令部中的生命元不足以制造某个按顺序应该制造的武士，那么司令部就试图制造下一个。如果所有武士都不能制造了，则司令部停止制造武士。
给定一个时间，和双方司令部的初始生命元数目，要求你将从0点0分开始到双方司令部停止制造武士为止的所有事件按顺序输出。
一共有两种事件，其对应的输出样例如下： 
1) 武士降生 
输出样例： 004 blue lion 5 born with strength 5,2 lion in red headquarter
表示在4点整，编号为5的蓝魔lion武士降生，它降生时生命值为5，降生后蓝魔司令部里共有2个lion武士。（为简单起见，
	不考虑单词的复数形式）注意，每制造出一个新的武士，都要输出此时司令部里共有多少个该种武士。
2) 司令部停止制造武士
输出样例： 010 red headquarter stops making warriors
表示在10点整，红方司令部停止制造武士
输出事件时： 
首先按时间顺序输出； 
同一时间发生的事件，先输出红司令部的，再输出蓝司令部的。
输入
第一行是一个整数，代表测试数据组数。
每组测试数据共两行。 
第一行：一个整数M。其含义为， 每个司令部一开始都有M个生命元( 1 <= M <= 10000)。
第二行：五个整数，依次是 dragon 、ninja、iceman、lion、wolf 的初始生命值。它们都大于0小于等于10000。
输出
对每组测试数据，要求输出从0时0分开始，到双方司令部都停止制造武士为止的所有事件。
对每组测试数据，首先输出"Case:n" n是测试数据的编号，从1开始 。
接下来按恰当的顺序和格式输出所有事件。每个事件都以事件发生的时间开头，时间以小时为单位，有三位。
样例输入
1
20
3 4 5 6 7
样例输出
Case:1
000 red iceman 1 born with strength 5,1 iceman in red headquarter
000 blue lion 1 born with strength 6,1 lion in blue headquarter
001 red lion 2 born with strength 6,1 lion in red headquarter
001 blue dragon 2 born with strength 3,1 dragon in blue headquarter
002 red wolf 3 born with strength 7,1 wolf in red headquarter
002 blue ninja 3 born with strength 4,1 ninja in blue headquarter
003 red headquarter stops making warriors
003 blue iceman 4 born with strength 5,1 iceman in blue headquarter
004 blue headquarter stops making warriors
*/
