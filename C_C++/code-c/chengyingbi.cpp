#include<iostream>
#include<cstring>
using namespace std;
char Left[3][7];
char Right[3][7];
char result[3][7];
bool IsFake(char c, bool light)
{
	for(int i = 0; i < 3; i++)
	{
		char * pLeft, *pRight;
		if(light)
		{
			pLeft = Left[i];
			pRight = Right[i];
		}
		else
		{
			pLeft = Right[i];
			pRight = Left[i];
		}
		switch(result[i][0])
		{
			case 'u':
				if(strchr(pRight, c) == NULL)
					return false;
				break;
			case 'e':
				if(strchr(pLeft,c) || strchr(pRight, c))
					return false;
				break;
			case 'd':
				if(strchr(pLeft, c) == NULL)
					return false;
				break;
		}
		return true;
	}
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		for(int i = 0;i < 3; ++i)
			cin>>Left[i]>>Right[i]>>result[i];
		for(char c = 'A'; c <= 'L'; c++)
		{
			if(IsFake(c, true))
			{
				cout<<c<<" is the counterfeit coin and it is light.\n";
				break;
			}
			else if ( IsFake(c,false))
			{
				cout<<c<<" is the counterfeit coin and it is heavy.\n";
				break;
			}
		}
	}
	return 0;
} 
