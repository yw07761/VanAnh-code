#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node{
	float data;
	Node *link;	
};
struct stack{
	Node *top;	
};

void Init(stack &s);
int Empty(stack &s);
void Push(stack &s, float x);
float Pop(stack &s);
float TinhBieuThuc(stack &s, char bieuThuc[]);
void DocTu(char s[], char tu[], int &vt);
int LaToanTu(char s[]);
float TinhToan(float toanHang1, float toanHang2, char toanTu);

int main(int argc, char *argv[]){
	stack s;
	Init(s);
	char bieuThuc[100] = "";
	printf("Nhap bieu thuc dang hau to\n");
	fflush(stdin);
	gets(bieuThuc);
	float kq = TinhBieuThuc(s, bieuThuc);
	printf("Gia tri cua bieu thuc la: %f", kq);
}

void Init(stack &s){
	s.top= NULL;
}

int Empty(stack &s){
	return (s.top == 0);
}

void Push(stack &s, float x){
	Node *p = new Node;
	if(p!=NULL){
		p->data = x;
		p->link = s.top;
		s.top = p;
	}
}
float Pop(stack &s){
	float x;
	if(!Empty(s)){
		Node *p=s.top;
		s.top=p->link;
		x = p->data;
		delete(p);
		return x;
	}
}

float TinhBieuThuc(stack &s, char bieuThuc[]){
	float kq;
	char t[10];
	int i=0;
	do{
		DocTu(bieuThuc, t, i); 							//doc 1 tu bat dau tai vi tri i trong BieuThuc, kq la tu t, lay t dem di so sanh
		if(LaToanTu(t)){ 								//Neu t la toan tu thi...:
			char toanTu = t[0]; 						
			float toanHang1 = Pop(s);
			float toanHang2 = Pop(s);
			kq = TinhToan(toanHang1, toanHang2, toanTu); //thuc hien tinh toan dua vao ham TinhToan
			Push(s, kq);   								// tinh xong dua kq vao stack
		}
		else{ 											//Nguoc lai t la toan hang thi...:
			float toanHang = atof(t);  					// chuyen t thanh so thuc
			Push(s, toanHang); 							// dua toan hang vao stack
		}
		i++;
	}while(bieuThuc[i]!='#'); 							//Gia su dau # de ket thuc
	return Pop(s);
}

void DocTu(char s[], char tu[], int &vt){
	//khoi tao tu ban dau chi chua cac khoang trang
	for(int i=0; i<strlen(tu); i++)
		tu[i]= ' ';
	int i=0;
	while (s[vt] != ' ') // trong khi chua gap khoang trang
	{
		tu[i] = s[vt];
		vt++;
		i++;	
	}
}

int LaToanTu(char s[]){
	char c = s[0];
	if((c == '+') || (c == '-') || (c == '*') || (c == '/'))
		return 1;
	return 0;
}

float TinhToan(float toanHang1, float toanHang2, char toanTu){
	float kq;
	switch (toanTu){
		case '+': kq = toanHang1 + toanHang2; break;
		case '-': kq = toanHang1 - toanHang2; break;
		case '*': kq = toanHang1 * toanHang2; break;
		case '/': kq = toanHang1 / toanHang2;
	}
	return kq;
}





























