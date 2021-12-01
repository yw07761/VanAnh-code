#include <stdio.h>
#include <string.h>
#include<cstdlib>
struct THONG_TIN_THUOC{
	char ma_thuoc[12];
	char ten_thuoc[60];
	char loai_thuoc[60]; 
	int so_luong_nhap;
	int so_luong_ban;
};
struct NODE{
THONG_TIN_THUOC data;
	NODE *next;
};
struct LIST{
	NODE* head;
	NODE* tail; 	
};
void KhoiTaoDSLK(LIST &l);
NODE *KhoiTaoNode(THONG_TIN_THUOC x);
void ThemVaoCuoi(LIST &l, NODE *p);
void Insert_Last(LIST &l,THONG_TIN_THUOC x);
int NhapThongTinThuoc(THONG_TIN_THUOC &x);
void NhapDSThuoc(LIST &l);
void XuatThongTinThuoc(THONG_TIN_THUOC x);
void xuatDSThuoc(LIST l);
void hoanvi(THONG_TIN_THUOC *a,THONG_TIN_THUOC *b);
void NhapDSThuocBanDuoc(LIST &l);
void interchangeSort_SapxeptheoMSThuoc(LIST &l);
int NhapThongTinThuocDuocBanThem(THONG_TIN_THUOC &x);

int main(int argc, char *argv[])
{
	LIST thuoc;
	int x;
	KhoiTaoDSLK(thuoc);
	int chon;
	do{
		printf("\n--menu--\n");
		printf("1. Tao moi danh muc thuoc\n");
		printf("2. Xuat danh muc thuoc ton kho\n");
		printf("3. Nhap danh muc thuoc duoc ban them\n");
		printf("4. Sap xep thuoc tang theo ma thuoc\n");
		printf("5. Thoat\n");
		printf("chon cv:");scanf("%d",&chon);
		switch(chon){
			case 1:{
				printf(" Ban chon tao moi danh muc thuoc\n");
				NhapDSThuoc(thuoc);
			}break;
			case 2:{
				printf(" Ban chon xuat danh muc thuoc ton kho\n");
				xuatDSThuoc(thuoc);
			}break;
			case 3:{
				printf("Ban chon nhap danh muc thuoc duoc ban them\n");
				NhapDSThuocBanDuoc(thuoc);
			}break;	
			case 4:{
				if(thuoc.head==NULL){
					printf("Vui long nhap danh sach\n");
                break;
				}
			 	interchangeSort_SapxeptheoMSThuoc(thuoc);
		 		printf("Da sap xep!");
			}break;
				}
	}while(chon<6);
	xuatDSThuoc(thuoc);
	return 0;
}
void KhoiTaoDSLK(LIST &l)
{
	l.head = l.tail = NULL;
}
NODE *KhoiTaoNode(THONG_TIN_THUOC x)
{
	NODE* p = new NODE;
	if (p==NULL){
		printf("khong du bo nho!");
		return NULL;
	}
	p->data = x;
	p->next = NULL;
	return p;
}
void ThemVaoCuoi(LIST &l, NODE *p)
{
	if (l.head == NULL)
		l.head = l.tail = p;
	else
	{
		l.tail->next = p;
		l.tail = p;
	}
}
void Insert_Last(LIST &l,THONG_TIN_THUOC x){
	NODE *new_node;
	new_node=KhoiTaoNode(x);
	if(new_node!=NULL)
		ThemVaoCuoi(l,new_node);
}
int NhapThongTinThuoc(THONG_TIN_THUOC &x){
	printf("nhap ma thuoc: ");
	scanf("%s",&x.ma_thuoc);
	fflush(stdin);
	if(strcmp(x.ma_thuoc,"0")==0)
		return 0;
	
	printf("nhap ten thuoc:");gets(x.ten_thuoc);
	fflush(stdin);
	printf("nhap loai thuoc: ");gets(x.loai_thuoc);
	fflush(stdin);
	printf("so luong nhap :");scanf("%d",&x.so_luong_nhap);
	printf("so luong ban :");scanf("%d",&x.so_luong_ban);
	if(x.so_luong_ban > x.so_luong_nhap){
		printf("So luong ban phai nho hon so luong nhap");
		return 0;
	}
	return 1;
}
int NhapThongTinThuocDuocBanThem(THONG_TIN_THUOC &x){
	NhapThongTinThuoc(x);
	if(x.so_luong_nhap - x.so_luong_ban	 >= x.so_luong_ban)
		printf("Du thuoc de ban !");
	else
		printf(" khong du thuoc de ban!");
		return 0;
	return 1;
}
void NhapDSThuocBanDuoc(LIST &l){
	THONG_TIN_THUOC x;int flag;
	do{
		flag=NhapThongTinThuocDuocBanThem(x);
		if(flag==1)
			Insert_Last(l,x);
	}while(flag!=0);
}
void NhapDSThuoc(LIST &l){
	THONG_TIN_THUOC x;int flag;
	do{
		flag=NhapThongTinThuoc(x);
		if(flag==1)
			Insert_Last(l,x);
	}while(flag!=0);
}
void XuatThongTinThuoc(THONG_TIN_THUOC x){
	printf("%8s|%20s|%20s|%15d|%15d\n",x.ma_thuoc,x.ten_thuoc,
	x.loai_thuoc,x.so_luong_nhap,x.so_luong_ban);
	
}
void xuatDSThuoc(LIST l){
	printf("%8s|%20s|%20s|%15s|%15s\n","ma thuoc","ten thuoc",
	"loai thuoc","soluongnhap","soluongban");
	NODE*p=l.head;
	while(p!=NULL){
		XuatThongTinThuoc(p->data);
		p=p->next;
	}
}
void hoanvi(THONG_TIN_THUOC *a,THONG_TIN_THUOC *b)
{
         THONG_TIN_THUOC t=*a;
         *a=*b;
         *b=t;
}
void interchangeSort_SapxeptheoMSThuoc(LIST &l)
{
	NODE *p = l.head;	
	
	while (p->next != NULL)
	{
		NODE *q = p->next;
		while (q != NULL)
		{
			if (p->data.ma_thuoc < q->data.ma_thuoc)
			{
				hoanvi(&p->data, &q->data);
			}
			q = q->next;
		}
		p = p->next;
	}
}
