#include<iostream>
#include<cstdio>
using namespace std;
#define Warr_Num 5
class Headquarter;
//class Weapon;
class Warrior {
protected:
    Headquarter * phq;
	int id;// ������ʿ���
public:
    static int initLifeValue[Warr_Num];
    static string warr_name[5];// ������ʿ��
    static string weapon[3];
    Warrior() { }
	Warrior(Headquarter * phead,int n):phq(phead),id(n) { }
    virtual ~Warrior() { }
    virtual void print(int clock, int whichWarr);
};
class Iceman :public Warrior {
    public:
    string wea;
    Iceman(Headquarter * ph, int i):Warrior(ph, i), wea(Warrior::weapon[id % 3]) { }
    ~Iceman() { }
    void print(int clock, int whichWarr) {
        Warrior::print(clock, whichWarr);
        printf("It has a %s\n", wea.c_str());
    }
};
class Lion :public Warrior {
    public:
    int loyalty;
    Lion(Headquarter * ph, int i, int loyalty_):Warrior(ph, i),loyalty(loyalty_) { }
    ~Lion() { }
    void print(int clock, int whichWarr) {
        Warrior::print(clock, whichWarr);
        printf("It's loyalty is %d\n", loyalty);
    }
};
class Wolf :public Warrior {
    public:
    Wolf(Headquarter * ph, int i):Warrior(ph, i) { }
    ~Wolf() { }
};
class Ninja :public Warrior {
    public:
    string wea1, wea2;
    Ninja(Headquarter * ph, int i):Warrior(ph, i) {
        wea1 = Warrior::weapon[id % 3];
        wea2 = Warrior::weapon[(id + 1) % 3];
    }
    ~Ninja() { }
    void print(int clock, int whichWarr) {
        Warrior::print(clock, whichWarr);
        printf("It has a %s and a %s\n", wea1.c_str(), wea2.c_str());
    }
};
class Dragon :public Warrior {
    public:
    // Weapon w
    string wea;
    float morale; //ʿ��
    Dragon(Headquarter * ph, int i, float morale_):Warrior(ph, i),morale(morale_), wea(Warrior::weapon[id % 3]){ }
    void print(int clock, int whichWarr) {
        Warrior::print(clock, whichWarr);
        printf("It has a %s,and it's morale is %.02f\n", wea.c_str(), morale);
    }
    ~Dragon() { }
};

class Headquarter {
public:
    int color,  vitality;// ����˾�������Ԫ
    static string hq_color[2];
    bool stopped;
    int curmaking;
    static int makingorder[2][Warr_Num];
    int num_warr;// ������ʿ�ܸ���
    int num[Warr_Num]; // ����ʿ����
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

    int count = 0; //Ѱ����һ������
    while(Warrior::initLifeValue[makingorder[color][curmaking]] > vitality && count < Warr_Num) { //�ұ黹���Ҳ���curmaking�ص���ʼλ��
        curmaking = (curmaking + 1) % Warr_Num; //curmaking �ҵ�Ҫ�������ʿ
        count ++;
    }

    int whichWarr = makingorder[color][curmaking]; //ѡ��Ҫ�������ʿ����
    if(Warrior::initLifeValue[whichWarr] > vitality) { //��ǰ����Ԫ������������һ����ʿ��ֹͣ���죩
        stopped = true;
        if(color == 0)
            printf("%03d red headquarter stops making warriors\n", clock);
        else
            printf("%03d blue headquarter stops making warriors\n", clock);
        return 0;
    }

    vitality -= Warrior::initLifeValue[whichWarr];
    curmaking = (curmaking + 1) % Warr_Num; // curmaking������һ��Ҫ�������ʿ
    switch(whichWarr) { //������ʿ
        case 0: {
            float mor = (vitality * 1.0 / Warrior::initLifeValue[0]);
            pWarr[num_warr] = new Dragon(this, num_warr + 1, mor);
            break;
        }
        case 1:pWarr[num_warr] = new Ninja(this, num_warr + 1);break;
        case 2:pWarr[num_warr] = new Iceman(this, num_warr + 1);break;
        case 3:pWarr[num_warr] = new Lion(this, num_warr + 1, vitality);break;
        case 4:pWarr[num_warr] = new Wolf(this, num_warr + 1);break;
        default:cout<<"wrong";
    }
    num[whichWarr]++; //����ʿ����+1
    pWarr[num_warr]->print(clock, whichWarr);
    num_warr ++; //����ʿ��+1
    return 1;
}

string Headquarter::hq_color[2] = {"red","blue"};
string Warrior::warr_name[Warr_Num] =  {"dragon","ninja","iceman","lion","wolf" };
int Warrior::initLifeValue[5];
int Headquarter::makingorder[2][Warr_Num] = {{2,3,4,1,0},{3,0,1,2,4}}; //�����˾���ʿ����˳��
string Warrior::weapon[3] = {"sword","bomb","arrow"};

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

*/
