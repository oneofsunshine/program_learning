#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 21
int main() {
	void input(char (*p_id)[13],int *p_score,int n);
	void sort(char (*p_id)[13],int *p_score,int n);
	void output(char (*p_id)[13],int *p_score,int n);
	char num[N][13];          //定义学号数组
	int score[N];             //定义成绩数组
	int i;
	input(num,score,21);
	/*调用input，从文件studentlist.txt中读取21名学生的学号与成绩到实参学号数组num和成绩数组score中*/
	puts("\tstudent ID\tscore\n-----------------------------------");
	for(i=0; i<N; i++)
		printf("\t%s\t%d\n",num[i],score[i]);  //显示学号与成绩
	sort(num,score,21);
	//调用sort函数，实现按成绩降序排序数组数据，同时同步更新学号顺序
	puts("==================sort==============");
	puts("\tstudent ID\tscore\n");
	for(i=0; i<N; i++)
		printf("\t%s\t%d\n",num[i],score[i]);  //再次显示排序后学号与成绩
	output(num,score,21);   //输入排序后的数据到指定文件studentlist_De.txt中
	return 0;
}
//从数据文件studentlist.txt中读取21名学生的学号与成绩到形参p_ID所指向的二维char学号数组中
//p_score所指向的一维成绩数组中
void input(char (*p_id)[13],int *p_score,int n) {
	FILE * pr=fopen("studentlist.txt","r");
	int i = 0;
	if(pr == NULL) {                             //检查打开文件是否成功
		puts("Can't open studentlist.txt");
		exit(0);
	}
	//while(fscanf(pr,"%s%d", (p_id + i), (p_score + i)) >=0 ) i++; //思考题最后i是读入数据个数 
	for(i = 0; i < n; i ++)
		fscanf(pr,"%s%d", (p_id + i), (p_score + i));    //读出数据
	fclose(pr);                                //关闭文件
}
//对p_score所指向的成绩数组排序（降序），同时同步更改对应的形参p_ID所指向的学号数组顺序。
void sort(char (*p_id)[13],int *p_score,int n)
{
	int i, j, temp;
	char tmp[13];
	for(i = 0; i < n - 1; i ++) {
		for(j = 1; j < n - i; j ++) {
			if(p_score[j - 1] < p_score[j]) { //以成绩降序排列
				//交换成绩
				temp = p_score[j - 1];
				p_score[j - 1] = p_score[j];
				p_score[j] = temp;

				//交换学号
				strcpy(tmp, p_id[j - 1]);
				strcpy(p_id[j - 1], p_id[j]);
				strcpy(p_id[j], tmp);
			}
		}
	}
}
//将数组中数据输出到数据文件studentlist_De.txt中。完成后文件studentlist_De.txt内容如下：
void output(char (*p_id)[13], int *p_score, int n)
{
	FILE * pr;
    int i;
    pr = fopen("studentlist_De.txt", "w");
    if(pr == NULL) {
        puts("Can't creat studentlist_De.txt");
        exit(0);
    }
    for(i = 0; i < n; i ++)
        fprintf(pr, "%s %d\n", p_id[i], p_score[i]);
	fclose(pr);                                //关闭文件	
}
