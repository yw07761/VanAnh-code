#include <stdio.h>
#include <string.h>
struct SinhVien{
	char masv[20];
	char ten[20];
	double diem;
};
struct Node{
	SinhVien data;
	Node *pLeft, *pRight;
};
typedef Node *Tree;
void Init(Tree &r);
Node* GetNode(SinhVien x);
int insert_Node (Tree &r, SinhVien x);
void create_Tree(Tree &r);
void LNR(Tree r);
void nhap_1sv(SinhVien &x);
void xuat_1sv(SinhVien x);
int dem_node_la(Tree r);
int chieucao(Tree r);
Node *timKiem(Tree r, char masv[20]);
int main(int argc, char *argv[])
{
	Tree root; // Node *root
	Init(root);
	char x[20];
	Node *p;
	create_Tree(root);
	LNR(root);
	printf("So node la trong cay la %d\n",dem_node_la(root));
	printf("Chieu cao cua cay la %d \n",chieucao(root));
	printf("\nTim sinh vien");
 	printf("\nNhap masv can tim: ");
 	fflush(stdin); 
 	scanf("%s",x);      
	p = timKiem(root, x);
    xuat_1sv(p->data);
	return 0;
}
//=======================================//
void Init(Tree &r){
	r=NULL;
}
Node *GetNode(SinhVien x){
	Node *p;
	p = new Node;
	if(p==NULL){
		printf("Khong du bo nho de tao !"); return NULL;
	}
	p->data=x;
	p->pLeft=NULL;
	p->pRight=NULL;
	return p;
}
int insert_Node (Tree &r, SinhVien x){
	if(r==NULL){
		r=GetNode(x);return 1;
	}
	else
		if(strcmp(r->data.masv,x.masv)==0)
			return -1;
		else
			if(strcmp(r->data.masv,x.masv)>0)
				return insert_Node(r->pLeft,x);
			else
				return insert_Node(r->pRight,x);
}
void create_Tree(Tree &r){
	SinhVien x;
	char tl;
	do{
		nhap_1sv(x);
		int kt = insert_Node(r,x);
			if(kt == -1)
				printf("khong chen duoc!");
			fflush(stdin);
			printf("Nhap them nua khong ? (khong hay nhap 'n'): ");
			scanf("%c",&tl);			
	}while(tl!='n');
}
void LNR(Tree r){
	if(r!=NULL){
		LNR(r->pLeft);
		xuat_1sv(r->data);
		LNR(r->pRight);	
	}		
}
void nhap_1sv(SinhVien &x){
	fflush(stdin);
	printf("Nhap masv: ");scanf("%s",x.masv);
	fflush(stdin);
	printf("Nhsp ten: ");gets(x.ten);
	fflush(stdin);
	printf("Nhap diem: ");scanf("%lf",&x.diem);
	fflush(stdin);
}
void xuat_1sv(SinhVien x){
	printf("\n%s %s %lf \n",x.masv,x.ten,x.diem);
}
int dem_node_la(Tree r){
	if(r!=NULL){
		if(r->pLeft==NULL&&r->pRight==NULL)
			return 1;
		return dem_node_la(r->pLeft)+dem_node_la(r->pRight);
	}
	else
		return 0;
	
}
int chieucao(Tree r){
	if(r==NULL)
		return 0;
	int a=chieucao(r->pLeft);
	int b=chieucao(r->pRight);
	if(a>b)
		return a+1;
	else
		return b+1;
}
Node *timKiem(Tree r, char ma[20]){
    if (r != NULL)
    {
        if (strcmp(r->data.masv, ma) == 0)
            return r;
        else if (strcmp(r->data.masv, ma) < 0)
            return timKiem(r->pLeft, ma);
        else
            return timKiem(r->pRight, ma);
    }
    return NULL;
}
