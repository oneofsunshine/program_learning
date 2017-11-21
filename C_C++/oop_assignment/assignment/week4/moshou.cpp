#include<iostream>
#include<iomanip>
using namespace std;
class Warrior {
protected:
	int id;// 代表武士编号
	int bionergy;// 代表武士生命值
public:
    Warrior() { }
	Warrior(int bio,int n):bionergy(bio),id(n) { }
    int getBio() {
        return bionergy;
    }
    int getId() {
        return id;
    }
    ~Warrior() {}
};
class Iceman :public Warrior {
    public:
    Iceman(int b = 0,int i = 0):Warrior(b, i) {
        cout<<" iceman "<<id<<" born with strength "<<bionergy<<",";
    }
};
class Lion :public Warrior {
    public:
    Lion(int b,int i):Warrior(b, i) {
        cout<<" lion "<<id<<" born with strength "<<bionergy<<",";
    } 
};
class Wolf :public Warrior {
    public:
    Wolf(int b,int i):Warrior(b, i) { 
        cout<<" wolf "<<id<<" born with strength "<<bionergy<<",";
    } 
};
class Ninja :public Warrior {
    public:
    Ninja(int b,int i):Warrior(b, i) {
        cout<<" ninja "<<id<<" born with strength "<<bionergy<<",";
    } 
};
class Dragon :public Warrior {
    public:
    Dragon(int b, int i):Warrior(b, i) {
        cout<<" dragon "<<id<<" born with strength "<<bionergy<<",";
    } 
};
class Headquarter {
public:
    string order[5];// 代表武士出生顺序
    string hName;// 代表司令部名称
    // int num_warr;// 代表武士总个数
    int num_lion,num_ice,num_wolf,num_ninja,num_dragon;// 代表各武士对象的个数
    int bio_lion,bio_ice,bio_wolf,bio_ninja,bio_dragon;// 代表各武士的生命值
	int vitality, warr_id;// 代表司令部总生命元，武士编号
    Headquarter () { }
	Headquarter(string hn, int M) {
        hName = hn;
		vitality = M;
        warr_id = 1;
        //num_warr = 0;
        num_lion = num_ice = num_wolf = num_ninja = num_dragon = 0;
        bio_lion = bio_ice = bio_wolf = bio_ninja = bio_dragon = 0;
	}
    ~Headquarter() {}
    void setBio(int b_l,int b_i,int b_w,int b_n,int b_d) {// 设置武士生命值
        bio_lion = b_l;
        bio_ice = b_i;
        bio_wolf = b_w;
        bio_ninja = b_n;
        bio_dragon = b_d;
    }
    int min_bio() {
        int min = bio_lion;
        min = min<bio_ice?min:bio_ice;
        min = min<bio_wolf?min:bio_wolf;
        min = min<bio_ninja?min:bio_ninja;
        min = min<bio_dragon?min:bio_dragon;
        return min;
    }
    void setOrder(string s[5]) {// 设置武士出生顺序
        for(int i = 0; i < 5 ; i++)
            order[i] = s[i];
    }
	bool hasNext() { // 判断是否继续输出 
		return (vitality >= min_bio());
	}
    string createWhich(int l) {
        int next = l%5;
        int b = 0;
        while(1) {
            switch(order[next][0]) {
                case 'l':b = bio_lion;break;
                case 'i':b = bio_ice;break;
                case 'w':b = bio_wolf;break;
                case 'n':b = bio_ninja;break;
                case 'd':b = bio_dragon;break;
                default:cout<<"@";b = 0;
            }
            if (vitality >= b) break;
            next = (next + 1) % 5;
        }
        return order[next];
    }
	void createWarr(int c) { // 格式化输出
		switch(createWhich(warr_id - 1)[0]) {
		    case 'l':
            cout<<setw(3)<<setfill('0')<<c<<" "<<hName;
            new Lion(bio_lion,warr_id++);
            vitality -= bio_lion;
            cout<<++num_lion<<" lion in "<<hName<<" headquarter"<<endl;
            break;
            case 'i':
            cout<<setw(3)<<setfill('0')<<c<<" "<<hName;
            new Iceman(bio_ice,warr_id++);
            vitality -= bio_ice;
            cout<<++num_ice<<" iceman in "<<hName<<" headquarter"<<endl;
            break;
		    case 'w':
            cout<<setw(3)<<setfill('0')<<c<<" "<<hName;
            new Wolf(bio_wolf,warr_id++);
            vitality -= bio_wolf;
            cout<<++num_wolf<<" wolf in "<<hName<<" headquarter"<<endl;
            break;
			case 'n':
            cout<<setw(3)<<setfill('0')<<c<<" "<<hName;
            new Ninja(bio_ninja,warr_id++);
            vitality -= bio_ninja;
            cout<<++num_ninja<<" ninja in "<<hName<<" headquarter"<<endl;
            break;
		    case 'd':
            cout<<setw(3)<<setfill('0')<<c<<" "<<hName;
            new Dragon(bio_dragon,warr_id++);
            vitality -= bio_dragon;
            cout<<++num_dragon<<" dragon in "<<hName<<" headquarter"<<endl;
            break;
    		default:cout<<"wrong";
	    }
	}
};
int main()
{
	int num, time = 1;
    string order_red[5] = {"iceman","lion","wolf","ninja","dragon"};
    string order_blue[5] = {"lion","dragon","ninja","iceman","wolf"};
    cin>>num;
	while(time <= num) {
        int clock = 0;
		int M, b_dragon, b_ninja, b_iceman, b_lion, b_wolf;
        int red_over = 0,blue_over = 0;
		cin >> M;
		Headquarter red("red",M), blue("blue",M);
        cin >> b_dragon >> b_ninja >> b_iceman >> b_lion >> b_wolf;
        red.setBio(b_lion,b_iceman,b_wolf,b_ninja,b_dragon);
        blue.setBio(b_lion,b_iceman,b_wolf,b_ninja,b_dragon);
        red.setOrder(order_red);
        blue.setOrder(order_blue);
        cout<<"Case:"<<time<<endl;
	    while(red.hasNext() || blue.hasNext()) {
            if(red_over == 0) {
               if(red.hasNext())
                    red.createWarr(clock);
                else {
                    cout<<setw(3)<<setfill('0')<<clock<<" red headquarter stops making warriors"<<endl;
                    red_over = 1;
                }
            }
            if(blue_over == 0) {
                if(blue.hasNext())
                    blue.createWarr(clock);
                else {
                    cout<<setw(3)<<setfill('0')<<clock<<" blue headquarter stops making warriors"<<endl;
                    blue_over = 1;
                }
            }
            clock ++;
        }
        if(red_over == 0)
            cout<<setw(3)<<setfill('0')<<clock<<" red headquarter stops making warriors"<<endl;
        if(blue_over == 0)
            cout<<setw(3)<<setfill('0')<<clock<<" blue headquarter stops making warriors"<<endl;
        time ++;
	}
	return 0;
}
        /*red.setWarr(Iceman(b_iceman),Lion(b_lion),Wolf(b_wolf),Ninja(b_ninja),Dragon(b_dragon));
        blue.setWarr(Lion(b_lion),Dragon(b_dragon),Ninja(b_ninja),Iceman(b_iceman),Wolf(b_wolf));*/
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
