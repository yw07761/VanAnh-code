#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
struct sv
{
    char ten[20];
    char MSSV[10];
    int dtb;
};
struct NODE
{
    sv info;
    struct NODE* next;
};
struct LIST
{
    NODE *head;
    NODE *tail;
};
NODE* CreateNode (sv x)
{
    NODE *p;
    p=new NODE;
    if(p==NULL)  exit(1);
    p->info=x;
    p->next=NULL;
    return p;
}
void CreateList (LIST &L)
{
    L.head=L.tail=NULL;
}
void input (sv &x)
{
    printf("\nNhap MSSV: ");  fflush(stdin); gets(x.MSSV);
    printf("\nNhap ten: ");  fflush(stdin); gets(x.ten);   
    printf("\nNhap dtb: "); scanf("%d", &x.dtb);
}
void AddLast (LIST &L, NODE *p)
{
    if(L.head==NULL)  L.head=L.tail=p;
    else
    {
        L.tail->next=p;
        L.tail=p;
    }
}
void nhap (LIST &L)
{
    sv x;
    char kt;   
    printf("\nNhan phim bat ki de tiep tuc nhap.");
    printf("\nNhan 0 de dung nhap.");
    do
    {
        kt=getch();
        if(kt=='0')  break;
        input(x);
        NODE *p=CreateNode(x);
        AddLast(L,p);
    } while (1);
}
void output (sv x)
{
    printf("\n%s    %s      %d",x.MSSV,x.ten,x.dtb);
}
void xuat (LIST L)
{
    NODE *p;
    p=L.head;
    while(p!=NULL)
    {
        output(p->info);
        p=p->next;
    }
}
void maxdtb (LIST L)
{
    NODE *p,*max;
    int dem;
    p=L.head;
    max=p;
    while (p!=NULL)
    {
        if(p->info.dtb>max->info.dtb)  { max=p; dem=0; }
        if(p->info.dtb==max->info.dtb) { max=p; dem++; }
        p=p->next;
    }
    printf("\nSV co dtb cao nhat la: \n");
    if(dem==0)  output(max->info);
    else
    {
        NODE *q=L.head;
        while (q!=NULL)
        {
            if(q->info.dtb==max->info.dtb) output(q->info);
            q=q->next;
        }
    }
}
void thongkedtb (LIST L)
{
    NODE *p;
    int dem=0;
    p=L.head;
    while (p!=NULL)
    {       
        if(p->info.dtb>=5)  dem++;
        p=p->next;
    }
    if(dem==0)  printf("\nKo co sv co dtb>=5.");
    else printf("\nCo %d sv co dtb >=5.",dem);
}
void tim (LIST L)
{
    NODE *p;
    int dem=0;
    char k[20];
    printf("\nNhap ten sv can tim: ");
    fflush(stdin);
    gets(k);
    p=L.head;
    while (p!=NULL)
    {
        if(strcmp(k,p->info.ten)==0)      dem++;
        p=p->next;
    }
    if(dem!=0)
    {
            printf("\nTim thay sv: "); output(p->info);
    }
    else printf("\nKo tim thay.");
}
void xoa (LIST &L)
{
    NODE *p, *q;
    char a[10];
    p=L.head;
    q=NULL;
    printf("\nNhap MSSV can xoa: ");
    fflush(stdin);
    gets(a);
    while (p!=NULL)
    {
        if(strcmp(a, p->info.MSSV)==0)    break;
        else printf("\nKo co sv can xoa.");
        q=p;
        p=p->next;
    }
    if(q!=NULL)
    {
        if(p!=NULL)
        {
            q->next=p->next;
            delete (p);
            if(p==L.tail)  L.tail=q;
            delete(p);
        }
    }
    else
    {
        L.head=p->next;
        delete(p);
        if(L.head==NULL)  L.tail=NULL;
    }
}
void selectionsort (LIST &L)
{
    NODE *p,*q,*min;
    p=L.head;
    sv temp;
    while (p!=L.tail)
    {
        min=p;
        q=p->next;
        while (q!=NULL)
        {
            if(q->info.dtb<min->info.dtb)  min=q;
            q=q->next;
        }
        temp=p->info;
        p->info=min->info;
        min->info=temp;
        p=p->next;
    }
}
void menu()
{
    LIST L;
    NODE *p,*q,*moi;
    sv x;
    char chon;
    CreateList(L);
    do
    {
        printf("\n\t\t\tMENU");
        printf("\n\t1. Nhap ds");
        printf("\n\t2. In ds");
        printf("\n\t3. Ds sv co dtb cao nhat");
        printf("\n\t4. Ds sv co dtb >=5");
        printf("\n\t5. Tim sv");
        printf("\n\t6. Xoa sv");
        printf("\n\t7. Sap xep ds");
        printf("\n\t8. Chen sv");
        printf("\n\tNhap 0 de thoat");
        chon=getch();
        switch(chon)
        {
            case '1': { nhap(L); break;}
            case '2': { xuat(L); break;}
            case '3': { maxdtb(L); break;}
            case '4': { thongkedtb(L); break;}
            case '5': { tim(L); break;}
            case '6': { xoa(L); printf("\nDs sau khi xoa: "); xuat(L); break;}
            case '7': { selectionsort(L);printf("\nDs sau khi sap xep: "); xuat(L); break;}
            case '8':
                    {
                        sv them;
                        printf("\nNhap thong tin sv can them: ");
                        input(them);
                        NODE *t= CreateNode(them);
                        AddLast(L,t);
                        selectionsort(L);
                        printf("\nDs sau khi them :");
                        xuat(L);
                        break;
                    }
            case '0': exit(1);
            default: printf("\nNhap lai.");
        }
    } while (chon!='0');
}
int main()
{
    while(1)
    {
        menu();
        getch();
    }
}