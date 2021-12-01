#include <stdio.h>
typedef struct Node
{
    int data;
    Node *pNext;
} node;

typedef struct queue
{
    Node *front, *rear;
} queue;

void init(queue &q);
int empty(queue q);
void enQueue(queue &q, int x);
int deQueue(queue &q);
int Front(queue q);

int main(int argc, char const *argv[])
{
    int x, k;
    queue q;
    init(q);
    int n;
    printf("Nhap so luong phan tu can them vao queue: ");
    scanf("%d",&n);
    for (int i = 0; i < n; i++)
    {
        printf("Nhap x = ");
        scanf("%d",&x);
        enQueue(q, x);
    }
    printf("\nLay danh sach cac phan tu ra khoi queue:\n");
    while (!empty(q))
    {
        k = deQueue(q);
        printf(" %d", k );
    }

    return 0;
}

void init(queue &q)
{
    q.front = NULL;
}

int empty(queue q)
{
    return q.front == NULL ? 1 : 0;
}
//Thêm mot phan tu x vao queue S
void enQueue(queue &q, int x)
{
    Node *p = new Node;
    p->data = x;
    p->pNext = NULL;
    if (empty(q))
    {
        q.front = p;
        q.rear = p;
    }
    else
    {
        q.rear->pNext = p;
        q.rear = p;
    }
}
// Trich thong tin va huy phan tu o dinh Q
int deQueue(queue &q)
{
    if (empty(q))
    {
        printf( "queue rong \n");
        return 1;
    }
    Node *p = q.front;
    q.front = q.front->pNext;
    if (empty(q))
        q.rear = NULL;
    int x = p->data;
    p->pNext = NULL;
    delete p;
    return x;
}
// Xem thong tin phan tu dau Q
int Front(queue q)
{
    if (empty(q))
        return 1;
    return q.front->data;
}
