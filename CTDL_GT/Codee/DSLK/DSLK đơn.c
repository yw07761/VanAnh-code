#include <stdio.h>
struct Node{
	int data;
	Node *link;
};	
struct List{
	Node *first,*last;	
};
void Init(List &l);
Node *GetNode(int x);
void PrintList(List l);
void AddLast(List &l,Node *p);
void InsertLast(List &l,int x);
void CreateListLast(List&l);
void addAfter (List &l, Node *q, Node* new_node);
void chen_sau_q(List &l,Node *q,int x);
int search_x(List l,int x);
void delete_x(List &l,int x);
void delete_first(List &l);
void delete_last(List &l);
void delete_mid(List &l,int x);
int main(int argc, char *argv[])
{
	List ds;
	Init(ds);
	CreateListLast(ds);
	PrintList(ds);
	int x;
	printf("nhap gia tri can xoa:");scanf("%d",&x);
	delete_x(ds,x);
	PrintList(ds);
	printf("nhap gia tri can tim:");scanf("%d",&x);
	if(search_x(ds,x)==1)
		printf("tim thay\n");
	else
		printf("khong tim thay\n");

	printf("nhap gia tri cua node can chen sau:");scanf("%d",&x);
	Node *q=GetNode(x);
	printf("nhap gia tri can chen:");scanf("%d",&x);
	chen_sau_q(ds,q,x);
	PrintList(ds);

	return 0;
}
void Init(List &l){
	l.first=l.last=NULL;
}
Node *GetNode(int x){
	Node *p;
	p=new Node;
	if(p==NULL){
		printf("het bo nho, khong cap phat dc!!");
		return NULL;
	}
	p->data=x;
	p->link=NULL;
	return p;
}
void PrintList(List l){
	Node *p;
	p=l.first;
	printf("\nin danh sach:");
	while(p!=NULL){
		printf("%d ",p->data);
		p=p->link;
	}
}
void AddLast(List &l,Node *p){
	if(l.first==NULL){
		l.first=l.last=p;
	}
	else
	{
		l.last->link=p;
		l.last=p;
	}
}
void InsertLast(List &l,int x){
	Node*p;
	p=GetNode(x);
	if(p==NULL)
		return;
	AddLast(l,p);
}
void CreateListLast(List&l){
	int x;
	do{
		printf("nhap x:");scanf("%d",&x);
		if(x!=-1)
			InsertLast(l,x);
	}while(x!=-1);
}

void addAfter (List &l, Node *q, Node* new_node){
	if(q!=NULL){
		new_node->link=q->link;
		q->link=new_node;
		if(q==l.last)
			l.last=new_node;
	}	
}
void InsertAfter(List &l, Node	*q, int x){
	Node *p=GetNode(x);
	if(p==NULL)
		return;
	addAfter(l,q,p);
}

void chen_sau_q(List &l,Node *q,int x){

	Node *p=l.first;
	while(p!=NULL){
		if(p->data==q->data)
		{
			InsertAfter(l,p,x);
		}
		p=p->link;		
	}	
}
int search_x(List l,int x){
	Node *p=l.first;
	while(p!=NULL)
	{
		if(p->data==x)
			return 1;
		p=p->link;
	}
	return 0;
}
void delete_x(List &l,int x){
	Node *p=l.first;
	while(p!=NULL){
		if(p->data==x)
		{
			if(p==l.first)
			{				
				delete_first(l);
				p=l.first;
			}				
			else
				if(p==l.last){
					delete_last(l);
					p=NULL;
				}					
				else
				{
					delete_mid(l,x);
					p=l.first;
				}								
		}
		else			
			p=p->link;
	}	
}
void delete_first(List &l){
	Node *p=l.first;
	l.first=l.first->link;
	p->link=NULL;
	delete(p);
}
void delete_last(List &l){
	Node *p=l.first;
	while(p->link!=l.last)
		p=p->link;
	Node *q=l.last;	
	l.last=p;
	p->link=NULL;	
	delete(q);
	
}
void delete_mid(List &l,int x){
	Node*p=l.first,*k=l.first->link;
	while(k!=NULL){
		if(k->data==x){
			p->link=k->link;
			k->link=NULL;
			delete(k);
			return;
		//	k=p->link;			
		}
		p=k;
		k=k->link;
	}
}
