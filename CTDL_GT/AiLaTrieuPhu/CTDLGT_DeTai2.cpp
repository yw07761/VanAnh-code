#include <stdio.h>
#include<conio.h>
#include <stdlib.h>
#include<time.h>
#include <string.h>
#include <iostream>
#define _WIN32_WINNT 0x0500
#include<windows.h>

int RED = 140;
int WHITE = 15;
int BLUE = 57;
int WIDTH = 700;
int HEIGHT = 500;
int WRONG = 12;
int WRIGHT = 10;
int YELLOW = 14;
int SoCauDatDuoc=0;

// Su dung thu vien Window.h de goi duoc toa do cua x , y tren console . Giup di chuyen chuyen den vi tri bat ki tren console

void textcolor(int x)
{
    HANDLE mau;
    mau = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleTextAttribute(mau, x);
}

//---------------------------------------------------------------------------------//
void resizeConsole(int width, int height)
{
    HWND console = GetConsoleWindow();
    RECT r;
    GetWindowRect(console, &r);
    MoveWindow(console, r.left, r.top, width, height, TRUE);
}

void gotoxy(int x, int y)
{
    HANDLE hConsoleOutput;
    COORD Cursor_an_Pos = { x , y  };
    hConsoleOutput = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(hConsoleOutput, Cursor_an_Pos);
}
void XoaTaiToaDo(int x,int y)
{
    gotoxy(x,y);
    for(int i=0; i<80; i++)
        printf(" ");

}
//==============================KHAI BAO==================================//
struct CauHoi
{
    char cauHoi[500];
    char dapAnA[100];
    char dapAnB[100];
    char dapAnC[100];
    char dapAnD[100];
    int ketQua;
};
struct Node
{
    CauHoi data;
    Node*link;
};
struct List
{
    Node*first;
    Node*last;
};
//==================================================================//
void init(List &l)
{
    l.last=l.first=NULL;
}
Node*getNode(CauHoi	c)
{
    Node*p;
    p=new Node;
    if(p==NULL)
        return NULL;
    p->data=c;
    p->link=NULL;
    return p;
}
void addLast(List &l,Node *p)
{
    if(l.first==NULL)
    {
        l.first=l.last=p;
    }
    else
    {
        l.last->link=p;
        l.last=p;
    }
}
//=================================DOC FILE================================//
void doc_File(CauHoi &c,FILE *f)
{
    char *ch=new char[1000];
    char *str;
    fgets(ch,1000,f);
    //fgets() doc 1 dong ky tu tu` file (f) da cho truoc
    str= strtok(ch,",");
    //Ham strtok(string token) nhan vao mot chuoi string (ch), trong do no se tim ky tu tach chuoi bat dau tu` ky' tu. dau` tien cua chuoi nhap vao
    strcpy(c.cauHoi,str);
    //Tu` loi` goi thu 2,ham strtok muon nhan vao NULL de co the tiep tuc tim` kiem' tu` vi tri' ket thuc truoc do.Chu' ko bat dau` lai tu` dau`.
    str=strtok(NULL,",");
    strcpy(c.dapAnA,str);
    str=strtok(NULL,",");
    strcpy(c.dapAnB,str);
    str=strtok(NULL,",");
    strcpy(c.dapAnC,str);
    str=strtok(NULL,",");
    strcpy(c.dapAnD,str);
    str=strtok(NULL,",");
    c.ketQua=atoi(str);
}
void doc_DS_CauHoi(List &l){
	FILE *f;
	CauHoi c;
	init(l);
	int a;
	srand(time(NULL));
	a=rand()%2;
	if(a==1){
	f=fopen("boCauHoi1.txt","r"); //Doc file voi mode "r": Mo 1 file de doc.File phai ton tai	
	}else{
	f=fopen("boCauHoi2.txt","r");	
	}
	if(f==NULL){
		printf("\nFile khong ton tai");
	}else{
		while(!feof(f))// eof = end of file, khi nao chua gap ki tu ket thuc(eof) thi se con thuc hien doc ky' tu trong file
		{
			doc_File(c,f);
			Node *p = getNode(c);
			addLast(l,p);
		}
	}
	fclose(f);//Dong file
	printf("\n");
}
//=========================================================================//
void XuatA(char s[])
{

    gotoxy(0,10);
    printf("%s", s);
}

