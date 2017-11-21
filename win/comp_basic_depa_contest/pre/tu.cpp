#include <iostream>
#include <queue>
#include <fstream>
#include <map>

using namespace std;

#define MAX_CITIES 100
#define INFINITY	10000 //���������

class Graph
{
public:
	typedef struct _ArcNode //����
	{
		int key; //����ֵ 
		int weight; //���� 
		_ArcNode* next; // ��һ������ 
		_ArcNode(int k, int w):next(NULL), key(k), weight(w) { }; 
	}ArcNode, *pArcNode;

	typedef struct _Adj //�ڽӱ�
	{
		int dist;
		bool IsKnow;
		pArcNode head;
		int path;
		_Adj():head(NULL), dist(INFINITY), IsKnow(false), path(0){};
	}Adj, AdjArray[MAX_CITIES+1];

	Graph(int city, int road):m_City(city),m_Road(road) { };
	void SetBeginEnd(int b)	{ m_nBegin = b; }//������ʼ���
	void InsertNode(int vVertex, int uVertex, int w); //������
	void BFS(); //��Ȩ���·���㷨;
	void Dijkstra(); //��Ȩ���·���㷨;000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
	void PrintPath(int nEnd);//���·��;nEnd��ֹ���Ĺؼ���

private:
	//һ��ͼ����Ҫ��: �ڽӱ�������������
	AdjArray	m_AdjArray; //�ڽӱ� 
	int			m_City; //������
	int			m_Road;   //����
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
	map<int, int> mSort; //map<����, �ڽӱ�>
	map<int, int>::iterator it;
	pArcNode pNode;
	while (nIsOver)
	{		
		//��map�ҳ���ûȷ��·���Ľ��,��Ϊmap����Ĭ������������
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
	ifstream ifile("a.txt"); //���ļ��ж�ȡ
	int vertex, edge;
	cout << "���붥�����ͱ���:";
	ifile >> vertex >> edge; 
	cout << vertex << " " << edge << endl;
	Graph graph(vertex, edge);

	int vVertex, uVertex, w;
	cout << "�������:" << endl;
	for (int i = 1; i <= edge; ++ i)
	{
		cout << "��" << i << "����:";
		ifile >> vVertex >> uVertex >> w;
		cout << vVertex << " " << uVertex  << " " << w << endl;
		graph.InsertNode(vVertex, uVertex, w);
	}

	int nBegin, nEnd;
	cout << "��������ʼ������ֹ���:";
	cin >> nBegin >> nEnd;
	graph.SetBeginEnd(nBegin);
	cout << "BFS:";
	graph.BFS();
	cout << "BFS·��:";
	graph.PrintPath(nEnd);
	cout << "Dijkstra:";
	graph.Dijkstra();
	cout << "Dijkstra·��:";
	graph.PrintPath(nEnd);
	return 0;
}

