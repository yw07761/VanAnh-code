#include <stdio.h>
#include <string.h>
#include<cstdlib>
#define MAX 100
struct Date
{
	int ngay;
	int thang;
	int nam;
};
typedef struct Date DATE;

struct SinhVien {
  char masv[5];
  char hoten[35];
  DATE ns;
  int gioitinh;
  float diem;
};
typedef struct SinhVien SINHVIEN;

struct Node
{
	SINHVIEN data;
	Node* pNext;
};
typedef struct Node NODE;

struct List
{
	NODE* pHead;
	NODE* pTail;
};
typedef struct List LIST;
//============== KHAI BAO HAM ===============//
//======== khoi tao ==========//
void KhoiTaoDSLK(LIST &l);
NODE* KhoiTaoNode(SINHVIEN x);
//======== them  ============ //
//void ThemVaoDau(LIST &l, NODE *p);
void ThemVaoCuoi(LIST &l, NODE *p);
void Insert_Last(LIST&l,SINHVIEN x);
//======== nhap xuat  ========//
int Nhapsinhvien(SINHVIEN &x);
void NhapDSSV(LIST &l);
void Xuatsinhvien(SINHVIEN x);
void xuatDSSV(LIST l);
int InsertLast_khongtrung(LIST &l,SINHVIEN x);   
//======== sap xep   =========//
void hoanvi(SINHVIEN *a,SINHVIEN *b);   
void sapxeptang(LIST l);
void interchangeSort_SapxeptheoMSSV(LIST &l);
void interchangeSort_SapxepTheoTen(LIST &l);
//======== xoa   ============//
void XoaDau(LIST &l);
void XoaCuoi(LIST &l);
void XoaMaSV(LIST &l, char ma[]);
void XoaTenSV(LIST &l, char ten[]);
//======== tim   ===========//
Node* searchSV(LIST l, char* ten);
Node* searchMS(LIST l, char* x);
//================== MENU = ================//
int main(int argc, char *argv[])
{
	LIST sv;
	KhoiTaoDSLK(sv);
	int chon;
	do{
		printf("\n--menu--\n");
		printf("1. Tao ds sv\n");
		printf("2. Xuat ds sv\n");
		printf("3. Them 1 sinh vien vao dssv\n");
		printf("4. Sap xep sv tang theo dtb\n");
		printf("5. Sap xep theo MSSV (1->n)\n");
	    printf("6. Sap xep Theo Ten (a->z)\n");
	    printf("7. Xoa sv dau ds\n");
	    printf("8. Xoa sv cuoi ds\n");
	    printf("9. Xoa Sinh Vien co ten la X\n");
	    printf("10. Xoa Sinh Vien co ma so la X\n");
		printf("chon cv:");scanf("%d",&chon);
		switch(chon){
			case 1:NhapDSSV(sv);break;
			case 2:xuatDSSV(sv);break;
			case 3:{
				SINHVIEN x;
				Nhapsinhvien(x);
				if(InsertLast_khongtrung(sv,x)==0)
					printf("bi trung ma sv nen khong them!");
				else
					printf("da them!");
			}break;
			case 4:{
				if(sv.pHead==NULL){
					printf("Vui long nhap danh sach\n");
                break;
				}
				sapxeptang(sv);
				xuatDSSV(sv);
			}break;
			case 5:{
				if(sv.pHead==NULL){
					printf("Vui long nhap danh sach\n");
                break;
				}
			 	interchangeSort_SapxeptheoMSSV(sv);
		 		printf("Da sap xep!");
			}break;
			case 6:
			{
				if(sv.pHead==NULL){
					printf("Vui long nhap danh sach\n");
                break;
				}
				interchangeSort_SapxepTheoTen(sv);
				printf("Da sap xep!");
			}break;
			case 7:
			{
				if(sv.pHead==NULL){
					printf("Vui long nhap danh sach\n");
                break;
				}
				XoaDau(sv);
				printf("Xoa thanh cong!");
			}break;
			case 8:
			{
				if(sv.pHead==NULL){
					printf("Vui long nhap danh sach\n");
                break;
				}
				XoaCuoi(sv);
				printf("Xoa thanh cong!");
			}break;
			case 9:
			{
				char *ten = new char[50];
				printf("\nNhap Ten Sinh Vien : ");
				fflush(stdin);
				gets(ten);
				NODE* a = searchSV(sv,ten);
				if(a==NULL) 
					printf("\nKhong Tim Thay !");
				else{
					printf("\nTim thay !\n");
					XoaTenSV(sv,ten);
					printf("Da xoa !");
				}				 	
			}break;
			case 10: 
			{
				char ma[10];
				printf("Nhap ma so muon xoa: ");
				fflush(stdin);
				gets(ma);
				NODE *a = searchMS(sv, ma);
				if(a== NULL){
					printf("\nKhong Tim thay !\n");
				}
				else{
					printf("\nTim thay !\n");
					XoaMaSV(sv, ma);
					printf("Da xoa !");
				}		 			
			}break;
		}
	}while(chon<12);
	xuatDSSV(sv);
	return 0;
}
//=============HAM KHOI TAO ==================//
void KhoiTaoDSLK(LIST &l)
{
	l.pHead = l.pTail = NULL;
}
NODE *KhoiTaoNode(SINHVIEN x)
{
	NODE* p = new NODE;
	if (p==NULL){
		printf("khong du bo nho!");
		return NULL;
	}
	p->data = x;
	p->pNext = NULL;
	return p;
}
//=============== HAM THEM ====================//
/**void ThemVaoDau(LIST &l, NODE *p)
{
	if (l.pHead == NULL)
		l.pHead = l.pTail = p;
	else
	{
		p->pNext = l.pHead;
		l.pHead = p;
	}
}
*/
void ThemVaoCuoi(LIST &l, NODE *p)
{
	if (l.pHead == NULL)
		l.pHead = l.pTail = p;
	else
	{
		l.pTail->pNext = p;
		l.pTail = p;
	}
}
void Insert_Last(LIST &l,SINHVIEN x){
	NODE *new_node;
	new_node=KhoiTaoNode(x);
	if(new_node!=NULL)
		ThemVaoCuoi(l,new_node);
}
int Nhapsinhvien(SINHVIEN &x){
	printf("nhap ma sv:");scanf("%s",x.masv);
	fflush(stdin);
	if(strcmp(x.masv,"0")==0)
		return 0;
	printf("nhap ho ten:");gets(x.hoten);
	fflush(stdin);
	printf("nhap gioi tinh(0:nam,1:nu):");scanf("%d",&x.gioitinh);
	printf("nhap ngay sinh(d/m/y):");scanf("%d/%d/%d",&x.ns.ngay,&x.ns.thang,&x.ns.nam);
	printf("nhap diem tb :");scanf("%f",&x.diem);
	return 1;
}
void NhapDSSV(LIST &l){
	SINHVIEN x;int flag;
	do{
		flag=Nhapsinhvien(x);
		if(flag==1)
			Insert_Last(l,x);
	}while(flag!=0);
}
//================= HAM XUAT =================//
void Xuatsinhvien(SINHVIEN x){
	char gt[4];
	if(x.gioitinh==0)
		strcpy(gt,"nam");
	else
		strcpy(gt,"nu");
	printf("%5s|%10s|%3s|%d/%d/%4d|%.2f\n",x.masv,x.hoten,gt,
	x.ns.ngay,x.ns.thang,x.ns.nam,x.diem);
	
}
void xuatDSSV(LIST l){
	printf("%5s|%10s|%3s|%8s|%4s\n","Ma SV","HoTenSV","GT","NgaySinh","Diem");
	NODE*p=l.pHead;
	while(p!=NULL){
		Xuatsinhvien(p->data);
		p=p->pNext;
	}
}
int InsertLast_khongtrung(LIST &l,SINHVIEN x){
	NODE*p=l.pHead;
	while(p!=NULL&&strcmp(p->data.masv,x.masv)!=0)
		p=p->pNext;
	if(p==NULL){
		Insert_Last(l,x);return 1;
	}		
	else
		return 0;
}
//================= SAP XEP =====================//
void hoanvi(SINHVIEN *a,SINHVIEN *b)
{
         SINHVIEN t=*a;
         *a=*b;
         *b=t;
}
void sapxeptang(LIST l)
{
        NODE *i,*j;
        for(i=l.pHead; i!=NULL; i=i->pNext)
            for(j=i->pNext;j!=NULL;j=j->pNext)
            if(i->data.diem>j->data.diem)
            hoanvi(&i->data,&j->data);
}
void interchangeSort_SapxeptheoMSSV(LIST &l)
{
	NODE *p = l.pHead;	
	
	while (p->pNext != NULL)
	{
		NODE *q = p->pNext;
		while (q != NULL)
		{
			if (p->data.masv < q->data.masv)
			{
				hoanvi(&p->data, &q->data);
			}
			q = q->pNext;
		}
		p = p->pNext;
	}
}
void interchangeSort_SapxepTheoTen(LIST &l)
{
	NODE *p = l.pHead;
	
	while (p->pNext != NULL) // Next isn't NULL
	{
		NODE *q = p->pNext; 
		while (q != NULL)
		{
			if (strcmp(p->data.hoten, q->data.hoten) > 0)
			{
				hoanvi(&q->data,&p->data);
			}
			q = q->pNext;
		}
		p = p->pNext;
	}
}
//================== XOA =====================//
// hàm xóa dau
void XoaDau(LIST &l)
{
	// n?u danh sách rong
	if (l.pHead == NULL)
	{
		return;
	}
	NODE *p = l.pHead; // node p là node se xóa
	l.pHead = l.pHead->pNext;// cap nhat lai l.pHead là phan tu ke tiep
	delete p;
}

