#include <iostream>
#include <iomanip>
using namespace std;
#define INFINITY 9999
class Graph
{
public:
	int vexnum;
	string * vexname;
	int ** arcs;
	void floyd_path(int, int);
	Graph(int num):vexnum(num) {
		vexname = new string[vexnum];
		arcs = new int * [vexnum];
		for(int i = 0; i < vexnum; ++ i)
			* (arcs + i) = new int[vexnum];
		for(int i = 0; i < vexnum; ++ i)
			for(int j = 0; j < vexnum; ++j)
				arcs[i][j] = INFINITY;
	}
	~Graph() {
		for(int i = 0; i < vexnum; ++ i)
			delete [] arcs[i];
		delete [] arcs;
	} 
};
void Graph::floyd_path(int begin, int end)
{
	int path[vexnum][vexnum];
	int dist[vexnum][vexnum];
	for(int i = 0; i < vexnum; ++ i)
		for(int j = 0; j < vexnum; ++ j) {
			dist[i][j] = arcs[i][j];
			path[i][j] = j;
		}
	
	for(int k = 0; k < vexnum; ++ k) {
		for(int i = 0; i < vexnum; ++ i) {
			for(int j = 0; j < vexnum; ++ j) {
				int tmp;
				if(dist[i][k] == INFINITY 
					  || dist[k][j] == INFINITY)
					tmp = INFINITY;
				else
					tmp = (dist[i][k] + dist[k][j]);
				if(dist[i][j] > tmp) {
                    dist[i][j] = tmp;
                    path[i][j] = path[i][k];
                }
			}
		}
	}
    cout << "最进距离：" << dist[begin][end] << endl;
    cout << "最进路径为：" << vexname[begin] << "->";
    while(path[begin][end] != begin
		  && path[begin][end] != end) {
    	begin = path[begin][end];
    	cout << vexname[begin] << "->";
	}
	cout<< vexname[end] << endl;
}
int main()
{
    int num = 5;
    Graph sch(num);
    cout << "input vertex name:";
    for(int i = 0; i < num; ++ i)
    	cin >> sch.vexname[i];
    int arcnum;
    cout << "input arcnum:";
    cin >> arcnum;
    cout << "input veterx and weight:" << endl;
    for(int i = 0; i < arcnum; ++ i){
    	int v1, v2, weight;
    	cin >> v1 >> v2 >> weight;
    	sch.arcs[v1][v2] = weight;
    	sch.arcs[v2][v1] = weight;
    }
    
	int begin, end;
	cout << "input begin and end:";
	cin >> begin >> end;
    sch.floyd_path(begin, end);
	return 0; 
}

