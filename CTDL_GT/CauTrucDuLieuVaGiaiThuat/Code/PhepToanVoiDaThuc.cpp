#include <stdio.h>

struct Node {
	float heso;
	int somu;
	Node *next;
};

struct list {
	Node *first,*last;
};

void Init (list &l)
{l.first=l.last=NULL;
}

Node *GetNode(float heso,int somu)
{
	Node *p;
	p=new Node;
	if (p==NULL)
	
	{printf ("bo nho khong du !!!");
	return NULL;
	};
	p->heso=heso;
	p->somu=somu;
	p->next=NULL;
	return p;
}

void AddLast(list &l,Node *new_node)
{
    if (l.first==NULL)
        {
           l.first=l.last=new_node;
        }
    else
       {
       	l.last->next =new_node;
       	l.last=new_node ;
	   }
 
}

void InsertLast (list &l,float heso,int somu)
{
	Node *q;
	q=GetNode(heso , somu);
	if (q==NULL)
	    {
		printf ("khong du bo nho !!!");
	    return;
	    }
	 AddLast(l,q);
}

void Nhapdathuc(list &l)
{
	float heso;
	int somu;
	char a;
	do
	    {
	     printf ("Nhap he so : ");scanf ("%f",&heso);
	     printf ("Nhap so mu : "); scanf ("%d",&somu);	    
	     InsertLast(l,heso,somu);
	     fflush(stdin);
	     printf ("Nhap nua khong ?  (y/n) :");
	     scanf("%c",&a);
	 }while (a!='n'&& a!='N');
	     
}

void Print_List(list l){
	Node *p=l.first;
	while(p!=NULL){
		if(p==l.first||p->heso<0)
	  	{
	  	if (p->somu>1)	printf("%.1fx^%d ",p->heso,p->somu);
		else if(p->somu==1) printf ("%.1fx",p->heso);
		else if(p->somu<1)   printf("%.1f",p->heso);
	    }
		else if(p->heso>0)
		{
		if (p->somu>1)   printf("+%.1fx^%d ",p->heso,p->somu);
		else if(p->somu==1   )printf ("+%.1fx",p->heso);
		else  if(p->somu<1)    printf ("+%.1f",p->heso);
		
	    }
		p=p->next;	   
	}
}
void congdathuc(list l1,list l2,list &l3){
	Init(l3);
	float tonghs;
	Node *p=l1.first,*q=l2.first,*tam;
	while(p!=NULL&&q!=NULL)
		if(p->somu==q->somu){
			tonghs=p->heso+q->heso;
			if(tonghs!=0){
				tam=GetNode(tonghs,p->somu);
				AddLast(l3,tam);
			}
			p=p->next;q=q->next;
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

void trudathuc(list l1,list l2,list &l3){
	Init(l3);
	float hieuhs;
	Node *p=l1.first,*q=l2.first,*tam;
	while(p!=NULL&&q!=NULL)
		if(p->somu==q->somu){
			hieuhs=p->heso-q->heso;
			if(hieuhs!=0){
				tam=GetNode(hieuhs,p->somu);
				AddLast(l3,tam);
			}
			p=p->next;q=q->next;
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
		tam=GetNode(-(q->heso),q->somu);
		AddLast(l3,tam);
		q=q->next;
	}
}

void swapHS(float &a, float &b){
	float x;
	x=a;
	a=b;
	b=x;
}
void swapSM(int &a, int &b){
	int x;
	x=a;
	a=b;
	b=x;
}
void sapxep(list &l){
	for(Node *i=l.first; i!=l.last; i=i->next)
		for(Node *j = i->next ; j != NULL; j=j->next){
			if(i->somu<j->somu){
				swapHS(i->heso, j->heso);
				swapSM(i->somu, j->somu);
			}
		}
}
int main()
{   int chon;
    list dathuc1;
    list dathuc2;
    list dathuc3;
    list dathuc4;
    do
    {
	    printf ("\n1.Nhap da thuc 1  ");
        printf ("\n2.Nhap da thuc 2  ");
        printf ("\n3.Cong hai da thuc");
        printf ("\n4.Tru hai da thuc");
        printf ("\nNhap lua chon cua ban: ");
        scanf("%d",&chon);
		switch(chon)
		{
			case 1: {
             	Init(dathuc1);
        	    Nhapdathuc(dathuc1);
        	    sapxep(dathuc1);
        	    printf ("Da thuc 1 : ");
                Print_List(dathuc1);
			    break;
			};
			case 2: {
	            Init(dathuc2);
	            Nhapdathuc(dathuc2);
	            sapxep(dathuc2);
	            printf ("Da thuc 2 : ");
	            Print_List(dathuc2);
				break;
			};
			case 3: {
			    congdathuc(dathuc1,dathuc2,dathuc3);
			    printf ("Tong cua 2 da thuc :");
				 Print_List(dathuc3);
				break;
			};
			case 4:{
				trudathuc(dathuc1,dathuc2,dathuc4);
			    printf ("Hieu cua 2 da thuc :");
				 Print_List(dathuc4);
				break;
			}
		};
   }while (chon>0 && chon<5);
   return 0;
   	
}
