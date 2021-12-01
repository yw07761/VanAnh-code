#include <stdio.h>
struct Node{
	float heso;
	int somu;
	Node *next;	
};
struct List{
	Node *first,*last;	
};
Node *GetNode(float hs,int sm);
void Create_List(List &l);
void Init(List &l);
void Print_List(List l);
void AddLast(List &l,Node *p);
void congdathuc(List l1,List l2,List &l3);
int main(int argc, char *argv[])
{
	List ds1,ds2,ds3;
	//tao da thuc 1
	printf("nhap da thuc 1:");
	Init(ds1);
	Create_List(ds1);
	Print_List(ds1);
	//tao da thuc 2
	printf("nhap da thuc 2:");
	Init(ds2);
	Create_List(ds2);
	Print_List(ds2);
	//cong 2 da thuc
	printf("\ncong 2 da thuc la:");
	congdathuc(ds1,ds2,ds3);
	Print_List(ds3);
	return 0;
}
Node *GetNode(float hs,int sm){
	Node *p;
	p=new Node;
	if(p==NULL){
		printf("khong du bo nho de tao!");
		return NULL;
	}
	p->heso=hs;p->somu=sm;p->next=NULL;
	return p;	
}
void Create_List(List &l){
	float hs;int sm;
	char chon;
	Node*p;
	do{
		printf("nhap he so:");scanf("%f",&hs);
		printf("nhap so mu:");scanf("%d",&sm);
		p=GetNode(hs,sm);
		if(l.first==NULL)
			l.first=l.last=p;
		else{
			l.last->next=p;l.last=p;
		}
		fflush(stdin);
		printf("nhap nua k?(y/n):");scanf("%c",&chon);
	}while(chon!='N'&&chon!='n');
}
void Init(List &l){
	l.first=l.last=NULL;
}
void Print_List(List l){
	Node *p=l.first;
	printf("\nin da thuc:");
	while(p!=NULL){
		printf("%.1fx^%d ",p->heso,p->somu);
		p=p->next;
	}
}
void congdathuc(List l1,List l2,List &l3){
	Init(l3);
	float tonghs;
	Node *p=l1.first,*q=l2.first,*tam;
	while(p!=NULL&&q!=NULL)
		if(p->somu==q->somu){
			tonghs=p->heso+q->heso;
			if(tonghs!=0){
				tam=GetNode(tonghs,p->somu);
				AddLast(l3,tam);
				p=p->next;q=q->next;
			}
		}
		else
			if(p->somu>q->somu){
				tam=GetNode(p->heso,p->somu);
				AddLast(l3,tam);
				p=p->next;
			}
			else{
				tam=GetNode(q->heso,q->somu);
				AddLast(l3,tam);
				q=q->next;
			}	
	while(p!=NULL){
		tam=GetNode(p->heso,p->somu);
		AddLast(l3,tam);
		p=p->next;
	}
	while(q!=NULL){
		tam=GetNode(q->heso,q->somu);
		AddLast(l3,tam);
		q=q->next;
	}
}
void AddLast(List &l,Node *p){
	if(l.first==NULL)
		l.first=l.last=p;
	else{
		l.last->next=p;l.last=p;
	}
}
