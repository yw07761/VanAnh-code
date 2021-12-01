#include<iostream>
using namespace std;
struct node
{
	int data; 
	struct node *pLeft; 
	struct node *pRight;
};
typedef struct node NODE;
typedef NODE* TREE;
void KhoiTaoCay (TREE &t)
{
	t = NULL; // cây r?ng
}
// hàm thêm ph?n t? x vào cây
void ThemNodeVaoCay(TREE &t, int x)
{
    // neu cây rong
     if (t == NULL)
     {     	
     	NODE *p = new NODE; // kh?i t?o 1 cái node d? thêm vào cây
		p->data = x;// thêm d? li?u x vào data
		p->pLeft = NULL;
		p->pRight = NULL;
		t = p;// node p chính là node g?c <=> x chính là node g?c
		}
	else 
	{ 
    	if (t->data > x)
   		 {
        	ThemNodeVaoCay (t->pLeft, x); 
   		 }
  		  else if (t->data < x) 
   		 {
       		 ThemNodeVaoCay (t->pRight, x);
   		 }
	}
}
void Duyet_NLR(TREE t)
{
   if (t != NULL)
   {
       cout << t->data << " "; 
       Duyet_NLR(t->pLeft); 
	   Duyet_NLR(t->pRight); 
	}
}
void Duyet_NRL(TREE t)
{
  // n?u cây còn ph?n t? thì ti?
   if (t != NULL)
   {
      cout << t->data << " "; //
      Duyet_NRL (t->pRight); // de
      Duyet_NRL (t->pLeft);
   }
}
void Duyet_LNR(TREE t)
{
   // n?u cây còn ph?n t? thì ti
    if (t != NULL)
    {
        Duyet_LNR(t->pLeft); 
        cout << t->data << " ";
        Duyet_LNR(t->pRight);
    }
}
void Duyet_LRN(TREE t)
{
   // n?u cây còn ph?n t? thì ti
    if (t != NULL)
    {
        Duyet_LRN(t->pLeft); 
        Duyet_LRN(t->pRight); 
        cout << t->data <<" ";
    }
}
void Menu(TREE &t)
{
   while (true)
    {
    	system("cls");
        cout << "\n\n\t\t ===== MENU ===";
        cout << "\n1. Nhap du lieu";
        cout << "\n2. Xuat du lieu cay theo NLR NRL LNR LRN";
        cout << "\ne. Ket thuc";
        cout << "\n\n\t\t===============";
        
        int luachon;
        
        cout << "\nNhap lua chon: ";
        cin >> luachon;
        if (luachon < 0 || luachon > 2)
        {
             cout << "\nLua chon khong hop le";
             system("pause");
        }
        else if (luachon == 1)
		{
    		int x;
    		cout << "\nNhap so nguyen x: ";
	 		cin >> x;
   			ThemNodeVaoCay (t, x);
		}
		else if (luachon == 2)
		{
			cout << "\n\t\tDUYET CAY THEO NLR\n";
			Duyet_NLR(t);
			cout << "\n\t\tDUYET CAY THEO NRL\n";
			Duyet_NRL(t);
			cout << "\n\t\tDUYET CAY THEO LNR\n";
			Duyet_LNR(t);
			cout << "\n\t\tDUYET CAY THEO LRN\n";	
			Duyet_LRN(t);
			system("pause");	
		}
		else
		{
  		  break;
		}
	}
}
int main()
{
      TREE t;
      KhoiTaoCay(t);
      Menu(t);
      system("pause");
      return 0;
}
