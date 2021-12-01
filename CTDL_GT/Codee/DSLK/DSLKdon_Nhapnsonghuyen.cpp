#include<iostream>
using namespace std;



// ========== KHAI B�O C?U TR�C 1 C�I NODE ==========
struct node
{
	int data; // d? li?u c?a node
	struct node *pNext; // con tr? d�ng d? li�n k?t gi?a c�c c�i node v?i nhau
};
typedef struct node NODE;

// ========== KHAI B�O C?U TR�C DANH S�CH LI�N K?T �ON =========

struct list
{
	NODE *pHead;
	NODE *pTail;
};
typedef struct list LIST;


// h�m kh?i t?o danh s�ch li�n k?t don
void KhoiTaoDanhSach(LIST &l)
{
	l.pHead = NULL;
	l.pTail = NULL;
}
// h�m kh?i t?o 1 c�i node d? chu?n b? th�m v�o danh s�ch
NODE *KhoiTaoNode(int x)
{
	NODE *p = new NODE;
	if (p == NULL)
	{
		cout << "\nCap phat that bai !";
		return NULL;
	}
	p->data = x; // dua d? li?u c?a bi?n x v�o data c?a c�i Node p
	p->pNext = NULL; // kh?i t?o node p nhung node p chua c� li�n k?t d?n node n�o h?t

	return p;
}

// h�m th�m 1 c�i node v�o d?u danh s�ch
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

// h�m th�m 1 c�i node v�o cu?i danh s�ch
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

// h�m th�m node p sau node q <=> n?u node p b?ng node q ?????
void ThemNode_p_SauNode_q(LIST &l, NODE *p)
{
	int x;
	cout << "\nNhap node q: ";
	cin >> x;
	NODE *q = KhoiTaoNode(x);

	// duy?t t? d?u danh s�ch d? t�m node q c?n th�m v�o sau 
	for (NODE *k = l.pHead; k != NULL; k = k->pNext)
	{
		if (k->data == q->data)
		{
			NODE *g = KhoiTaoNode(p->data);
			g->pNext = k->pNext; // cho node p c?n th�m v�o sau node q tr? d?n node n?m sau node k <=> c?p nh?t m?i li�n k?t
			k->pNext = g; // cho node q - cung ch�nh l� node k tr? d?n node p
		}
	}
}

// h�m th�m node p tru?c node q <=> n?u node p b?ng node q ?????
void ThemNode_p_TruocNode_q(LIST &l, NODE *p)
{
	int x;
	cout << "\nNhap node q: ";
	cin >> x;
	NODE *q = KhoiTaoNode(x);

	NODE *h = new NODE;
	// duy?t t? d?u danh s�ch d? t�m node q c?n th�m v�o sau 
	for (NODE *k = l.pHead; k != NULL; k = k->pNext)
	{
		if (k->data == q->data)
		{
			NODE *g = KhoiTaoNode(p->data);
			g->pNext = k; // cho node p c?n th�m v�o sau node q tr? d?n node n?m sau node k <=> c?p nh?t m?i li�n k?t
			h->pNext = g; // cho node q - cung ch�nh l� node k tr? d?n node p
		}
		h = k;
	}
}

// h�m x�a d?u
void XoaDau(LIST &l)
{
	// n?u danh s�ch r?ng
	if (l.pHead == NULL)
	{
		return;
	}
	NODE *p = l.pHead; // node p l� node s? x�a
	l.pHead = l.pHead->pNext;// c?p nh?t l?i l.pHead l� ph?n t? k? ti?p
	delete p;
}

// x�a cu?i
void XoaCuoi(LIST &l)
{

	// n?u danh s�ch r?ng
	if (l.pHead == NULL)
	{
		return;
	}
	// tru?ng h?p danh s�ch c� ph?n t?
	if (l.pHead->pNext == NULL)
	{
		XoaDau(l);
		return;
	}
	// duy?t t? d?u danh s�ch d?n th?ng k? cu?i
	for (NODE *k = l.pHead; k != NULL; k = k->pNext)
	{
		// ph�t hi?n th?ng k? cu?i
		if (k->pNext == l.pTail)
		{
			delete l.pTail; // x�a di ph?n t? cu?i
			k->pNext = NULL; // cho con tr? c?a node k? cu?i tr? d?n v�ng nh? null
			l.pTail = k; // c?p nh?t l?i l.pTail
			return;
		}
	}
}

