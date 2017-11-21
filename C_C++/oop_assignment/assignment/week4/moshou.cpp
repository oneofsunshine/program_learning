#include<iostream>
#include<iomanip>
using namespace std;
class Warrior {
protected:
	int id;// ������ʿ���
	int bionergy;// ������ʿ����ֵ
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
    string order[5];// ������ʿ����˳��
    string hName;// ����˾�����
    // int num_warr;// ������ʿ�ܸ���
    int num_lion,num_ice,num_wolf,num_ninja,num_dragon;// �������ʿ����ĸ���
    int bio_lion,bio_ice,bio_wolf,bio_ninja,bio_dragon;// �������ʿ������ֵ
	int vitality, warr_id;// ����˾�������Ԫ����ʿ���
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
    void setBio(int b_l,int b_i,int b_w,int b_n,int b_d) {// ������ʿ����ֵ
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
    void setOrder(string s[5]) {// ������ʿ����˳��
        for(int i = 0; i < 5 ; i++)
            order[i] = s[i];
    }
	bool hasNext() { // �ж��Ƿ������� 
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
	void createWarr(int c) { // ��ʽ�����
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
