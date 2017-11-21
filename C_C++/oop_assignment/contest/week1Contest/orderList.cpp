#include<iostream>
using namespace std;
struct LNode
{
    int num;
    LNode *next;
};
LNode *ListInsert(LNode *L, int e)
{
    LNode *unit, *temp, *follow;
    unit = new LNode;
    unit->num = e;
    unit->next = NULL;
    temp = L;
    if(L == NULL)
        L = unit;
    while((temp->next != NULL)&&(temp->num < e))
    {
        follow = temp;
        temp = temp->next;
    }
    if(temp == L)
    {
        unit->next = L;
        L = unit;
    }
    else
    {
        if(temp->next == NULL)
            temp->next = unit;
        else
        {
            follow->next = unit;
            unit->next = temp;
        }
    }
}
int main()
{
    LNode *LinkList, *temp;
    int n;
    cin>>n;
    if(n == 0)
        LinkList = NULL;
    int input;
    LinkList = new LNode;
    temp = LinkList;
    for(int i = 0; i < n; i++)
    {
        cin>>input;
        temp->num = input;
        if(i == n - 1)
            temp->next = NULL;
        else
        {
            temp->next = new LNode;
            temp = temp->next;
        }
    }
    delete temp;
    int insert;
    cin>>insert;
    LinkList = ListInsert(LinkList, insert);
    LNode *pointer = LinkList;
    while(pointer->next != NULL)
    {
        if(pointer->next != NULL)
            cout<<pointer->num<<" ";
        else
            cout<<pointer->num;
        pointer = pointer->next;
    }
    return 0;
}
