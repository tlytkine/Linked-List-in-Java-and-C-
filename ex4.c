#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>

/* Initially list is empty */

struct Node {
	int data; 
	struct Node* next;
	struct Node* prev;
};

struct Node* head;

// inserts node at head of the list 
void insertAtFront (int data)
{
	struct Node* newNode1 = (struct Node*)malloc(sizeof(struct Node));
	newNode1->data = data; newNode1->prev = NULL; newNode1->next = NULL;
	if (head == NULL) {
	head = newNode1;
	return;
	}
	newNode1->next = head;
	newNode1->prev = NULL;
	head = newNode1;
}
// sets head equal to null
void initializeList ()
{
	head=NULL;
}


/* Need to free memory */

void clearList ()
{

	while(head!=NULL){
		free(head);
		head = head->next;
	}
}


/* Insert an item at the end of a list */

void insertAtEnd (int data)
{

	struct Node* tempNode = head;
	struct Node* newNode2 = (struct Node*)malloc(sizeof(struct Node));
	newNode2->data=data; newNode2->prev=NULL; newNode2->next=NULL;
	if (head==NULL){
		head = newNode2;
		return;
	}
	while(tempNode->next!=NULL){
		tempNode = tempNode->next;
	}
	tempNode->next=newNode2;
	newNode2->prev=tempNode;

}
// Prints the memory address and data of each node in the list
// (for viewing and debugging purposes)
void printList() 
{
	struct Node* temp = head;
	while(temp!=NULL){
		printf("Memory Address of Node: %p\n",temp);
		printf("Data in Node: %d \n",temp->data);
		temp=temp->next;
	}
}
int getPosition(int data){
	struct Node* search = (struct Node*)malloc(sizeof(struct Node));
	search->data = data; 
	struct Node* temp = head;
	int position = 1; int check;
	int a = data; int b;
	while(temp!=NULL){
		int b = temp->data; 
		if(a!=b){
			position++;
		}
		if(a==b){
			return position;
			break;
		}
		temp=temp->next;
	}
	if(a!=b){
		position = -1;
	}
	return position;
}

struct Node* getNode(int position){
	struct Node* temp = head;
	for(int i=1;i<position;i++){
		if(temp->next!=NULL){
			temp = temp->next;
		}
	}
	return temp;
}



/* Find "data" in the list, if it exists, and move it up by
   a distance of "moveDistance" closer to the front of the list. */

int findPositionAndMove (int data, int moveDistance){
	int position = getPosition(data);
	if((position!=-1)&&(position!=1)){
	struct Node* temp = getNode(position);
	while(moveDistance!=0){
		if(temp->prev==NULL){
			break;
		}
		struct Node* p = temp->prev;
		struct Node* pp = p->prev;
		struct Node* n = temp->next;
		if(pp!=NULL){
			pp->next = temp;
		}
		temp->prev = pp;
		temp->next = p;
		p->prev = temp;
		p->next = n;
		if(n!=NULL){
			n->prev = p;
		}
		moveDistance--;
	}
	}
	return position;
}






