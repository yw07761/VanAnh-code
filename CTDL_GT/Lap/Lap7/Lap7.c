#include <stdio.h>
#include <string.h>

#define MAXQUEUE 100

typedef struct MatHang
{
    int maMH;
    char tenMH[12];
} mathang;

typedef struct queue
{
    int front, rear;
    MatHang nodes[MAXQUEUE];
} Queue;

void init(queue *q);
int empty(queue *q);
void insert(queue *q, MatHang x);
MatHang remove(queue *q);
void traverse(queue *q);

int main(int argc, char const *argv[])
{
    queue q;
    init(&q);
    int chucNang, front1;
    char c;
    MatHang mh;

    do
    {
        printf("============ Chuong Trinh Quan Ly Kho ===============\n");
        printf( "1. Nhap mot mat hang\n");
        printf( "2. Xuat mot mat hang\n");
        printf( "3. Xem mat hang chuan bi xuat\n");
        printf( "4. Xem mat hang moi nhap\n");
        printf( "5. Xem cac mat hang co trong kho\n");
        printf( "6. Xuat toan bo kho hang\n");
        printf( "0. Ket thuc chuong trinh\n");
        printf( "Chuc nang ban chon:");
        scanf("%d", &chucNang);

        switch (chucNang)
        {
        case 1:
        {
        	
            printf("\nMa mat hang: ");
 			scanf("%d", &mh.maMH);
 			printf("Ten mat hang: ");
 			scanf("%s", &mh.tenMH);
 			insert(&q, mh);
 			break;
        }
        case 2:
        {	
        	if (!empty(&q))
            {
                mh = remove(&q);
                printf("\nMat hang chuan bi xuat:\nMa:%d  Ten:%s\n", mh.maMH, mh.tenMH );
            }
            else
            {
                printf("\nKho khong con hang\n");
            }
        }
            break;
        case 3:
        {
        	front1 = ((q.front == MAXQUEUE - 1) ? 0 : q.front + 1);
            printf("\nMat hang chuan bi xuat:\nMa:%d  Ten:%s\n", q.nodes[front1].maMH, q.nodes[front1].tenMH );
            break;
        }
        case 4:
		{
	 		printf("\nMat hang chuan bi xuat:\nMa:%d  Ten:%s\n", q.nodes[front1].maMH, q.nodes[front1].tenMH );
            break;
        }
        case 5:
            printf("\nCac mat hang co trong kho:\n");
            printf("%11s%15s\n", "MA MAT HANG", "TEN MAT HANG");
            traverse(&q);
            break;
        case 6:
            printf("\nBan co chac khong (c/k): ");
            c = getchar();
            while(c!='c'&&c!='C');
                init(&q);
            break;
        }
    } while (chucNang != 0);

    return 0;
}

void init(queue *q)
{
    q->front = q->rear = MAXQUEUE - 1;
}

int empty(queue *q)
{
    return ((q->front == q->rear) ? true : false);
}

void insert(queue *q, MatHang x)
{
    if (q->rear == MAXQUEUE - 1)
        q->rear = 0;
    else
        (q->rear)++;
    if (q->rear == q->front)
        printf("\nKho hang da day\n");
    else
        q->nodes[q->rear] = x;
}

MatHang remove(struct queue *q)
{
    if (empty(q))
        printf("\nKho khong con hang\n");
    else
    {
        if (q->front == MAXQUEUE - 1)
            q->front = 0;
        else
            (q->front)++;
        return (q->nodes[q->front]);
    }
}
// Tac vu traverse: duyet kho hang tu front toi rear
void traverse(queue *q)
{
    int i;
    if (empty(q))
    {
        printf ("\nKho khong con hang\n");
        return;
    }
    if (q->front == MAXQUEUE - 1)
        i = 0;
    else
        i = q->front + 1;
    while (i != q->rear)
    {
        
        printf("%-11d%-15s\n", q->nodes[i].maMH, q->nodes[i].tenMH);
        if (i == MAXQUEUE - 1)
            i = 0;
        else
            i++;
    }
    
    printf("%-11d%-15s\n", q->nodes[i].maMH, q->nodes[i].tenMH);
}
