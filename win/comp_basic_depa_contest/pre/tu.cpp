#include <iostream>
#include <queue>
#include <fstream>
#include <map>

using namespace std;

#define MAX_CITIES 100
#define INFINITY	10000 //距离无穷大

class Graph
{
public:
	typedef struct _ArcNode //顶点
	{
		int key; //顶点值 
		int weight; //限重 
		_ArcNode* next; // 下一个顶点 
		_ArcNode(int k, int w):next(NULL), key(k), weight(w) { }; 
	}ArcNode, *pArcNode;

	typedef struct _Adj //邻接表
	{
		int dist;
		bool IsKnow;
		pArcNode head;
		int path;
		_Adj():head(NULL), dist(INFINITY), IsKnow(false), path(0){};
	}Adj, AdjArray[MAX_CITIES+1];

	Graph(int city, int road):m_City(city),m_Road(road) { };
	void SetBeginEnd(int b)	{ m_nBegin = b; }//设置起始结点
	void InsertNode(int vVertex, int uVertex, int w); //插入结点
	void BFS(); //无权最短路径算法;
	void Dijkstra(); //加权最短路径算法;000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
	void PrintPath(int nEnd);//输出路径;nEnd终止结点的关键字

private:
	//一个图的三要素: 邻接表，顶点数，边数
	AdjArray	m_AdjArray; //邻接表 
	int			m_City; //顶点数
	int			m_Road;   //边数
	int			m_nBegin;
};

void Graph::InsertNode(int vCity, int uCity, int w)
{
	pArcNode pNode = new ArcNode(uCity, w);
	pNode->next = m_AdjArray[vCity].head;
	m_AdjArray[vCity].head = pNode;
}

void Graph::BFS()
{
	for (int i = 1; i <= m_City; ++ i) {
		m_AdjArray[i].dist = INFINITY;
		m_AdjArray[i].path = 0;
	}
	queue<int> q;
	q.push(m_nBegin);
	m_AdjArray[m_nBegin].dist = 0;
	pArcNode pNode;
	cout << m_nBegin << " ";
	while (!q.empty()) {
		int nTmp = q.front();
		q.pop();
		for (pNode = m_AdjArray[nTmp].head; pNode != NULL; pNode = pNode->next) {
			if (m_AdjArray[pNode->key].dist == INFINITY) {
				m_AdjArray[pNode->key].dist = m_AdjArray[nTmp].dist + 1;
				cout << pNode->key << " ";
				m_AdjArray[pNode->key].path = nTmp;
				q.push(pNode->key);
			}
		}
	}
	cout << endl;
}

void Graph::Dijkstra()
{
	for (int i = 1; i <= m_City; ++ i)
	{
		m_AdjArray[i].dist = INFINITY;
		m_AdjArray[i].path = 0;
	}
	m_AdjArray[m_nBegin].dist = 0;
	int nIsOver = m_City;
	map<int, int> mSort; //map<距离, 邻接表>
	map<int, int>::iterator it;
	pArcNode pNode;
	while (nIsOver)
	{		
		//用map找出还没确定路径的结点,因为map插入默认是升序排序
		for (int i = 1; i <= m_City; ++ i)
			if (!m_AdjArray[i].IsKnow)
				mSort.insert(make_pair(m_AdjArray[i].dist, i));
		it = mSort.begin();
		cout << it->second << " ";
		m_AdjArray[it->second].IsKnow = true;
		int nTmp = it->second;
		-- nIsOver;
		mSort.clear();
		
		for (pNode = m_AdjArray[nTmp].head; pNode != NULL; pNode = pNode->next)
			if (!m_AdjArray[pNode->key].IsKnow)
				if ((m_AdjArray[nTmp].dist + pNode->weight) < m_AdjArray[pNode->key].dist) {
					m_AdjArray[pNode->key].dist = m_AdjArray[nTmp].dist + pNode->weight;
					m_AdjArray[pNode->key].path = nTmp;				
				}
	}
	cout << endl;
}

void Graph::PrintPath(int nEnd)
{
	static int isEnd = nEnd;
	if (nEnd != 0)
	{
		PrintPath(m_AdjArray[nEnd].path);
		cout << " to ";
		cout << nEnd;
	}
	if (isEnd == nEnd)
		cout << endl;
}

int main()
{
	ifstream ifile("a.txt"); //从文件中读取
	int vertex, edge;
	cout << "输入顶点数和边数:";
	ifile >> vertex >> edge; 
	cout << vertex << " " << edge << endl;
	Graph graph(vertex, edge);

	int vVertex, uVertex, w;
	cout << "请输入边:" << endl;
	for (int i = 1; i <= edge; ++ i)
	{
		cout << "第" << i << "条边:";
		ifile >> vVertex >> uVertex >> w;
		cout << vVertex << " " << uVertex  << " " << w << endl;
		graph.InsertNode(vVertex, uVertex, w);
	}

	int nBegin, nEnd;
	cout << "请输入起始结点和终止结点:";
	cin >> nBegin >> nEnd;
	graph.SetBeginEnd(nBegin);
	cout << "BFS:";
	graph.BFS();
	cout << "BFS路径:";
	graph.PrintPath(nEnd);
	cout << "Dijkstra:";
	graph.Dijkstra();
	cout << "Dijkstra路径:";
	graph.PrintPath(nEnd);
	return 0;
}

