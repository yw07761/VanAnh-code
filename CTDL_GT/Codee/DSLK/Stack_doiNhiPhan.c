#include <stdio.h>
struct Node{
	int data;
	Node *next;
};
struct stack{
	Node *top;
};
void Init(stack &s);
int is_empty(stack &s);
Node *GetNode (int x);
void push(stack &s, int x);
void create_stack(stack &s);
int pop (stack &s);
void print_stack(stack s);
void doi_nhi_phan(stack &s,int so);
int main(int argc, char *argv[])
{
	stack s;
	int so;
	Init(s);
	printf("nhap so he 10: "); scanf("%d",&so);
	//create_stack(s);
	doi_nhi_phan(s,so);
	print_stack(s);
	return 0;
}
void Init(stack &s){
	s.top=NULL;
}
int is_empty(stack &s){
	return s.top==NULL ? 1 : 0;
}
Node *GetNode (int x){
	Node *p;
	p=new Node;
	if(p==NULL){
		printf("khong tao duoc");
		return NULL;	
	}
	p->data=x;
	p->next=NULL;
	return p;

}
void push(stack &s, int x){
	Node *p = GetNode(x);
	if(is_empty(s)==1)
		s.top=p;
	else
		p->next=s.top;
		s.top=p;
}
void create_stack(stack &s){
	int x;
	do{
	printf("nhap data: ");scanf("%d",&x);	
	if(x!=-1)
		push(s,x);
	}while(x!=-1);
}
int pop (stack &s){
	if(is_empty(s)==1)
	{
		printf("stack rong! "); return -1;
	}
	else{
		Node *p=s.top;s.top=s.top->next;p->next=NULL;
		int x=p->data;
		delete(p);
		return x;
	}
}
void print_stack(stack s){
	while(s.top!=NULL){
		int x=pop(s);
		printf("%d",x);
		
	}
}
void doi_nhi_phan(stack &s,int so){
	int n;
	while(so>0){
		n=so%2;push(s,n);
		so=so/2;
	}
}