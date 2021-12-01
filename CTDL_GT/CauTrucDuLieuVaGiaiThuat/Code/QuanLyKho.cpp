#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>
#define MAXQUEUE 100
typedef struct mathang
{
	int mamh;
	char tenmh[12];
};
struct queue
{
	int front, rear;
	mathang nodes[MAXQUEUE];
};
void Initialize(struct queue *pq);
int Empty(struct queue *pq);
void Insert(struct queue *pq, mathang x);
mathang Remove(struct queue *pq);
void Traverse(struct queue *pq);
int main(int argc, char *argv[])
{
	struct queue q;
	int chucnang, front1;
	char c;
	mathang mh;
	Initialize(&q);
	do
	{
		printf("\n\n\t\t\tCHUONG TRINH QUAN LY KHO");
 		printf("\n\t\t\t(NHAP TRUOC - XUAT TRUOC)");
 		printf("\n\nCac chuc nang cua chuong trinh:\n");
	 	printf("1: Nhap mot mat hang\n");
 		printf("2: Xuat mot mat hang\n");
		printf("3: Xem mat hang chuan bi xuat\n");
		printf("4: Xem mat hang moi nhap\n");
 		printf("5: Xem cac mat hang co trong kho\n");
 		printf("6: Xuat toan bo kho hang\n");
 		printf("0: Ket thuc chuong trinh\n");
 		printf("Chuc nang ban chon: ");
 		scanf("%d", &chucnang);
 		switch(chucnang)
 		{
 			case 1:
 			{
 				printf("\nMa mat hang: ");
 				scanf("%d", &mh.mamh);
 				printf("Ten mat hang: ");
 				scanf("%s", &mh.tenmh);
 				Insert(&q, mh);
 				break;
 			}
			case 2:
 			{
 				if(!Empty(&q))
 				{
 					mh = Remove(&q);
 					printf("\nMat hang xuat:Ma:%d, Ten:%s", mh.mamh, mh.tenmh);
 				}
 				else
				 	printf("\nKho khong con hang");
				break;
 			}
 			case 3:
 			{
			 	front1 = (q.front==MAXQUEUE-1 ? 0 : q.front+1);
			 	printf("\nMat hang chuan bi xuat: Ma:%d, Ten:%s", q.nodes[front1].mamh, q.nodes[front1].tenmh);
			 	break;
		 	}
		 	case 4:
		 	{
	 			printf("\n Mat hang moi nhap: Ma:%d Ten:%s", q.nodes[q.rear].mamh, q.nodes[q.rear].tenmh);
	 			break;
	 		}
	 		case 5:
	 		{
		 		printf("\n Cac mat hang co trong kho:");
		 		printf("\n%11s%15s", "MA MAT HANG", "TEN MAT HANG");
		 		Traverse(&q);
		 		break;
		 	}
		 	case 6:
		 	{
	 			printf("\n Ban co chac khong (c/k):");
	 			scanf("%s", &c);
	 			fflush(stdin);
	 			if (c == 'c' || c == 'C')
	 				Initialize(&q);
 				break;
	 		}
 		}
	}while(chucnang != 0);
	return 0;
}
void Initialize(struct queue *pq)
{
	pq->front = pq->rear = MAXQUEUE-1;
}
int Empty(struct queue *pq)
{
	return((pq->front == pq->rear) ? true : false);
}
void Insert(struct queue *pq, mathang x)
{
	if(pq->rear == MAXQUEUE-1)
		pq->rear = 0;
	else
		(pq->rear)++;
	if(pq->rear == pq->front)
		printf("Kho hang bi day");
	else
		pq->nodes[pq->rear] = x;
}
mathang Remove(struct queue *pq)
{
	if(Empty(pq))
		printf("Kho khong con hang");
	else
	{
		if(pq->front == MAXQUEUE-1)
			pq->front = 0;
		else
			(pq->front)++;
		return(pq->nodes[pq->front]);
	}
}
void Traverse(struct queue *pq)
{
	int i;
	if(Empty(pq))
	{
		printf("\nKho khong con hang");
		return;
	}
	if(pq->front == MAXQUEUE-1)
		i = 0;
	else
		i = pq->front+1;
	while(i != pq->rear)
	{
		printf("\n%11d%15s", pq->nodes[i].mamh, pq->nodes[i].tenmh);
		if(i == MAXQUEUE-1)
			i = 0;
		else
			i++;
	}
	printf("\n%11d%15s", pq->nodes[i].mamh, pq->nodes[i].tenmh);
}