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
void InterchangeSort_List (List &l);
void SelectionSort_List (List &l);
void BubleSort_List (List &l );
void ListQSort(List &l);
void SListAppend(List &l1, List &l2);
void swap1 (float &a, float &b);
void swap2 (int &a, int &b);
int main(int argc, char *argv[])
{
	List d;
	int chon;
	do{
		printf("\n----menu----\n");
		printf("1.tao danh sach\n");
		printf("2.xuat danh sach\n");
		printf("3.Sap xep theo so mu giam dan (Interchange Sort) \n");
		printf("4.Sap xep theo so mu giam dan (Selection Sort) \n");
		printf("5.Sap xep theo so mu giam dan (Buble Sort) \n");
		printf("6.Sap xep theo so mu giam dan \n");
		printf("7.Sap xep theo so mu giam dan \n");
		printf("chon cong viec:");scanf("%d",&chon);
		switch(chon){
			case 1:{
				printf("nhap da thuc P(X):");
				Init(d);
				Create_List(d);}break;
			case 2:  Print_List(d);break;
			case 3:{
				InterchangeSort_List (d);
				printf("\nSap xep theo so mu giam dan (Interchange Sort): P(X)=");
				Print_List(d);
				}break;
			case 4:{
				SelectionSort_List(d);
				printf("\nSap xep theo so mu giam dan (Selection Sort): P(X)=");
				Print_List(d);
				}break;
			case 5:{
				BubleSort_List(d);
				printf("\nSap xep theo so mu giam dan (Buble Sort): P(X)=");
				Print_List(d);
			}break;
			case 6:{
				ListQSort(d);
				printf("\nSap xep theo so mu giam dan (Quick Sort): P(X)=");
				Print_List(d);
				}break;
			
			}		
	}while(chon<10);
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
// Gan node p vao dau danh sach
void AddHead(List& l, Node* node)
{
	if (l.first == NULL)
	{
		l.first = node;
		l.last = node;
	}
	else
	{
		node->link = l.first;
		l.first = node;
	}
}
// Gan node p vao cuoi danh sach
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
		if(p->heSo)
			printf("%.1fx^%d",p->heSo,p->soMu);
		p=p->link;
		if(p->heSo > 0)
				printf("+");						
	}
}
void swap1 (float &a, float &b){
	float temp =a; a=b; b = temp;
}
void swap2 (int &a, int &b){
	int temp =a; a=b; b = temp;
}
void InterchangeSort_List (List &l){
	for(Node *p=l.first; p != NULL; p=p->link)
		for(Node *q=p->link;q!=NULL;q=q->link)
			if(p->soMu<q->soMu){
				swap1(p->heSo,q->heSo);
				swap2(p->soMu,q->soMu);
			}
}
void SelectionSort_List (List &l)
{	
	for ( Node* p = l.first ; p != l.last ; p = p->link )
 	{
		Node* min = p;
		for ( Node* q = p->link ; q != NULL ; q = q->link )
				if ( min->soMu < q->soMu ) min = q ;
					swap1(min->heSo, p->heSo);
				 	swap2(min->soMu, p->soMu); 
				 	
	}
}
void BubleSort_List( List &l )
{
	for ( Node* p = l.first ;  p != NULL ; p = p->link)
	{	
		 for ( Node* q = l.first ; p != l.last ; q = q->link )
		{
			if( q->soMu  < q->link->soMu )
				swap1(q->heSo , q->link->heSo);
				swap2( q->soMu , q->link->soMu);
			q = q ->link ;
		}
		l.last = p;
	} 
}
void SListAppend(List &l1, List &l2)
{
	if (l2.first == NULL) return; 
	if (l1.first == NULL) 
		l1 = l2;
	else {
		l1.first->link = l2.first;
		l1.last = l2.last;
	} 
	Init(l2);
}
void ListQSort(List &l) {
	Node *X, *p;
	List l1, l2;
	if (l.first == l.last) return; 
	Init(l1);	
	Init(l2);
	X = l.first; 
	l.first= X->link;
	while (l.first != NULL) {
		p = l.first;
		if (p->soMu < X->soMu) AddHead(l1, p);
		else AddHead(l2, p);
	}
	ListQSort(l1);	 
	ListQSort(l2);
	SListAppend(l, l1);	
	AddHead(l, X);
	SListAppend(l, l2);
}

