#include<stdio.h>
#include<conio.h>
#include<math.h>
#include<string.h>
#define max 100
struct NhanVien
{
	int msnv;
	char ten[30];
	float luong;

};
typedef struct NhanVien nhanvien;
struct DanhSach
{
	nhanvien a[max];
	int n;
};
typedef struct DanhSach danhsach;
void menu();
void nhap1nv(nhanvien &nv);
void xuat1nv(nhanvien nv);
void nhapdanhsach(danhsach &ds);
void xuatdanhsach(danhsach ds);
void themnv(danhsach &ds,nhanvien x,int k);
int timMSNV(danhsach ds,int d);
void sapxep(danhsach ds);
int main()
{
	menu();
	getch();
}
void menu()
{
	int ch;
	int d,k;
	danhsach ds;
	nhanvien x;
	nhapdanhsach(ds);
	xuatdanhsach(ds);
	printf("\n\t\t--------------MENU--------------");
	printf("\n\t1.Them vao 1 nhan vien");
	printf("\n\t2.Tim nhan vien theo ma so");
	printf("\n\t3.Tim nhan vien thoe ten");
	printf("\n\t4.Bang luong cua  nhan vien giam dan");
	printf("\n\t5.Xoa 1 nhan vien");
	printf("\n\    *************************************************");
	printf("\n\tChon 1 trong chuc nang tren: ");
	scanf("%d",&ch);
	switch(ch)
	{
		case 1:
			{
				printf("\n\tvi tri them: ");
				scanf("%d",&k);
				nhap1nv(x);
				themnv(ds,x,k);
				printf("\n\t\t\tdanh sach sau khi them");
				xuatdanhsach(ds);
				break;
			}
		case 2:
			{
				int d;
				danhsach ds;
				printf("\n\tNhap ma so can tim: ");
				scanf("%d",&d);
				int b=timMSNV(ds,d);
				if(timMSNV(ds,d)==-1)
					printf("\nkhong tim thay");
				else
					printf("\nTim thay nhan vien thu %d",b+1);
			}
		case 3:
			{
				sapxep(ds);
				printf("\n\t\t\tDANH SACH LUONG SAU KHI SAP XEP ");
				xuatdanhsach(ds);
				break;
			}
		
		default: printf("\nkhong co chuc nang nay");
			break;
	}
}

void nhap1nv(nhanvien &nv)
{

	printf("\nnhap vao msnv: ");
	scanf("%d",&nv.msnv);
	printf("\nnhap vao ten:");
	fflush(stdin);
	gets(nv.ten);
	printf("\nnhap vao luong: ");
	scanf("%f",&nv.luong);
	
	
}
void xuat1nv(nhanvien nv)
{
	printf("\nma so nhan vien: %d",nv.msnv);
	printf("\nten: %s",nv.ten);
	printf("\nluong: %8.2f",nv.luong);
}
void nhapdanhsach(danhsach &ds)
{
	printf("\nnhap so luong nhan vien: ");
	scanf("%d",&ds.n);
	printf("\n\t\t\tnhap thong tin nhan vien");
	for(int i=0;i< ds.n;i++)
	{
		printf("\n\t\tnhan vien thu %d",i+1);
		nhap1nv(ds.a[i]);
	}
}
void xuatdanhsach(danhsach ds)
{
	printf("\n\t\t\tdanh sach nhan vien");
	for(int i=0;i< ds.n;i++)
	{
		printf("\n\t\tnhan vien thu %d",i+1);
		xuat1nv(ds.a[i]);
	}
}
void themnv(danhsach &ds,nhanvien x,int k)
{
	for(int i=ds.n;i>k;i--)
		ds.a[i]=ds.a[i-1];
	ds.a[k]=x;
	ds.n++;
}
/**
int timten(danhsach ds,char *c)
{
	for(int i=0;i<ds.n;i++)
	{
		if(strcmp(ds.a[i].ten,c)==0)
		{
			return i;
			break;
		}
	}
	return -1;
}
case 3:
			{
				char c[20];
				printf("\n\tnhap ten can tim: ");
				fflush(stdin);
				gets(c);
				int b=timten(ds,c);
				if(timten(ds,c)==-1)
					printf("\nKhong tim thay nhan vien: %s",c);
				else
					printf("\nTim thay nhan vien thu %d",b+1);
				break;
			}*/
int timMSNV(danhsach ds,int d)
{
	for(int i=0;i<ds.n;i++)
	{
		if(ds.a[i].msnv==d)
		{
			return i;
			break;
		}
	}
	return -1;
}

void sapxep(danhsach ds)
{
	for(int i=0;i<ds.n-1;i++)
	{
		for(int j=i+1;j<ds.n;j++)
		{
			if(ds.a[i].luong<ds.a[j].luong)
			{
				float t=ds.a[i].luong;
				ds.a[i].luong=ds.a[j].luong;
				ds.a[j].luong=t;
			}
		}
	}
}
/**
void xoanv(danhsach ds,int d)
{
	int vt=timMSNV(ds,d);
	if(vt==-1)
		printf("\nkhong tim thay msnv %d muon xoa",d );
	else
		for(int i=vt;i<ds.n;i++)
		{
			ds.a[i]=ds.a[i+1];
			ds.n--;
		}
}
case 5:
			{
				printf("\nnhap ma so can xoa: ");
				scanf("%d",&d);
				xoanv(ds,d);
				printf("\n\t\tdanh sach sau khi xoa");
				xuatdanhsach(ds);
				break;
			}*/
			