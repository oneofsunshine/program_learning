#include <iostream>
#include <fstream>
#include <queue>
#include <map>
using namespace std;
ifstream in("input.dat");
ofstream out("output.dat");
typedef int City;
class CGraph
{
public:
	typedef struct CNode * PtrToCNode;
	typedef struct CNode
	{
		int Nc; //顶点数 
		int Nr; //路条数 
		AdjList G; //邻接表 
	};
	typedef PtrToCNode CGraph; //以邻接表形式存储图; 
	
	typedef struct AdjCNode * PtrToAdjCNode;
	struct AdjCNode {
		City AdjC; //邻接表下标
		int limit;
		PtrToAdjCNode Next;
	}; 
	typedef struct Cnode {
		PtrToAdjCNode FirstRoad;
		int city;
	} AdjList[MaxCityNum]; //AdjList是邻接表类型 
	
	CGraph CreateGraph(int CityNum) {
		City From, End;
		CGraph Graph;
		
		Graph = new CNode;
		Graph->Nc = CityNum;
		Graph->Nr = 0;
		for(From = 0; From < Graph->Nc; From++)
			Graph->G[From].FirstRoad = NULL:
		
		return Graph;
	}
	
	void InertRoad(CGraph Graph, Road R)
	{
		PtrToAdjCNode NewNode;
		
		NewNode = new AdjNode;
		NewNode->AdjC = C->V2
	}
//	typedef struct AdjList //邻接表
//	{
//		int dist;
//		bool IsKnow;
//		pArcNode head;
//		int path;
//		_Adj():head(NULL), dist(INFINITY), IsKnow(false), path(0){};
//	}Adj, AdjArray[MAX_VERTEXS+1];

	Graph(int vertex, int edge);
	void SetBeginEnd(int b);//设置起始结点
	void InsertNode(int vVertex, int uVertex, int w); //插入结点(int start_city, int end_city, int limit)
	void PrintMost(start, end);

private:
	//一个图的三要素: 邻接表，顶点数，边数
	AdjArray	m_AdjArray;
	int			m_Vertex; //顶点数->城市数 m_City
	int			m_Edge;   //边数->路数 m_Road
	int			m_nBegin;// ->限重 m_
	int         m_nEnd;
};
Graph::Graph(int vertex, int edge): m_Vertex(vertex), m_Edge(edge) { }
void Graph::InsertNode(int vVertex, int uVertex, int w)// (int start_city, int end_city, int limit)
{
	pArcNode pNode = new ArcNode(uVertex, w);
	pNode->next = m_AdjArray[vVertex].head;
	m_AdjArray[vVertex].head = pNode;
}
int main()
{
	int n, m;// n个城市, m条公路;
	int q_num;// 问题个数;
	
	in >> n >> m;
	while(!(n == 0 && m == 0)) {
		//cout<<n<<" "<<m<<endl;
		int start_city, end_city, limit;
		
		for(int i = 0; i < m; i++) {
			in >> start_city >> end_city >> limit;
			graph.InsertNode(start_city, end_city, limit);
		}
		
		in >> q_num;
		int start, end;
		for(int i = 0; i < q_num; i++) {
			in >> start >> end;
			graph.PrintMost(start, end);
		}
		
		in >> n >> m;
	}
	
	return 0;
}
