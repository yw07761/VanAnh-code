#include <stdio.h>

struct Node
{
    Node *pLeft, *pRight;
    int idata;
};
typedef Node* Tree;
Node* TaoNode(int X);
void ThemNodeVaoCay(Node *p, Tree &c);
void Nhap(Tree &c);
void Xuat(Tree c);
int main(int argc, char *argv[])
{
	Tree c = NULL;
	Nhap(c);
	printf("Xuat cay LNR (Tang dan): ");
	Xuat(c);	
	return 0;
}
Node* TaoNode(int X)
{
    Node *p = new Node;
    if (p == NULL)
        return NULL;
    p->pLeft = NULL;
    p->pRight = NULL;
    p->idata = X;
    return p;
}
void ThemNodeVaoCay(Node *p, Tree &c)
{
    if (c == NULL) // neu cay rong
        c = p;
    else // cay khac rong
    {
        if (p->idata < c->idata)
            ThemNodeVaoCay(p, c->pLeft);
        else if (p->idata > c->idata)
            ThemNodeVaoCay(p, c->pRight);
        else
            return;
    }
}
// Nhap gia tri vao cay
void Nhap(Tree &c)
{
    int chon = 0;
    //printf("\nNhap so luong phan tu can them: ");
    //scanf("%d",&chon);
    //for (int i = 0; i < chon; i++)
    do
    {
    	int x;
    	printf("\nNhap x: "); 
    	scanf("%d",&x); 
    	Node *p = TaoNode(x);
    	ThemNodeVaoCay(p, c);
    	printf("Ban co muon nhap thong tin tiep khong? 1: Co/0: Khong -->");
    	scanf("%d",&chon);
    }while(chon);
}
// Viet ham xuat cac gia tri trong cay
void Xuat(Tree c)
{
	if(c!=NULL)
	{
		if(c->pLeft != NULL)
			Xuat(c->pLeft);
		printf("%4d", c->idata);
		if (c->pRight != NULL)
			Xuat(c->pRight);
	}
}