void XuatB(char s[])
{

    gotoxy(42,10);
    printf("%s", s);
}

void XuatC(char s[])
{

    gotoxy(0,15);
    printf("%s", s);
}

void XuatD(char s[])
{

    gotoxy(42,15);
    printf("%s", s);
}

void XuatCauHoi(CauHoi x)
{

    printf("%s ", x.cauHoi);
    XuatA(x.dapAnA);
    XuatB(x.dapAnB);
    XuatC(x.dapAnC);
    XuatD(x.dapAnD);
}
void xuat1CH(CauHoi x)
{
    printf("%s\n",x.cauHoi);
    printf("%s\n",x.dapAnA);
    printf("%s\n",x.dapAnB);
    printf("%s\n",x.dapAnC);
    printf("%s\n",x.dapAnD);
    printf("Dap An(1-4 tuong ung voi A,B,C,D): %d\n",x.ketQua);
}
void xuatDanhSach(List l)
{
	doc_DS_CauHoi(l);
    Node *p = l.first;
    while(p != NULL)
    {
        xuat1CH(p->data);
        p = p->link;
        
    }
}

void nhapCauHoi(CauHoi &c)
{
    printf("Nhap cau hoi: ");
    fflush(stdin);
    gets(c.cauHoi);
    printf("Nhap dap an A: ");
    fflush(stdin);
    gets(c.dapAnA);
    printf("Nhap dap an B: ");
    fflush(stdin);
    gets(c.dapAnB);
    printf("Nhap dap an C: ");
    fflush(stdin);
    gets(c.dapAnC);
    printf("Nhap dap an D: ");
    fflush(stdin);
    gets(c.dapAnD);
    printf("Nhap dap an dung(1-4 tuong ung voi dap an A-B-C-D): ");
    scanf("%d", &c.ketQua);
}
//=============================QUYEN TRO GIUP================================//
void Help_50_50(CauHoi &c,boolean &tg1)
{

    if(tg1==false)
    {
        printf("\n Quyen tro giup nay da duoc su dung!");
        return;
    }
    else
    {
        int a, b;
        gotoxy(0,25);
        printf("\n Hai dap an sai la: ");
        do
        {
            srand(time(NULL));
            a=rand()%4;
            b=rand()%4;
        }
        while(a==0||a==c.ketQua||b==0||b==c.ketQua||b==a);
        if(a==1&&b==2)
            printf("A va B");
        if(a==1&&b==3)
            printf("A va C");
        if(a==1&&b==4)
            printf("A va D");
        if(a==2&&b==1)
            printf("A va B");
        if(a==3&&b==1)
            printf("A va C");
        if(a==4&&b==1)
            printf("A va D");
        //=============================
        if(a==2&&b==3)
            printf("B va C");
        if(a==2&&b==4)
            printf("B va D");
        if(a==3&&b==2)
            printf("B va C");
        if(a==4&&b==2)
            printf("B va D");
        //=============================
        if(a==3&&b==4)
            printf("C va D");
        if(a==4&&b==3)
            printf("C va D");
        //=============================
        if(a==1||b==1)
            strcpy(c.dapAnA, "");//Sao chep chuoi, "" day là chuoi duoc sao chep,
        //	c.dapanA Day la con tro den mang dich noi noi dung  se duoc sao chep
        if(a==2||b==2)
            strcpy(c.dapAnB, "");
        if(a==3||b==3)
            strcpy(c.dapAnC, "");
        if(a==4||b==4)
            strcpy(c.dapAnD, "");
        tg1=false;//Bien ho tro tuong ung duoc gan bang false
    }
}

void goiDienNguoiThan(CauHoi &q, boolean &tg2)
{
    if(tg2==false)
    {
        printf("\n Quyen tro giup nay da duoc su dung!");
        return;
    }
    else
    {
        int kq;
        if(q.ketQua == 1 )
            kq = 1;
        if(q.ketQua == 2)
            kq = 2;
        if(q.ketQua == 3)
            kq = 3;
        if(q.ketQua == 4)
            kq = 4;

        gotoxy(0,25);
        srand(time(NULL));
        int a =rand()%4;
        if(a==1)
        {
            printf("\nDap an la A, uy tin luon");
        }
        else if(a==2)
        {
            printf("\nToi nghi dap an la B");
        }
        else if(a==3)
        {
            printf("\nToi chac chan la C");
        }
        else
            printf("\nDap an la D, tin toi di");
    }
}

