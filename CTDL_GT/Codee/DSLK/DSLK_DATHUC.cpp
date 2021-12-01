#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iomanip>
#include <conio.h>

using namespace std;

struct Node{
	int data;
	Node *pNext;
};

struct List{
	Node *pHead;
	Node *pTail;
};

Node *getNode(int data);
void Ini(List &L);
void processList (List L);
void addHead(List &L, Node* new_node);
void insertHead(List &L, int data);
void createListHead(List &L, int n);
void addTail(List &L, Node* new_node);
void insertTail(List &L, int data);
void createListTail(List &L, int n);
void printList(List L);
/*int main(int argc, char *argv[])
{
	List L;
	Ini(L);	
	Node *p;
	int x;
	cout<<"Input data: ";
	cin>>x;
	p=getNode(x);
	L.pHead=L.pTail=p;
	processList(L);
	return 0;
}*/

int main(int argc, char *argv[])
{
		int n, data,choice;
		List L;	
		Ini(L);
		Node *p;
	do{
		cout<<endl<<setw(10)<<"MENU"<<endl;
		cout<<"1. Add Head"<<endl;
		cout<<"2. CreateList Head"<<endl;
		cout<<"3. Insert Tail"<<endl;
		cout<<"4. CreateList Tail"<<endl;
		cout<<"5. Delete Node"<<endl;
		cout<<"6. Search Node"<<endl;
		cout<<"7. Print List"<<endl;
		cout<<"0. Exit"<<endl;
		cout<<"Input your choice please: ";
		cin>>choice;
		switch(choice){
			case 1:
			cout<<"Input value: ";
			cin>>data;
			insertHead(L,data);
			break;
			case 2:
			cout<<"Please enter the number of values: ";
			cin>>n;
			createListHead(L,n);
			break;
			case 3:
			cout<<"Input value: ";
			cin>>data;
			insertTail(L,data);
			break;
			case 4:
			cout<<"Please enter the number of values: ";
			cin>>n;
			createListTail(L,n);
			break;
			case 5:
			printList(L);
			break;
			case 7:
			printList(L);
			break;
		 	case 0:
                cout<<"Exit";
                getch();
                return 0;
    		break;
		}
	}while(choice<10);
	return 0;
}
Node *getNode(int data){
	Node *p;
	p=new Node;
	if(p==NULL){
		cout<<"Khong du bo nho!";
		return NULL;
	}
	p->data=data;
	p->pNext=NULL;
	return p;
}

void Ini(List &L)
{
	L.pHead = L.pTail = NULL;
}

void processList (List L)
{	
     	Node *p = L.pHead;
     	while (p!= NULL)
     	{ 
     		p = p->pNext;
     	}
}

void addHead(List &L, Node* new_node)
{
	if (L.pHead == NULL)
	{
		L.pHead = L.pTail = new_node;	
	}
	else 
	{	
		new_node->pNext = L.pHead;  
		L.pHead = new_node; 	
	}
}

void insertHead(List &L, int data)
{	
	Node* new_node = getNode(data);
	if (new_node == NULL)
		return;
	addHead(L, new_node);
}

void createListHead(List &L, int n){
	int data;
	for(int i=0; i<n; i++)
    {
        cout<<"Enter the value "<<i+1<<endl;
        cin>>data;
        insertHead(L,data);
    }
}

void printList(List L){
	Node *p;
	p=L.pHead;
	while(p!=NULL){
		cout<<p->data<<setw(4);
		p=p->pNext;
	}
}

void addTail(List &L, Node* new_node)
{
	if (L.pHead == NULL)
	{
		L.pHead = L.pTail = new_node;	
	}
	else 
	{	
		L.pTail->pNext=new_node;  
		L.pTail= new_node; 	
	}
}

void insertTail(List &L, int data)
{	
	Node* new_node = getNode(data);
	if (new_node == NULL)
		return;
	addTail(L, new_node);
}

void createListTail(List &L, int n){
	int data;
	for(int i=0; i<n; i++)
    {
        cout<<"Enter the value "<<i+1<<endl;
        cin>>data;
        insertTail(L,data);
    }
}