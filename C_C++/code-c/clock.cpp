#include<iostream>
#include<string>
using namespace std;
int GetBitDiff(char c, char s, int i)
{
	//判断两串第i位是否相同 
	if((( c >> i ) & 1) == (( s >> i ) & 1))
		return true;
	else
		return false;
}

void SetBit(char & c, int i, int v)
{
	if( v)
	{
		c |= ( 1<< i);
	}
	else
		c &= ~(1 << i);
}

void Flip(char & c, int i)
{
	c ^= (1 << i);
}

int main()
{
	int min = 0, time;
	int from = 30, end = 0;
	char orClock, clock, result;
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
	
	if( orClock == result )
		cout<<0;
	else
	{
		for (int i = 0; i < start.length(); i ++ )// 找开始位置
		{
			int t;
			if (GetBitDiff( orClock, result, i))
				t = i;
			if (t < from ) 
				from = t;
			if (t > end)
				end = t;
		}
		for (int l = 0 ; l < start.length(); l++ )// 从开始位置不同的后一位开始
		{
			clock = orClock;
			time = 0;
			// 改变状态 
			if (l > 0 )
				Flip( clock, l - 1 );
			Flip( clock, l );
			if (l < start.length())
				Flip( clock, l + 1 );
			if (clock == result )
			{
				min = (min < time)?min:time;
				continue;
			} 
			time ++;
		}
		if (min == 0)
			cout<<"impossible";
		else
			cout<<min;
	}
	return 0;
} 
