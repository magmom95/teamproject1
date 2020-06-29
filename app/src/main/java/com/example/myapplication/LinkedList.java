package com.example.myapplication;

import org.w3c.dom.Node;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Dog data;

        private Node next;
        public Node(Dog input){
            this.data = input;
            this.next = null;
        }

        public String toDogName(){
            return String.valueOf(this.data.dogName);
        }
    }

    public void addFirst(Dog input){
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if(head.next == null){
            tail = head;
        }
    }

    public void addLast(Dog input){
        Node newNode = new Node(input);

        if(size == 0){
            addFirst(input);
        }else{
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    Node node(int index){
        Node x = head;
        for(int i  = 0 ; i < index ; i++){
            x = x.next;
        }
        return x;

    }

    public void add(int k , Dog input){
        if(k == 0){
            addFirst(input);
        }else{
            Node temp1 = node(k-1);

            Node temp2 = temp1.next;

            Node newNode = new Node(input);

            temp1.next = newNode;

            newNode.next = temp2;
            size++;

            if(newNode.next == null){
                tail = newNode;
            }
        }
    }
    public String toString() {
        // 노드가 없다면 []를 리턴합니다.
        if(head == null){
            return "[]";
        }
        // 탐색을 시작합니다.
        Node temp = head;
        String str = "[";
        // 다음 노드가 없을 때까지 반복문을 실행합니다.
        // 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
        while(temp.next != null){
            str += temp.data + ",";
            temp = temp.next;
        }
        // 마지막 노드를 출력결과에 포함시킵니다.
        str += temp.data;
        return str+"]";
    }


    public Object removeFirst(){
        // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
        Node temp = head;
        head = temp.next;
        // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public Object remove(int k){
        if(k == 0)
            return removeFirst();
        // k-1번째 노드를 temp의 값으로 지정합니다.
        Node temp = node(k-1);
        // 삭제 노드를 todoDeleted에 기록해 둡니다.
        // 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없습니다.
        Node todoDeleted = temp.next;
        // 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정합니다.
        temp.next = temp.next.next;
        // 삭제된 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
        Object returnData = todoDeleted.data;
        if(todoDeleted == tail){
            tail = temp;
        }
        // cur.next를 삭제 합니다.
        todoDeleted = null;
        size--;
        return returnData;
    }

    public Object removeLast(){
        return remove(size-1);
    }

    public int size() {
        return size;
    }

    public Dog get(int k){
        Node temp = node(k);
        return temp.data;
    }

    public int indexOf(Dog data){
        // 탐색 대상이 되는 노드를 temp로 지정합니다.
        Node temp = head;
        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
        int index = 0;
        // 탐색 값과 탐색 대상의 값을 비교합니다.
        while(temp.data != data){
            temp = temp.next;
            index++;
            // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
            if(temp == null)
                return -1;
        }
        // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴합니다.
        return index;
    }
}
