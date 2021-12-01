#include <stdio.h>
#include <string.h>

struct Ngay{
	int ngay,thang,nam;	
};

struct Sinhvien{
	char masv[8];
	char hoten[50];
	int gioitinh;
	Ngay ns;
	char diachi[100];
	char lop[12];
	char khoa[7];
};

struct Node{
	Sinhvien data;
	Node*link;	
};

struct List{
	Node *first,*last;	
};

Node *Getnode(Sinhvien x);
void Init(List &l);
void addLast(List &l,Node *new_node);
void Insert_Last(List&l,Sinhvien x);
int Nhapsinhvien(Sinhvien &x);
void NhapDSSV(List &l);
void Xuatsinhvien(Sinhvien x);
void xuatDSSV(List l);
int InsertLast_khongtrung(List &l,Sinhvien x);
int xoa_sv_theo_ma (List &l, char ma[]);
int main(int argc, char *argv[])
{
	List sv;
	Init(sv);
	int chon;
	do{
		printf("\n--menu--\n");
		printf("1. Tao ds sv\n");
		printf("2. Xuat ds sv\n");
		printf("3. Them 1 sinh vien vao dssv\n");
		printf("4. Xoa sinh vien theo masv trong dssv\n")
		printf("chon cv:");scanf("%d",&chon);
		switch(chon){
			case 1:NhapDSSV(sv);break;
			case 2:xuatDSSV(sv);break;
			case 3:{
				Sinhvien x;
				Nhapsinhvien(x);
				if(InsertLast_khongtrung(sv,x)==0)
					printf("bi trung ma sv nen khong them!");
				else
					printf("da them!");
			}break;
			case 4:{
				char ma[8];
				printf("Nhap ma can xoa: "); scanf("%s",ma);
				xoa_sv_theo_ma(sv,ma);
			}break;
		}
	}while(chon<10);
	NhapDSSV(sv);
	xuatDSSV(sv);
	return 0;
}

Node *Getnode(Sinhvien x){
	Node *p;
	p=new Node;
	if(p==NULL){
		printf("khong du bo nho!");
		return NULL;
	}
	p->data=x;
	p->link=NULL;
	return p;
}

void Init(List &l){
	l.first=l.last=NULL;
}

void addLast(List &l,Node *new_node){
	if(l.first==NULL)
		l.first=l.last=new_node;
	else{
		l.last->link=new_node;l.last=new_node;
	}
}

void Insert_Last(List&l,Sinhvien x){
	Node *new_node;
	new_node=Getnode(x);
	if(new_node!=NULL)
		addLast(l,new_node);
}

// Nhap 

int Nhapsinhvien(Sinhvien &x){
	printf("nhap ma sv:");scanf("%s",x.masv);
	fflush(stdin);
	if(strcmp(x.masv,"0")==0)
		return 0;
	printf("nhap ho ten:");gets(x.hoten);
	fflush(stdin);
	printf("nhap gioi tinh(0:nam,1:nu):");scanf("%d",&x.gioitinh);
	printf("nhap ngay sinh(d/m/y):");scanf("%d/%d/%d",&x.ns.ngay,&x.ns.thang,&x.ns.nam);
	fflush(stdin);
	printf("nhap dia chi:");gets(x.diachi);
	fflush(stdin);
	printf("nhap lop:");gets(x.lop);
	fflush(stdin);
	printf("nhap khoa:");gets(x.khoa);
	fflush(stdin);
	return 1;
}

void NhapDSSV(List &l){
	Sinhvien x;int flag;
	do{
		flag=Nhapsinhvien(x);
		if(flag==1)
			Insert_Last(l,x);
	}while(flag!=0);
}

// Xuat
void Xuatsinhvien(Sinhvien x){
	char gt[4];
	if(x.gioitinh==0)
		strcpy(gt,"nam");
	else
		strcpy(gt,"nu");
	printf("%5s %10s %4s %d/%d/%d %10s %5s %5s\n",x.masv,x.hoten,gt,
	x.ns.ngay,x.ns.thang,x.ns.nam,x.diachi,x.lop,x.khoa);
	
}

void xuatDSSV(List l){
	Node*p=l.first;
	while(p!=NULL){
		Xuatsinhvien(p->data);
		p=p->link;
	}
}

// them sinh vien bang maSV
int InsertLast_khongtrung(List &l,Sinhvien x){
	Node*p=l.first;
	while(p!=NULL&&strcmp(p->data.masv,x.masv)!=0)
		p=p->link;
	if(p==NULL){
		Insert_Last(l,x);return 1;
	}		
	else
		return 0;
}

// Xoa sv theo ma trong dssv
int xoa_sv_theo_ma (List &l, char ma[]){
	if(strcmp(l.first->data.masv,ma)==0)
		{
			Node *p=l.first
			l.first=l.first->link; p->link=NULL;
			delete(p);
		}
	else{
		Node*p= l.first,*q=p;
		while(p != NULL && strcmp(p->data.masv,ma)!=0) // khong xoa duoc return 0
		{
			q=p;p=p->link; 
		}
		if(p==NULL)
			return 0;
		else{
			if(p==l.last)
			{
				l.last = q; l.last->link = NULL;
				delete(p);
				return 1;
			}
			else
			{
				q->link = p->link; p->link = NULL;
				delete(p);
				return 1;	
			}
		}
	}
}
