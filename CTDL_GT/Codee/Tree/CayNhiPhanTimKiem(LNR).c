#include <stdio.h>
struct Node{
	int data;
	Node *left,*right;	
};
typedef struct Node* Tree;
void Init(Tree &r);
Node *Getnode(int x);
void CreateTree(Tree &r);
int InsertNode(Tree &r,int x);
void LNR(Tree r);
int tim_kiem(Tree r, int x); //tra ve co hoac khong (lam tra ve d�t)
int Dem_node_la(Tree r);
int dem_node(Tree r);
int chieuCao(Tree r);
int main(int argc, char *argv[])
{
	Tree root; // Node *root;
	Init(root);
	CreateTree(root);
	LNR(root);
	/*int x;
	printf("Nhap gia tri can tim: \n");scanf("%d", &x);
	if(tim_kiem(root,x)==1)
		printf("Tim thay!");
	else
		printf("Khong tim thay!");
	*/
	// dem node l�
	printf("\nCo %d node la\n",Dem_node_la(root));
	//
	printf("\nCo tat ca %d node\n",dem_node(root));
	//
	printf("\nChieu cao cua cay la %d\n",chieuCao(root));
	return 0;
}
void Init(Tree &r)
{ 
//bo & khong duoc cap nhat lai -> r!= NULL
	r=NULL;
}
Node *Getnode(int x)
{
	Node *p;
	p = new Node;
	if(p == NULL)
	{
		printf("khong du bo nho!");
		return NULL;
	}
	p->data=x;
	p->left=NULL;
	p->right=NULL;
	return p;
}
void CreateTree(Tree &r)
{
	int x;
	do
	{
		printf("Nhap x: ");scanf("%d",&x);
		if(x!=0)
		{
			int kt = InsertNode(r,x);
			if(kt == -1)
				printf("Khong chen duoc!\n");
		}
	}while(x!=0);
}
int InsertNode(Tree &r,int x)
{
	// cay rong
	if(r==NULL){
		r=Getnode(x);return 1;	// ch�n th�nh c�ng
	}
	else
	{
		if(r->data==x) //khong chen duoc
			return -1; // nhi phan tim kiem k co gia tri trung n�n kh�ng ch�n
		else
			if(r->data>x) //x< n�t goc nen ch�n tr�i 
				return InsertNode(r->left,x); // goi lai de quy tren
			else // x > n�t goc n�n ch�n phai
				return InsertNode(r->right,x);// goi lai de quy tren
				
	}	
}
void LNR(Tree r)
{
	if(r!=NULL)
	{
		LNR(r->left);
		printf("%d ",r->data);
		LNR(r->right);
	}
}
int tim_kiem(Tree r, int x)
{	if(r!=NULL)
		if(r->data==x)
			return 1; //tim c�
		else
			if (r->data > x) // tim cay ben trai
				return tim_kiem(r->left,x);
			else
				return tim_kiem(r->right,x);
	else
			return -1;
}
int Dem_node_la(Tree r)
{
	if(r!=NULL){
		if(r->left==NULL && r->right==NULL)
			return 1;
		return Dem_node_la(r->left)+Dem_node_la(r->right);
	}
	else	
		return 0;
}
int dem_node(Tree r)
{
	if(r!=NULL)
		return 1 + dem_node(r->left) + dem_node(r->right);
	else
		return 0;		
}	
int chieuCao(Tree r)
{
	if(r==NULL)
		return 0;
	int a = chieuCao(r->left);
	int b = chieuCao(r->right);
	if(a>b)
		return a+1;
	else 
		return b+1;	
}
	