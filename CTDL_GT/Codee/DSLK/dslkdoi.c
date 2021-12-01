#include <stdio.h>
struct Node{
	int data;
	Node *next,*pre;	
};
struct List{
	Node *first,*last;	
};
void Init(List&l);
void create_List(List&l);
void PrinList(List&l);
Node *GetNote(int x);
void addFirst(List &l,Node *p);
void addLast(List &l,Node *new_node);
void add_After(List&l,Node*q,Node*new_node);
void addPre(List&l,Node*q,Node*new_node);
void chen_vitri(List&l,int x,int vt);
int removeFirst(List&l);
void removeLast(List&l);
void remove_After(List&l,Node*q);
void remove_Pre(List&l,Node*q);
int main(int argc, char *argv[])
{
	List ds;
	int chon;
	do{
		printf("\n----menu----\n");
		printf("1.tao danh sach\n");
		printf("2.xuat danh sach\n");
		printf("3.chen x sau node q\n");
		printf("4.chen x truoc node q\n");
		printf("5.chen x vao vi tri thu i q\n");
		printf("6.xoa dau danh sach\n");
		printf("7.xoa cuoi danh sach\n");
		printf("8.xoa sau q\n");
		printf("9.xoa truoc q\n");
		printf("chon cong viec:");scanf("%d",&chon);
		switch(chon){
			case 1:{
				Init(ds);
				create_List(ds);}break;
			case 2:PrinList(ds);break;
			case 3:{
				int x,y;
				printf("nhap gia tri can chen:");scanf("%d",&x);
				printf("nhap gia tri cua node can chen sau:");scanf("%d",&y);
				Node*q=GetNote(y);
				Node *new_node=GetNote(x);
				add_After(ds,q,new_node);
				}break;
			case 4:{
				int x,y;
				printf("nhap gia tri can chen:");scanf("%d",&x);
				printf("nhap gia tri cua node can chen truoc:");scanf("%d",&y);
				Node*q=GetNote(y);
				Node *new_node=GetNote(x);
				addPre(ds,q,new_node);
				}break;
			case 5:{
				int x,vt;
				printf("nhap gia tri can chen:");scanf("%d",&x);
				printf("nhap vi tri can chen:");scanf("%d",&vt);
				chen_vitri(ds,x,vt);
			}break;
			case 6:removeFirst(ds);break;
			case 7:removeLast(ds);break;
			case 8:{
				int x;printf("nhap gia tri cua node can xoa sau:");scanf("%d",&x);
				Node*q=GetNote(x);
				remove_After(ds,q);
			}break;
			case 9:{
				int x;printf("nhap gia tri cua node can xoa truoc:");scanf("%d",&x);
				Node*q=GetNote(x);
				remove_Pre(ds,q);
			}break;
			}		
	}while(chon<10);
	return 0;
}
Node *GetNote(int x){
	Node *p;
	p=new Node;
	if(p==NULL){
		printf("khong thanh cong");
		return NULL;
	}
	p->data=x;
	p->next=NULL;
	p->pre=NULL;
	return p;
}
void addFirst(List &l,Node *new_node){
	if(l.first==NULL){
		l.first=l.last=new_node;
	}
	else
	{
		new_node->next=l.first;l.first->pre=new_node;
		l.first=new_node;
	}
}
void addLast(List &l,Node *new_node){
	if(l.first==NULL){
		l.first=l.last=new_node;
	}
	else{
		new_node->pre=l.last;l.last->next=new_node;
		l.last=new_node;
	}
}
void add_After(List&l,Node*q,Node*new_node){
	Node*p=l.first;
	while(p!=NULL&&p->data!=q->data)
		p=p->next;
	if(p==NULL){
		printf("khong chen");return;
	}
	else
		if(p==l.last)
			addLast(l,new_node);
		else{
			Node *t=p->next;
			new_node->next=t;t->pre=new_node;
			new_node->pre=p;p->next=new_node;
		}
}
void Init(List&l){
	l.first=l.last=NULL;
}
void create_List(List&l){
	int x;
	do{
		printf("nhap data:");scanf("%d",&x);
		if(x!=-1){
			Node *p=GetNote(x);
			addLast(l,p);
		}
	}while(x!=-1);
}
void PrinList(List&l){
	Node*p=l.first;
	printf("\nin danh sach:");
	while(p!=NULL){
		printf("%d ",p->data);
		p=p->next;
	}
}
void addPre(List&l,Node*q,Node*new_node){
	if(l.first->data==q->data)
		addFirst(l,new_node);
	else{
		Node*p=l.first;
		while(p!=NULL&&p->data!=q->data)
			p=p->next;
		if(p==NULL)
			{
				printf("khong chen");
				return;
			}
		else{
			Node *t=p->pre;
			new_node->next=p;p->pre=new_node;
			new_node->pre=t;t->next=new_node;
		}
	}
}
void chen_vitri(List&l,int x,int vt){
	Node*p=l.first;
	int dem=0;
	while(p!=NULL&&dem<vt){
		dem++;
		p=p->next;
	}
	if(p==NULL)
		{
			printf("khong co vi tri nay");return;
		}
	else{
		Node*new_node=GetNote(x);
		addPre(l,p,new_node);
	}		
}
int removeFirst(List&l){
	Node*p=l.first;
	l.first=l.first->next;
	l.first->pre=NULL;p->next=NULL;
	delete(p);
}
void removeLast(List&l){
	Node*p=l.last;
	l.last=l.last->pre;
	l.last->next=NULL;
	p->pre=NULL;
	delete(p);
}
void remove_After(List&l,Node*q){
	Node*p=l.first;
	while(p!=NULL&&p->data!=q->data)
		p=p->next;
	if(p==NULL||p==l.last){
		printf("khong xoa");return;
	}
	else
		if(p->next==l.last)
			removeLast(l);
		else{
			Node*t=p->next;
			p->next=t->next;t->next->pre=p;
			t->next=NULL;t->pre=NULL;
			delete(t);		
	}
}
void remove_Pre(List&l,Node*q){
	if(l.first->data==q->data)
		{
			printf("khong xoa");return;
		}
	else
		if(l.first->next->data==q->data)
			removeFirst(l);
		else{
			Node*p=l.first;
			while(p!=NULL&&p->data!=q->data)
				p=p->next;
			if(p==NULL)
			{
				printf("khong xoa");return;
			}
			else{
				Node*t=p->pre;
				t->pre->next=p;p->pre=t->pre;
				t->next=NULL;t->pre=NULL;
				delete(t);
			}
		}		
}
void remove_k(List&l,int k){
	if(l.first->data==k)
		removeFirst(l);
	else
		if(l.last->data==k)
			removeLast(l);
		else{
			Node*p=l.first;
			while(p!=NULL&&p->data!=k)
				xoa tai node p;
		}
}