void hoiYKienKhanGia(CauHoi &q, boolean &tg3)
{
    if(tg3==false)
    {
        printf("\n Quyen tro giup nay da duoc su dung!");
        return;
    }
    else
    {
        int kq;
        if(q.ketQua == 1 )
            kq = 1;
        if(q.ketQua == 2)
            kq = 2;
        if(q.ketQua == 3)
            kq = 3;
        if(q.ketQua == 4)
            kq = 4;

        gotoxy(0,25);
        int rd,rd1, rd2, rd3;
        srand(time(NULL));
        do
        {
            rd = rand() % 80 + 1;
            rd1 = rand() % (100 - rd) + 1;
            int r = rd + rd1;
            rd2 = rand() % (100 - r) + 1;
            r = rd + rd1 + rd2;
            rd3 = 100 - r;
        }
        while (rd < 50 || rd + rd1 + rd2 + rd3 != 100);
        if (kq==1)
        {

            printf("%d phan tram khan gia lua chon A\n%d phan tram khan gia lua chon B\n%d phan tram khan gia lua chon C\n%d phan tram khan gia lua chon D "
                   ,rd,rd1,rd2,rd3 );
        }
        if (kq==2)
        {
            printf("%d phan tram khan gia lua chon A\n%d phan tram khan gia lua chon B\n%d phan tram khan gia lua chon C\n%d phan tram khan gia lua chon D "
                   ,rd1,rd,rd2,rd3 );
        }
        if (kq == 3)
        {
            printf("%d phan tram khan gia lua chon A\n%d phan tram khan gia lua chon B\n%d phan tram khan gia lua chon C\n%d phan tram khan gia lua chon D "
                   ,rd1,rd2,rd,rd3 );
        }
        if (kq == 4)
        {
            printf("%2d phan tram khan gia lua chon A\n%2d phan tram khan gia lua chon B\n%2d phan tram khan gia lua chon C\n%2d phan tram khan gia lua chon D "
                   ,rd1,rd2,rd3,rd );
        }
    }
}

//================================MUC TIEN======================================//
void tienthuong()
{
    Beep(3000,200);
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t| SO TIEN QUA MOI CAU HOI   |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t| Cau 15: 150,000,000 DONG  |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 14: 85,000,000 DONG  |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 13: 60,000,000 DONG  |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 12: 40,000,000 DONG  |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 11: 30,000,000 DONG  |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 10: 22,000,000 DONG  |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 9:  14,000,000 DONG  |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 8:  10,000,000 DONG  |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 7:  6,000,000 DONG   |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 6:  3,000,000 DONG   |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 5:  2,000,000 DONG   |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 4:  1,000,000 DONG   |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 3:  600,000  DONG    |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 2:  400,000  DONG    |\n");
    printf("\t\t\t|===========================|\n");
    printf("\t\t\t|  Cau 1:  200,000  DONG    |\n");
    printf("\t\t\t|===========================|\n");
}
//------------------------------ TINH TIEN --------------------------------//
void tinhdiem(int x, int &diem)
{
    switch(x)
    {
    case 1:
        diem+=200000;
        break;
    case 2:
        diem+=200000;
        break;
    case 3:
        diem+=200000;
        break;
    case 4:
        diem+=400000;
        break;
    case 5:
        diem+=1000000;
        break;
    case 6:
        diem+=1000000;
        break;
    case 7:
        diem+=3000000;
        break;
    case 8:
        diem+=4000000;
        break;
    case 9:
        diem+=4000000;
        break;
    case 10:
        diem+=8000000;
        break;
    case 11:
        diem+=8000000;
        break;
    case 12:
        diem+=10000000;
        break;
    case 13:
        diem+=20000000;
        break;
    case 14:
        diem+=25000000;
        break;
    case 15:
        diem+=65000000;
        break;
    }
}

void intienthuong(int diem)
{

    printf("\n\t\tTIEN THUONG CUA BAN LA: %d", diem);
    Sleep(5000);

}
void InSoTienDatDuoc(int m)
{
    gotoxy(70,0);
    textcolor(YELLOW);
    printf("%d VND",m);
    textcolor(WHITE);
}
//=======================KIEM TRA DAP AN=============================//
void DoiMauKetQua(CauHoi qs,int mau, int tl)
{
    textcolor(mau);
    if(tl == 1 )
    {
        XuatA(qs.dapAnA);
    }
    else if(tl == 2 )
    {
        XuatB(qs.dapAnB);
    }
    else if(tl == 3)
    {
        XuatC(qs.dapAnC);
    }
    else if(tl == 4)
    {
        XuatD(qs.dapAnD);
    }
}

