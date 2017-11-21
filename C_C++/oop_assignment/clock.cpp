#include<iostream>
#include<string>
using namespace std;
int GetBitDiff(char c, char s, int i)
{
	//判断两串第i位是否相同 
	if((( c >> i ) & 1) == (( s >> i ) & 1))
		return 1;
	else
		return 0;
}
void SetBit(char & c, int i, int v)
{
	if( v)
	{
		c |= ( 1<< i);
	}
	else
		c &= ~( 1 << i);
}

void FlipBit(char & c, int i)
{
	c ^= (1 << i);
}

int main()
{
	int min, time1 = 0, time2 = 0;
	char orClock, clock,  result;
    bool finish = false;
	string start, over;
	cin>>start>>over;
	for (int i = 0; i < start.length(); i ++ )
	{
		int t;
		t = (int)start[i] - 48;
		SetBit(orClock, i, t);
		t = (int)over[i] - 48;
		SetBit(result, i, t);
	}//输入两种状态;
	if (orClock == result)
        cout<<0;
    else
    {
        clock = orClock;
        for (int i = 1; i < start.length(); i ++ )
	    {
    		// 改变状态 
	    	if(clock == result)
            {
                finish = true;
	    		break;
            }
            FlipBit(clock, 0);
            FlipBit(clock, 1);
            if( GetBitDiff(clock, result, i - 1))
            {
                if( i < start.length())
                    FlipBit(clock, i + 1);
                FlipBit(clock, i);
                if( i > 0 )
                    FlipBit(clock, i -1);
            }
    		time1 ++;
	    }
        clock = orClock;
    	for (int i = 1; i < start.length(); i ++ )
        {
            if(clock == result)
            {
                finish = true;
                break;
            }
            if(GetBitDiff(clock, result, i - 1))
            {
                if( i < start.length())
                    FlipBit(clock, i + 1);
                FlipBit(clock, i);
                if( i > 0 )
                    FlipBit(clock, i-1);
            }
            time2 ++;
        }
    	min = (time1 < time2)?time1 : time2;
    	if( !finish )
        {
            cout<<orClock<<"  "<<result<<endl;
	    	cout<<"impossible";
        }
    	else
	    	cout<<min;
    } 
	return 0;
} 
