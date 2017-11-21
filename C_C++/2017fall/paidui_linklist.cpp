#include<iostream>
using namespace std;
struct student
{
    int id;
    int tall;
    student * next;
    student(int i, int t):id(i), tall(t) { next = NULL; }
};
student * create(int n)
{
    student * head = NULL, * tmp = NULL;
    int _id, _tall;
    head = new student(0, 0);
    tmp = head;
    for(int i = 0; i < n; i ++) {
        cin >> _id >> _tall;
        tmp->id = _id;
        tmp->tall = _tall;
        if(i != n - 1) {
            tmp->next = new student(0,0);
            tmp = tmp->next;
        }
        else
            tmp->next = NULL;
    }
    return head;
}
student * insert(student * a, student * b)
{
    student * head = a;
    student * tmp = NULL;
    while(b) {
        if(a->tall > b->tall) {
            head = b;
            b = b->next;
            head->next = a;
        }
        else {// not in the head
            tmp = a;
            while(a && a->tall < b->tall) {
                tmp = a;
                a = a->next;
            }
            if(!a) {
                tmp->next = b;
                b = b->next;
                tmp = tmp->next;
                tmp->next = NULL;
            }
            else {
                tmp->next = b;
                b = b->next;
                tmp = tmp->next;
                tmp->next = a;
            }
        }
        a = head;
    }
    return a;
}
void print(student * p)
{
    while(p->next) {
        cout << p->id << "-" << p->tall << " -> ";
        p = p->next;
    }
    cout << p->id << "-" << p->tall;
}
int main()
{
    int n, m;
    cin >> n;
    student * stu = create(n);
    cin >> m;
    student * ins = create(m);

    stu = insert(stu, ins);
    print(stu);
    return 0;
}