int KiemTraDungSai(CauHoi qs, int tl)
{
    if(tl >= 'a')
        tl = tl - 32;
    if(qs.ketQua == tl)
    {
        //Right
        DoiMauKetQua(qs,WRIGHT,tl);
        Sleep(1000);
        return 1;
    }
    else
    {
        //Wrong
        //Doi mau cau dung
        DoiMauKetQua(qs,WRIGHT,qs.ketQua);
        Sleep(1000);
        //Doi mau cau sai
        DoiMauKetQua(qs,WRONG,tl);
        Sleep(1000);
        return 0;
    }
    textcolor(WHITE);
}


//========================= MENU TRO GIUP ============================//
void QuyenTroGiup(CauHoi &q,boolean &tg1, boolean &tg2, boolean &tg3)
{
    Beep(3000,200);
    gotoxy(0,20);
    printf("\tQUYEN TRO GIUP           \n");
    printf("1. 50:50                     \n");
    printf("2. Goi dien cho nguoi than   \n");
    printf("3. Y kien khan gia           \n");
    printf("Hay chon 1 quyen tro giup (neu khong muon hay nhan '0' de tra loi):\n");
    int chon;
    scanf("%d",&chon);
    while(chon<0||chon>4);
    switch(chon)
    {
    case 1:
    {
        XoaTaiToaDo(0,25);
        XoaTaiToaDo(0,24);
        Help_50_50(q,tg1);
        chon = 0;
    }
    break;
    case 2:
    {

        goiDienNguoiThan(q,tg2);
        chon = 0;


    }
    break;
    case 3:
    {
        hoiYKienKhanGia(q,tg3);
        chon = 0;


    }
    break;
    }
    while(chon=0);

}
//===============================CAU HOI=====================================//
int goicauhoi(List l, int x, boolean &tg1, boolean &tg2, boolean &tg3)
{
    int a;
    CauHoi c=l.first->data;
quaylai:
    if(x<15)
    {
        gotoxy(0,7);
        printf("\nCau hoi so %d: ", x);
    }
    else
    {
        printf("\nCau hoi so %d:", x);
    }
    XuatCauHoi(c);

    do
    {
        printf("\n De xem quyen tro giup: Nhan 0");
        printf("\n Answer (1-4 tuong ung voi dap an A-B-C-D):\t");
        printf("\n Tra loi: ");
        scanf("%d", &a);
        if(tg1==false && tg2== false && tg3==false && a==0)
        {
            printf("\nBan da su dung het quyen tro giup cua minh!");
            goto quaylai;
        }
    }
    while(a<0||a>5);
    switch(a)
    {
    case 0:
        system("cls");
        QuyenTroGiup(c, tg1, tg2, tg3);

        goto quaylai;
        break;
    case 1:
    case 2:
    case 3:
    case 4:
    {
        if(KiemTraDungSai(c,a))
            return 1;
        else
            return 0;
    }
    break;


    }
}

