#include <iostream>
using namespace std;
//tao node ;
struct node{
	int data;
	node*left;
	node*right;
};
typedef struct node*tree;
//  khoi tao node
node *getNode(int x){
	node*p;
	p=new node;
	if(p==NULL){
		cout<<"khong thanh cong!";return NULL;
	}
	p->data=x;
	p->left=NULL;p->right=NULL;
	return p;
}
//khoi tao cay
void Init(tree &r){
	r=NULL;//cay rong
}
//chen node vao tree:cay
int inserttree(tree &r,int x){
	node*p=getNode(x);
	if(r==NULL){      //cay rong;
		r=p;return 1;
	}else    // cay ton tai phan tu;
		if(r->data>x)
		   return inserttree(r->left,x);
		else if(r->data<x)
		   return inserttree(r->right,x);
		else{
			return-1;
		}
		
}
//ham nhap du lieu
void creat_tree(tree&r){
	int x;
    do{
    	cout<<"nhap x";
	    cin>>x;
	    if(x!=0)
	       if(inserttree(r,x)==-1){
	       	   cout<<"khong chuen duoc";
		   }
	}while(x!=0);
}
// xuat theo LNR
void LNR(tree r){
	if(r!=NULL)
	    LNR(r->left);
	    cout<<r->data;
	    LNR(r->right);	
}
//int dem_node_la(tree r){
//	if(r!=NULL){
//		if(r->left==NULL&&r->right==NULL)
//			return 1;
//		return dem_node_la(r->left)+dem_node_la(r->right);
//	}	
//	else
//		return 0;	
//}
int main(){
	tree r;
	Init(r);
	creat_tree(r);
	LNR(r);
	return 0;
}
