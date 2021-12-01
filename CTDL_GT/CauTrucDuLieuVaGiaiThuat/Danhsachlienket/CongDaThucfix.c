#include <stdio.h>
#include<stdlib.h>
struct Node{
	float heSo;
	int soMu;
	Node *link;
};
struct List
{
	Node *first, *last;
};

void Init(List &l);
Node *GetNode (float heSo, int soMu);
void AddLast (List &l, Node *p);
void Create_List (List &l);
void Print_List(List l);
void CongDaThuc (List d1, List d2, List &d3);
void Sort_List (List &l);
void swap1 (float &a, float &b);
void swap2 (int &a, int &b);
int main(int argc, char *argv[])
{
	List d1,d2,d3;
	//tao da thuc 1
	printf("nhap da thuc P(X):");
	Init(d1);
	Create_List(d1);
	//tao da thuc 2
	printf("\nnhap da thuc Q(X):");
	Init(d2);
	Create_List(d2);
	//Xuat da thuc
	printf("\nP(X)=");
	Print_List(d1);
	printf("\nQ(X)=");
	Print_List(d2);
	//cong 2 da thuc
	CongDaThuc(d1,d2,d3);
	printf("\nP(X) +Q(X) =");
	Print_List(d3); 
	//sap xep
	Sort_List(d1);
	printf("\nSap xep theo so mu giam dan");
	Print_List(d1);
	//lam tat ca cac loai sort
	return 0;
}

// khoi tao danh sach rong
void Init(List &l){
	l.first=l.last=NULL;
}
// Tao mot node moi
Node *GetNode(float heSo,int soMu){
	Node *p;
	p=new Node;
	if(p==NULL){
		printf("khong du bo nho de tao!");
		return NULL;
	}
	p->heSo=heSo;p->soMu=soMu;p->link=NULL;
	return p;	
}
// Gan node new_ele vao danh sach
void AddLast(List &l,Node *p){
	if(l.first==NULL)
		l.first=l.last=p;
	else{
		l.last->link=p;l.last=p;
	}
}
// Ham nhap da thuc
void Create_List (List &l)
{	
	float heSo;int soMu;
	char chon;
	Node*p;
	do{
		printf("\nnhap he so:");scanf("%f",&heSo);
		printf("\nnhap so mu:");scanf("%d",&soMu);
		p=GetNode(heSo,soMu);
		if(l.first==NULL)
			l.first=l.last=p;
		else{
			l.last->link=p;l.last=p;
		}
		fflush(stdin);
		printf("nhap nua k?(y/n):");scanf("%c",&chon);
	}while(chon!='N'&&chon!='n');
}
void Print_List(List l)
{
	Node *p=l.first;
	while(p!= NULL){	
		if(p->link == NULL ){
			printf("%.1fx^%d  ",p->heSo,p->soMu);
				break;
			}
		printf("%.1fx^%d + ",p->heSo,p->soMu);			
		p=p->link;		
	}

}
// Cong da thuc
void CongDaThuc (List d1, List d2, List &d3){
	Init(d3);
	float tonghs;
	Node *p=d1.first,*q=d2.first,*tam;
	while(p!=NULL&&q!=NULL)
		if(p->soMu==q->soMu){
			tonghs=p->heSo+q->heSo;
			if(tonghs!=0){
				tam=GetNode(tonghs,p->soMu);
				AddLast(d3,tam);
				p=p->link;q=q->link;
			}
		}
		else
			if(p->soMu>q->soMu){
				tam=GetNode(p->heSo,p->soMu);
				AddLast(d3,tam);
				p=p->link;
			}
			else{
				tam=GetNode(q->heSo,q->soMu);
				AddLast(d3,tam);
				q=q->link;
			}	
	while(p!=NULL){
		tam=GetNode(p->heSo,p->soMu);
		AddLast(d3,tam);
		p=p->link;
	}
	while(q!=NULL){
		tam=GetNode(q->heSo,q->soMu);
		AddLast(d3,tam);
		q=q->link;
	}
}
void Sort_List (List &l){
	for(Node *p=l.first; p != NULL; p=p->link)
		for(Node *q=p->link;q!=NULL;q=q->link)
			if(p->soMu<q->soMu){
				swap1(p->heSo,q->heSo);
				swap2(p->soMu,q->soMu);
			}
}
void swap1 (float &a, float &b){
	float temp =a; a=b; b = temp;
}
void swap2 (int &a, int &b){
	int temp =a; a=b; b = temp;
}