//============================ CHE DO CHOI GAME ======================//
void Gaming(List l,boolean &tg1, boolean &tg2, boolean &tg3)
{
    system("cls");
    doc_DS_CauHoi(l);
    tienthuong();
    Sleep(1000);
    system("cls");
    Node *q=l.first;
    int x=1;
    int diem=0;
    int luaChon,a ,b, c;
    while(l.first!=NULL)
    {
        srand(time(NULL));
        c=rand()%2;
        if(c==1)
        {
            l.first=l.first->link;
        }
        InSoTienDatDuoc(diem);
        int kq=goicauhoi(l, x, tg1, tg2, tg3);
        {
            if(kq==1)
            {
                system("cls");
                gotoxy(0,13);
                printf("\n\t\tChinh xac, xin chuc mung!");
                tinhdiem(x, diem);
                gotoxy(0,14);
                printf("\n\t SO TIEN HIEN TAI CUA BAN LA: %d", diem);
                Sleep(1000);
                gotoxy(0,15);
                printf("\n\tNhan 1 de choi tiep hoac 0 de dung cuoc choi: ");
                scanf("%d", &a);
                while(a<0||a>1);
                if(a==0)
                {
                	system("cls");
                	gotoxy(0,12);
                	printf("\n\t\t Cam on ban da den voi chuong trinh!!");
                    gotoxy(0,13);
                    intienthuong(diem);
                    gotoxy(0,14);
                    printf("\n\t\t Nhan so bat ki de thoat!!");
                    scanf("%d", &b);
                    goto end;
                }

                if(x==15)
                {
                    system("cls");
                    gotoxy(36,12);
                    printf("\n\tTHANG CUOC                   ");
                    gotoxy(0,13);
                    intienthuong(diem);
                    gotoxy(0,14);
                    printf("\n Nhan so bat ki de thoat!!");
                    scanf("%d", &b);
                    goto end;
                }
                x++;
            }
            else if(kq==0)
            {
                system("cls");
                gotoxy(36,13);
                printf("END GAME!!");
                Beep(100,900);
                gotoxy(0,14);
                printf("\n\t\tRat tiec cau tra loi cua ban khong chinh xac");
                Sleep(1000);
                if(x<=5)
                {
                    diem = 0;
                    gotoxy(0,15);
                    intienthuong(diem);
                    gotoxy(0,16);
                    printf("\n\t\tNhan so bat ki de thoat!!");
                    scanf("%d", &b);
                    goto end;
                }
                else if(x<=10)
                {
                    diem = 2000000;
                    gotoxy(0,15);
                    intienthuong(diem);
                    gotoxy(0,16);
                    printf("\n\t\tNhan so bat ki de thoat!!");
                    scanf("%d", &b);
                    goto end;
                }
                else
                {
                    diem = 22000000;
                    gotoxy(0,15);
                    intienthuong(diem);
                    gotoxy(0,16);
                    printf("\n\t\tNhan so bat ki de thoat!!");
                    scanf("%d", &b);
                    goto end;
                }
            }
            else
            {
                gotoxy(0,15);
                intienthuong(diem);
                gotoxy(0,16);
                printf("\n\t\tNhan so bat ki de thoat!!");
                scanf("%d", &b);
                goto end;
            }


            textcolor(WHITE);
            q = q->link;
            system("cls");
            l.first=l.first->link;
        }
    }
end:
    ;
}
//=============================== CHUC NANG ===========================//
void timKiem(List &l)
{	
	doc_DS_CauHoi(l);
	char ch[100];
	printf("Nhap cau hoi: ");
    fflush(stdin);
    gets(ch);
	int check = 0;
	for (Node *p = l.first; p != NULL; p = p->link)
	{
		if(strcmp(p->data.cauHoi,ch) == 0)
	{
			printf("Cau Hoi :%s \n",  p->data.cauHoi);
			printf("A:%s\n", p->data.dapAnA);
			printf("B:%s\n", p->data.dapAnB);
			printf("C:%s\n", p->data.dapAnC);
			printf("D:%s\n", p->data.dapAnD);
			printf("D:%s\n", p->data.ketQua);
			check = 1;
		}
	}
	if (check == 0)
	{
		printf("Khong Tim Thay\n");
	}
}
void themCauHoi(List ds)
{
    system("cls");
    CauHoi ch;
    int a;
    FILE *fp;
    fp=fopen("CauHoi.txt","a"); //Mode "a" hoat dong ghi, phu. them du lieu lai cuoi file. File duoc tao neu no chua ton tai

    while(true)
    {
        nhapCauHoi(ch);
        fprintf(fp,"\n");
        fprintf(fp, "%s,%s,%s,%s,%s,%d", ch.cauHoi, ch.dapAnA, ch.dapAnB, ch.dapAnC, ch.dapAnD, ch.ketQua);
        printf("\nDA THEM THANH CONG! ");
        do
        {
            printf("\n Nhap tiep: nhan 1\n Thoat: nhan 0\nLua chon cua ban:");
            scanf("%d", &a);
        }
        while(a<0||a>1);
        if(a==0)
            break;
    }
    fclose(fp);
}
//========================== CHE DO DIEU KHIEN ==========================//
void Admin(List ds)
{
    printf("---Vui Long Chon---\n");
    printf("\t1.Them cau hoi moi\n");
    printf("\t2.Xuat danh sach cau hoi\n");
	printf("\t3.Tim kiem cau hoi\n");
	
	CauHoi ch;
	int n;
    char c[100];
    int chon;
    scanf("%d",&chon);
    switch(chon)
    {
    case 1:
   	     system("cls");
    	 themCauHoi(ds);
 		 break;
    case 2:
  		 system("cls");
   		 xuatDanhSach(ds);
		 Sleep(10000);	
  		 break;
	case 3:
    	system("cls");
        timKiem(ds);
		Sleep(5000);				
        break;
    }
    while(chon!=3);
}
//========================== Huong dan ===========================//
void huongDan()
{
	system("cls");
 	printf("|=========================================================================|\n");
    printf("|                         HUONG DAN                                       |\n");
    printf("|=========================================================================|\n");
  	printf("|VUOT QUA DUOC 15 CAU HOI CUA CHUONG TRINH BAN SE NHAN DUOC 150 TRIEU DONG|\n");
  	printf("|                     BAN CO CAC QUYEN TRO GIUP                           |\n");
  	printf("|=========================================================================|\n");
  	printf("|1. GOI DIEN THOAI CHO NGUOI THAN                                         |\n");
	printf("|  BAN CO 30S DE GOI DIEN THOAI NHO SU GIUP SO CUA NGUOI THAN             |\n");	
 	printf("|=========================================================================|\n");
  	printf("|2. TRO GIUP 50/50                                                        |\n");
  	printf("|  MAY TINH SE TU DONG LOAI BO HAI PHUONG AN SAI                          |\n");
  	printf("|=========================================================================|\n");
  	printf("|3. HOI Y KIEN KHAN GIA                                                   |\n");
  	printf("|  NHAN DUOC KET QUA: PHAN TRAM SO KHAN GIA LUA CHON PHUONG AN            |\n");
  	printf("|=========================================================================|\n");
  	
  	
  	printf("\n|=========================================================================|\n");
  	printf("|                       CACH TINH DIEM                                    |\n");
  	printf("|=========================================================================|\n");
  	printf("|1. NEU BAN QUYET DINH DUNG CUOC CHOI O CAU HOI NAO DO: SO TIEN CUA BAN   |\n");
  	printf("|SE DUOC TINH LA SO TIEN TUONG UNG VOI MOC TIEN CUA CAU HOI DO            |\n");
 	printf("|=========================================================================|\n");
  	printf("|2. NEU BAN TRA LOI SAI SE QUAY VE MOC GAN NHAT 0 - 5 - 10 - 15 MA BAN DA |\n");
  	printf("|TRA LOI DUOC TUONG UNG VOI SO TIEN 0-2 TRIEU-22 TRIEU-150 TRIEU          |\n");
  	printf("|=========================================================================|\n");
  	
  	
  	Sleep(12000);
}
//=========================== MAIN ==============================//
int main(int argc, char *argv[])
{

    List ds;
    init(ds);
    boolean tg1=true;
    boolean tg2=true;
    boolean tg3=true;
    int chon;
    do
    {

        printf("\n\n\n|==============================================================================|\n");
        printf("|               CHAO MUNG BAN DEN VOI TRO CHOI AI LA TRIEU PHU                 |\n");
        printf("|==============================================================================|\n\n");
        printf("|==============================================================================|\n");
        printf("|                               1. Choi game                                   |\n");
        printf("|==============================================================================|\n");
        printf("|==============================================================================|\n");
        printf("|                               2. Huong dan                                   |\n");
        printf("|==============================================================================|\n");
        printf("|==============================================================================|\n");
        printf("|                               3. Quan ly                                     |\n");
        printf("|==============================================================================|\n");
        printf("|==============================================================================|\n");
        printf("|                               4. Thoat                                       |\n");
        printf("|==============================================================================|\n");
        do
        {
            printf("\n CHON MUC : ");
            scanf("%d", &chon);
            if(chon<1||chon>4)
                printf(" Lua chon khong phu hop vui long chon lai \n");
        }
        while(chon<1 && chon>4);
        switch(chon)
        {
        case 1:
            Beep(3000,200);
            tg1=true;
            tg2=true;
            tg3=true;
            Gaming(ds,tg1,tg2,tg3);
            break;
        case 2:
        	system("cls");
        	Beep(3000,200);
        	huongDan();
        	break;
        case 3:
            system("cls");
            Beep(3000,200);
            Admin(ds);
            break;

        }
        system("cls");
    }
    while(chon!=4);
    return 0;

}
