#include <iostream>
#include <stack>
#include <cstdio>
using namespace std;
struct PathUnit {
	int x;
	int y;
	int direct; //0 -> right , 1 -> down, 2 -> left, 3 -> up
};
class Maze 
{
public:
	int row, col;
	int ** arr;
	int ** mark;
	bool hasPath(stack<PathUnit> & st, int r1, int c1, int r2, int c2);
	Maze(int r, int c):row(r),col(c) {
		arr = new int* [row];
		for(int i = 0; i < row; i ++)
			*(arr + i) = new  int[col];
		for(int i = 0; i < row; i ++)
			for(int j = 0; j < col; j ++)
				arr[i][j] = 0;
		mark = new int* [row];
		for(int i = 0; i < row; i ++)
			*(mark + i) = new  int[col];
		for(int i = 0; i < row; i ++)
			for(int j = 0; j < col; j ++)
				mark[i][j] = 0;
	}
	~Maze() {
		for(int i = 0; i < row; i ++){
			delete [] arr[i];
			delete [] mark[i];
		}
		delete [] arr;
		delete [] mark;
	}
	friend istream & operator>>(istream & is, Maze & m)
	{
		for(int i = 0; i < m.row; i ++)
			for(int j = 0; j < m.col; j ++)
				is >> m.arr[i][j];
		return is;
	}
	friend ostream & operator<<(ostream & os, Maze & m)
	{
		os << "  ";
		for(int i = 0; i < m.col; i ++)
			os << i << " ";
		os << endl;
		for(int i = 0; i < m.row; i ++) {
			os << i << " ";
			for(int j = 0; j < m.col; j ++)
				os << m.arr[i][j] << " ";
			os << endl;
		}
		return os;
	}
};
bool Maze::hasPath(stack<PathUnit> & st, int x1, int y1, int x2, int y2)
{
	PathUnit unit;
	unit.x = x1;
	unit.y = y1;
	unit.direct = 0;
	st.push(unit);
	bool isOver = 0;
	while(!st.empty()) {
		PathUnit cur = st.top();
		st.pop();
		PathUnit next;
		
		while(cur.direct <= 3) {
			next = cur;
			next.direct = 0;
			switch(cur.direct) {
				case 0: next.x += 1; break;
				case 1: next.y += 1; break;
				case 2: next.x -= 1; break;
				case 3: next.y -= 1; break;
				default: cout << "wrong" << endl;
			}

			//isOver
			if(next.x == x2 && next.y == y2) {
				st.push(cur);
				st.push(next);
				isOver = 1;
				break;
			}
			
			if(next.y < 0 || next.x < 0) {
				cur.direct ++;
				continue;
			}
			if(!arr[next.y][next.x] && !mark[next.y][next.x] && next.y < row && next.x < col) { //从未走过且有路
				mark[next.y][next.x] = 1;
				st.push(cur);
				cur = next;
			}
			else
				cur.direct ++;
		}
		if(isOver) break;
	}
	return isOver;
}
int main()
{
	int m, n;
	int x1, y1, x2, y2;
	stack<PathUnit> st_maze;
	cout << "input row and col:";
	cin >> m >> n;
	Maze maze(m, n);
	cout << "input maze:\n";
	cin >> maze;
	cout << string(52, '-')<< "\nmaze:\n" << maze << endl;
	
	cout << "begin:";
	cin >> x1 >> y1;
	cout << "end:";
	cin >> x2 >> y2;
	
	if(x1 > n || y1 > m || x2 > n || y2 > m) {
		cout << "input wrong";
		exit(0);
	}
	if(maze.hasPath(st_maze, x1, y1, x2, y2)) {
		while(!st_maze.empty()) {
			PathUnit & u = st_maze.top();
			cout << "(" << u.x << "," << u.y << ")" << endl;
			st_maze.pop();
		}
	}
	else
		printf("There is no path from(%d, %d) to (%d, %d)\n", x1, y1, x2, y2);
	return 0;
}
