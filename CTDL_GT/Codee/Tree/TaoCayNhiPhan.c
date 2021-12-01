#include <stdio.h>
struct Tnode{
	int data;
	Tnode*left,*right;	
};
void Init(Tnode *&r);
Tnode *Getnode(int x);
void tao_cay(Tnode *&r,int x);
void NLR(Tnode*r);
void LNR(Tnode*r);
void LRN(Tnode*r);
int main(int argc, char *argv[])
{
	Tnode *root;
	Init(root);
	int x;
	printf("nhap data goc:");scanf("%d",&x);
	tao_cay(root,x);
	printf("duyet truoc:");
	NLR(root);
	printf("\nduyet giua:");
	LNR(root);
	printf("\nduyet sau:");
	LRN(root);
	return 0;
}
void Init(Tnode *&r){
	r=NULL;
}
Tnode *Getnode(int x){
	Tnode*p;
	p=new Tnode;
	if(p==NULL){
		printf("khong du bo nho!");return NULL;
	}
	p->data=x;p->left=NULL;p->right=NULL;
	return p;
}
void tao_cay(Tnode *&r,int x){
	if(x==0)
		return;
	else{
		r=Getnode(x);
		printf("nhap con trai:");scanf("%d",&x);
		tao_cay(r->left,x);
		printf("nhap con phai:");scanf("%d",&x);
		tao_cay(r->right,x);
	}
}
/*
goc:10
trai 10:8
trai 8:3
trai 3:0
phai 3: 5
trai 5:0
phai 5:0
phai 8:7
trai 7: 0
phai 7: 0
phai 10:9
trai 9:0
phai 9:0
*/
void NLR(Tnode *r){
	if(r!=NULL){
		printf("%d ",r->data);
		NLR(r->left);
		NLR(r->right);
	}
}
void LNR(Tnode *r){
	if(r!=NULL){		
		LNR(r->left);
		printf("%d ",r->data);
		LNR(r->right);
	}
}
void LRN(Tnode *r){
	if(r!=NULL){		
		LRN(r->left);		
		LRN(r->right);
		printf("%d ",r->data);
	}
}