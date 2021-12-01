#include <stdio.h>
struct Node{
	int data;
	Node *next;
};
Node *getNode(int data);
int main(int argc, char *argv[])
{
	int x;
	printf("nhap du lieu:"); scanf("%d",&x);
	Node *p;
	p=getNode(x);
	printf("du lieu cua Node la %d", p -> data);
	return 0;
}
Node *getNode(int data){
	Node *p;
	p=new Node;
	if(p==NULL)
	{
			printf("Khong du bo nho!"); return NULL;
	}
	p -> data = data;
	p -> next = NULL;
	return p;
}
	