#include<iostream>
#include<cstdio>
using namespace std;
#define Warr_Num 5
class Headquarter;
class Warrior {
protected:
    Headquarter * phq;
	int id;// ������ʿ���
public:
    static int initLifeValue[Warr_Num];
    static string warr_name[5];// ������ʿ��
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
    switch(curmaking) { //������ʿ
        case 0:pWarr[num_warr] = new Dragon(this, num_warr + 1);break;
        case 1:pWarr[num_warr] = new Ninja(this, num_warr + 1);break;
        case 2:pWarr[num_warr] = new Iceman(this, num_warr + 1);break;
        case 3:pWarr[num_warr] = new Lion(this, num_warr + 1);break;
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
 *����
 *ħ������������Ǻ�ħ����˾�����������ħ����˾�������˾�֮�����������е����ɳ��С� 
 ��˾���City 1��City 2��������City n����˾�
������˾�����������ʿ����ʿһ���� dragon ��ninja��iceman��lion��wolf ���֡�ÿ����ʿ���б�š�����ֵ�����������������ԡ� 
˫������ʿ��Ŷ��Ǵ�1��ʼ���㡣�췽��������ĵ�n����ʿ����ž���n��ͬ����������������ĵ�n����ʿ�����Ҳ��n�� 
��ʿ�ڸս�����ʱ����һ������ֵ�� 
��ÿ�����㣬˫����˾��и���һ����ʿ������ 
�췽˾�����iceman��lion��wolf��ninja��dragon��˳��ѭ��������ʿ�� 
����˾�����lion��dragon��ninja��iceman��wolf��˳��ѭ��������ʿ�� 
������ʿ��Ҫ����Ԫ�� 
����һ����ʼ����ֵΪm����ʿ��˾��е�����Ԫ��Ҫ����m���� 
���˾��е�����Ԫ����������ĳ����˳��Ӧ���������ʿ����ô˾�����ͼ������һ�������������ʿ�����������ˣ���˾�ֹͣ������ʿ��
����һ��ʱ�䣬��˫��˾��ĳ�ʼ����Ԫ��Ŀ��Ҫ���㽫��0��0�ֿ�ʼ��˫��˾�ֹͣ������ʿΪֹ�������¼���˳�������
һ���������¼������Ӧ������������£� 
1) ��ʿ���� 
��������� 004 blue lion 5 born with strength 5,2 lion in red headquarter
��ʾ��4���������Ϊ5����ħlion��ʿ������������ʱ����ֵΪ5����������ħ˾��ﹲ��2��lion��ʿ����Ϊ�������
	�����ǵ��ʵĸ�����ʽ��ע�⣬ÿ�����һ���µ���ʿ����Ҫ�����ʱ˾��ﹲ�ж��ٸ�������ʿ��
2) ˾�ֹͣ������ʿ
��������� 010 red headquarter stops making warriors
��ʾ��10�������췽˾�ֹͣ������ʿ
����¼�ʱ�� 
���Ȱ�ʱ��˳������� 
ͬһʱ�䷢�����¼����������˾��ģ��������˾��ġ�
����
��һ����һ�������������������������
ÿ��������ݹ����С� 
��һ�У�һ������M���京��Ϊ�� ÿ��˾�һ��ʼ����M������Ԫ( 1 <= M <= 10000)��
�ڶ��У���������������� dragon ��ninja��iceman��lion��wolf �ĳ�ʼ����ֵ�����Ƕ�����0С�ڵ���10000��
���
��ÿ��������ݣ�Ҫ�������0ʱ0�ֿ�ʼ����˫��˾���ֹͣ������ʿΪֹ�������¼���
��ÿ��������ݣ��������"Case:n" n�ǲ������ݵı�ţ���1��ʼ ��
��������ǡ����˳��͸�ʽ��������¼���ÿ���¼������¼�������ʱ�俪ͷ��ʱ����СʱΪ��λ������λ��
��������
1
20
3 4 5 6 7
�������
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
