#include<iostream>
#include<fstream>
#include<stdlib.h>
using namespace std;
ifstream in("input.dat");
ofstream out("output.dat");
struct LNode{
	int num;// ���ڴ��С����� 
	string name;// ���ڴ��С������
	LNode *next;// ָ����һ��С�� 
};

LNode * link_create(int n, char c[][15]) {// ����ѭ������ 
	LNode *p = NULL, *q = NULL, *head = NULL;
    for(int i = 1; i <= n; i++) {
		p = new LNode;
		p->name = c[i - 1];
		p->num = i;
		p->next = NULL;
		if(head == NULL)
			head = p;
		else
			q->next = p;
		q = p;
	}
	p->next = head;
	return head;
} 
void joseph(LNode * List, int n, int m) {// ��n��ʼ����������m���� 
	LNode *p = List, *tmp = NULL;
	while(p->num != n)// pָ��Ľڵ���Ϊk��С�� 
        p = p->next;
    
	while(p->next != p) {// ���� m��С������ 
		for(int i = 1; i < m; i++) {
			tmp = p;
			p = p->next;
		}
		tmp->next = p->next;
		out << p->name << endl;
		free(p);
		p = tmp->next;
	}
	out << p->name << endl;
    free(p);
}
int main()
{
	int N;
	int W, S;
	LNode * jList;
	in >> N;
	char player[N][15];
	for (int i = 0; i < N; i ++)
		in >> player[i];
	jList = link_create(N, player);
	
	in >> W;
	in.get();
	in >> S;
	
	joseph(jList, W, S);	
	return 0;
}
