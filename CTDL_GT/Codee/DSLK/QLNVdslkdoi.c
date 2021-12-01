#include<iostream>
#include<string>
struct Date
{
	int ngay;
	int thang;
	int nam;
};
typedef struct NhanVien
{
    int mnv;
    char hoten[20];
    Date ns;
    float tl;

};
typedef struct DNode
{
    NhanVien info;
    DNode *next;
    DNode *prev;
};
typedef struct DList
{
    DNode *DHead;
    DNode *DTail;
};
//============== KHAI BAO HAM ===============//
void init(DList &l);
DNode *Get_DNode(NhanVien x);
void InPutNV(NhanVien &x);
void OutPutNV(NhanVien x);
int Length(DList l);
void AddHead(DList &l, DNode *p);
void AddTail(DList &l,DNode *p);
void AddBefore(DList &l,DNode *q, DNode *new_ele);
void TLTatCa(DList l);
void InPut(DList &l, int n);
void OutPut(DList l);
void DeleteHead(DList &l);
void DeleteTail(DList &l);
void DeleteMaSV(DList &l, int ma);
void TLCaoNhat(DList l);
void TLTren2M(DList l);
void SXMNV(DList &l);

// =============== HAM MAIN =================//
int main()
{
    DList l;
    int chon;
    init(l);
    do{
		printf("\n--menu--\n");
		printf("        CHUONG TRINH LUAN LY NHAN VIEN      \n");
		printf("        1. Nhap danh sach nhan vien         \n");
		printf("        2. Hien danh sach nhan vien         \n");
		printf("        3. Them 1 nhan vien vao dau ds      \n");
		printf("        4. Tong luong tat ca nhan vien      \n");
		printf("        5. Xoa 1 nhan vien co Ma NV X       \n");
		printf("        6. Nhan vien co tong luong cao nhat \n");
		printf("        7. Nhan vien co tong luong tren 2tr \n");
		printf("        8. Sap xep nhan vien theo Ma NV     \n");
		printf("        0. Thoat                            \n");
		printf("********************************************\n");
		printf("         Hay chon chuc nang                 \n");
		printf("chon cv:");
		scanf("%d",&chon);
		switch(chon){
			case 1:{
				printf("Ban da chon nhap danh sach nhan vien\n");
				int c;
    			printf("Nhap so nhan vien: "); scanf("%d",&c);
			 	InPut(l,c);
			};break;
			case 2:{
				printf("Ban da chon xuat danh sach nhan vien\n");
				OutPut(l);}break;
			case 3:
			{
				printf("Ban da chon them 1 nhan vien vao dau danh sach\n");
                NhanVien x;
                DNode *p;
                InPutNV(x);
                p = Get_DNode(x);
                AddHead(l,p);
                printf("\nDa them xong!!");
			}break;
			case 4:
			{
				printf("Ban da chon tong luong tat ca nhan vien \n");
				TLTatCa(l);	
			}break;
			case 5:
			{
				printf("Ban da chon xoa nhan vien co Ma NV X trong danh sach\n");
				int ma;
				printf("Nhap Ma NV muon xoa:"); scanf("%d",ma);
				DeleteMaSV(l,ma);
				
			}break;
			case 6:
			{
				printf("Ban da chon hien nhan vien co tong luong cao nhat\n");
				TLCaoNhat(l);
				
			}break;
			case 7:
			{
				printf("Ban da chon hien nhan vien co tong luong tren 2000000\n");
				TLTren2M(l);
				
			}break;
			case 8:
			{
				printf("Ban da chon sap xep nhan vien theo MNV\n");
				SXMNV(l);
				
			}break;
		}
	}while(chon<10);
	OutPut(l);
	return 0;
}
//========== Khoi tao DSLK doi ===============//
void init(DList &l)
{
    l.DHead = NULL;
    l.DTail=NULL;
}
DNode *Get_DNode(NhanVien x)
{
    DNode *p;
    p = new DNode;
    p -> info = x;
    p -> next = NULL;
    p -> prev = NULL;
    return p;
}
//=========== Nhap xuat DSNV =================//
void InPutNV(NhanVien &x)
{
    printf("Nhap mnv: ");scanf("%d",&x.mnv);
    
    printf("Nhap ho ten: ");
    fflush(stdin);
    gets(x.hoten);
    
    printf("nhap ngay sinh(d/m/y):");scanf("%d/%d/%d",&x.ns.ngay,&x.ns.thang,&x.ns.nam);

    printf("Nhap tong luong: ");
    scanf("%f",&x.tl);
}