// xóa cuoi
void XoaCuoi(LIST &l)
{
	// neu danh sách rong
	if (l.pHead == NULL)
	{
		return;
	}
	// truong hop danh sách có phan tu
	if (l.pHead->pNext == NULL)
	{
		XoaDau(l);
		return;
	}
	// duyet tu dau danh sách den ke cuoi
	for (NODE *k = l.pHead; k != NULL; k = k->pNext)
	{
		// phát hien ptu ke cuoi
		if (k->pNext == l.pTail)
		{
			delete l.pTail; // xóa di phan tu cuoi
			k->pNext = NULL; // cho con tro cua node ke cuoi tro den vùng nho null
			l.pTail = k; // cap nhat lai l.pTail
			return;
		}
	}
}
/**
void XoaSauQ(LIST& l, NODE* q)
{
	NODE* p;
	if (q != NULL)
	{
		p = q->pNext; 
		if (p != NULL) 
		{
			if (p == l.pTail) 
				l.pTail = q;
			q->pNext = p->pNext;
			p = NULL;
			delete p;
		}
	}
}
*/
void XoaMaSV(LIST &l, char ma[]){
	Node *p = l.pHead;
	Node *q = NULL;
	while(p != NULL){
		if(strcmp(p->data.masv, ma) == 0 && p == l.pHead) {
				XoaDau(l);
				break;
		}
		if(strcmp(p->data.masv, ma) == 0 && p == l.pTail	){
				XoaCuoi(l);
				break;
		}
		if(strcmp(p->pNext->data.masv, ma) == 0 && p->pNext != NULL){
			q = p->pNext;
			p->pNext = q->pNext;
			delete(q);
			break;
		}
		p = p ->pNext;
	}
}
void XoaTenSV(LIST &l, char ten[]){
	Node *p = l.pHead;
	Node *q = NULL;
	while(p != NULL){
		if(strcmp(p->data.hoten, ten) == 0 && p == l.pHead) {
				XoaDau(l);
				break;
		}
		if(strcmp(p->data.hoten, ten) == 0 && p == l.pTail	){
				XoaCuoi(l);
				break;
		}
		if(strcmp(p->pNext->data.hoten, ten) == 0 && p->pNext != NULL){
			q = p->pNext;
			p->pNext = q->pNext;
			delete(q);
			break;
		}
		p = p ->pNext;
	}
}

//================ TIM KIEM ===================/

Node* searchSV(LIST l, char* ten) {
	NODE *i =l.pHead;
	while (i!=NULL)
	{
		if(strcmp(i->data.hoten,ten) == 0)
				return i;
		i=i->pNext;
	}
	return NULL;
}
Node* searchMS(LIST l, char *x)
{
    NODE *p = l.pHead;
    while(p!=NULL) 
    {
    	if(strcmp(p->data.masv,x) == 0)
		return p;
        p= p->pNext;
    }
    return NULL;
}