// h�m x�a 1 node n?m sau node q trong danh s�ch
void XoaSauNode_q(LIST &l, NODE *q)
{
	// duy?t danh s�ch t? d?u d?n cu?i d? t�m node q
	for (NODE *k = l.pHead; k != NULL; k = k->pNext)
	{
		// ph�t hi?n node q
		if (k->data == q->data)
		{
			NODE *g = k->pNext; // node g ch�nh l� node n?m sau node k(n?m sau node q) <=> node m� ta s? x�a
			k->pNext = g->pNext; // c?p nh?t m?i li�n k?t gi?a node k(node q) v?i node sau node g 
			delete g; // x�a node n?m sau node q			
		}
	}
}

// h�m xu?t danh s�ch li�n k?t don
void XuatDanhSach(LIST l)
{
	for (NODE *k = l.pHead; k != NULL; k = k->pNext)
	{
		cout << k->data << "  ";
	}
}

// h�m x�a 1 c�i node c� kh�a k b?t k�
void XoaNodeCoKhoaBatKy(LIST &l, int x)
{
	// n?u danh s�ch r?ng th� kh�ng l�m g� h?t
	if (l.pHead == NULL)
	{
		return;
	}
	// n?u node c?n x�a n?m d?u danh s�ch
	if (l.pHead->data == x)
	{
		XoaDau(l);
		return;
	}
	// n?u node c?n x�a n?m ? cu?i danh s�ch
	if (l.pTail->data == x)
	{
		XoaCuoi(l);
		return;
	}

	NODE *g = new NODE; // node g l� node tr? d?n node n?m tru?c node c?n x�a: x
	// duy?t danh s�ch li�n k?t don d? t�m
	for (NODE *k = l.pHead; k != NULL; k = k->pNext)
	{
		// ph�t hi?n ph?n t? c?n x�a
		if (k->data == x)
		{
			g->pNext = k->pNext; // c?p nh?t m?i li�n k?t gi?a node k v?i node sau node h
			delete k; // x�a node n?m sau node k	
			return;
		}
		g = k; // cho node g tr? d?n node k
	}

}

// h�m menu
void Menu(LIST &l)
{
	int luachon;
	while (true)
	{
		system("cls");
		cout << "\n\n\t\t =========== MENU ===========";
		cout << "\n1. Them node vao danh sach";
		cout << "\n2. Xuat danh sach";
		cout << "\n3. Them node p vao sau node q";
		cout << "\n4. Them node p vao truoc node q";
		cout << "\n5. Xoa dau";
		cout << "\n6. Xoa cuoi";
		cout << "\n7. Xoa node sau node q";
		cout << "\n8. Xoa node co khoa k bat ky";
		cout << "\n0. Ket thuc";
		cout << "\n\n\t\t =========== END ===========";

		cout << "\nNhap lua chon: ";
		cin >> luachon;
		if (luachon == 1)
		{
			int x;
			cout << "\nNhap gia tri can them: ";
			cin >> x;
			NODE *p = KhoiTaoNode(x);
			ThemCuoi(l, p);
		}
		else if (luachon == 2)
		{
			cout << "\n\n\t\t DANH SACH LIEN KET DON \n";
			XuatDanhSach(l);
			system("pause");
		}
		else if (luachon == 3)
		{
			int x;
			cout << "\nNhap node q can them: ";
			cin >> x;
			NODE *q = KhoiTaoNode(x);
			ThemNode_p_SauNode_q(l, q);
		}
		else if (luachon == 4)
		{
			int x;
			cout << "\nNhap node q can them: ";
			cin >> x;
			NODE *q = KhoiTaoNode(x);
			ThemNode_p_TruocNode_q(l, q);
		}
		else if (luachon == 5)
		{
			XoaDau(l);
		}
		else if (luachon == 6)
		{
			XoaCuoi(l);
		}
		else if (luachon == 7)
		{
			int x;
			cout << "\nNhap node q: ";
			cin >> x;
			NODE *q = KhoiTaoNode(x);
			XoaSauNode_q(l, q);
		}
		else if (luachon == 8)
		{
			int x;
			cout << "\nNhap node can xoa: ";
			cin >> x;
			XoaNodeCoKhoaBatKy(l, x);
		}
		else
		{
			break;
		}
	}
}

int main()
{
	LIST l;
	KhoiTaoDanhSach(l);
	Menu(l);
	system("pause");
	return 0;
}