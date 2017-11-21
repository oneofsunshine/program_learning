#include <iostream>
#include <fstream>
using namespace std;
ifstream in("input.dat");
ofstream out("output.dat");
int main()
{
	int n, m;// n个城市, m条公路;
	int q_num;// 问题个数;
	
	in >> n >> m;
	while(!(n == 0 && m == 0)) {
		//cout<<n<<" "<<m<<endl;
		int start_city[n], end_city[n], limit[m];
		
		for(int i = 0; i < m; i++)
			in >> start_city[i] >> end_city[i] >> limit[i];
		in >> q_num;
		int start[q_num], end[q_num], nearest[q_num];
		for(int i = 0; i < q_num; i++)
			in >> start[i] >> end[i];
		
		// 核心 
		
		for(int i = 0; i < q_num; i++)
			cout << least[i] << endl;
		in >> n >> m;
	}
	
	in.close();
	out.close();
	
	return 0;
}
/*
某快递公司在n个城市建立了物流运输（n不超过200），这些城市之间有的直接有一条高速公路相连，
高速公路都是双向的，总共有m条。每条高速公路都有自己的载重限制，即载重最大值。通过车辆的载重不能超过公路的载重限制。
如今我们想了解的是，从某一起点城市出发，到达目标城市，车辆最多能带多重的货物。
【输入】
输入的第一行为两个整数n和m（n=m=0时结束）。以下有m行，每行三个整数描述一条公路，分别是首尾相连的城市以及载重限制。
然后是一个整数k，即问题个数。接下来k行描述k个问题，每行两个整数表示起点城市和目标城市。问题数不超过100。
输入文件数据包含在input.dat文件中。
【输入文件样例】
3 3 
1 2 100
2 3 100
1 3 50
2
1 3
2 3
8 12
1 2 20
1 3 30
1 6 100
2 3 70
2 5 20
3 5 50
3 4 80
4 5 70
5 7 100
5 6 60
4 8 40
7 8 200
3
1 8
3 8
7 8
0 0
【输出】
输出包括k行，每行对应一个问题，输出从起点到目标的最大载重量。如果两城市间无路径则输出-1。
数据输出到input.dat文件中。
【输出文件样例】
100
100
60
70
200
【要求】
程序必须包含文件读写操作，从输入文件input.dat中读数据，将计算结果输出到output.dat文件中。
*/
