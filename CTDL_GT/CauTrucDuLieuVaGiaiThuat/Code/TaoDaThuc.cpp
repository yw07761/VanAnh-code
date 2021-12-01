#include<stdio.h>

struct Node {
	
	float heso;
	int somu;
	Node *link;
};
typedef struct Node NODE;
struct List {
	NODE *dau;
	NODE *cuoi;
};
typedef struct List LIST;

void Init(LIST &l);
NODE *Tao_Node(float hs,int sm);
void CreateList(LIST &l);
void AddLast(LIST &l, NODE *p);
void Interchange_Sort(LIST &l);
void Tru_Da_Thuc(LIST l1,LIST l2,LIST &l3);
void Printf_List(LIST l);

int main() {
	int cv;
	LIST ds1,ds2,ds3;
	Init(ds1);
	Init(ds2);
	Init(ds3);

	do {
		printf("\n************************************************* \n");
		printf(" 1. Tao da thuc 1 \"co dau\", sap xep va in ket qua .\n");
		printf(" 2. Tao da thuc 2 \"co dau\", sap xep va in ket qua .\n");
		printf(" 3. dt1 - dt2.\n");
		printf(" 4. In KQ.\n");
		printf("    Chon cong viec: ");
		scanf("%d",&cv);

		switch(cv) {
			case 1:
				CreateList(ds1);
				Interchange_Sort(ds1);
								printf("Da thuc 1: ");
				Printf_List(ds1);
				break;
			case 2:
				CreateList(ds2);
				Interchange_Sort(ds2);
				printf("da thuc 2: ");
				Printf_List(ds2);
				break;
			case 3:
				Tru_Da_Thuc(ds1,ds2,ds3);
				printf("\nDa tru da thuc !!\n");
				break;
			case 4:
				Interchange_Sort(ds3);
				printf("KQ = ");
				Printf_List(ds3);
				break;
		}
	} while(cv!=0);

}

void Init(LIST &l) {
	l.dau = l.cuoi = NULL;
}
NODE *Tao_Node(float hs,int sm) {
	NODE *p = new NODE;
	if(p==NULL) {
		printf("Khong du bo nho!!");
		return NULL;
	}
	p->heso = hs;
	p->somu = sm;
	p->link = NULL;
	return p;
}
void AddLast(LIST &l, NODE *p) {
	if(l.dau==NULL)
		l.dau = l.cuoi = p;
	else {
		l.cuoi->link = p;
		l.cuoi = p;
	}

}
void CreateList(LIST &l) {
	float hs;
	int sm,chon;
	char dau;
	do {
		printf("\nNhap he so: ");
		scanf("%f",&hs);
		printf("Nhap so mu: ");
		scanf("%d",&sm);
		if(hs!=0) {
			NODE *p = Tao_Node(hs,sm);
			AddLast(l,p);
		}
		printf("0 -> Stop.");
		scanf("%d",&chon);
	} while(chon!=0);
}
void Printf_List(LIST l) {
	NODE *p = l.dau;
	if(p->somu!=0) {
		if(p->heso>0)
			printf(" (%.f*x^%d) ",p->heso,p->somu);
		else if(p->heso < 0)
			printf(" - (%.f*x^%d) ", p->heso*-1,p->somu);
		else
			printf(" ");
	} else {
		if(p->heso>0)
			printf(" %.f ",p->heso);
		else if (p->heso<0)
			printf("- %.f ", p->heso*-1);
		else
			printf(" ");
	}
	p=p->link;
	while(p!=NULL) {
		if(p->somu!=0) {
			if(p->heso>0)
				printf("+ (%.f*x^%d) ",p->heso,p->somu);
			else if(p->heso<0)
				printf(" - (%.f*x^%d) ", p->heso*-1,p->somu);
			else
				printf(" ");
		} else {
			if(p->heso>0)
				printf("+ %.f ",p->heso);
			else if(p->heso<0)
				printf("- %.f ", p->heso*-1);
			else
				printf(" ");
		}
		p=p->link;
	}
}
void swap1(float &a,float &b) {
	float temp=a;
	a=b;
	b=temp;
}
void swap2(int &a,int &b) {
	int temp=a;
	a=b;
	b=temp;
}

void Interchange_Sort(LIST &l) {
	for(Node *p=l.dau; p!=NULL; p=p->link)
		for(Node *q=p->link; q!=NULL; q=q->link)
			if(p->somu<q->somu) {
				swap1(p->heso,q->heso);
				swap2(p->somu,q->somu);
			}
}
void Tru_Da_Thuc(LIST l1,LIST l2,LIST &l3) {
	NODE *p = l1.dau;
	NODE *q = l2.dau;
	NODE *t = new NODE;
	float hstam;
	while(p != NULL && q != NULL) {
		if(p->somu == q->somu) {
			hstam = p->heso - q->heso;
			t = Tao_Node(hstam,p->somu);
			AddLast(l3,t);
			p = p->link;
			q = q->link;
		} else if(p->somu>q->somu) {
			t = Tao_Node(p->heso,p->somu);
			AddLast(l3,t);
			p = p->link;
		} else if(p->somu < q->somu) {
			t = Tao_Node(q->heso*-1,q->somu);
			AddLast(l3,t);
			q = q->link;
		}
	}
		while(q != NULL) {
			t = Tao_Node(q->heso*-1,q->somu);
			AddLast(l3,t);
			q = q->link;
		}
		while(p != NULL) {
			t = Tao_Node(p->heso,p->somu);
			AddLast(l3,t);
			p = p->link;
		}
}
