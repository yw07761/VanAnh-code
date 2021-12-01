#include<iostream>
using namespace std;
#include<string>
#include<fstream>

// khai b�o c?u tr�c ng�y th�ng nam sinh
struct date
{
	int ngay;
	int thang;
	int nam;
};
typedef struct date DATE;

// h�m d?c d? li?u ng�y th�ng nam t? file
void Doc_Ngay_Thang_Nam(ifstream &filein, DATE &date)
{
	filein >> date.ngay;
	filein.seekg(1, 1); // d?ch sang ph?i 1 byte d? b? qua k� t? '/'
	filein >> date.thang;
	filein.seekg(1, 1); // d?ch sang ph?i 1 byte d? b? qua k� t? '/'
	filein >> date.nam;
}

// khai b�o c?u tr�c sinh vi�n
struct sinhvien
{
	string hoten;
	string masv;
	DATE ngaysinh;
	float dtb;
};
typedef struct sinhvien SINHVIEN;

// khai b�o c?u tr�c 1 c�i node sinh vi�n
struct node
{
	SINHVIEN data; // d? li?u c?a node
	struct node *pNext; // con tr? d�ng d? li�n k?t gi?a c�c c�i node v?i nhau
};
typedef struct node NODE;

// ========== KHAI B�O C?U TR�C DANH S�CH LI�N K?T �ON C�C SINH VI�N =========

struct list
{
	NODE *pHead;
	NODE *pTail;
};
typedef struct list LIST;

// h�m kh?i t?o danh s�ch li�n k?t don c�c sinh vi�n
void KhoiTaoDanhSach(LIST &l)
{
	l.pHead = NULL;
	l.pTail = NULL;
}

// h�m kh?i t?o 1 c�i node d? chu?n b? th�m v�o danh s�ch
NODE *KhoiTaoNode(SINHVIEN x)
{
	NODE *p = new NODE;
	if (p == NULL)
	{
		cout << "\nCap phat that bai !";
		return NULL;
	}
	p->data = x; // dua d? li?u c?a bi?n sinh vien x v�o data c?a c�i Node p
	p->pNext = NULL; // kh?i t?o node p nhung node p chua c� li�n k?t d?n node n�o h?t
	return p;
}

// h�m th�m 1 c�i node sinh vi�n v�o d?u danh s�ch
void ThemDau(LIST &l, NODE *p)
{
	// n?u danh s�ch r?ng
	if (l.pHead == NULL)
	{
		l.pHead = l.pTail = p; // node p th�m v�o cung ch�nh l� node d?u v� node cu?i
	}
	else
	{
		p->pNext = l.pHead; // cho con tr? p tr? d?n pHead
		l.pHead = p; // c?p nh?t l?i pHead l� node p
	}
}

// h�m th�m 1 c�i node sinh vi�n v�o cu?i danh s�ch
void ThemCuoi(LIST &l, NODE *p)
{
	// n?u danh s�ch r?ng
	if (l.pHead == NULL)
	{
		l.pHead = l.pTail = p; // node p th�m v�o cung ch�nh l� node d?u v� node cu?i
	}
	else
	{
		l.pTail->pNext = p; // cho con tr? c?a pTail tr? d?n node p
		l.pTail = p; // c?p nh?t l?i pTail ch�nh l� node p
	}
}

// h�m d?c d? li?u 1 sinh vi�n t? file
void Doc_Thong_Tin_1_Sinh_Vien(ifstream &filein, SINHVIEN &sv)
{
	// d?c h? t�n sinh vi�n
	getline(filein, sv.hoten, ','); // d?c d?n d?u ',' th� d?ng
	filein.seekg(1, 1); // t?i v? tr� hi?n t?i d?ch sang ph?i 1 byte d? b? kho?ng tr?ng ' '
	// d?c m� sinh vi�n
	getline(filein, sv.masv, ','); // d?c d?n d?u ',' th� d?ng
	filein.seekg(1, 1); // t?i v? tr� hi?n t?i d?ch sang ph?i 1 byte d? b? kho?ng tr?ng ' '
	// d?c th�ng tin ng�y th�ng nam sinh
	Doc_Ngay_Thang_Nam(filein, sv.ngaysinh);
	filein.seekg(2, 1); // t?i v? tr� hi?n t?i d?ch sang ph?i 2 byte d? b? d?u ph?y v� kho?ng tr?ng ' '
	// d?c di?m trung b�nh
	filein >> sv.dtb;

	// t?o bi?n t?m d? d?c c�i k� t? xu?ng d�ng ? cu?i d�ng
	string temp;
	getline(filein, temp);
}

// h�m d?c danh s�ch sinh vi�n t? file
void Doc_Danh_Sach_Sinh_Vien(ifstream &filein, LIST &l)
{
	// d?c d?n cu?i file th� d?ng
	while (!filein.eof())
	{
		// BU?C 1: �?C TH�NG TIN SINH VI�N
		SINHVIEN sv;
		Doc_Thong_Tin_1_Sinh_Vien(filein, sv);
		// BU?C 2: KH?I T?O 1 C�I NODE SINH VI�N
		NODE *p = KhoiTaoNode(sv);
		// BU?C 3: TH�M SINH VI�N(th�m node p) V�O DANH S�CH LI�N K?T �ON C�C SINH VI�N
		ThemCuoi(l, p);
	}
}

// h�m xu?t d? test d? li?u
void Xuat(SINHVIEN sv)
{
	cout << "\nHo ten:" << sv.hoten;  
	cout << "\nMa sinh vien:" << sv.masv;
	cout << "\nNgay sinh:" << sv.ngaysinh.ngay << "/" << sv.ngaysinh.thang << "/" << sv.ngaysinh.nam;
	cout << "\nDiem trung binh:" << sv.dtb;
}

// h�m xu?t danh s�ch sinh vi�n
void Xuat_Danh_Sach_Sinh_Vien(LIST l)
{
	int dem = 1;
	for (NODE *k = l.pHead; k != NULL; k = k->pNext)
	{
		cout << "\n\n\t\t SINH VIEN THU " << dem++;
		Xuat(k->data);
	}
}

int main()
{
	LIST l;
	KhoiTaoDanhSach(l);
	// m? file l�n
	ifstream filein;
	filein.open("SINHVIEN.TXT", ios::in);
	Doc_Danh_Sach_Sinh_Vien(filein, l);
	Xuat_Danh_Sach_Sinh_Vien(l);

	filein.close();
	system("pause");
	return 0;
}