void OutPutNV(NhanVien x)
{
    printf("MNV: %d ",x.mnv);
    printf("\nHo ten: %-10s",x.hoten);
    printf("\nNgay sinh: %d/%d/%d",x.ns.ngay,x.ns.thang,x.ns.nam);
    printf("\nTong luong: %.2f",x.tl);
}
// =============== Dem so NV ==================//
int Length(DList l)
{
    int length = 0;
    for(DNode *p = l.DHead; p != NULL; p = p->next)
    {
        ++length;
    }
    return length;
}
//================ Ham them NV ===============//
void AddHead(DList &l, DNode *p)
{
    if(l.DHead==NULL)
    {
        l.DHead=p;
        l.DTail=l.DHead;
    }
    else
    {
        p->next=l.DHead;
        l.DHead->prev=p;
        l.DHead=p;
    }
}
void AddTail(DList &l,DNode *p)
{
    if(l.DHead==NULL)
    {
        l.DHead=p;
        l.DTail=l.DHead;
    }
    else
    {
        l.DTail->next=p;
        p->prev=l.DTail;
        l.DTail=p;
    }
}
void AddBefore(DList &l,DNode *q, DNode *new_ele)
{
    DNode *p;
    p=q->prev;
    if(q!=NULL)
    {
        new_ele-> next = q;
        if(p!=NULL)
        {
            new_ele->prev=p;
            p->next=new_ele;
        }
        q->prev=new_ele;
        if(q==l.DHead)
        {
            l.DHead=new_ele;
        }
        else
            AddTail(l,new_ele);
    }
}
void DeleteMaSV(DList &l, int ma){
	DNode *p = l.DHead;
	DNode *q = NULL;
	while(p != NULL){
		if(p->info.mnv == ma&& p == l.DHead) {
				DeleteHead(l);
				break;
		}
		if(p->info.mnv== ma && p == l.DTail){
				DeleteTail(l);
				break;
		}
		if(p->next->info.mnv== ma && p->next != NULL){
			q = p->next;
			p->next = q->next;
			delete(q);
			break;
		}
		p = p ->next;
	}
}
//================ Ham thinh tong luong =============//
void TLTatCa(DList l)
{
    float tongluong=0;
    for(DNode *p = l.DHead; p != NULL; p = p->next)
    {
        tongluong+=p->info.tl;

    }
    printf("Tong luong tat ca nhan vien la: %f", tongluong);
}
//=============== HAM NHAP XUAT DSNV ===================//
void InPut(DList &l, int n)
{
    init(l);
    NhanVien x;
    DNode *p;
    for (int i = 0; i < n; i++)
    {
        printf( "Sinh vien thu %d: ",i+1 );
        InPutNV(x);
        p = Get_DNode(x);
        AddTail(l, p);
    }
}

void OutPut(DList l)
{
    for(DNode *p = l.DHead; p != NULL; p = p->next)
    {
        OutPutNV(p -> info);
        printf("\n----------------------------\n");
    }
}
//================= HAM XOA  ==================//
void DeleteHead(DList &l)
{
    DNode *p;
    if(l.DHead!=NULL)
    {
        p=l.DHead;
        l.DHead=l.DHead->next;
        l.DHead->prev=NULL;
        delete p;
        if(l.DHead!=NULL)
        {
            l.DTail=NULL;
        }
    }

    printf("\nDa xoa xong!!");
}

void DeleteTail(DList &l)
{
    DNode *p;
    if(l.DTail!=NULL)
    {
        p=l.DTail;
        l.DTail=l.DTail->prev;
        l.DTail->next=NULL;
        delete p;
        if(l.DHead==NULL)
        {
            l.DTail=NULL;
        }
    }

    printf("\nDa xoa xong!!");
}
//======================================================//
void TLCaoNhat(DList l)
{
    if(l.DHead==NULL)
    {
        printf("\nDanh sach rong!!\n");
    }
    else
    {
        float cn =l.DHead->info.tl;
        for(DNode *p = l.DHead->next; p != NULL; p = p->next)
        {
            if(p->info.tl>cn)
            {
                cn=p->info.tl;
            }
        }
        printf("Danh sach nhan vien co luong cao nhat la: \n");
        for(DNode *p = l.DHead; p != NULL; p = p->next)
        {
            if(p->info.tl==cn)
            {
                OutPutNV(p->info);
            }
        }

    }
}
void TLTren2M(DList l)
{
    printf("Danh sach nhan vien co luong tren 2000000 la: \n");
    for(DNode *p = l.DHead; p != NULL; p = p->next)
    {
        if(p->info.tl>2000000)
        {
            OutPutNV(p->info);
        }
    }
}
//============= HAM SAP XEP THEO MA NV ==================//
void swap(NhanVien &x, NhanVien &y) {
	NhanVien tam = x;
	x = y;
	y = tam;
}
void SXMNV(DList &l)
{
    for(DNode *p = l.DHead; p != NULL; p = p->next)
    {
        for(DNode *q = p->next; q != NULL; q = q->next)
        {
            if(p->info.mnv>q->info.mnv){
                swap(p->info,q->info);
            }
        }
    }
    printf("\nDa sap xep xong!!\n");
}



