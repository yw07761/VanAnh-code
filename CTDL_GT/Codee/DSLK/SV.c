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
	float diemtb;
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
void hoanvi(Sinhvien *a,Sinhvien *b);
void sapxeptang(List l);
int main(int argc, char *argv[])
{
	List sv;
	Init(sv);
	int chon;
	do{
		printf("\n--menu--\n");
		printf("1.tao ds sv\n");
		printf("2.xuat ds sv\n");
		printf("3.them 1 sinh vien vao dssv\n");
		printf("4.Sap xep sv tang theo dtb\n");
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
				sapxeptang(sv);
				xuatDSSV(sv);
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
	printf("nhap diem tb :");scanf("%.2f",&x.diemtb);
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
void Xuatsinhvien(Sinhvien x){
	char gt[4];
	if(x.gioitinh==0)
		strcpy(gt,"nam");
	else
		strcpy(gt,"nu");
	printf("%s %s %s %d/%d/%d %s %s %s %.2f\n",x.masv,x.hoten,gt,
	x.ns.ngay,x.ns.thang,x.ns.nam,x.diachi,x.lop,x.khoa,x.diemtb);
	
}
void xuatDSSV(List l){
	Node*p=l.first;
	while(p!=NULL){
		Xuatsinhvien(p->data);
		p=p->link;
	}
}
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
void hoanvi(Sinhvien *a,Sinhvien *b)
     {
         Sinhvien t=*a;
         *a=*b;
         *b=t;
     }
void sapxeptang(List l)
    {
        Node *i,*j;
        for(i=l.first; i!=NULL; i=i->link)
            for(j=i->link;j!=NULL;j=j->link)
            if(i->data.diemtb>j->data.diemtb)
            hoanvi(&i->data,&j->data);

    }
    