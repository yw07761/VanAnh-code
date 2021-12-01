#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
typedef struct Node
{
    float data; //gia su stack chua cac so nguyen
    Node *link;
} node;

typedef struct stack
{
    Node *top;
} Stack;
void init(stack &s);
int empty(stack &s);
Node *GetNode(int x);
void push(stack &s, float x);
float pop(stack &s);
void DocTu(char s[],char tu[], int &vt );
int LaToanTu (char s[]);
float TinhToan(float toanHang1, float toanHang2, char toanTu);
float TinhBieuThuc(stack &x, char bieuThuc[]);
int main()
{
	stack s;
	init (s);
	char bieuThuc[100] = "";
	printf("nhap bieu thuc hau to: \n");
	fflush(stdin);
	gets(bieuThuc);
	float kq;
	kq = TinhBieuThuc(s,bieuThuc);
	printf("Gia tri cua bieu thuc: %.2f ", kq);	
}
void init(stack &s)
{
    s.top = NULL;
}
// kiem tra stack rong
int empty(stack &s)
{
    return s.top == NULL ? 1 : 0; //stack rong
}
Node *GetNode(int x){
	Node*p;
	p=new Node;
	if(p==NULL){
		printf("khong thanh cong!");return NULL;
	}
	p->data=x;
	p->link=NULL;
	return p;
}
// them 1 phan tu x vao stack s
void push(stack &s, float x)
{
    Node *p = new Node;

    if (p != NULL)
    {
        p->data = x;
        p->link = s.top;
        s.top = p;
    }
}
//Trich thong tin va huy phan tu o dinh stack S
float pop(stack &s){
if(empty(s)==1){
		printf("stack rong!");return -1;
	}
	else{
		Node *p=s.top;s.top=s.top->link;p->link=NULL;
		float x=p->data; delete(p);
		return x;
	}
}
/**void Input (Stack & s)
{
	int i=0; 
    int x;
    do
    {
        i++;
        printf ("Nhap phan tu thu %d : ",i);
        scanf("%d",&x);
        if (x != 0) push(s,x);
    } while(x != 0); //nhap 0 de ket thuc	
}
void Output(Stack s)
{
   	while(s.top!=NULL){
		float x=pop(s);
		printf("%d ",x);
	}
}
int main ()
{
	Stack s;
    init(s);
    Input(s);
    Output(s);
}
*/
void DocTu(char s[],char tu[], int &vt )
{
	for(int i=0;i<strlen(tu);i++)
		tu[i]=' ';
	int i = 0;
	while(s[vt] !=' ')
	{
		tu[i] = s[vt];
		vt++;
		i++;
	}
}
int LaToanTu (char s[])
{
	char c = s[0];
	if ((c == '+') || (c == '-') || (c == '*') || (c == '/') || (c == '^'))
		return 1;
	return 0;
}
float TinhToan(float toanHang1, float toanHang2, char toanTu)
{
	float kq;
	switch (toanTu)
	{
		case '+': kq = toanHang1 + toanHang2; break;
		case '-': kq = toanHang1 - toanHang2; break;
		case '*': kq = toanHang1 * toanHang2; break;
		case '/': kq = toanHang1 / toanHang2; break;
		case '^': kq = pow(toanHang1, toanHang2);
	}
	return kq;
}
float TinhBieuThuc(stack &s, char bieuThuc[])
{
	float kq;
	char t[10];
	int i =0;
	do
	{
		DocTu(bieuThuc, t , i);
		if(LaToanTu(t))
		{
			char toanTu = t[0];
			float toanHang1 = pop(s);
			float toanHang2 = pop(s);
			kq = TinhToan(toanHang2,toanHang1, toanTu);
			push(s, kq);
		}
		else{
			float toanHang = atof(t);
			push(s, toanHang);
		}
		i++;
	}while(bieuThuc[i]!='#');
	return pop(s);
}
